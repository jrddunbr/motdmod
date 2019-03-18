package org.ja13.mc.motd;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = MotdMod.MODID, version = MotdMod.VERSION)
public class MotdMod {

    public static final String MODID = "motdmod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("EEEERRRGGGG");
    }
}
