package fr.adrean.BlueHub.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

import fr.adrean.BlueCore.BlueCore;

public class ServerSelectionGUI extends GUI {

	BlueCore plugin;
	
	public ServerSelectionGUI(InventoryHolder owner, int size, String title,
			BlueCore plugin, Player p) {
		super(owner, size, title, plugin, p);
		this.plugin = plugin;
	}

	@Override
	public void update() {
		
	}

}
