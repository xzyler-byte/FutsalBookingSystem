package com.ncit.minor.futsalbookingapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookingStat;
	private String bookDate;
	private String bookTime;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(mappedBy = "booking", cascade = CascadeType.PERSIST)
	private Court court;

	public Booking() {
		super();
	}

	public Booking(String bookingStat, String bookDate, String bookTime) {
		super();
		this.bookingStat = bookingStat;
		this.bookDate = bookDate;
		this.bookTime = bookTime;
	}

	public String getBookingStat() {
		return bookingStat;
	}

	public void setBookingStat(String bookingStat) {
		this.bookingStat = bookingStat;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookTime() {
		return bookTime;
	}

	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public long getId() {
		return id;
	}

}
