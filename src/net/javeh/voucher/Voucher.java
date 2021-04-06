package net.javeh.voucher;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.javeh.javehtp.WarpsCommand;

public class Voucher extends JavaPlugin{
	
	private static boolean voucherLoggedIn = false;
	
	FileConfiguration config = getConfig();
	
	
	
	@Override
	public void onEnable() {
		config.addDefault("VoucherUUID", "abc123");
		config.addDefault("VoucheeUUID", "abc123");
		config.options().copyDefaults(true);
		saveConfig();
		
		
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		getServer().getPluginManager().registerEvents(new VoucherDisconnectListener(this), this);
		
		this.getCommand("voucher").setExecutor(new MasterCommand(this));

	}
	
	//needs to be static in case of live reloads
	public static void setVoucherStatus(boolean status) {
		voucherLoggedIn = status;
	}
	//needs to be static in case of live reloads
	public static boolean isVoucherLoggedIn() {
		return voucherLoggedIn;
	}

	
}
