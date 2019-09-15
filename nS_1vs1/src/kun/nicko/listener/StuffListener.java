package kun.nicko.listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WeatherType;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;

import kun.nicko.GameStates;
import kun.nicko.Handler;
import kun.nicko.Main;

public class StuffListener implements Listener {
	@SuppressWarnings("unchecked")
	public static HashMap<Entity, Entity> luta = new HashMap<>();

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if (!Main.build.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onfood(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}

	@EventHandler
	public void onbed(PlayerBedEnterEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onredstoneaction() {

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if ((((e.getClickedBlock().getType() == Material.WOOD_DOOR ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.WOODEN_DOOR ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.TRAP_DOOR ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.FENCE_GATE ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.FENCE ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.WOOD_BUTTON ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.STONE_BUTTON ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.LEVER ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.CHEST ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.ENDER_CHEST ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.NOTE_BLOCK ? 1 : 0)
					| (e.getClickedBlock().getType() == Material.BED_BLOCK ? 1 : 0)) != 0)
					&& (!Main.build.contains(p))) {
				e.setCancelled(true);
			}
		}
		if ((((e.getAction() == Action.RIGHT_CLICK_AIR ? 1 : 0)
				| (e.getAction() == Action.RIGHT_CLICK_BLOCK ? 1 : 0)) != 0)
				&& (p.getItemInHand().getType() == Material.FISHING_ROD)) {
			if ((Main.build.contains(p))) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public static void onBuild(BlockPlaceEvent e) {
		Player builder = e.getPlayer();
		if (Main.build.contains(builder)) {
			e.setCancelled(false);
		} else
			e.setCancelled(true);
	}

	@EventHandler
	public static void onBreak(BlockBreakEvent e) {
		Player breaker = e.getPlayer();
		if (Main.build.contains(breaker)) {
			e.setCancelled(false);
		} else
			e.setCancelled(true);
	}

	@EventHandler
	public void onPing(ServerListPingEvent e) {
		int online = Bukkit.getOnlinePlayers().size();
		e.setMaxPlayers(2);
		int max = 2;

		if (online == max) {
			e.setMotd("SPECTATE");
			e.setMaxPlayers(20);
		} else {
			e.setMaxPlayers(max);
			e.setMotd("LOBBY");
		}
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (Main.getgamestate() == GameStates.LOBBY || Main.getgamestate() == GameStates.RESTART) {
					e.setCancelled(true);
				}
			}
			if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
				if (Handler.player1.contains(p)) {
					p.setHealth(0);
				} else if (Handler.player2.contains(p)) {
					p.setHealth(0);
				} else {
					Bukkit.broadcastMessage("§cERROR");
					Handler.restart();
				}
			}
		}
	}

	@EventHandler
	public void onDmage(EntityDamageEvent e) {
		if (Main.getgamestate() == GameStates.RESTART || Main.getgamestate() == GameStates.WARUMUP
				|| Main.getgamestate() == GameStates.LOBBY) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void ondmg(EntityDamageByEntityEvent e) {
		Player dmger = (Player) e.getDamager();
		Player p = (Player) e.getEntity();
		if (e.getDamager() instanceof Player) {
			if (e.getEntity() instanceof Player) {
				if (!luta.containsValue(e.getDamager())) {
					if (Handler.player1.contains(dmger) || Handler.player2.contains(dmger)) {
						luta.put(e.getEntity(), e.getDamager());
					}

				}
			}

		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPADS(PlayerMoveEvent e) {

		Player p = e.getPlayer();
		p.setPlayerWeather(WeatherType.CLEAR);
		p.setPlayerTime(0, true);
		if (Main.getgamestate() == GameStates.WARUMUP) {
			p.teleport(e.getFrom());
		}
		if (Main.specs.contains(p)) {
			for (Entity en : p.getNearbyEntities(3.5D, 3.5D, 3.5D)) {
				if(!Main.specs.contains(en)){
					if (((en instanceof Player)) || ((en instanceof Arrow))) {
						p.setVelocity(p.getLocation().getDirection().setY(1.0D));
						p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1.0F, 1.0F);
					}
				}
			}
			p.setAllowFlight(true);
			p.setFlying(true);
			
		}
	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		e.blockList().clear();
	}

	@EventHandler
	public void onEntityShootBow(EntityShootBowEvent e) {
		Player p = (Player) e.getEntity();
		if (Main.getgamestate() == GameStates.INGAME) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public static void onBrew(BrewEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onHangingBreakByEntity(HangingBreakByEntityEvent e) {
		if ((e.getRemover() instanceof Player)) {
			Player p = (Player) e.getRemover();
			if (!Main.build.contains(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory() == null) {
			e.setCancelled(true);
			return;
		}
		if (e.getCurrentItem() == null) {
			e.setCancelled(true);
			return;
		}
		if (e.getClickedInventory() == p.getInventory()) {
			if ((((e.getCurrentItem().getType() == Material.IRON_HELMET ? 1 : 0)
					| (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE ? 1 : 0)
					| (e.getCurrentItem().getType() == Material.IRON_LEGGINGS ? 1 : 0)
					| (e.getCurrentItem().getType() == Material.IRON_BOOTS ? 1 : 0)) != 0)) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		final Block block = e.getBlock();
		if (!Main.build.contains(p)) {
			e.setCancelled(true);
		}
		if (e.getBlock().getType() == Material.FIRE) {
			if (Main.getgamestate() == GameStates.INGAME) {
				e.setCancelled(false);
				p.getInventory().setItemInHand(null);
				p.updateInventory();
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					public void run() {
						block.setType(Material.AIR);
					}
				}, 100L);
			}
		}
		if (e.getBlock().getType() == Material.FLINT_AND_STEEL) {
			e.setCancelled(false);
		}
		if (e.getBlockPlaced().getType() == Material.TNT) {
			e.setCancelled(true);
			p.getInventory().removeItem(new ItemStack(Material.TNT));
			p.updateInventory();
			((TNTPrimed) e.getBlock().getWorld().spawn(e.getBlock().getLocation().add(0.5D, 0.5D, 0.5D),
					TNTPrimed.class)).setFuseTicks(30);
		}
	}

}
