package ca.sheridancollege.karakow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.CarModel;
import ca.sheridancollege.karakow.beans.CarType;
import ca.sheridancollege.karakow.database.DatabaseAccess;

@Controller
public class CarController {

	
	@Autowired
	DatabaseAccess da;
	
	@GetMapping("/")
	private String goHome(Model model) {
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("carModelList", da.getCarModel());
		model.addAttribute("carType", new CarType());
		model.addAttribute("carTypeList", da.getCarType());
	
		return ("index");
	}
	
	@GetMapping("/addCarModel")
	private String addCarModel(Model model) {
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("carModelList", da.getCarModel());
		model.addAttribute("carTypeList", da.getCarType());
		
		return ("addCarModel");
	}
	
	@GetMapping("/displayCarModels")
	private String displayCarModels(Model model) {
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("carModelList", da.getCarModel());
		
		return ("displayCarModels");
	}
	
	@GetMapping("/searchCarByType")
	private String searchCar(Model model) {
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("carModelList", da.getCarModel());
		model.addAttribute("carTypeList", da.getCarType());
		
		return("searchCarByType");
	}
	
	@PostMapping("/searchCarByType")
	private String searchCarByType(Model model,
			@RequestParam String carType) {
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("searchList", da.getCarModelByType(carType));
		model.addAttribute("carTypeList", da.getCarType());
		
		return("searchCarByType");
	}
	
	@PostMapping("/processForm")
	private String insertCarModel(Model model,
		@RequestParam Long modelNo,
		@RequestParam String modelName,
		@RequestParam String carType,
		@RequestParam double price,
		@RequestParam String description,
		@ModelAttribute CarModel carModel) {
		
		da.insertCarModel(modelNo, modelName, carType, price, description);
		
		model.addAttribute("carModel", new CarModel());
		model.addAttribute("carModelList", da.getCarModel());
		model.addAttribute("carTypeList", da.getCarType());
		
		return ("addCarModel");
	}
	
	
	
	
	
	
	
	
	
	
}
