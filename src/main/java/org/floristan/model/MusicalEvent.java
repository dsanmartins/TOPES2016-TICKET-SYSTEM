package org.floristan.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Essa classe representa o show musical que se apresentará no teatro Florestan. 
 * @author dsanmartins
 *
 */

@Entity
@Table(name = "musical_event")
@Cacheable
public class MusicalEvent {

	private static final long serialVersionUID = 1L;
	private int id;
	private String eventName;
	private String description;
	private Date eventDate;
	
	/**
	 * Contrutor vacío para JPA.
	 */
	public MusicalEvent(){
		
	}
	
	/**
	 * Construtor com todos os atributos para a criação de um novo evento musical e ser inserido no banco de dados.
	 * 
	 * @param eventName: Nome do Show.
	 * @param eventDate: Día em que ocorrerá o Show.
	 * @param description: De que trata o Show.
	 */
	public MusicalEvent(String eventName, Date eventDate, String description) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
	}

	@Id
	@GeneratedValue
	/**
	 * ID auto incremental.
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * 
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public Date getEventDate() {
		return eventDate;
	}

	/**
	 * 
	 * @param eventDate
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
}
