package net.muffinized.cpschecker;

import net.muffinized.cpschecker.commands.reloadCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public final class CPSChecker extends JavaPlugin implements Listener {

    private final HashMap<UUID, Integer> clickCounts = new HashMap<>();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);
        getCommand("cpschecker").setExecutor(new reloadCommand(this));

        startCPSResetTask();
    }

    @Override
    public void onDisable() {
        // do whatever you want here
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        int MAX_CPS = getConfig().getInt("max-cps");

        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
                UUID playerId = player.getUniqueId();
                clickCounts.put(playerId, clickCounts.getOrDefault(playerId, 0) + 1);

                if (clickCounts.get(playerId) > MAX_CPS) {
                    player.sendMessage(ChatColor.RED + "⚠ Warning: You are clicking over " + MAX_CPS + " CPS!");
                }
                break;
            default:
                break;
        }
    }

    private void startCPSResetTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                clickCounts.clear();
            }
        }.runTaskTimer(this, 20, 20);
    }
}