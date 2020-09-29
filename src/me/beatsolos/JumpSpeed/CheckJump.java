package me.beatsolos.JumpSpeed;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CheckJump implements Listener {

    final double STILL = -0.0784000015258789;
    int amp = 0;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("Don't die. It's hardcore. Every time you jump, your speed increases. >:)");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = (Player) event.getEntity();
        p.setWalkSpeed((float) 0.2);
        p.removePotionEffect(PotionEffectType.SPEED);
    }

    @EventHandler
    public void onJump(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        int fullJump = 0;

        // the player is jumping
        if(p.getVelocity().getY() > STILL) {

            if(p.getWalkSpeed() > 0.999) {
                fullJump++;
                amp += fullJump;

                PotionEffect pe2 = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, amp, false, false);
                p.addPotionEffect(pe2);

            }
            else {
                //add speed to the player 0.2
                p.setWalkSpeed((float) (p.getWalkSpeed() + 0.005));
            }
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player p = event.getPlayer();
        if(p.isSneaking()) {
            p.setSneaking(false);
        }
    }

}
