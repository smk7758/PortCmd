package my.smk.plugin.PortCmd;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public final Logger log = Logger.getLogger("Minecraft");
	public String PluginName = getDescription().getName();
	public String ChatPrefix = ChatColor.YELLOW + "[" + ChatColor.GREEN + PluginName + ChatColor.YELLOW + "] " + ChatColor.WHITE;
	public String ErroPrefix = ChatColor.WHITE + "[" + ChatColor.RED + PluginName + ChatColor.WHITE + "] " + ChatColor.WHITE;

	public void onEnable() {
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("port"))) {
			if (sender instanceof Player) {
				if (!(sender.hasPermission("PortCmd")) || !(sender.isOp())) {
					sender.sendMessage(this.ErroPrefix + "You don't have permission use port command!!");
					return false;
				}
			}
			int Port = getServer().getPort();
			sender.sendMessage(" Port:" + Port);
			return true;
		}
		return false;
	}
}