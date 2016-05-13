package org.floristan.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Essa classe representa o cliente da nossa aplicação. O cliente realiza a compra ou reserva de uma cadeira do teatro 
 * Floresta para assistir um show musical. Os atributos da classe são os definidos no documento de requisitos. 
 * 
 */

@Entity
@Table(name = "client")
@Cacheable
public class Client implements Serializable {


	private static final long serialVersionUID = 1L; /**< Static property needed for JPA implementation. */ 
	private int id;
	private String firstname;  /**< It is the first name of the client */ 
	private String surname;    /**< It is the surname of the client */ 
	private String mobilePhone; /**< It is the mobile phone of the client */ 
	private String firstPhone; /**< It is a telephone number of the client. (Usually it represents the work phone) */ 
	private String secondPhone; /**< It is a telephone number of the client. (Usually it represents the home phone) */ 
	private String email; /**< It is the e-mail address for further contact.  */ 
	private String passport; /**< It is an ID for foreign people. */ 
	private String rg; /**< It is the Brazilian citizens ID. */ 
	private String address; /**< Physical address of the client */ 
	private String city; /**< The city where the client lives. */ 
	private String cpf; /**< Financial ID of the client. */ 
	private Date bornDate; /**< The born date of the client. */ 


	/**
	 * Construtor vacío que é precisado pela JPA (Java Persistence API)
	 */
	public Client(){

	}
	
	/**
	 * Construtor para a criação de um objeto cliente, que depois será inserido no banco de dados.
	 * 
	 * @param firsname: Primeiro nome do cliente.
	 * @param surname: Sobrenome do cliente.
	 * @param mobilePhone: Telefone do cliente.
	 * @param firstPhone: Telefone fixo do cliente. Geralmente é do trabalho.
	 * @param secondPhone: Telefone fixo do cliente. Geralmente é do lugar onde ele mora.
	 * @param email: Endereço eletrónico, para futuras comunicações.
	 * @param passport: ID do cliente estrangeiro.
	 * @param rg: ID do cliente brasileiro.
	 * @param address: Enderço físico do cliente.
	 * @param city: Cidade onde o cliente mora.
	 * @param cpf: ID comercial do cliente.
	 * @param bornDate: Data de nascimento do client.
	 */
	public Client(String firsname, String surname, String mobilePhone,
			String firstPhone, String secondPhone, String email,
			String passport, String rg, String address, String city,
			String cpf, Date bornDate) {
		super();
		this.firstname = firsname;
		this.surname = surname;
		this.mobilePhone = mobilePhone;
		this.firstPhone = firstPhone;
		this.secondPhone = secondPhone;
		this.email = email;
		this.passport = passport;
		this.rg = rg;
		this.address = address;
		this.city = city;
		this.cpf = cpf;
		this.bornDate = bornDate;
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
	public String getFirstname() {
		return firstname;
	}


	/**
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * 
	 * @return
	 */
	public String getSurname() {
		return surname;
	}


	/**
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * 
	 * @return
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}


	/**
	 * 
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	/**
	 * 
	 * @return
	 */
	public String getFirstPhone() {
		return firstPhone;
	}


	/**
	 * 
	 * @param firstPhone
	 */
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}


	/**
	 * 
	 * @return
	 */
	public String getSecondPhone() {
		return secondPhone;
	}


	/**
	 * 
	 * @param secondPhone
	 */
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * 
	 * @return
	 */
	public String getPassport() {
		return passport;
	}


	/**
	 * 
	 * @param passport
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}


	/**
	 * 
	 * @return
	 */
	public String getRg() {
		return rg;
	}


	/**
	 * 
	 * @param rg
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}


	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}


	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * 
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}


	/**
	 * 
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	/**
	 * 
	 * @return
	 */
	public Date getBornDate() {
		return bornDate;
	}


	/**
	 * 
	 * @param bornDate
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}




}
