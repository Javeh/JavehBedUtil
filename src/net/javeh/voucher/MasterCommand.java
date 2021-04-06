package net.javeh.voucher;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MasterCommand implements CommandExecutor{
	
	private Plugin plugin;
	 
	public MasterCommand(Plugin plugin) {
	this.plugin = plugin;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(!sender.isOp()) {
			return false;
		}
		if(args.length == 0) {
			sender.sendMessage("Try " + ChatColor.BLUE + "/Voucher " + ChatColor.WHITE + "reload");
		}
		if(args[0].equalsIgnoreCase("reload")) {
			plugin.reloadConfig();
		}
		return true;
	
	}

}
