package org.ja13.mc.motd;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

/**
 * MotdCommand - command handler for the /motd command
 */
public class MotdCommand extends CommandBase {

    /**
     * getCommandName - returns name of command
     * @return name of the command (motd)
     */
    @Override
    public String getCommandName() {
        return "motd";
    }

    /**
     *  getCommandUsage - returns information about the command usage
     * @param player the player's ICommandSender object
     * @return some text about running the motd command
     */
    @Override
    public String getCommandUsage(ICommandSender player) {
        return "/motd";
    }

    /**
     * processCommand - run when the user actually runs the command ingame
     * @param player the player's ICommandSender object
     * @param args array of arguments (not used)
     */
    @Override
    public void processCommand(ICommandSender player, String[] args) {
        for (String line: MotdMod.motdMessage) {
            player.addChatMessage(new ChatComponentText(line));
        }
    }
}
