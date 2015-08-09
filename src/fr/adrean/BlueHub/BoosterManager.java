package fr.adrean.BlueHub;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.adrean.BlueCore.BlueCore;

public class BoosterManager implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerClick(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() == Material.TNT) {
			e.setCancelled(true);
			int boost = e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ? 3 : -3;
			BlueCore.boost(e.getPlayer(), boost);
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.FIREWORK_LAUNCH, 3, 1);
			BlueCore.spawnParticles(e.getPlayer(), Effect.SMOKE, 10);
		} else if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() == Material.ENDER_PEARL) {
			e.setCancelled(true);
			int boost = e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ? 2 : -1;
			BlueCore.verticalBoost(e.getPlayer(), boost);
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 3, 1);
			BlueCore.spawnParticles(e.getPlayer(), Effect.FIREWORKS_SPARK, 10);
		}
	}
	
}
