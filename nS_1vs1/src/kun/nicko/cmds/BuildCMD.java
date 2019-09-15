package kun.nicko.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kun.nicko.Main;
import kun.nicko.Message;


public class BuildCMD implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("lobby.gerente") || sender.hasPermission("lobby.builder")) {
			if (sender instanceof Player) {
				if (args.length <= 1) {
					if (Main.build.contains(sender)) {
						sender.sendMessage(Main.prefix + "�7Voc� n�o pode mais construir.");
						Message.failsound((Player)sender);
						Main.build.remove((Player) sender);
						((Player) sender).setGameMode(GameMode.SURVIVAL);
					} else {
						sender.sendMessage(Main.prefix + "�7Agora voc� pode construir.");
						Message.sucesssound((Player)sender);
						Main.build.add((Player) sender);
						((Player) sender).setGameMode(GameMode.CREATIVE);
					}
				} else {
					Message.sixerrada("build", (Player)sender);
				}
			}
		} else {
			Message.semperm((Player)sender);
		}
		return false;
	}
	

}
