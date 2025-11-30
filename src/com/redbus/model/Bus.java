package com.redbus.model;

public class Bus {
	private int busno;
	private String busname;
	private String bustype;
	private String seattype;
	private int totalseats;
	private int availseats;
	private int occupiedseats;
	private String boardingpoint;
	private String dropingpoint;
	private String boardingtime;
	private String droppingtime;
	private String dateofboarding;
	private int rating;
	private double pricing;
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getAvailseats() {
		return availseats;
	}
	public void setAvailseats(int availseats) {
		this.availseats = availseats;
	}
	public int getOccupiedseats() {
		return occupiedseats;
	}
	public void setOccupiedseats(int occupiedseats) {
		this.occupiedseats = occupiedseats;
	}
	public String getBoardingpoint() {
		return boardingpoint;
	}
	public void setBoardingpoint(String boardingpoint) {
		this.boardingpoint = boardingpoint;
	}
	public String getDropingpoint() {
		return dropingpoint;
	}
	public void setDropingpoint(String dropingpoint) {
		this.dropingpoint = dropingpoint;
	}
	public String getBoardingtime() {
		return boardingtime;
	}
	public void setBoardingtime(String boardingtime) {
		this.boardingtime = boardingtime;
	}
	public String getDroppingtime() {
		return droppingtime;
	}
	public void setDroppingtime(String droppingtime) {
		this.droppingtime = droppingtime;
	}
	public String getDateofboarding() {
		return dateofboarding;
	}
	public void setDateofboarding(String dateofboarding) {
		this.dateofboarding = dateofboarding;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public double getPricing() {
		return pricing;
	}
	public void setPricing(double pricing) {
		this.pricing = pricing;
	}
	
	public Bus(int busno, String busname, String bustype, String seattype, int totalseats, int availseats,
			int occupiedseats, String boardingpoint, String dropingpoint, String boardingtime, String droppingtime,
			String dateofboarding, int rating, double pricing) {
		super();
		this.busno = busno;
		this.busname = busname;
		this.bustype = bustype;
		this.seattype = seattype;
		this.totalseats = totalseats;
		this.availseats = availseats;
		this.occupiedseats = occupiedseats;
		this.boardingpoint = boardingpoint;
		this.dropingpoint = dropingpoint;
		this.boardingtime = boardingtime;
		this.droppingtime = droppingtime;
		this.dateofboarding = dateofboarding;
		this.rating = rating;
		this.pricing = pricing;
	}
	
	public Bus() {
		super();
	}
	@Override
	public String toString() {
		return "Bus [busno=" + busno + ", busname=" + busname + ", bustype=" + bustype + ", seattype=" + seattype
				+ ", totalseats=" + totalseats + ", availseats=" + availseats + ", occupiedseats=" + occupiedseats
				+ ", boardingpoint=" + boardingpoint + ", dropingpoint=" + dropingpoint + ", boardingtime="
				+ boardingtime + ", droppingtime=" + droppingtime + ", dateofboarding=" + dateofboarding + ", rating="
				+ rating + ", pricing=" + pricing + "]";
	}
	
	
	
	
}
