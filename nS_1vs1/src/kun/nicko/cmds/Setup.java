package kun.nicko.cmds;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kun.nicko.Locations;
import kun.nicko.Main;
import kun.nicko.Message;


public class Setup implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.prefix+"§cComando executavel por jogadores.");
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("install.use")) {
			if ((args.length == 0) && (label.equalsIgnoreCase("1vs1"))) {
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage("§3§m------------------" + " §7nStorm - Instalação - 1x1 " + "§3§m------------------");
				p.sendMessage(Main.prefix + "§7- /install set §c- §Definir spawn dos jogadores.");
				p.sendMessage(Main.prefix + "§7- /install setspawn §c- §eDefine o spawn.");
				p.sendMessage(Main.prefix + "§7- /install setholo §c- §eDefine o holograma.");
				p.sendMessage("§3§m------------------" + " §7nStorm - Instalação - 1x1 " + "§3§m------------------");
				p.sendMessage("");
				p.sendMessage("");
				p.sendMessage("");
			}
		} else {
			Message.semperm(p);
		}
		if (p.hasPermission("install.use")) {
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("setspawn")){
					Locations.setlocations(p, "Lobby");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.prefix+"§7O lobby foi definido.");
				}
				if(args[0].equalsIgnoreCase("setholo")){
					Locations.setlocations(p, "Hologram");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
					p.sendMessage(Main.prefix+"§7O holograma foi definido.");
				}
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("set")) {
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("§3§m------------------" + " §7nStorm - Instalação - 1x1 " + "§3§m------------------");
					p.sendMessage(Main.prefix + "§7- /install set §c- §Definir spawn dos jogadores.");
					p.sendMessage(Main.prefix + "§7- /install setspawn §c- §eDefine o spawn.");
					p.sendMessage(Main.prefix + "§7- /install setholo §c- §eDefine o holograma.");
					p.sendMessage("§3§m------------------" + " §7nStorm - Instalação - 1x1 " + "§3§m------------------");
					p.sendMessage("");
					p.sendMessage("");
					p.sendMessage("");
				}
			}
			if (args.length == 2) {
				if (args[1].equalsIgnoreCase("Player1")) {
					if (args[0].equalsIgnoreCase("set")) {

					}
					return false;
				}
				if (p.hasPermission("install.use")) {
					if (args.length == 2) {
						if (args[1].equalsIgnoreCase("Player2")) {
							if (args[0].equalsIgnoreCase("set")); 
							}
						}
						if (p.hasPermission("install.use")) {
							if (args.length == 2) {
								if (args[1].equalsIgnoreCase("spec")) {
									if (args[0].equalsIgnoreCase("set")) {
									}
									return false;
								}
							}
						}
					}
				}
			} else {
			Message.semperm(p);
		} 
		return false;
	}
}
