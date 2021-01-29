package net.javeh.bedutil;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import net.md_5.bungee.api.ChatColor;

public class SleepListener implements Listener {

	@EventHandler
	public void onPlayerSleep(PlayerBedEnterEvent event) {
		if (event.isCancelled()) {
			return;
		}

		List<Player> players = event.getPlayer().getLocation().getWorld().getPlayers();
		int playersSleeping = 1; // start at 1 to include the player current sleeping
		for (Player current : players) {
			if (current.isSleeping()) {
				playersSleeping++;
			}
		}
		int playersRequired = players.size() / 2;
		
		//fix rounding error.
		if(playersRequired == 0) {
			playersRequired = 1;
		}
		Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + event.getPlayer().getDisplayName()
				+ ChatColor.RESET + "" + ChatColor.GREEN + " has fallen asleep. " + ChatColor.YELLOW + "("
				+ playersSleeping + "/" + players.size() / 2 + ")");
		if (playersSleeping >= players.size() / 2) {
			event.getPlayer().getWorld().setTime(0);
			if(event.getPlayer().getWorld().hasStorm()) {
				event.getPlayer().getWorld().setStorm(false);
			}
		}
	}
}
