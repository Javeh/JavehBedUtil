package net.javeh.voucher;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class VoucherDisconnectListener implements Listener {

	private Plugin plugin;
	 
	public VoucherDisconnectListener(Plugin plugin) {
	this.plugin = plugin;
	}
	
	@EventHandler
	public void onVoucherDisconnect(PlayerQuitEvent e) {
		
		if(e.getPlayer().getUniqueId().toString().equals(plugin.getConfig().getString("VoucherUUID"))) {
			Voucher.setVoucherStatus(false);
			
			OfflinePlayer vouchee = Bukkit.getPlayer(UUID.fromString(plugin.getConfig().getString("VoucheeUUID")));
			
			if(vouchee.isOnline()) {
				((Player) vouchee).kickPlayer("Bye");
			}
		}
		
	}
}
