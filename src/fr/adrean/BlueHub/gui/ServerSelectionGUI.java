package fr.adrean.BlueHub.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.adrean.BlueCore.BlueCore;
import fr.adrean.BlueCore.GUI;
import fr.adrean.BlueHub.BlueHub;

public class ServerSelectionGUI extends GUI {

	BlueHub plugin;
	
	public ServerSelectionGUI(BlueHub plugin, Player p) {
		this(null, 9, "Sélection du serveur", plugin, p);
	}
	
	private ServerSelectionGUI(InventoryHolder owner, int size, String title,
			BlueHub plugin, Player p) {
		super(owner, size, title, plugin, p);
		this.plugin = plugin;
	}

	@Override
	public void update() {
		for (byte a = 0; a < this.getSize() / 9; a++) {
			for (byte b = 0; b < 9; b++) {
				this.set(a, b, getGreyPane());
			}
		}
		this.set((byte) 0, (byte) 1, getSurvivorButton());
		this.set((byte) 0, (byte) 3, getFactionsButton());
	}

	@EventHandler
	public void onPlayerClickInventory(InventoryClickEvent e) {
		if (this.disabled) return;
		if ((e.getClickedInventory() != null && e.getClickedInventory().hashCode() == this.hashCode()) || (e.getInventory() != null && e.getInventory().hashCode() == this.hashCode())) {
		//	if (e.getCli)
		}
	}

	private ItemStack getFactionsButton() {
		ItemStack wheat = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = wheat.getItemMeta();
		meta.setDisplayName("Factions");
		wheat.setItemMeta(meta);
		return BlueCore.removeAttributes(wheat);
	}

	private ItemStack getSurvivorButton() {
		ItemStack wheat = new ItemStack(Material.WHEAT);
		ItemMeta meta = wheat.getItemMeta();
		meta.setDisplayName("Survivor");
		wheat.setItemMeta(meta);
		return wheat;
	}

}
