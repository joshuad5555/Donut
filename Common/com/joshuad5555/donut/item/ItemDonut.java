package com.joshuad5555.donut.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDonut extends ItemFood {

	public ItemDonut(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setUnlocalizedName("foodDonut");
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
            this.itemIcon = ir.registerIcon("joshuad5555_donut:foodDonut");
    }

}
