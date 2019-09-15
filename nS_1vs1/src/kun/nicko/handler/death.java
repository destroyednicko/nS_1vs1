package kun.nicko.handler;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import kun.nicko.titles.TitleAPI;
import kun.nicko.Handler;
import kun.nicko.Main;
import kun.nicko.listener.StuffListener;
import kun.nicko.mysql.MySQLMethoden;

public class death implements Listener{
	
	@EventHandler
	public void onrespawn(PlayerRespawnEvent e){
		Handler.restart();
	}
	
	@EventHandler
	public void ondeath(PlayerDeathEvent e){

		e.setDeathMessage(null);
		Player p = e.getEntity();
		Player k = p.getKiller();
		e.setDroppedExp(0);
		if (!(p != k) || !(k instanceof Player)) {
			Player last = null;
			if(!StuffListener.luta.containsKey(p)){
				if(Handler.player1.contains(p)){
					last = Handler.player2.get(0);
				}else if(Handler.player2.contains(p)){
					last = Handler.player1.get(0);					
				}else {
					Bukkit.shutdown();
				}
			}else {
				last = (Player) StuffListener.luta.get(p);
			}
			int lastills = MySQLMethoden.getkills(last);
			int deaths = MySQLMethoden.getdeaths(p);

				MySQLMethoden.addcoins(p, 5);
			MySQLMethoden.addcoins(last, 100);
			MySQLMethoden.setdeath(p, deaths + 1);
			MySQLMethoden.setkill(last, lastills + 1);
			MySQLMethoden.setlose(p, 1);
			MySQLMethoden.setwins(last, 1);


			Respawner.restarteratdeath(p, last);
			TitleAPI.sendTitle(p, "§cDerrota!", "§7Você levou §e5 §7Coins por perder!", 15, 20, 15);
			TitleAPI.sendTitle(last, "§aVitória!", "§7Você levou §e100 §7Coins por vencer!", 15, 20, 15);
			p.sendMessage(Main.prefix + "§8» §c+ §e1 morte nas estatisticas");
			last.sendMessage(Main.prefix + "§8» §a+ §e1 kill nas estatisticas");
			p.sendMessage(Main.prefix + "§8» §c+ §e1 derrota nas estatisticas");
			last.sendMessage(Main.prefix + "§8» §a+ §e1 vitória nas estatisticas");
			TitleAPI.randomFireworks(last);
			for(Player all : Bukkit.getOnlinePlayers()){
				TitleAPI.sendTitle(all, "§4Servior reiniciando", "§eAguarde um momento...", 15, 150, 15);
			}
			Handler.restart();
			p.getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 4);
			e.getDrops().clear();
			Respawner.restarteratdeath(p, last);
		} else {
			int kills = MySQLMethoden.getkills(k);
			int deaths = MySQLMethoden.getdeaths(p);

				MySQLMethoden.addcoins(p, 5);
			MySQLMethoden.addcoins(k, 100);
			MySQLMethoden.setdeath(p, deaths + 1);
			MySQLMethoden.setkill(k, kills + 1);
			MySQLMethoden.setlose(p, 1);
			MySQLMethoden.setwins(k, 1);


			Respawner.restarteratdeath(p, k);
			TitleAPI.sendTitle(k, "§cDerrota!", "§7Você levou §e5 §7Coins por perder!", 15, 20, 15);
			TitleAPI.sendTitle(k, "§aViória!", "§7Você levou §e100 §7Coins por vencer!", 15, 20, 15);
			p.sendMessage(Main.prefix + "§8» §c+ §e1 morte nas estatisticas");
			k.sendMessage(Main.prefix + "§8» §a+ §e1 kill nas estatisticas");
			p.sendMessage(Main.prefix + "§8» §c+ §e1 derrota nas estatisticas");
			k.sendMessage(Main.prefix + "§8» §a+ §e1 vitória nas estatisticas");
			Handler.restart();
			p.getWorld().playEffect(p.getLocation(), Effect.LAVA_POP, 4);
			e.getDrops().clear();
			if (((CraftPlayer) k).getHealth() != 20.0D) {
				p.sendMessage(Main.prefix + "§7Voc~e foi morto por " + k.getDisplayName() + " §7com §4"
						+ Math.round((int) (((CraftPlayer) k).getHealth() + 1.0D) * 10.0D) / 20.0D + " §7de HP.");
				k.sendMessage(Main.prefix + "§7Você matou " + p.getDisplayName() + " §7com §4"
						+ Math.round((int) (((CraftPlayer) k).getHealth() + 1.0D) * 10.0D) / 20.0D + " §7de HP.");
			} else {
				p.sendMessage(Main.prefix + "§7Você foi morto por " + k.getDisplayName() + " §7com §4"
						+ Math.round((int) ((CraftPlayer) k).getHealth() * 10.0D) / 20.0D + " §7de HP");
				k.sendMessage(Main.prefix + "§7Você matou " + p.getDisplayName() + " §7com §4"
						+ Math.round((int) ((CraftPlayer) k).getHealth() * 10.0D) / 20.0D + " §7de HP.");
			}

		}
	}

}
