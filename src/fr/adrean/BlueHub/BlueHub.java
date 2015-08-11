package fr.adrean.BlueHub;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.java.JavaPlugin;

public class BlueHub extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new BoosterManager(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new ActionBarManager(this), this);
	}
	
	
	@EventHandler
	public void onPlayerDamageReceive(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause() != DamageCause.SUICIDE && e.getCause() != DamageCause.VOID) {
			e.setCancelled(true);
		}
	}
	
		
}
