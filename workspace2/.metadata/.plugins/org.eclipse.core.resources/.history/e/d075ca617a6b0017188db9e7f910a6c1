package com.mkyong.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tabletemp")
public class Tabletemp {
	@GET
	@Path("/Temp")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TempVO> getMsg() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<TempVO> dataArr = new ArrayList<TempVO>();
		try
		{
			

			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");

			String query = "SELECT * FROM Temp";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next())
			{
				TempVO data=new TempVO();
				Date day = rs.getDate("Day");
				float temperature = rs.getFloat("Temperature");
				
				
				
				System.out.println(day);
				System.out.println(temperature);
				
				String output = day +"   "+ temperature;
				data.setDay(day);
				data.setTemperature(temperature);
				
				
				dataArr.add(data);
			}
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}


		finally {
			try {
				if(st!= null){
					st.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if(rs!= null){
					rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if(conn!= null){
					conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return dataArr;
		
	}
}
