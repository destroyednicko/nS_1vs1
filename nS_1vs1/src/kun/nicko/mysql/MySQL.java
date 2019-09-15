package kun.nicko.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

	public static String host;
	public static String database;
	public static String user;
	public static String passwd;
	public static Connection con;
	public static Connection coinscon;

	public static void connect() {
		if (!isconnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:" + "3306/" + "DB1v1" + "?autoReconnect=true", "root", "ASxAYvPKgbw3UmNr");
				System.out.println("[1vs1] Conex�o ao DB bem sucedida...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public static void disconnect() {
		if (isconnected()) {
			try {
				con.close();
				System.out.println("[1vs1] DB desconectado.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean isconnected() {
		return (con == null ? false : true);

	}

	public static PreparedStatement getStatement(String sql) {
		if (isconnected()) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				return ps;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static ResultSet getResult(String sql) {
		if (isconnected()) {
			PreparedStatement ps;
			ResultSet rs;
			try {
				ps = getStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
