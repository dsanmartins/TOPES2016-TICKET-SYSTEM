package org.floristan.storable;

// import org.jboss.annotation.ejb.LocalBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.floristan.model.Client;
import org.floristan.model.MusicalEvent;
import org.floristan.model.Seat;
import org.floristan.model.SeatCategory;
import org.floristan.model.TicketSale;

@Stateless
@LocalBean
public class StorageBean implements Storage {


	@PersistenceContext
	protected EntityManager em;
	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(StorageBean.class.getName());

	public StorageBean() {

	}

	@Override
	public void createSeat(int number, int situation, int IdmusicalEvent ,int iCategory) {
		// TODO Auto-generated method stub
		MusicalEvent musicalEvent = this.getMusicalEvent(IdmusicalEvent);
		if (musicalEvent != null)
		{
			//Create de Seat
			SeatCategory sc = this.findCategory(iCategory);
			Seat s = new Seat(number,situation, musicalEvent);
			em.persist(s);
			em.flush();

			//Set the category of the seat.
			sc.setSeat(s);
			em.persist(sc);
			em.flush();
		}
	}

	@Override
	public int updateSeat(int number, int situation, int idMusicalEvent) {
		// TODO Auto-generated method stub
		Seat s = this.getSeat(number, idMusicalEvent);
		MusicalEvent m = this.getMusicalEvent(idMusicalEvent);

		if (s!= null)
		{
			em.createQuery("UPDATE Seat Set situation =:situation Where id =:id and musicalEvent =:musicalEvent")
			.setParameter("musicalEvent", m).setParameter("id", s.getId()).setParameter("situation", situation).executeUpdate();	
			return s.getNumberSeat();
		}
		else
			return 0;
	}

	@Override
	public int deleteSeat(int number, int idMusicalEvent) {
		// TODO Auto-generated method stub
		Seat s = this.getSeat(number, idMusicalEvent);
		em.remove(s);
		if (s != null)
			return number;
		else
			return 0;
	}

