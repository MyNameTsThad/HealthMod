package com.iwant2tryhard.healthmod;

import com.iwant2tryhard.healthmod.config.Config;
import com.iwant2tryhard.healthmod.gui.WarningPopup;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;


@Mod(modid = Reference.MOD_ID,name = Reference.MOD_NAME, version = Reference.VERSION)
public class HealthMod
{

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new WarningPopup());
        MinecraftForge.EVENT_BUS.register(new Config());
    }
}
