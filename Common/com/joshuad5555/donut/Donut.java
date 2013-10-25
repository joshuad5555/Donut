package com.joshuad5555.donut;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.joshuad5555.donut.item.ItemDonut;
import com.joshuad5555.donut.lib.Reference;
import com.joshuad5555.donut.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Chicken's Donut Mod
 * 
 * Main mod class for the Minecraft Mod Chicken's Donut Mod
 * 
 * @author joshuad5555
 *
 */

@Mod(modid = "CD", name = "Chicken's Donut Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Donut {

	@Instance("Donut")
	public Donut instance;
	
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_PATH, serverSide = Reference.COMMON_PROXY_PATH)
    public static CommonProxy proxy;
	
    //Item Ids
    public static int foodDonutID;
    
    //Items
    public static Item foodDonut;
    
    //Pre Initialization
    @EventHandler
    public void load(FMLPreInitializationEvent event) {
  
        Configuration config = new Configuration(new File("config/Emerald.cfg"));
        
        config.load();
                     
                //Item Ids
        foodDonutID = config.get("Items", "Donut", 5100).getInt();
        
        config.save();
    	
    }
    
    //Initializaton
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	
        foodDonut = new ItemDonut(foodDonutID, 4, 5F, false);
        LanguageRegistry.addName(foodDonut, "Donut");
        GameRegistry.addRecipe(new ItemStack(foodDonut, 6), "SBS", "B B", "SBS", 'B', Item.bread, 'S', Item.sugar);
    	
    }
    
    //Post Initializaton
    @EventHandler
    public void load(FMLPostInitializationEvent event) {
    	
    }
    
}
