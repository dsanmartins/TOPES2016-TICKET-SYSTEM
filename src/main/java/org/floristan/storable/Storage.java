package org.floristan.storable;

import java.util.Date;

import org.floristan.model.Client;
import org.floristan.model.MusicalEvent;
import org.floristan.model.Seat;
import org.floristan.model.SeatCategory;
import org.floristan.model.TicketSale;


/**
 * All the administration functionality is implemented
 * here.
 */
public interface Storage {

	public void createSeat(int number, int situation, int musicalEvent,int iCategory);
	public int updateSeat(int number, int situation, int idMusicalEvent);
	public int deleteSeat(int number, int idMusicalEvent);
	public int getSeatNumber(int number, int idMusicalEvent);
	public Seat getSeat(int number, int idMusicalEvent);
	public Seat getSeatById(int id, int idMusicalEvent);
	public void createMusicalEvent(String eventName, Date date, String description);
	public String loadMusicalEvent();
	public MusicalEvent getMusicalEvent(int id);
	public void createClient(String firstname, String surname, String mobilePhone, String firstPhone, String secondPhone, String email,String passport,
			String rg, String address, String city, String cpf, Date bornDate);
	public Client getClient(String passport);
	public Client getClient(int id);
	public void updateClient(String firstname, String surname, String mobilePhone, String firstPhone, String secondPhone, String email,String passport,
			String rg, String address, String city, String cpf, Date bornDate);
	public String deleteClient(String idPassport);
	public String getSeats(String musicalEvent);
	public String getClients();
	public int createTicket(int musicalEvent,int seat, int price, Date saleDate, int client, String paidForm);
	public void createCategory(String name, int tax);
	public int updateCategory(String name, int tax);
	public int deleteCategory(String name);
	public SeatCategory findCategory (String name);
	public SeatCategory findCategory (int id);
	public String getCategories();
	public TicketSale getTicketSale(Client c, Seat s, Date date);
	public TicketSale getTicketSale(int id);
	public int getTaxFromCategory(Seat seat);
	public int deleteTicket(int idTicket);
	
	
	
	

}
