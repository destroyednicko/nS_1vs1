package kun.nicko.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kun.nicko.Main;
import kun.nicko.Message;

public class FixCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("fix")) {
				if (args.length == 0) {
					p.sendMessage(Main.prefix + "�aVoc� se fixou.");

					p.teleport(p.getLocation().add(0.0D, 0.2D, 0.0D));
				} else {
					Message.sixerrada("fix", p);
				}
			} else {
				Message.sixerrada("fix", p);
			}

		}

		return false;
	}
}
