package com.chaseoes.simpleheads;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleHeads extends JavaPlugin {

    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cs instanceof Player) {
            if (strings.length == 1) {
                if (cs.hasPermission("simpleheads.use")) {
                    ((Player) cs).getInventory().addItem(getHead(strings[0]));
                    cs.sendMessage(ChatColor.DARK_AQUA + "There you go!");
                } else {
                    cs.sendMessage(ChatColor.DARK_AQUA + "You don't have permission.");
                }
            } else {
                cs.sendMessage(ChatColor.RED + "Usage: /head <player>");
            }
        } else {
            cs.sendMessage("You must be a player to use that command.");
        }
        return true;
    }

    public ItemStack getHead(String player) {
        ItemStack i = new ItemStack(Material.SKULL_ITEM);
        i.setDurability((short) 3);
        SkullMeta sm = (SkullMeta) i.getItemMeta();
        sm.setOwner(player);
        i.setItemMeta(sm);
        return i;
    }

}
