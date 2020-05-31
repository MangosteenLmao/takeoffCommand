package me.MangosteenLmao.TakeoffCommand;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.craftbukkit.Main;

import me.MangosteenLmao.TakeoffCommand.ActualCommand;

@SuppressWarnings("unused")
public class TakeoffCommand extends JavaPlugin implements Listener {

	public static TakeoffCommand plugin;
		
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("takeoff").setExecutor((CommandExecutor)new ActualCommand());
	}
	
}
