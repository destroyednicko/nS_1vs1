package kun.nicko.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kun.nicko.Main;
import kun.nicko.Message;
import kun.nicko.mysql.MySQLMethoden;

public class StatsCommand extends Command {
	
	public StatsCommand(){
	   super("stats");	
	}
	
       @Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		Player p = (Player) sender;
		int kills = MySQLMethoden.getkills(p);
		int deaths = MySQLMethoden.getdeaths(p);
		int coinsp = MySQLMethoden.getCoins(p);
		int wins = MySQLMethoden.getwins(p);
		int loses = MySQLMethoden.getloses(p);
		if (args.length == 0) {
			if ((kills == 0) && (deaths == 0)) {
				p.sendMessage("§3§m-------------------------");
				p.sendMessage("§8» §7Jogador: §9" + p.getName());
				p.sendMessage(" ");
				p.sendMessage("§8» §cVocê não jogou o §e1vs1 §cainda!");
				p.sendMessage("§3§m-------------------------");
			} else if (deaths == 0) {
				p.sendMessage("§3§m-------------------------");
				p.sendMessage("§8 »§7Jogador: §9" + p.getName());
				p.sendMessage(" ");
				p.sendMessage("§8» §eVitórias: §c" + wins);
				p.sendMessage("§8» §eDerrotas: §c" + loses);
				p.sendMessage("§8» §eCoins: §c" + coinsp);
				p.sendMessage("§8» §eKills: §c" + kills);
				p.sendMessage("§8» §eMortes: §c0");
				p.sendMessage("§8» §eK/D: §c" + kills);
				p.sendMessage("§3§m-------------------------");
			} else {
				double kd = kills / deaths;
				p.sendMessage("§3§m-------------------------");
				p.sendMessage("§8» §7Jogador: §9" + p.getName());
				p.sendMessage(" ");
				p.sendMessage("§8» §eVitórias: §c" + wins);
				p.sendMessage("§8» §eDerrotas: §c" + loses);
				p.sendMessage("§8» §eCoins: §c" + coinsp);
				p.sendMessage("§8» §eKills: §c" + kills);
				p.sendMessage("§8» §eMortes: §c" + deaths);
				p.sendMessage("§8» §eK/D: §c" + kd);
				p.sendMessage("§3§m-------------------------");
			}
		} else if (args.length == 1) {
			String tar = args[0];
			Player target = Bukkit.getPlayer(tar);
			int kills1 = MySQLMethoden.getkills(target);
			int deaths1 = MySQLMethoden.getdeaths(target);
			int coinst = MySQLMethoden.getCoins(target);
			int wins1 = MySQLMethoden.getwins(target);
			int loses1 = MySQLMethoden.getloses(target);
				if (target.hasPlayedBefore()) {
					if (target.isOnline() == true) {
						if ((kills1 == 0) && (deaths1 == 0)) {
							p.sendMessage("§3§m-------------------------");
							p.sendMessage("§8» §7Jogador: §9" + target.getName());
							p.sendMessage(" ");
							p.sendMessage("§8» §cAté agora §9" + target.getDisplayName() + "§c não jogou §e1vs1 §cainda!");
							p.sendMessage("§3§m-------------------------");
						} else if (deaths1 == 0) {
							p.sendMessage("§3§m-------------------------");
							p.sendMessage("§8» §7Jogador: §9" + target.getName());
							p.sendMessage(" ");
							p.sendMessage("§8» §eVitórias: §c" + wins1);
							p.sendMessage("§8» §eDerrotas: §c" + loses1);
							p.sendMessage("§8» §eCoins: §c" + coinst);
							p.sendMessage("§8» §eKills: §c" + kills1);
							p.sendMessage("§8» §eMortes: §c0");
							p.sendMessage("§8» §eK/D: §c" + kills1);
							p.sendMessage("§3§m-------------------------");
						} else {
							double kd = kills1 / deaths1;
							p.sendMessage("§3§m-------------------------");
							p.sendMessage("§8» §7Jogador: §9" + target.getName());
							p.sendMessage(" ");
							p.sendMessage("§8» §eVitórias: §c" + wins1);
							p.sendMessage("§8» §eDerrotas: §c" + loses1);
							p.sendMessage("§8» §eCoins: §c" + coinst);
							p.sendMessage("§8» §eKills: §c" + kills1);
							p.sendMessage("§8» §eMortes: §c" + deaths1);
							p.sendMessage("§8» §eK/D: §c" + kd);
							p.sendMessage("§3§m-------------------------");
						}
					} else {
						p.sendMessage(Main.prefix + "§9" + target.getDisplayName() + "§c não está online!");
					}
				} else {
					p.sendMessage(Main.prefix + "§cO Jogador §9" + target.getDisplayName() + " §cnão existe.");
				}

		} else {
			Message.sixerrada("stats <Jogador>", p);
		}
		return true;
	}

}
