package org.ja13.mc.motd;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.*;
import java.util.ArrayList;

/**
 * MotdMod - Main FML Interface class for the MOTD Mod.
 */
@Mod(modid = MotdMod.MODID, version = MotdMod.VERSION, acceptableRemoteVersions = "*")
public class MotdMod {

    // Mod information
    static final String MODID = "motdmod";
    static final String VERSION = "1.0";

    // MOTD Message to send to newly connected clients
    static ArrayList<String> motdMessage = new ArrayList<String>();

    @SideOnly(Side.SERVER)
    @EventHandler
    @SuppressWarnings("unused")
    public void startin(FMLServerStartingEvent event) {
        MotdCommand mc = new MotdCommand();
        // use this method to register command classes
        event.registerServerCommand(mc);
    }

    /**
     * load - Initializes the mod with FML
     *
     * @param event FMLInitializationEvent
     */
    @SideOnly(Side.SERVER)
    @EventHandler
    @SuppressWarnings("unused")
    public void load(FMLInitializationEvent event) {
        MotdListener ml = new MotdListener();
        // Use this method to register adding event listeners.
        FMLCommonHandler.instance().bus().register(ml);
        // There's also the following which doesn't work so far as I can tell.
        // MinecraftForge.EVENT_BUS.register(ml);

        // Try to get the "motd.txt" file read and put the MOTD into the motdMessage ArrayList.
        motdMessage.clear();
        File f = new File("motd.txt");
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            while(true) {
                String t = r.readLine();
                if (t != null) {
                    motdMessage.add(t);
                }else{
                    r.close();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // we failed to find the file.
            System.out.println("Failed to read from " + f.getAbsolutePath() + " because " + e);
            System.out.println("Try creating the \"motd.txt\" file in the server directory.");
        } catch (IOException e) {
            // we failed to read the file.
            System.out.println("Failed to read from " + f.getAbsolutePath() + " because " + e);
            System.out.println("Make sure the directory permissions are correct.");
        }
    }
}
