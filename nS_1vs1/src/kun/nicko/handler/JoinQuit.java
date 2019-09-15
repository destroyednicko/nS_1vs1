package kun.nicko.handler;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import kun.nicko.chat.ChatEvent;
import kun.nicko.tablist.TabEvent;
import kun.nicko.GameStates;
import kun.nicko.Handler;
import kun.nicko.Locations;
import kun.nicko.Main;
import kun.nicko.SetupHandle;
import kun.nicko.mysql.MySQLMethoden;
import kun.nicko.mysql.oooSB;

public class JoinQuit implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) | (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
				if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eDe volta ao lobby")) {
					Main.ConnectP(p, "Lobby1");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0F, 20.0F);
				}
		}
	}
	@EventHandler
	public void onchat(AsyncPlayerChatEvent e) {
		ChatEvent.onChat(e.getPlayer(), e);
	}

	@EventHandler
	public void onjoin(PlayerJoinEvent e) {
		if (SetupHandle.getsetup() == false) {
			Bukkit.broadcastMessage(Main.prefix + "§cVocê não definiu o Setup ainda.");
			return;
		}
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SURVIVAL);
		p.setHealth(20D);
		p.setFoodLevel(20);
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		p.setAllowFlight(false);
		p.setFlying(false);
		TabEvent.onsetTabList(e.getPlayer());
		if (Main.getgamestate() == GameStates.LOBBY) {
			Items.setlobbyitems(p);
			SetHolo.setholo(p);
			if (!MySQLMethoden.isregi(p)) {
				MySQLMethoden.setplayer(p);
			}
			if (Handler.player1.size() == 0) {
				Handler.player1.add(p);
			} else {
				Handler.player2.add(p);
			}

			p.teleport(Locations.getlocations("Lobby", true));
			oooSB.setsbt(p);

			e.setJoinMessage(Main.prefix + "§a * [+] §7" + e.getPlayer().getDisplayName());
			Handler.start();
		} else {
			e.setJoinMessage(null);
		}
	}


	@EventHandler
	public void onquit(PlayerQuitEvent e) {
		e.setQuitMessage(Main.prefix + "§c * [-] §7" + e.getPlayer().getDisplayName());
		TabEvent.onremoveTabList(e.getPlayer());
		if (Main.getgamestate() == GameStates.INGAME || Main.getgamestate() == GameStates.WARUMUP) {

			for (Player all : Bukkit.getOnlinePlayers()) {
				if (Handler.player1.contains(all) || Handler.player2.contains(all)) {
					all.sendMessage(Main.prefix + "§aVocê venceu a luta!");
					MySQLMethoden.setwins(all, 1);
					MySQLMethoden.setlose(e.getPlayer(), 1);
					MySQLMethoden.addcoins(all, 10);
					all.sendMessage(Main.prefix + "§8» §a+ §e10 Coins");
					all.sendMessage(Main.prefix + "§8» §a+ §e1 vitória");
					Handler.restart();
				}
			}

		} else if (Main.getgamestate() == GameStates.RESTART) {
			e.setQuitMessage(Main.prefix + "§7" + e.getPlayer().getDisplayName() + "§7 saiu do jogo.");
		} else {
			e.setQuitMessage(Main.prefix + "§7" + e.getPlayer().getDisplayName() + "§7 saiu do jogo.");
			if (Bukkit.getOnlinePlayers().size() == 1) {
				Bukkit.broadcastMessage(Main.prefix + "§cServidor em modo inativo...");
			} else {
				for (Player all : Bukkit.getOnlinePlayers()) {
					Bukkit.getScheduler().cancelAllTasks();
					Handler.start();
					Main.setgamstate(GameStates.LOBBY);
					if(Handler.player1.contains(e.getPlayer())){
						Handler.player1.remove(e.getPlayer());
					}
					if(Handler.player2.contains(e.getPlayer())){
						Handler.player2.remove(e.getPlayer());
					}
					all.sendMessage(Main.prefix + "§cAguardando novos oponentes...");
				}
			}

		}
	}

}
