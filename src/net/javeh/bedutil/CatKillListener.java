package net.javeh.bedutil;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CatKillListener implements Listener {

	@EventHandler
	public void onCatKill(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Tameable ) {
			Tameable pet = (Tameable) e.getEntity();
			if(!pet.isTamed()) {
				return;
			}
		}
		else {
			return;
		}
		if(e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			if(player.isOp()) {
				return; //make this a permission later
			}
			player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 1);
			if(e.getEntity() instanceof Wolf) {
				Wolf wolf = (Wolf) e.getEntity();
				wolf.setAngry(false);
			}
		}
		
		e.setCancelled(true);
		
		
	}
}
