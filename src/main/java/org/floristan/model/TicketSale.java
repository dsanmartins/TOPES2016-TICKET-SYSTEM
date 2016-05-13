package org.floristan.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A clase representa o ticket de reserva ou venda. 
 * 
 * @author dsanmartins
 *
 */

@Entity
@Table(name = "ticket_sale")
@Cacheable
public class TicketSale {

	int id;
	Seat seat;
	int price;
	Date saleDate;
	Date cancelDate;
	Client client;
	String paidForm;
	
	/**
	 * Construtor vacío para o JPA.
	 */
	public TicketSale()
	{
		
	}
	
	/**
	 * Construtor para a criação de um ticket para logo ser inserido no banco de dados.
	 * 
	 * @param seat: A Cadeira reservada ou vendida.
	 * @param price: O preço do ticket.
	 * @param saleDate: A data de venda.
	 * @param cancelDate: A data de cancelamento (Venda ou reserva).
	 * @param client: O Cliente.
	 * @param paidForm: Forma de pagamento ou se é reserva.
	 */
	public TicketSale(Seat seat, int price, Date saleDate, Date cancelDate,
			Client client, String paidForm) {
		super();
		this.seat = seat;
		this.price = price;
		this.saleDate = saleDate;
		this.cancelDate = cancelDate;
		this.client = client;
		this.paidForm = paidForm;
	}
	
	/**
	 * ID do ticket auto incremental
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
	 * Relacionamento muitos a um com a cadeira.
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPaidForm() {
		return paidForm;
	}
	public void setPaidForm(String paidForm) {
		this.paidForm = paidForm;
	}
	
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	/**
	 * Relacionamento muitos a um com o cliente.
	 * 
	 * @return
	 */
	@ManyToOne(optional=true)	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
}