	@Override
	public int getSeatNumber(int number, int idMusicalEvent) {

		Seat s = null;
		MusicalEvent m = this.getMusicalEvent(idMusicalEvent);

		try
		{
			s = (Seat) em.createQuery("From Seat Where numberSeat =:numberSeat and musicalEvent =:musicalEvent",Seat.class)
					.setParameter("numberSeat", number)
					.setParameter("musicalEvent", m)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (s != null )
			return s.getNumberSeat();
		else
			return 0;
	}

	@Override
	public Seat getSeat(int number, int idMusicalEvent) {

		Seat s = null;
		MusicalEvent m = this.getMusicalEvent(idMusicalEvent);

		try
		{
			s = (Seat) em.createQuery("From Seat Where numberSeat =:numberSeat and musicalEvent =:musicalEvent",Seat.class)
					.setParameter("numberSeat", number)
					.setParameter("musicalEvent", m)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (s != null )
			return s;
		else
			return null;
	}

	@Override
	public Seat getSeatById(int id, int idMusicalEvent) {

		Seat s = null;
		MusicalEvent m = this.getMusicalEvent(idMusicalEvent);

		try
		{
			s = (Seat) em.createQuery("From Seat Where id =:id and musicalEvent =:musicalEvent",Seat.class)
					.setParameter("id", id)
					.setParameter("musicalEvent", m)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (s != null )
			return s;
		else
			return null;
	}

	@Override
	public void createMusicalEvent(String eventName, Date eventDate,
			String description) {
		MusicalEvent musicalEvent = new MusicalEvent(eventName,eventDate,description);
		em.persist(musicalEvent);
		em.flush();
	}

	@Override
	public String loadMusicalEvent() {
		// TODO Auto-generated method stub

		String select = "";
		List <MusicalEvent> listMusicalEvent = (List<MusicalEvent>) em.createQuery("FROM MusicalEvent", MusicalEvent.class)
				.getResultList();

		for (MusicalEvent musicalEvent:listMusicalEvent)
			select = select + musicalEvent.getId() + "," + musicalEvent.getEventName() + "|";

		return select.substring(0, select.length()-1);
	}

	public MusicalEvent getMusicalEvent(int id)
	{
		MusicalEvent s=null;
		try
		{
			s = (MusicalEvent) em.createQuery("From MusicalEvent Where id =:id", MusicalEvent.class)
					.setParameter("id", id)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (s != null )
			return s;
		else
			return null;
	}

	@Override
	public void createClient(String firstname, String surname,
			String mobilePhone, String firstPhone, String secondPhone,
			String email, String passport, String rg, String address,
			String city, String cpf, Date bornDate) {
		// TODO Auto-generated method stub
		Client c = new Client(firstname, surname, mobilePhone, firstPhone,  secondPhone,  email, passport,  rg,  address,  city, cpf,  bornDate);
		em.persist(c);
		em.flush();
	}

	@Override
	public Client getClient(String passport) {
		// TODO Auto-generated method stub

		Client c=null;
		try
		{
			c = (Client) em.createQuery("From Client Where passport =:passport",Client.class)
					.setParameter("passport", passport)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (c != null )
			return c;
		else
			return null;
	}

	@Override
	public Client getClient(int id) {
		// TODO Auto-generated method stub

		Client c=null;
		try
		{
			c = (Client) em.createQuery("From Client Where id =:id", Client.class)
					.setParameter("id", id)
					.getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (c != null )
			return c;
		else
			return null;
	}

	@Override
	public void updateClient(String firstname, String surname,
			String mobilePhone, String firstPhone, String secondPhone,
			String email, String passport, String rg, String address,
			String city, String cpf, Date bornDate) {
		// TODO Auto-generated method stub

		Client c = this.getClient(passport);
		c.setFirstname(firstname);
		c.setSurname(surname);
		c.setMobilePhone(mobilePhone);
		c.setFirstPhone(firstPhone);
		c.setSecondPhone(secondPhone);
		c.setEmail(email);
		c.setPassport(passport);
		c.setRg(rg);
		c.setAddress(address);
		c.setCity(city);
		c.setCpf(cpf);
		c.setBornDate(bornDate);
		em.merge(c);
		em.flush();
	}

	@Override
	public String deleteClient(String idPassport) {
		// TODO Auto-generated method stub

		Client c = this.getClient(idPassport);
		em.remove(c);
		if (c != null)
			return idPassport;
		else
			return "0";

	}

	@Override
	public String getSeats(String musicalEvent) {
		// TODO Auto-generated method stub

		MusicalEvent me = this.getMusicalEvent(Integer.parseInt(musicalEvent));
		String select = "";
		List <Seat> listSeat = (List<Seat>) em.createQuery("FROM Seat Where musicalEvent =:musicalEvent and situation=:situation ", Seat.class)
				.setParameter("musicalEvent", me)
				.setParameter("situation", 0)
				.getResultList();
		if (listSeat.size() != 0)
		{
			for (Seat seat:listSeat)
				select = select + seat.getId() + "," + seat.getNumberSeat() + "|";

			return select.substring(0, select.length()-1);
		}
		return "";
	}

	@Override
	public String getClients() {
		// TODO Auto-generated method stub
		String select = "";
		List <Client> listClient = (List<Client>) em.createQuery("FROM Client ", Client.class)
				.getResultList();
		if (listClient.size() != 0)
		{
			for (Client client:listClient)
				select = select + client.getId() + "," + client.getPassport() + "-"+ client.getFirstname()+ " " +client.getSurname() + "|";
			return select.substring(0, select.length()-1);
		}
		else
			return "";

	}

	@Override
	public int createTicket(int musicalEvent,int seat, int price, Date saleDate, int client, String paidForm) {
		// TODO Auto-generated method stub

		Seat s = this.getSeatById(seat, musicalEvent);
		Client c = this.getClient(client);
		TicketSale ts = null;

		try
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<TicketSale> query = builder.createQuery(TicketSale.class);

			Root<TicketSale> fromTicketSale = query.from(TicketSale.class);
			Join<TicketSale, Client> clients = fromTicketSale.join("client");
			Join<TicketSale, Seat> seats = fromTicketSale.join("seat");
			Join<Seat,MusicalEvent> musicalEvents = seats.join("musicalEvent");
			List<Predicate> conditions = new ArrayList();
			conditions.add(builder.equal(musicalEvents.get("id"), musicalEvent));
			conditions.add(builder.equal(seats.get("id"), seat));

			TypedQuery<TicketSale> typedQuery = em.createQuery(query
					.select(fromTicketSale)
					.where(conditions.toArray(new Predicate[] {}))

					);

			ts = (TicketSale) typedQuery.getSingleResult();

		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (ts != null )
			return 0;
		else
		{
			s.setSituation(1);
			ts = new TicketSale(s,price,saleDate,null,c,paidForm);
			em.persist(ts);
			em.flush();
			return this.getTicketSale(c, s, saleDate).getId();
		}
	}

	@Override
	public void createCategory(String name, int tax) {
		// TODO Auto-generated method stub
		SeatCategory sc = new SeatCategory(name, tax);
		em.persist(sc);
		em.flush();
	}

	@Override
	public int updateCategory(String name, int tax) {
		// TODO Auto-generated method stub

		SeatCategory sc = this.findCategory(name);
		if (sc != null)
		{
			sc.setPrice(tax);
			em.merge(sc);
			return 1;
		}
		else
			return 0;
	}

	@Override
	public int deleteCategory(String name) {
		// TODO Auto-generated method stub
		SeatCategory sc = this.findCategory(name);
		if (sc != null)
		{
			em.remove(sc);
			return 1;
		}
		else
			return 0;
	}

	@Override
	public SeatCategory findCategory(String name) {
		// TODO Auto-generated method stub
		SeatCategory sc = null;

		try
		{
			sc = (SeatCategory) em.createQuery("From SeatCategory Where categoryName=:name",SeatCategory.class)
					.setParameter("name", name).getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (sc != null )
			return sc;
		else
		{
			return null;

		}
	}

	@Override
	public SeatCategory findCategory(int id) {
		// TODO Auto-generated method stub
		SeatCategory sc = null;

		try
		{
			sc = (SeatCategory) em.createQuery("From SeatCategory Where id=:id",SeatCategory.class)
					.setParameter("id", id).getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (sc != null )
			return sc;
		else
		{
			return null;

		}
	}

	@Override
	public String getCategories() {
		// TODO Auto-generated method stub
		String select = "";
		List <SeatCategory> listSeatCategory = (List<SeatCategory>) em.createQuery("FROM SeatCategory ", SeatCategory.class)
				.getResultList();
		if (listSeatCategory.size() != 0)
		{
			for (SeatCategory seatCategory:listSeatCategory)
				select = select + seatCategory.getId() + "," + seatCategory.getCategoryName() + "|";
			return select.substring(0, select.length()-1);
		}
		else
			return "";
	}

	@Override
	public TicketSale getTicketSale(Client c, Seat s, Date date) {
		// TODO Auto-generated method stub
		TicketSale ts = null;

		try
		{
			ts = (TicketSale) em.createQuery("From TicketSale Where seat=:seat and client=:client and saleDate=:saleDate",TicketSale.class)
					.setParameter("seat", s).setParameter("client", c).setParameter("saleDate", date).getSingleResult();
		}
		catch (javax.persistence.NoResultException e)
		{
			e.printStackTrace();
		}

		if (ts != null )
			return ts;
		else
		{
			return null;

		}
	}
	
	public TicketSale getTicketSale(int id)
	{
		return em.find(TicketSale.class, id);
	}

	@Override
	public int getTaxFromCategory(Seat seat) {
		// TODO Auto-generated method stub
		List <SeatCategory> listSeatCategory = (List<SeatCategory>) em.createQuery("FROM SeatCategory Where seat=:seat ", SeatCategory.class)
				.setParameter("seat", seat)
				.getResultList();
		if (listSeatCategory.size() != 0)
		{
			return listSeatCategory.get(0).getPrice(); 
		}
		else
			return 0;
	}

	@Override
	public int deleteTicket(int idTicket) {
		// TODO Auto-generated method stub
		
		TicketSale ts = null;
		ts = em.find(TicketSale.class,idTicket);
		int id = ts.getId();
		if (ts !=null)
		{
			ts.getSeat().setSituation(0);
			em.remove(ts);
			em.flush();
			return id;
		}
		else
			return 0;
	}
}
