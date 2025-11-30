package com.redbus.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.redbus.model.Bus;
import com.redbus.utils.Utils;

public class Repository {
	public ResultSet getAllBus(String boardingPoint, String dropingPoint,String date) throws IOException, SQLException {
		Connection con = Utils.getConnection();
		String query = "select * from buses where boardingpoint = ? and dropingpoint = ? and  dateofboarding = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, boardingPoint);
		pstmt.setString(2, dropingPoint);
		pstmt.setString(3, date);
		return pstmt.executeQuery();
	}
	
	public ResultSet filterBus(String boardingPoint, String dropingPoint, String date, String busType, String seatType, int rating, String sortIn) throws IOException, SQLException {
		Connection con = Utils.getConnection();
		String query = "select * from buses where boardingpoint = ? and dropingpoint = ? and  dateofboarding = ? and bustype = ? and seattype = ? and rating >= ? order by pricing "+sortIn;
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, boardingPoint);
		pstmt.setString(2, dropingPoint);
		pstmt.setString(3, date);
		pstmt.setString(4, busType);
		pstmt.setString(5, seatType);
		pstmt.setInt(6, rating);
		return pstmt.executeQuery();
	}
	
	public int bookSeat(int busno, String passName, String number , String gender, boolean isPayed) throws IOException, SQLException {
		Connection con = Utils.getConnection();
		String query = "insert into bookedseat(busno, passname,phonenum,gender, ispayed)"
				+ "values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, busno);
		pstmt.setString(2,passName);
		pstmt.setString(3, number);
		pstmt.setString(4,gender);
		pstmt.setBoolean(5, isPayed);
		
		if(pstmt.executeUpdate()>0) {
			updateBusAvailSeat(busno);
			return bId(passName,number);
		}
		return 0;
	}
	
	
	public void updateBusAvailSeat(int busno) throws IOException, SQLException {
		Connection con = Utils.getConnection();
		String query = "update buses set availseats = availseats - ? where busno = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,1);
		pstmt.setInt(2, busno);
		pstmt.executeUpdate();
	}
	
	public int bId(String passname, String number) throws IOException, SQLException {
		Connection con = Utils.getConnection();
		String query = "select bid from bookedseat where passname = ? and phonenum = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,passname);
		pstmt.setString(2,number);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public ResultSet displayAllBus() throws IOException, SQLException{
		Connection con = Utils.getConnection();
		String query = "select * from buses";
		PreparedStatement pstmt = con.prepareStatement(query);
		return pstmt.executeQuery();
	}
	
	public int addNewBus(Bus bus) throws SQLException, IOException {
		int result = 0;

	    String query = "INSERT INTO buses (busno, busname, bustype, seattype, totalseats, availseats, "
	            + "boardingpoint, dropingpoint, occupiedseats, boardingtime, droppingtime, dateofboarding, rating, pricing) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    Connection con = Utils.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(query);

	    pstmt.setInt(1, bus.getBusno());
        pstmt.setString(2, bus.getBusname());
        pstmt.setString(3, bus.getBustype());
        pstmt.setString(4, bus.getSeattype());
        pstmt.setInt(5, bus.getTotalseats());
        pstmt.setInt(6, bus.getAvailseats());
        pstmt.setString(7, bus.getBoardingpoint());
        pstmt.setString(8, bus.getDropingpoint());
        pstmt.setInt(9, bus.getOccupiedseats());
        pstmt.setString(10, bus.getBoardingtime());
        pstmt.setString(11, bus.getDroppingtime());
        pstmt.setString(12, bus.getDateofboarding());
        pstmt.setInt(13, bus.getRating());
        pstmt.setDouble(14, bus.getPricing());

        result = pstmt.executeUpdate();

	    return result;
	}
	
	public int deleteBus(int busNo) throws IOException, SQLException {
		String query = "delete from buses where busNo = ?";

	    Connection con = Utils.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(query);
	    pstmt.setInt(1,busNo);
	    return pstmt.executeUpdate();
	}

	public int updateBus(Bus bus) throws IOException, SQLException {
		int result = 0;

		String query = "UPDATE buses SET busname=?, bustype=?, seattype=?, totalseats=?, availseats=?, "
		        + "boardingpoint=?, dropingpoint=?, occupiedseats=?, boardingtime=?, droppingtime=?, "
		        + "dateofboarding=?, rating=?, pricing=? WHERE busno=?";

	    Connection con = Utils.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setString(1, bus.getBusname());
        pstmt.setString(2, bus.getBustype());
        pstmt.setString(3, bus.getSeattype());
        pstmt.setInt(4, bus.getTotalseats());
        pstmt.setInt(5, bus.getAvailseats());
        pstmt.setString(6, bus.getBoardingpoint());
        pstmt.setString(7, bus.getDropingpoint());
        pstmt.setInt(8, bus.getOccupiedseats());
        pstmt.setString(9, bus.getBoardingtime());
        pstmt.setString(10, bus.getDroppingtime());
        pstmt.setString(11, bus.getDateofboarding());
        pstmt.setInt(12, bus.getRating());
        pstmt.setDouble(13, bus.getPricing());
        pstmt.setInt(14, bus.getBusno());

        result = pstmt.executeUpdate();

	    return result;
	}
}
