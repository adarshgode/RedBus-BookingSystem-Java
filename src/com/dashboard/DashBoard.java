package com.dashboard;

import java.io.IOException;
import java.sql.SQLException;

import com.redbus.controller.RedBusController;
import com.redbus.model.Bus;
import com.redbus.utils.Utils;

public class DashBoard {
	static RedBusController rbc = new RedBusController();
	public static void main(String[] args) throws SQLException, IOException {
		System.out.println("Welcome To RedBus Application");
		while(true) {
			System.out.println("Choose The Options: \n1) Search Buses 2)Filter Buses 3) Book Seat 4)Goto Admin Panel 5)Exit");
			int choice  = Utils.sc.nextInt();
			if(choice == 1) {
				System.out.println("Enter Boarding Point : ");
				String boardingPoint = Utils.sc.next();
				
				System.out.println("Enter Droping Point : ");
				String dropingPoint = Utils.sc.next();
				
				System.out.println("Enter Date: ");
				String date  = Utils.sc.next();
				rbc.getAllBus(boardingPoint,dropingPoint,date);
			}else if(choice == 2) {
				System.out.println("Enter Boarding Point : ");
				String boardingPoint = Utils.sc.next();
				
				System.out.println("Enter Droping Point : ");
				String dropingPoint = Utils.sc.next();
				
				System.out.println("Enter Date: ");
				String date  = Utils.sc.next();
				
				System.out.println("Enter Bus Type(ac/non-ac) : ");
				String busType = Utils.sc.next();
				
				System.out.println("Enter Seat Type(seater/sleeper) : ");
				String seatType = Utils.sc.next();
				
				System.out.println("Enter Rating(1-5) : ");
				int rating = Utils.sc.nextInt();
				if(rating > 5) {
					rating = 1;
				}
				
				System.out.println("Sort By Price(high-low / low-high ) : ");
				String sort = Utils.sc.next();
				if(sort.equals("high-low")) {
					sort = "asc";
				}else {
					sort = "desc";
				}
				
				rbc.filterBus(boardingPoint, dropingPoint, date, busType, seatType, rating, sort);
				
				
			}
			else if(choice == 3) {
				System.out.println("Enter Bus Number : ");
				int busno = Utils.sc.nextInt();
				
				System.out.println("Enter Your Name : ");
				String passengerName = Utils.sc.next();
				
				System.out.println("Enter Your Contact Number: ");
				String number = Utils.sc.next();
				
				System.out.println("Enter Your Gender(Male/Female) : ");
				String gender = Utils.sc.next();
				
				System.out.println("Please Pay Amount : ");
				boolean isPayed = Utils.sc.nextBoolean();
				
				rbc.bookSeat(busno, passengerName, number, gender, isPayed);
				
			}else if(choice == 4) {
				while(true) {
					System.out.println("Choose Options \n1)Display All Buses 2)Add New Bus 3)Delete Bus 4)Update Bus 5)LogOut From Admin Panel");
					int ch = Utils.sc.nextInt();
					if(ch != 5){
						adminPanel(ch);
					}else {
						System.out.println("Exiting From Admin Panel....!");
						break;
					}
				}
			}else {
				System.out.println("\n Thanks For Using RedBus App");
				System.exit(0);
			}
			
			System.out.println();
		}
	}
	public static void adminPanel(int choice) throws IOException, SQLException {
		if(choice == 1) {
			rbc.displayAllBus();
		}
		else if(choice == 2) {
			System.out.println("Enter Bus Details to Add New Bus");
			Bus bus = insertBusData();
			rbc.addNewBus(bus);
		}else if(choice == 3){
			System.out.println("Enter Bus Number : ");
			int busNo = Utils.sc.nextInt();
			rbc.deleteBus(busNo);
		}
		else if(choice == 4) {
			System.out.println(" Enter Details To Update Existing Data of Bus ");
			Bus bus = insertBusData();
			rbc.updateBus(bus);
		}
	}
	
	public static Bus insertBusData() {
		Bus bus = new Bus();
		System.out.println("Enter Bus No : ");
		bus.setBusno(Utils.sc.nextInt());
		
		System.out.println("Enter Bus Name : ");
		bus.setBusname(Utils.sc.next());
		
		System.out.println("Enter Totalseats : ");
		bus.setTotalseats(Utils.sc.nextInt());
		
		System.out.println("Enter Available Seats : ");
		bus.setAvailseats(Utils.sc.nextInt());
		
		System.out.println("Enter Occupied Seats : ");
		bus.setOccupiedseats(Utils.sc.nextInt());
		
		System.out.println("Enter BusType(ac/non-ac) : ");
		bus.setBustype(Utils.sc.next());
		
		System.out.println("Enter Bus Seat Type : ");
		bus.setSeattype(Utils.sc.next());
		
		System.out.println("Enter Boarding Point : ");
		bus.setBoardingpoint(Utils.sc.next());
	
		System.out.println("Enter Boarding Point Time: ");
		bus.setBoardingtime(Utils.sc.next());
		
		System.out.println("Enter Droping Point : ");
		bus.setDropingpoint(Utils.sc.next());
		
		System.out.println("Enter Droping Point Time : ");
		bus.setDroppingtime(Utils.sc.next());
		
		System.out.println("Enter Ticket Price : ");
		bus.setPricing(Utils.sc.nextDouble());
		
		System.out.println("Enter Bus Rating : ");
		bus.setRating(Utils.sc.nextInt());
		
		System.out.println("Enter Date of Boarding : ");
		bus.setDateofboarding(Utils.sc.next());
		return bus;
	}
}
