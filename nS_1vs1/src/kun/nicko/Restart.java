package kun.nicko;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Restart {

	public static void restartcd() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				if(Bukkit.getOnlinePlayers().size() != 2 || Main.getgamestate() != GameStates.INGAME || Main.getgamestate() != GameStates.RESTART || Main.getgamestate() != GameStates.WARUMUP){
					Date date = new Date();
					if ((date.getHours() == 10) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 11) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 12) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 13) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 14) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 15) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 16) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 17) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 18) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 20) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 21) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 22) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 23) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 0) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 1) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 2) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 3) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 4) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 5) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 6) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 7) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();

							}
						}, 50L);
					}
					if ((date.getHours() == 8) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
							
							@Override
							public void run() {
								Bukkit.getServer().shutdown();
								
							}
						}, 50L);
					}
					if ((date.getHours() == 9) && (date.getMinutes() == 0) && (date.getSeconds() == 0)) {
						Bukkit.broadcastMessage(Main.prefix + "§cServidor reiniciando.");
						for (Player ps : Bukkit.getOnlinePlayers()) {
							ps.playSound(ps.getLocation(), Sound.NOTE_BASS_GUITAR, 10, 1);
						}
						Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
							
							@Override
							public void run() {
								Bukkit.getServer().shutdown();
								
							}
						}, 50L);
					}
				
				}
			}
		}, 20L, 20L);
	}
	

}
