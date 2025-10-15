package me.VAL.welcomeManager;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class JoinEvent implements Listener {

    private final WelcomeManager main = WelcomeManager.instance;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
    }

    public void firstJoin(Player player){
        if (!main.getConfig().getBoolean("FirstJoin.Toggle")) return;
        if (player.hasPlayedBefore()) return;
        String message = main.getConfig().getString("FirstJoin.Message");

        if (message == null) return;
        String HexColour = message.substring(0, 7);
        String message1 = message.substring(7);

        player.sendMessage(ChatColor.of(HexColour) + message1);
    }


    public void welcomeMessage(Player player){

        if (!main.getConfig().getBoolean("Join.Toggle")) return;
        String message = main.getConfig().getString("Join.Message");

        if (message == null) return;
        String HexColour = message.substring(0, 7);
        String message1 = message.substring(7);

        player.sendMessage(ChatColor.of(HexColour) + message1);
    }


    public void titleWelcome(Player player){
        if (!main.getConfig().getBoolean("Title.Toggle")) return;
        String title = main.getConfig().getString("Title.Message");
        String subtitle = main.getConfig().getString("Title.Subtitle");

        if (title == null) return;
        String HexColour1 = title.substring(0, 7);
        String message1 = title.substring(7);

        String HexColour2 = subtitle.substring(0, 7);
        String message2 = subtitle.substring(7);

        player.sendTitle(ChatColor.of(HexColour1) + message1, ChatColor.of(HexColour2) + message2);
    }


    public void Firework(Player player){
        if (!main.getConfig().getBoolean("Firework.toggle")) return;

        Firework firework = player.getWorld().spawn(player.getLocation(), Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.AQUA).with(FireworkEffect.Type.BURST).withFlicker().build());
        meta.setPower(2);
        firework.setFireworkMeta(meta);
    }


    public void broadcast(Player player){
        if (!main.getConfig().getBoolean("Broadcast.toggle")) return;

        String message = main.getConfig().getString("Broadcast.message");
        if (message == null) return; //message null check
        String HexColour = message.substring(0, 7);
        String message1 = message.substring(7);

        String broadcast = message1.replace("{player}", player.getName());
        Bukkit.broadcastMessage(ChatColor.of(HexColour) + broadcast);
    }
}

