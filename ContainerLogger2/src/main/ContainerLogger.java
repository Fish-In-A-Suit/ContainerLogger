package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import listeners.BlockBreak;
import listeners.BlockPlace;

public class ContainerLogger extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//init constants
		Constants.init(this);
		
		//register listeners
		Bukkit.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
	}
	
	@Override
	public void onDisable() {
		Constants.clFile.save();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equals("clSave")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.BLUE + "Saving container info to yml file.");
			}
		}
		Constants.clFile.save();
		return true;
	}
}
