package org.floristan.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tshirt")
@Cacheable
public class Tshirt implements Serializable {


	private static final long serialVersionUID = 1L; /**< Static property needed for JPA implementation. */ 
	private int id;
	private int size;
	private String sexType;
	
	public Tshirt()
	{
		
	}
	
	public Tshirt(int size, String sexType) {
		super();
		this.size = size;
		this.sexType = sexType;
	}

	@Id
	@GeneratedValue
	/**
	 * ID Auto incremental
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getSexType() {
		return sexType;
	}
	
	public void setSexType(String sexType) {
		this.sexType = sexType;
	}
}
