package com.redbus.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Utils {
	public static Scanner sc = new Scanner(System.in);
	static Connection con;
	public synchronized static Connection getConnection() throws IOException, SQLException {
		if(con == null) {
			FileInputStream fis = new FileInputStream("application.properties");
			Properties cfg = new Properties();
			cfg.load(fis);
			con = DriverManager.getConnection(cfg.getProperty("url"),cfg.getProperty("username"),cfg.getProperty("password"));
			System.out.println(con);
		}
		return con;
	}
}
