package Pelle;

import java.sql.*;

public class Mysql {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://88.196.217.224:3306/proov";

	public static void start() {
		Connection conn = null;
		Statement stmt = null;
		String USER="pelleproosa";
		String PASS="Spordi2611";
		
		try{
			  //STEP 2: Register JDBC driver
			  Class.forName("com.mysql.jdbc.Driver");

			  //STEP 3: Open a connection
			  //System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);
System.out.println("Connected!");
			  //STEP 4: Execute a query
			 // System.out.println("Creating statement...");
			  stmt = conn.createStatement();

			  
			//  String sql;
			  String sql = "SELECT ID, Nimi, Perenimi, Vanus FROM isikud";
			  ResultSet rs = stmt.executeQuery(sql);

			  //STEP 5: Extract data from result set
			  while(rs.next()){
			     //Retrieve by column name
			  	
			  	
			     int id  = rs.getInt("ID");
			     String str1=rs.getString("Nimi");
			     String str2=rs.getString("Perenimi");
			     int vanus  = rs.getInt("Vanus");
			    System.out.println("ID: "+id+"  Nimi: "+str1+"  Perenimi: "+str2+"  Vanus: "+vanus);	
			     
			  }
			  //STEP 6: Clean-up environment
			  rs.close();
			  stmt.close();
			  conn.close();
			}catch(SQLException se){
			  //Handle errors for JDBC
			  se.printStackTrace();
			}catch(Exception e){
			  //Handle errors for Class.forName
			  e.printStackTrace();
			}finally{
			  //finally block used to close resources
			  try{
			     if(stmt!=null)
			        stmt.close();
			  }catch(SQLException se2){
			  }// nothing we can do
			  try{
			     if(conn!=null)
			        conn.close();
			  }catch(SQLException se){
			     se.printStackTrace();
			  }//end finally try
			}//end try
			//System.out.println(".ok.");

		
		
		
		
		
		
		
		

	}

}
