package org.floristan.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Cacheable
public class Article implements Serializable {


	private static final long serialVersionUID = 1L; /**< Static property needed for JPA implementation. */ 
	private int id;
	private int size;
	private String sexType;
	private String type;
	private float price;
	private MusicalEvent musicalEvent;
	
	public Article()
	{
		
	}
	
	public Article(int size, String sexType, String type, float price, MusicalEvent musicalEvent) {
		super();
		this.size = size;
		this.sexType = sexType;
		this.type = type;
		this.price = price;
		this.musicalEvent = musicalEvent;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Relacionamento muitos a um com a classe cadeira.
	 * @return evento musical
	 */
	@ManyToOne(optional=true)
	public MusicalEvent getMusicalEvent() {
		return musicalEvent;
	}

	public void setMusicalEvent(MusicalEvent musicalEvent) {
		this.musicalEvent = musicalEvent;
	}
	
}
