package kun.nicko;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Locations {
	
	public static void setlocations(Player p, String name) {
		String mundo = p.getWorld().getName();

		double x = p.getLocation().getX();
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ();

		double yaw = p.getLocation().getYaw();
		double pitch = p.getLocation().getPitch();

		Main.cfg.set("1vs1.Spawns." + name + ".Mundo", mundo);
		Main.cfg.set("1vs1.Spawns." + name + ".X", x);
		Main.cfg.set("1vs1.Spawns." + name + ".Y", y);
		Main.cfg.set("1vs1.Spawns." + name + ".Z", z);
		Main.cfg.set("1vs1.Spawns." + name + ".Yaw", yaw);
		Main.cfg.set("1vs1.Spawns." + name + ".Pitch", pitch);

		try {
			Main.cfg.save(Main.file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Location getlocations(String string, boolean b) {
		String mundo = Main.cfg.getString("1vs1.Spawns." + string + ".Mundo");

		double x = Main.cfg.getDouble("1vs1.Spawns." + string + ".X");
		double y = Main.cfg.getDouble("1vs1.Spawns." + string + ".Y");
		double z = Main.cfg.getDouble("1vs1.Spawns." + string + ".Z");
		Location loc = new Location(Bukkit.getWorld(mundo), x, y, z);
		if(b == true){
			double yaw = Main.cfg.getDouble("1vs1.Spawns." + string + ".Yaw");
			double pitch = Main.cfg.getDouble("1vs1.Spawns." + string + ".Pitch");
			loc.setYaw((float) yaw);
			loc.setPitch((float) pitch);			
		}



		return loc;
	}

	
	
	
}
