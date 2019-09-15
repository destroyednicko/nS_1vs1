package kun.nicko.handler;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	
	public static void setitem(Player p){
		ItemStack IS = new ItemStack(Material.IRON_SWORD);
		ItemStack IH = new ItemStack(Material.IRON_HELMET);
		ItemStack IC = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack IL = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack IB = new ItemStack(Material.IRON_BOOTS);
		ItemStack FR = new ItemStack(Material.FISHING_ROD);
		ItemStack A = new ItemStack(Material.ARROW);
		ItemStack B = new ItemStack(Material.BOW);
		ItemStack FAS = new ItemStack(Material.FLINT_AND_STEEL);
		ItemStack TNT = new ItemStack(Material.TNT);

		ItemMeta TNTMeta = TNT.getItemMeta();
		TNTMeta.spigot().setUnbreakable(true);
		TNTMeta.setDisplayName("§8» §9TNT");
		TNT.setItemMeta(TNTMeta);
		ItemMeta ISMeta = IS.getItemMeta();
		ISMeta.spigot().setUnbreakable(true);
		ISMeta.setDisplayName("§8» §9Espada");
		IS.setItemMeta(ISMeta);
		ItemMeta FRMeta = FR.getItemMeta();
		FRMeta.setDisplayName("§8» §9Vara de Pesca");
		FRMeta.spigot().setUnbreakable(true);
		FR.setItemMeta(FRMeta);
		ItemMeta BMeta = B.getItemMeta();
		BMeta.setDisplayName("§8» §9Arco");
		BMeta.spigot().setUnbreakable(true);
		B.setItemMeta(BMeta);
		ItemMeta AMeta = A.getItemMeta();
		AMeta.setDisplayName("§8» §9Flechas");
		AMeta.spigot().setUnbreakable(true);
		A.setItemMeta(AMeta);
		ItemMeta IHMeta = IH.getItemMeta();
		IHMeta.setDisplayName("§8» §9Capacete");
		IHMeta.spigot().setUnbreakable(true);
		IH.setItemMeta(IHMeta);
		ItemMeta FASMeta = FAS.getItemMeta();
		FASMeta.setDisplayName("§8» §9Isqueiro");
		FAS.setDurability((short) 63);
		FAS.setItemMeta(FASMeta);
		ItemMeta ICMeta = IC.getItemMeta();
		ICMeta.setDisplayName("§8» §9Peitoral");
		ICMeta.spigot().setUnbreakable(true);
		IC.setItemMeta(ICMeta);
		ItemMeta ILMeta = IL.getItemMeta();
		ILMeta.setDisplayName("§8» §9Calças");
		ILMeta.spigot().setUnbreakable(true);
		IL.setItemMeta(ILMeta);
		ItemMeta IBMeta = IB.getItemMeta();
		IBMeta.setDisplayName("§8» §9Botas");
		IBMeta.spigot().setUnbreakable(true);
		IB.setItemMeta(IBMeta);


		p.getInventory().setItem(0, IS);
		p.getInventory().setItem(1, FR);
		p.getInventory().setItem(2, B);
		p.getInventory().setItem(10, A);

		p.getInventory().setHelmet(IH);
		p.getInventory().setChestplate(IC);
		p.getInventory().setLeggings(IL);
		p.getInventory().setBoots(IB);
		p.updateInventory();	
	}
	
	public static void setlobbyitems(Player p) {
		ItemStack Lobby = new ItemStack(Material.MAGMA_CREAM, 1);
		
		ItemMeta LobbyM = Lobby.getItemMeta();
		LobbyM.setDisplayName("§8» §eDe volta ao Lobby");
		LobbyM.spigot().setUnbreakable(true);
		LobbyM.setLore(Arrays.asList("§8» §7Volte para o lobby."));
		Lobby.setItemMeta(LobbyM);
		
		p.getInventory().clear();
		p.getInventory().setChestplate(null);
		p.getInventory().setBoots(null);
		p.getInventory().setHelmet(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setItem(4, Lobby);
		p.updateInventory();
	}

}
