package net.cinciullain.orbitio2.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/*
Aggiunge il tab in creative per la mod
 */
public class ModCreativeModeTab
{

    //Classe anonima
    public static final CreativeModeTab ORBITIO_TAB = new CreativeModeTab("orbitio2tab")
    {
        @Override
        public ItemStack makeIcon()
        {
            //Icona che viene mostrata nel tab
            return new ItemStack(ModItems.ORBITIO_ITEM.get());
        }
    };
}
