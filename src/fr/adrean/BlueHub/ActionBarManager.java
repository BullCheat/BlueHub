package fr.adrean.BlueHub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.adrean.BlueHub.gui.ServerSelectionGUI;

public class ActionBarManager implements Listener {
	
	BlueHub plugin;
	
	public ActionBarManager(BlueHub blueHub) {
		this.plugin = blueHub;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getPlayer().getInventory().getHeldItemSlot() == 0) {
				e.getPlayer().openInventory(new ServerSelectionGUI(plugin, e.getPlayer()));
			}
		}
	}
	
}
