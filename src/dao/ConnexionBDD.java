package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;




public final class ConnexionBDD {

	private static volatile ConnexionBDD instance;
	private Connection cnx; 
	
	private ConnexionBDD() {
		try {
			
//			Properties p = new Properties();
//			p.load(Thread.currentThread().getContextClassLoader().
//						getResourceAsStream("confBDD.properties"));
			
			
			// chargement du driver
//			Class.forName(p.getProperty("driver"));
//			cnx = DriverManager.getConnection(p.getProperty("url"),
//					p.getProperty("user"), p.getProperty("pwd"));
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver chargé");
			cnx=DriverManager.getConnection("jdbc:postgresql://localhost:5432/videoGames", "pierrebathellier", "");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		if (cnx != null)
		{
			System.out.println("You made it, take control your database now!");
		}
		else
		{
			System.out.println("Failed to make connection!");
		}
	} 
	
	public static synchronized ConnexionBDD getInstance() {
		if(instance==null)
			instance = new ConnexionBDD();
		
		return instance;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void closeCnx() throws SQLException{
		if(cnx!=null){
			cnx.close();
			instance=null;
		}
	}
}
