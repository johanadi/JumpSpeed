package me.beatsolos.JumpSpeed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class CommandReset implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        //first, check for player
        if(commandSender instanceof Player) {
            //second, check for OP
            Player p = (Player) commandSender;
            //third, check if it's for OP user, or for other user
            if(p.isOp()) {
                //then, we check arguments
                if(strings.length == 0) {
                    p.sendMessage("You have been reset of your speed.");
                    p.setWalkSpeed((float) 0.2);
                    p.removePotionEffect(PotionEffectType.SPEED);
                } else if (strings.length == 1) {
                    Player target = Bukkit.getPlayerExact(strings[0]);
                    if(target != null) {
                        p.sendMessage("Player " + strings[0] + " has been reset of their speed.");
                        target.setWalkSpeed((float) 0.2);
                        target.removePotionEffect(PotionEffectType.SPEED);
                    }
                } else {
                    p.sendMessage("Incorrect use of command.");
                }
            // user doesn't have permission
            } else {
                p.sendMessage("You do not have permission for this command.");
            }
        }

        return true;
    }
}
