package dev.sausage;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class JoinLeaveEvent implements Listener {

    private PluginBase plugin;

    public JoinLeaveEvent(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
       if (plugin.getConfig().getBoolean("Announce-Staff-Join") && event.getPlayer().hasPermission("cjl.staff")){
           event.setJoinMessage(TextFormat.colorize(plugin.getConfig().getString("Staff-Join-Message").replace("%playername%", event.getPlayer().getName())));


       } else {
            if (!event.getPlayer().hasPlayedBefore()){
                event.setJoinMessage(TextFormat.colorize(plugin.getConfig().getString("First-Join-Message").replace("%playername%", event.getPlayer().getName())));
            } else {
                event.setJoinMessage(TextFormat.colorize(plugin.getConfig().getString("Join-Message").replace("%playername%", event.getPlayer().getName())));
            }


       }


    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(TextFormat.colorize(plugin.getConfig().getString("Leave-Message").replace("%playername%", event.getPlayer().getName())));





    }
}
