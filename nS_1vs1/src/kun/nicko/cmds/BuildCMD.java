package kun.nicko.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import kun.nicko.Main;
import kun.nicko.Message;

public class BuildCMD extends Command{
	
		public BuildCMD() {
		super("build");

	}
	
	
	@Override
	public boolean execute(CommandSender sender, String arg1, String[] args) {
		if (sender.hasPermission("lobby.gerente") || sender.hasPermission("lobby.builder")) {
			if (sender instanceof Player) {
				if (args.length <= 1) {
					if (Main.build.contains(sender)) {
						sender.sendMessage(Main.prefix + "§7Você não pode mais construir.");
						Message.failsound((Player)sender);
						Main.build.remove((Player) sender);
						((Player) sender).setGameMode(GameMode.SURVIVAL);
					} else {
						sender.sendMessage(Main.prefix + "§7Agora você pode construir.");
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
