package ca.sheridancollege.karakow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.Customer;
import ca.sheridancollege.karakow.beans.Province;
import ca.sheridancollege.karakow.database.DatabaseAccess;

@Controller
public class ProvinceController {

	@Autowired
	DatabaseAccess da;
	
	
	@GetMapping("/")
	private String goHome(Model model) {
		
		model.addAttribute("province", new Province());
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("index");
	}
	
	@GetMapping("/addProvince")
	private String addProvince(Model model) {
		
		model.addAttribute("province", new Province());
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("addProvince");
	}
	
	@GetMapping("/addCustomer")
	private String addCustomer(Model model) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", da.getCustomer());
		model.addAttribute("province", new Province());
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("addCustomer");
	}

	
	@GetMapping("/searchCustomer")
	private String searchCustomer(Model model) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", da.getCustomer());
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("searchCustomer");
	}
	
	@PostMapping("/searchCustomer")
	private String searchCustomers(Model model,
			@RequestParam String custProvince) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("searchList", da.getCustomerByProvince(custProvince));
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("searchCustomer");
	}
	
	
	
	@PostMapping("/processForm")
	private String insertCustomer(Model model,
			@RequestParam String custName,
			@RequestParam String custAddress,
			@RequestParam String custProvince,
			@RequestParam String custCountry,
			@ModelAttribute Customer customer,
			@ModelAttribute Province province) {
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", da.getCustomer());
		model.addAttribute("province", province);
		model.addAttribute("provinceList", da.getProvinces());	
		
		da.insertCustomer(custName, custAddress, custProvince, custCountry);
		
		return ("addCustomer");
	}
	
	
	@PostMapping("/insertProvince")
	private String insertProvince(Model model,
			@RequestParam String provinceName,
			@ModelAttribute Province province) {
		
		model.addAttribute("province", new Province());
		model.addAttribute("provinceList", da.getProvinces());	
		
		da.insertProvince(provinceName);
		
		return ("addProvince");
	}
}
