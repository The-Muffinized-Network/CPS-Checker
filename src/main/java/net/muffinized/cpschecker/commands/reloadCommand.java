package net.muffinized.cpschecker.commands;

import net.muffinized.cpschecker.CPSChecker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class reloadCommand implements CommandExecutor {

    private final CPSChecker plugin;

    public reloadCommand(CPSChecker plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 0) {
            commandSender.sendMessage(plugin.getMessage("usage"));
            return true;
        }

        if(strings[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            commandSender.sendMessage(plugin.getMessage("reload_success"));
        } else {
            commandSender.sendMessage(plugin.getMessage("usage"));
        }
        return true;
    }
}
