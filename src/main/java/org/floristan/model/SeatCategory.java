package org.floristan.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A classe representa a catagoría de uma caderia, que pode ser VIP, Default entre outras. Depende da ubucação da cadeira
 * no teatro.
 * 
 * @author dsanmartins
 *
 */

@Entity
@Table(name = "seat_category")
public class SeatCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String categoryName;
	private Seat seat;
	private int price;
	
	/**
	 * Contrutor vacío para  JPA
	 */
	public SeatCategory() {
		
	}
	
	/**
	 * Construtor que cria uma nova categoría para logo ser inserido no bando de dados.
	 * 
	 * @param categoryName: Nome da categoría
	 * @param price: Taxa da categoría.
	 */
	public SeatCategory(String categoryName, int price) {
		super();
		this.categoryName = categoryName;
		this.price = price;
	}

	/**
	 * ID da categoría auto incremental
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Relacionamento entre categoría da cadeira e cadeira, muitos a um.
	 * 
	 * @return
	 */
	@ManyToOne(optional=true)
	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}
