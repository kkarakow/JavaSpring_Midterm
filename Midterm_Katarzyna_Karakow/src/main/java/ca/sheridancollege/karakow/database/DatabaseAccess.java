package ca.sheridancollege.karakow.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.karakow.beans.CarModel;
import ca.sheridancollege.karakow.beans.CarType;


@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public List<CarType> getCarType() {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "Select * from carTypes";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<CarType>(CarType.class));
	}

	public List<CarModel> getCarModel() {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "Select * from carModels";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<CarModel>(CarModel.class));
	}

	public List<CarModel> getCarModelByType(String carType) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM carModels WHERE carType = :carType";

		namedParameters.addValue("carType", carType);

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<CarModel>(CarModel.class));

	}
	
	public void insertCarModel(Long modelNo, String modelName, 
			String carType, double price, String description) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO carModels(modelNo, modelName, carType, price, description) "
				+ "VALUES(:modelNo, :modelName, :carType, :price, :description)";
		
		namedParameters.addValue("modelNo", modelNo);
		namedParameters.addValue("modelName", modelName);
		namedParameters.addValue("carType", carType);
		namedParameters.addValue("price", price);
		namedParameters.addValue("description", description);
		
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0) {
			System.out.println("Inserted car model into database");
		}
	}
}



















