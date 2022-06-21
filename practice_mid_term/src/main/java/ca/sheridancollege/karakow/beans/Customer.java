package ca.sheridancollege.karakow.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Long id;
	private String custName;
	private String custAddress;
	private String custProvince;
	private String custCountry;
}
