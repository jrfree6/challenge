package br.com.challenge.model;

import java.sql.Time;
import java.util.Date;

public class UberOnRailsModel {
	
	private String trip;
	private String origin;
	private String destiny;
	private Date departureDate;
	private Time departure;
	private Double value;
	private Time arrival;
	
	public String getTrip() {
		return trip;
	}
	public void setTrip(String strip) {
		this.trip = strip;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getDeparture() {
		return departure;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Time getArrival() {
		return arrival;
	}
	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}

}
