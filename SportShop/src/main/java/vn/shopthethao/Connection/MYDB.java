package vn.shopthethao.Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class MYDB {
	private final String serverName = "DESKTOP-L2I9TPJ";
	private final String dbName = "ShopTheThao";
	private final String portNumber = "1433";
	private final String instance="";//MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String username = "sa";
	private final String password = "123456";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://"+ serverName+ ":1433"+";databaseName="+dbName;
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		return DriverManager.getConnection(url, username, password);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			System.out.println(new MYDB().getConnection().getMetaData());
		} catch (Exception e) {
			
		}
	}
	

}
