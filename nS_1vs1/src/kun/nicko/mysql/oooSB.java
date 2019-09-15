package kun.nicko.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class oooSB {

	public static void setsbt(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		if(board.getObjective(DisplaySlot.SIDEBAR) != null){
			board.getObjective("aaa").unregister();
		}
		Objective obj = board.registerNewObjective("aaa", "bbb");

		obj.setDisplayName("§7» §eIniciando...");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score s7 = obj.getScore("§4");
		Score s8 = obj.getScore("§8» §e§lnS-1V1");
		Score s9 = obj.getScore("§5");

		Score s13 = obj.getScore("§2");
		Score s14 = obj.getScore("§8» §eMapa:");
		Score s15 = obj.getScore(" §2§8» §7"+Maps.getmap());

		Score s16 = obj.getScore("§1");
		Score s17 = obj.getScore(" §9§8» §7ynickokun.tk");

		s17.setScore(9);
		s16.setScore(10);
		s15.setScore(11);
		s14.setScore(12);
		s13.setScore(13);
		s9.setScore(14);
		s8.setScore(15);
		s7.setScore(16);

		p.setScoreboard(board);
	}
}