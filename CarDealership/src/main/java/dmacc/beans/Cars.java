/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Apr 10, 2021
 */
package dmacc.beans;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String carBrand;
	private String carName;
	private String carYear;
	private String carType;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	List<Options> options; 
	
	public Cars(long id, String carName, String carYear, String carType) {
		super();
		this.id = id;
		this.carName = carName;
		this.carYear = carYear;
		this.carType = carType;
	}
	public void addOption(Options o) {
		options.add(o); 
	}

}
