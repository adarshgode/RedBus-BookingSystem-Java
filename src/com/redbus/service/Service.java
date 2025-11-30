package com.redbus.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.redbus.model.Bus;
import com.redbus.repository.Repository;

public class Service {
	static Repository db = new Repository();
	public List<Bus> getAllBus(String boardingPoint, String dropingPoint,String date) throws SQLException, IOException{
		ResultSet rs = db.getAllBus(boardingPoint,dropingPoint,date);
		List<Bus> busList = storeBusInList(rs);
		
		
		return busList;
	}
	
	public List<Bus> filterBus(String boardingPoint, String dropingPoint, String date, String busType, String seatType, int rating, String sortIn) throws IOException, SQLException {
		ResultSet rs = db.filterBus(boardingPoint, dropingPoint, date, busType, seatType, rating, sortIn);
		List<Bus> busList = storeBusInList(rs);
		return busList;
	}
	
	public int bookSeat(int busno, String passName, String number , String geneder, boolean isPayed) throws IOException, SQLException {
		return db.bookSeat(busno, passName, number, geneder, isPayed);
	}

	
	public List<Bus> storeBusInList(ResultSet buses) throws SQLException {
		List<Bus> busList = new ArrayList<>();
		while(buses.next()) {
			Bus bus = new Bus();
			bus.setBusno(buses.getInt(1));
			bus.setBusname(buses.getString(2));
			bus.setBustype(buses.getString(3));
			bus.setSeattype(buses.getString(4));
			bus.setTotalseats(buses.getInt(5));
			bus.setAvailseats(buses.getInt(6));
			bus.setBoardingpoint(buses.getString(7));
			bus.setDropingpoint(buses.getString(8));
			bus.setOccupiedseats(buses.getInt(9));
			bus.setBoardingtime(buses.getString(10));
			bus.setDropingpoint(buses.getString(11));
			bus.setDateofboarding(buses.getString(12));
			bus.setRating(buses.getInt(13));
			bus.setPricing(buses.getInt(14));
			busList.add(bus);
		}
		return busList;
	}
	
	public List<Bus> displayAllBus() throws IOException, SQLException{
		ResultSet rs =  db.displayAllBus();
		return storeBusInList(rs);
	}
	
	public int addNewBus(Bus bus) throws SQLException, IOException {
		return db.addNewBus(bus);
	}
	
	public int deleteBus(int busNo) throws IOException, SQLException {
		return db.deleteBus(busNo);
	}
	
	public int updateBus(Bus bus) throws IOException, SQLException {
		return db.updateBus(bus);
	}
}
