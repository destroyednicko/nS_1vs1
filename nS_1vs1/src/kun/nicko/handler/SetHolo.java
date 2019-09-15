package kun.nicko.handler;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import kun.nicko.Locations;
import kun.nicko.mysql.Hologram;
import kun.nicko.mysql.MySQLMethoden;

public class SetHolo {

	public static void setholo(Player p) {
		int kills = MySQLMethoden.getkills(p);
		int tode = MySQLMethoden.getdeaths(p);
		int coins = MySQLMethoden.getCoins(p);
		int wins = MySQLMethoden.getwins(p);
		int loses = MySQLMethoden.getloses(p);
		int kd = 0;
		if (!(tode == 0)) {
			if (!(kills == 0)) {
				kd = kills / tode;
			}
		}
		Location hololoc = Locations.getlocations("Hologram", false);
		String[] Text = { "§8§m--§r §e" + p.getDisplayName() + " §8§m--", "§7Suas kills: §6" + kills,
				"§7Suas mortes: §6" + tode, "§7Seu K/D: §6" + kd, "§7Suas vitórias: §6" + wins,
				"§7Suas derrotas: §6" + loses, "§7Seus coins: §6" + coins, "§8§m--§r §eEstatisticas §8§m--" };
		Hologram holo = new Hologram(Text, hololoc);
		holo.showPlayer(p);
	}

}
