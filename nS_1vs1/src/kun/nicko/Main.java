package kun.nicko;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import kun.nicko.cmds.BuildCMD;
import kun.nicko.cmds.FixCMD;
import kun.nicko.cmds.Setup;
import kun.nicko.cmds.StatsCommand;
import kun.nicko.handler.JoinQuit;
import kun.nicko.handler.death;
import kun.nicko.listener.StuffListener;
import kun.nicko.mysql.Maps;
import kun.nicko.mysql.MySQL;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;


public class Main extends JavaPlugin {

	public static String prefix = "§9 * 1vs1 §8┃ §7";
	public static GameStates gmst;
	public static Main insta;
	public static File file = new File("plugins/nS_1vs1", "locs.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static File file2 = new File("plugins/nS_1vs1", "map.yml");
	public static FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
	public static ArrayList<Player> build = new ArrayList<>();
	public static ArrayList<Player> specs = new ArrayList<>();

	@Override
	public void onEnable() {
		insta = this;
		setgamstate(GameStates.LOBBY);
		Restart.restartcd();
		Maps.setmapvalue();
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
	        ((CraftServer) Bukkit.getServer()).getCommandMap().register("1v1", new BuildCMD());
	        ((CraftServer) Bukkit.getServer()).getCommandMap().register("1v1", new Setup());
	        ((CraftServer) Bukkit.getServer()).getCommandMap().register("1v1", new StatsCommand());

		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new StuffListener(), this);
		pm.registerEvents(new death(), this);
		System.out.println("[1vs1] Iniciando.");

		MySQL.connect();
		if (MySQL.isconnected()) {
			PreparedStatement ps = MySQL.getStatement(
					"CREATE TABLE IF NOT EXISTS 1vs1 (UUID VARCHAR(255),Tode INT(255),Kills INT(255), Wins INT(255), Lose INT(255))");

			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void ConnectP(Player p, String server) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);

		try {
			out.writeUTF("Connect");
			out.writeUTF(server);
		} catch (IOException ex) {
			p.sendMessage(Main.prefix + "§7Servidor não acessivel!");
		}
		p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
	}

	@Override
	public void onDisable() {
		System.out.println("[1vs1] Parando.");
	}

	public static GameStates getgamestate() {
		return gmst;
	}

	public static void setgamstate(GameStates gmste) {
		gmst = gmste;
	}

	public static Plugin getInstance() {
		// TODO Auto-generated method stub
		return insta;
	}

}
