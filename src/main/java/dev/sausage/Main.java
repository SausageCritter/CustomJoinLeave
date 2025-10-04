package dev.sausage;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;


public class Main extends PluginBase {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinLeaveEvent(this), this);
        getServer().getConsoleSender().sendMessage(TextFormat.GREEN+"CustomJoinLeave has started!");


        saveDefaultConfig();


        super.onEnable();


    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(TextFormat.RED+"CustomJoinLeave has stopped!");
    }
}