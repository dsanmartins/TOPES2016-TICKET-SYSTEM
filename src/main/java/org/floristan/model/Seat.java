package org.floristan.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A classe cadeira é o recurso para ser reservado ou comprado.
 * 
 * @author dsanmartins
 *
 */

@Entity
@Table(name = "seat")
@Cacheable
public class Seat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int numberSeat;
	private int situation;
	private MusicalEvent musicalEvent;


	/**
	 * Construtor vacío para o JPA
	 */
	public Seat() {
	}

	/**
	 * Construtor para a criação de um objeto cadeira para logo ser inserido no banco de dados.
	 * 
	 * @param numberSeat: Número da cadeira. 
	 * @param situation: Se a cadeira está reservada ou vendida. 
	 * @param musicalEvent: O show associado.
	 */
	public Seat(int numberSeat,int situation, MusicalEvent musicalEvent) {
		this.numberSeat = numberSeat;
		this.situation = situation;
		this.musicalEvent = musicalEvent;
	}

	/**
	 * ID auto incremental
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

	public int getNumberSeat() {
		return numberSeat;
	}
	public void setNumberSeat(int numberSeat) {
		this.numberSeat = numberSeat;
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
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

