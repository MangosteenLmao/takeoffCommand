package me.MangosteenLmao.TakeoffCommand;

import org.bukkit.entity.Entity;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.Material;

public class ActualCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("takeoff")) {
			if (sender instanceof Player) {
				if (((Player) sender).getInventory().getChestplate() == null) {
					sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You need to be wearing an elytra!");
				}
				try {
					if (((Player) sender).getInventory().getChestplate().getType() == Material.ELYTRA) {
						if (((Entity) sender).isOnGround()) {
							Location location = ((Player) sender).getLocation();
							Location checkBlock = location;
							if (checkBlock.add(0, 1, 0).getBlock().getType() == Material.AIR && 
								checkBlock.add(0, 2, 0).getBlock().getType() == Material.AIR) {
								((Player) sender).teleport(location.add(0, 1, 0));
								((Player) sender).setGliding(true);
								((Player) sender).playSound(location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 10F);
								
							} else {
								sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You need to have two blocks of air above you!");
							}
						} else {
							sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You need to be standing on a block!");
						}
					} else {
						sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You need to be wearing an elytra!");
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			} else {
				sender.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You are not a player!");
				return true;
			}
		}
		return false;
	}
	
}
