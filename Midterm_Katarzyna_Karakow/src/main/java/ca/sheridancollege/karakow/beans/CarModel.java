package ca.sheridancollege.karakow.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

	private Long id;
	private Long modelNo;
	private String modelName;
	private String carType;
	private double price;
	private String description;
}
