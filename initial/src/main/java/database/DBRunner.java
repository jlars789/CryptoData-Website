package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import currency.Currency;

public class DBRunner {

	private static final Logger logger = LoggerFactory.getLogger(DBRunner.class);
	
	public static Currency[] currency;
	
	public static void intializeData() {
		String resourceName = "/CurrencyFixture.json";
		System.out.println("INITIALIZING DATA!");
        InputStream is = DBRunner.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONArray array = new JSONArray(tokener);
        
        currency = new Currency[array.length()];
        
        for(int i = 0; i < currency.length; i++) {
        	String cd = array.getJSONObject(i).getString("code");
        	currency[i] = new Currency(cd);
        	
        }
        
        try {
			Connection dbConn = getRemoteConnection();
			if(dbConn == null) return;
			//String query = "SELECT * from Hourly WHERE time > " + shaveToYesterday();
			String query  = "SELECT * from Hourly0 WHERE COMP IS NOT NULL";
			PreparedStatement pst;
			pst = dbConn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			//ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()) {
				for(int i = 0 ; i < currency.length; i++) {
					currency[i].initializeDataEntry(rs.getDouble(currency[i].getCode()));
				}
			}
			
			for(int i = 0; i < currency.length; i++) {
				currency[i].init();
			}
        }
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dataRefresh(JSONArray exchangeData) {
		
		for(int i = 0 ; i < currency.length; i++) {
			for(int j = 0; j < exchangeData.length(); j++) {
				if(exchangeData.getJSONObject(j).getString("symbol").equals(currency[i].getCode())) {
					currency[i].updateTempData(exchangeData.getJSONObject(j).getDouble("priceUsd"));
					break;
				}
			}
		}
	}
	
	public static void permDataRefresh() {
		try {
			Connection dbConn = getRemoteConnection();
			if(dbConn == null) return;
			//String query = "SELECT * from Hourly WHERE time > " + shaveToYesterday();
			String query  = "SELECT * FROM Hourly0 ORDER BY time DESC LIMIT 1";
			PreparedStatement pst;
			pst = dbConn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			//ResultSetMetaData rsmd = rs.getMetaData();
			
			rs.next();
			for(int i = 0; i < currency.length; i++) {
				currency[i].updateData(rs.getDouble(currency[i].getCode()));
			}
        }
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getRemoteConnection() {
		try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      String dbName = "crypto";
	      String userName = System.getenv("RDS_USER");
	      String password = System.getenv("RDS_PASSWORD");
	      String hostname = System.getenv("RDS_HOSTNAME");
	      String port = "3306";
	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      Connection con = DriverManager.getConnection(jdbcUrl);
	      return con;
	    } catch (ClassNotFoundException e) { 
	    	e.printStackTrace();
	    }
	    catch (SQLException e) { 
	    	e.printStackTrace();
	    }
	    return null;
	    
	}
	
}
