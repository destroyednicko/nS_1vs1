package kun.nicko;

import org.bukkit.Sound;
import org.bukkit.entity.Player;


public class Message {
	
	public static void sixerrada(String ComandoSinx, Player s){
		failsound(s);
		s.sendMessage(Main.prefix+"§cSixtase incorreta,  §e/"+ComandoSinx+"§c!");
	}
	public static void semperm(Player p){
		failsound(p);
		p.sendMessage(Main.prefix+"§cVocê não tem permissão para isso.");
	}
	public static void sucesssound(Player p){
			p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 10, 10);
	}
	public static void failsound(Player p){
			p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 10, 10);
	}

}
