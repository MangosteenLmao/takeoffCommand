package me.MangosteenLmao.TakeoffCommand;

import org.bukkit.entity.Entity;
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
				if (((Player) sender).getInventory().getChestplate().getType() == null) {
					sender.sendMessage("You need to be wearing an elytra!");
				}
					if (((Player) sender).getInventory().getChestplate().getType() == Material.ELYTRA) {
						if (((Entity) sender).isOnGround()) {
							Location location = ((Player) sender).getLocation();
							Location checkBlock = location;
							if (checkBlock.getBlock().getType() == Material.AIR && checkBlock.add(0, 1, 0).getBlock().getType() == Material.AIR && checkBlock.add(0, 2, 0).getBlock().getType() == Material.AIR) {
								((Player) sender).teleport(location);
								
							} else {
								sender.sendMessage("You need to have two blocks of air above you!");
							}
						} else {
							sender.sendMessage("You need to be standing on a block!");
						}
					} else {
						sender.sendMessage("You need to be wearing an elytra!");
					}
			} else {
				sender.sendMessage("You are not a player!");
				return true;
			}
		}
		return false;
	}
}
