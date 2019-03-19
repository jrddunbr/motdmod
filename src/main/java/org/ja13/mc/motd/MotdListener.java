package org.ja13.mc.motd;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;

/**
 * MotdListener - a listener object for PlayerEvents
 */
public class MotdListener {

    /**
     * onClientConnect - Whenever a client connects, the code inside of the if statement executes.
     * We put the MOTD printing stuff in there so that it prints whenever a person enters the server (ie, a motd)
     * @param event PlayerEvent
     */
    @SubscribeEvent
    public void onClientConnect(PlayerEvent event) {
        // This event will only be triggered on the Server side (although it may work for SSP worlds too!)
        if (event instanceof PlayerEvent.PlayerLoggedInEvent) {
            // all MOTD messages after this
            event.player.addChatMessage(new ChatComponentText("Hello, " + event.player.getDisplayName() + "!"));
            for (String line: MotdMod.motdMessage) {
                event.player.addChatMessage(new ChatComponentText(line));
            }
        }
    }
}
