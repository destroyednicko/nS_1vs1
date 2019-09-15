package kun.nicko.handler;

import org.bukkit.entity.Player;

import kun.nicko.mysql.MySQLMethoden;

public class NoWinner {
	public static void onalllose(Player p){
		MySQLMethoden.setlose(p, 1);
	}

}
