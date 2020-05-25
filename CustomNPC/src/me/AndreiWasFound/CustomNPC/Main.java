package me.AndreiWasFound.CustomNPC;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Join(), this);
	}
	
	@Override
	public void onDisable() {
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("createnpc")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Console can't use this command");
				return true;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				NPC.createNPC(player, player.getName());
				player.sendMessage(ChatColor.RED + "NPC has been created");
				return true;
			}
			NPC.createNPC(player, args[0]);
			player.sendMessage(ChatColor.RED + "NPC has been created");
			return true;
		}
		return false;
	}
}
