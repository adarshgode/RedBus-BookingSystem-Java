package com.redbus.controller;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.redbus.model.Bus;
import com.redbus.service.Service;

public class RedBusController {
	static Service service = new Service();
	
	public void checkUser(String name , String phonenumber) {
		
	}
	
	public void getAllBus(String boardingPoint, String dropingPoint,String date) throws SQLException, IOException{
		List<Bus> busList = service.getAllBus(boardingPoint, dropingPoint,date);
		showList(busList);
		
	}
	
	public void filterBus(String boardingPoint, String dropingPoint, String date, String busType, String seatType, int rating, String sortIn) throws IOException, SQLException {
		List<Bus> busList = service.filterBus(boardingPoint, dropingPoint, date, busType, seatType, rating, sortIn);
		showList(busList);
	}
	
	public void showList(List<Bus> busList) {
		for(Bus bus : busList) {
			System.out.println("____________________________________________________________________________________________________");
			System.out.println("BusNumber : "+bus.getBusno() + 
					"\tBusName : "+bus.getBusname() + "\tBoarding Point : "+bus.getBoardingpoint() +
					"\tDroping Point : "+bus.getDropingpoint()+"\nRating : "+ bus.getRating() + 
					"\t Pricing : "+bus.getPricing() + "\tBoarding Time : " + bus.getBoardingtime() +
					"\t Dropping Time : "+bus.getBoardingtime() + "\nBusType : "+bus.getBustype() + 
					"\tSeatType : "+bus.getSeattype() + "\tAvailable Seats : "+bus.getAvailseats() +
					"\tTotal Seats : "+bus.getTotalseats());
			System.out.println("____________________________________________________________________________________________________");
		}
	}
	
	public void bookSeat(int busno, String passName, String number , String gender, boolean isPayed) throws IOException, SQLException {
		int bId =  service.bookSeat(busno, passName, number, gender, isPayed);
		if(bId != 0) {
			System.out.println("Seat Booked Successfully...");
			System.out.println("Your BookedId : "+bId);
		}
	}
	
	public void displayAllBus() throws IOException, SQLException {
		List<Bus> busList = service.displayAllBus();
		showList(busList);
	}
	
	public void addNewBus(Bus bus) throws SQLException, IOException {
		int result = service.addNewBus(bus);
		if(result > 0) {
			System.out.println(result + " Data Added Successfully....!");
		}else {
			System.out.println("Data Not Added....!");
		}
	}
	
	public void deleteBus(int busNo) throws IOException, SQLException {
		if(service.deleteBus(busNo) > 0) {
			System.out.println(busNo + " Number Bus Deleted Successfully...");
		}else {
			System.out.println(busNo + " Number Bus Not Deleted/Present in DB");
		}
	}
	
	public void updateBus(Bus bus) throws IOException, SQLException {
		if(service.updateBus(bus) > 0) {
			System.out.println(bus.getBusno() + " Number Bus Data Updated Successfully...");
		}else {
			System.out.println(bus.getBusno() + " Number Bus Data Not Updated...!");
		}
	}
	
}
