package net.javeh.voucher;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

	private Plugin plugin;
	 
	public PlayerJoinListener(Plugin plugin) {
	this.plugin = plugin;
	}
	
	String messages[] = {"You're off your leash", "أنت خارج مقودك", "You're missing something", 
			"It's cute that you think I'm just going to let you play unmoderated", "Why are you still reading this? Have you not figured it out"
					+ " yet?"};
	
	static int count = 0;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		final String personVouching = plugin.getConfig().getString("VoucherUUID");
		final String personVouchedFor = plugin.getConfig().getString("VoucheeUUID");
		String playerUUID = e.getPlayer().getUniqueId().toString();
		if(playerUUID.equals(personVouching)){
			Voucher.setVoucherStatus(true);
		}
		if(playerUUID.equals(personVouchedFor) && !Voucher.isVoucherLoggedIn()) {
			if(count > messages.length - 1) {
				count = 0;
			}
			e.getPlayer().kickPlayer(messages[count]);
			count++;
			
		}
		
		
	}
}
