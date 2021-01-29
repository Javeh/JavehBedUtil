package net.javeh.bedutil;

import org.bukkit.plugin.java.JavaPlugin;

public class JavehBedUtil extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new SleepListener(), this);
		getServer().getPluginManager().registerEvents(new CatKillListener(), this);
	}
}
