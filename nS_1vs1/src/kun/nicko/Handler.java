package kun.nicko;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import kun.nicko.tablist.TabEvent;
import kun.nicko.titles.TitleAPI;
import kun.nicko.handler.Items;
import kun.nicko.handler.NoWinner;
import kun.nicko.mysql.Maps;

public class Handler {
	public static ArrayList<Player> spec = new ArrayList<>();
	public static int counter = 300;
	public static int LobbyCounter = 30;
	public static int Warmup = 5;
	public static int restart = 10;
	public static BukkitRunnable lobbycd;
	public static BukkitRunnable warmupcd;
	public static BukkitRunnable ingame;
	public static BukkitRunnable restartcd;
	public static ArrayList<Player> player1 = new ArrayList<>();
	public static ArrayList<Player> player2 = new ArrayList<>();

	public static void restart() {
		Main.setgamstate(GameStates.RESTART);
		restartcd = new BukkitRunnable() {

			@Override
			public void run() {
			

				restart--;
				
				if (restart == 0) {

					for (Player all : Bukkit.getOnlinePlayers()) {

						all.playSound(all.getLocation(), Sound.WOLF_GROWL, 10, 1);
					}
					Bukkit.shutdown();
				}

			}
		};
		restartcd.runTaskTimer(Main.getInstance(), 0L, 40L);
	}

	public static void start() {
		lobbycd = new BukkitRunnable() {

			@SuppressWarnings("deprecation")
			public void run() {

				if (Main.getgamestate() == GameStates.LOBBY) {

					if (Bukkit.getOnlinePlayers().size() >= 2) {
						LobbyCounter--;

						if (LobbyCounter == 60 || LobbyCounter == 30 || LobbyCounter == 15 || LobbyCounter == 10
								|| LobbyCounter == 5 || LobbyCounter == 4 || LobbyCounter == 3 || LobbyCounter == 2
								|| LobbyCounter == 1) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								TitleAPI.sendTitle(all, "§7O jogo começa em ", "§e" + LobbyCounter + "§7 segundos!",
										15, 3, 15);
							}
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);

							}

						}
						if (LobbyCounter == 25) {
							for (Player all : Bukkit.getOnlinePlayers()) {
								TitleAPI.sendTitle(all, "§7Mapa: §e" + Maps.getmap(),
										"§7Autor: §e" + Maps.getmapautor(), 15, 25, 15);
							}
						}

						if (LobbyCounter == 0) {
							warmup();
							for (Player all : Bukkit.getOnlinePlayers()) {
								TitleAPI.sendTitle(all, "§7O jogo começa", "§eagora§7!", 15, 5, 15);
							}
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
							}

							Player p1 = player1.get(0);
							Player p2 = player2.get(0);
							Location p1loc = Locations.getlocations("Player1", true);
							Location p2loc = Locations.getlocations("Player2", true);
							ArrayList<Location> locs = new ArrayList<>();
							locs.add(p1loc);
							locs.add(p2loc);
							for(Location chunkload : locs){
								chunkload.getChunk().load();
							}
							p1.teleport(p1loc);
							p2.teleport(p2loc);
							for(Player all : Bukkit.getOnlinePlayers()){
								TabEvent.onremoveTabList(all);
								TabEvent.onsetTabList(all);
							}
							p1.hidePlayer(p2);
							p2.hidePlayer(p1);
							p1.showPlayer(p2);
							p2.showPlayer(p1);
							

						}
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(LobbyCounter);

						}


					} else {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(LobbyCounter);
							all.setExp(0);
						}
						Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
						Objective obj = sb.getObjective("aaa");
						obj.setDisplayName("§7» §cAguardando o jogador...");
						LobbyCounter = 30;
					}
				}
			}
		};
		lobbycd.runTaskTimer(Main.getInstance(), 0L, 40L);
		
	}

	public static void warmup() {
		Main.setgamstate(GameStates.WARUMUP);
		warmupcd = new BukkitRunnable() {

			@Override
			public void run() {

				if (Main.getgamestate() == GameStates.WARUMUP) {

					if (Warmup == 5 || Warmup == 4 || Warmup == 3 || Warmup == 2 || Warmup == 1) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							TitleAPI.sendTitle(all, "§7O jogo começa em ", "§e" + Warmup + "§7 segundos!", 15, 5,
									15);
						}
						for (Player all : Bukkit.getOnlinePlayers()) {

							all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
						}

					}
					if(Warmup == 4){
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.getInventory().clear();
							Items.setitem(all);
							all.setFoodLevel(20);
							all.setHealth(20D);
							all.setLevel(0);
							all.setExp(0);
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 10);
						}
					}
					if (Warmup == 0) {

						ingame();
						Bukkit.broadcastMessage(Main.prefix + "§7O jogo começou! Boa sorte! :)");

					}
					Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
					Objective obj = sb.getObjective("aaa");
					obj.setDisplayName("§7» §l§9"+Warmup+" §7segundos");

					Warmup--;
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(Warmup);
					}

				}
			}
		};
		warmupcd.runTaskTimer(Main.getInstance(), 0L, 20L);

	}

	public static void ingame() {
		Main.setgamstate(GameStates.INGAME);
		ingame = new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {

				if (Main.getgamestate() == GameStates.INGAME) {

					double counterd = counter;
					int min = (int) (counterd / 60);
					
					if (counter == 0) {

						Bukkit.broadcastMessage(Main.prefix + "§cO jogo acabou! Nenhum vencedor. \n" + Main.prefix
								+ "§cComeçando novamente.");

						Bukkit.getScheduler().cancelTask(counter);
						restart();

						for (Player all : Bukkit.getOnlinePlayers()) {
							if (player1.contains(all) || player2.contains(all)) {
								NoWinner.onalllose(all);
							}
						}
					}
					Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
					Objective obj = sb.getObjective("aaa");
					obj.setDisplayName("§7» §l§9"+min+" §7minutos");

					counter--;
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(counter);
					}
				} else {

				}

			}
		};
		ingame.runTaskTimer(Main.getInstance(), 0L, 20L);

	}

}
