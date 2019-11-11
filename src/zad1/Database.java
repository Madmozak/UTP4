package zad1;

import java.sql.*;
import java.util.Locale;
import java.util.Properties;

public class Database {
	
	String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	String url;
	Connection connection;
	TravelData travelData;
	Statement statement;
	String sql;
	String username = "username";
	String password = "password";
	
	
	public Database(String url, TravelData travelData) {
		this.url = url;
		this.travelData = travelData;
		
		
	}

	public void create() {

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url);
			if(connection !=null) {
				System.out.println(connection.getMetaData().getDriverName());
			}
			statement = connection.createStatement();
			sql = "CREATE TABLE FIRSTTABLE (ID INT PRIMARY KEY, "
					+ "Lokalizacja VARCHAR(20), "
					+ "Kraj VARCHAR(20), "
					+ "Data_wyjazdu DATE, "
					+ "Data_powrotu DATE, "
					+ "Miejscie VARCHAR(20), "
					+ "Cena VARCHAR(20), "
					+ "Symbol_waluty VARCHAR(10))";
			statement.executeUpdate(sql);
			sql = "INSERT INTO FIRSTTABLE VALUES "
					+ "(1, 'pl', 'Japonia', '2015-09-01', '2015-10-01', 'jezioro', '10000,20', 'PLN'),"
					+ "(2, 'pl_PL',	'Włochy', '2015-07-10',	'2015-07-30', 'morze', '4000,10', 'PLN'),"
					+ "(3, 'en_GB',	'United States', '2015-07-10', '2015-08-30', 'mountains', '5,400.20', 'USD') ";
			statement.executeUpdate(sql);
			ResultSet resutl = statement.executeQuery("SELECT * FROM FIRSTTABLE");;
			System.out.println(resutl);
			System.out.println("okey");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
	}

	public void showGui() {
		new LocaleSelection(travelData.dataDir);
		//new GuiOferty(travelData.dataDir);
		
		
	}

}
