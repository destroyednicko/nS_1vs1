package kun.nicko.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MySQLMethoden {

	public static boolean isregi(Player p) {
		String uuid = p.getUniqueId().toString();
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM 1vs1 WHERE UUID= ?");
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			boolean user = rs.next();
			rs.close();
			rs.close();
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void setplayer(Player p) {
		String uuid = p.getUniqueId().toString();
		PreparedStatement ps = MySQL.getStatement(
				"INSERT INTO 1vs1 (UUID, Tode, Kills, Wins, Lose) VALUES (?, ?, ?, ?, ?)");
		try {
			ps.setString(1, uuid);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setInt(5, 0);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Bukkit.getConsoleSender()
				.sendMessage("[1vs1SQL] Um novo jogador chamado " + p.getName() + " foi adicionado.");

	}
	public static int getloses(Player p) {
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM 1vs1 WHERE UUID= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int ach = rs.getInt("Lose");
			rs.close();
			ps.close();
			return ach;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static void setlose(Player p, int neuerlose) {
		if (isregi(p)) {
			
			String uuid = p.getUniqueId().toString();
			PreparedStatement ps = MySQL.getStatement("UPDATE 1vs1 SET Lose= ? WHERE UUID= ?");
			try {
				ps.setInt(1, getloses(p)+neuerlose);
				ps.setString(2, uuid);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			setplayer(p);
		}
	}

	public static int getwins(Player p) {
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM 1vs1 WHERE UUID= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int ach = rs.getInt("Wins");
			rs.close();
			ps.close();
			return ach;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static void setwins(Player p, int neuerwin) {
		if (isregi(p)) {
			
			String uuid = p.getUniqueId().toString();
			PreparedStatement ps = MySQL.getStatement("UPDATE 1vs1 SET Wins= ? WHERE UUID= ?");
			try {
				ps.setInt(1, getwins(p)+neuerwin);
				ps.setString(2, uuid);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			setplayer(p);
		}
	}

	public static void setkill(Player p, int kills) {
		if (isregi(p)) {
			String uuid = p.getUniqueId().toString();
			PreparedStatement ps = MySQL.getStatement("UPDATE 1vs1 SET Kills= ? WHERE UUID= ?");
			try {
				ps.setInt(1, kills);
				ps.setString(2, uuid);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.getConsoleSender()
					.sendMessage("[1vs1SQL] Uma kill foi adicionada para " + p.getName());
		} else {
			setplayer(p);
		}
	}

	public static void setdeath(Player p, int tode) {
		String uuid = p.getUniqueId().toString();
		if (isregi(p)) {
			PreparedStatement ps = MySQL.getStatement("UPDATE 1vs1 SET Tode= ? WHERE UUID= ?");
			try {
				ps.setInt(1, tode);
				ps.setString(2, uuid);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.getConsoleSender()
					.sendMessage("[1vs1SQL] Uma nova morte foi adicionada para " + p.getName());
		} else {
			setplayer(p);
		}

	}

	public static void addcoins(Player p, int coinstoadd) {
		String uuid = p.getUniqueId().toString();
		int coins = getCoins(p);
		PreparedStatement ps = MySQL.getStatement("UPDATE Coins SET Coins= ? WHERE UUID= ?");
		try {
			ps.setInt(1, coins + coinstoadd);
			ps.setString(2, uuid);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void removecoins(Player p, int toremove) {
		String uuid = p.getUniqueId().toString();
		int coins = getCoins(p);
		PreparedStatement ps = MySQL.getStatement("UPDATE Coins SET Coins= ? WHERE UUID= ?");
		try {
			ps.setInt(1, coins - toremove);
			ps.setString(2, uuid);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getCoins(Player p) {
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM Coins WHERE UUID= ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int coins = rs.getInt("Coins");
			rs.close();
			ps.close();
			return coins;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static int getkills(Player p) {
		String uuid = p.getUniqueId().toString();
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM 1vs1 WHERE UUID= ?");
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int kills = rs.getInt("Kills");
			rs.close();
			ps.close();
			return kills;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;

	}

	public static int getdeaths(Player p) {
		String uuid = p.getUniqueId().toString();
		try {
			PreparedStatement ps = MySQL.getStatement("SELECT * FROM 1vs1 WHERE UUID= ?");
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int tode = rs.getInt("Tode");
			rs.close();
			ps.close();
			return tode;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;

	}


}
