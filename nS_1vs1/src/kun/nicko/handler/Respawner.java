package kun.nicko.handler;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import kun.nicko.Handler;

public class Respawner {

	public static void restarteratdeath(Player p, Player k) {
		p.spigot().respawn();
		p.setAllowFlight(true);
		p.setFlying(true);

		p.getInventory().clear();
		p.setGameMode(GameMode.ADVENTURE);
		p.teleport(k.getLocation());
		Handler.restart();

	}

}
