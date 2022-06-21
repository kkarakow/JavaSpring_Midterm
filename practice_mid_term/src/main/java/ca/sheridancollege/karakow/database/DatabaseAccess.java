package ca.sheridancollege.karakow.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.karakow.beans.Customer;
import ca.sheridancollege.karakow.beans.Province;

@Repository
public class DatabaseAccess {

	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertProvince(String provinceName) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO provinces(provinceName) VALUES (:provinceName)";
		
		namedParameters.addValue("provinceName", provinceName);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0) {
			System.out.println("Inserted province into database");
		}
	}
	
	public List<Province> getProvinces(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Select * from provinces";
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Province>(Province.class));
		
	}
	
	public void insertCustomer(String custName, String custAddress,
			String custProvince, String custCountry) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO customers(custName, custAddress, custProvince, custCountry)"
				+ "VALUES(:custName, :custAddress, :custProvince, :custCountry)";
		
		namedParameters.addValue("custName", custName);
		namedParameters.addValue("custAddress", custAddress);
		namedParameters.addValue("custProvince", custProvince);
		namedParameters.addValue("custCountry", custCountry);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0) {
			System.out.println("Inserted customer into database");
		}
	}
	
	public List<Customer> getCustomer(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "Select * from Customers";
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Customer>(Customer.class));
		
	}
	
	public List<Customer> getCustomerByProvince(String custProvince){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM customers WHERE custProvince = :custProvince"; 
		
		namedParameters.addValue("custProvince", custProvince);
		
		return jdbc.query(query, namedParameters, 
				new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
}
