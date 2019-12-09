package com.ncit.minor.futsalbookingapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Court")
public class Court {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String courtName;
	private String courtType;
	private String courtStat;
	private String courtAddress;
	private double courtPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private Booking booking;

	public Court() {
		super();
	}

	public Court(String courtName, String courtType, String courtStat, String courtAddress, double courtPrice) {
		super();
		this.courtName = courtName;
		this.courtType = courtType;
		this.courtStat = courtStat;
		this.courtAddress = courtAddress;
		this.courtPrice = courtPrice;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getCourtType() {
		return courtType;
	}

	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}

	public String getCourtStat() {
		return courtStat;
	}

	public void setCourtStat(String courtStat) {
		this.courtStat = courtStat;
	}

	public String getCourtAddress() {
		return courtAddress;
	}

	public void setCourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}

	public double getCourtPrice() {
		return courtPrice;
	}

	public void setCourtPrice(double courtPrice) {
		this.courtPrice = courtPrice;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public long getId() {
		return id;
	}

}
