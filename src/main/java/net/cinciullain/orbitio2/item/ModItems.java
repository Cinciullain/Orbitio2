package net.cinciullain.orbitio2.item;

import net.cinciullain.orbitio2.Orbitio2;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/*
Classe necessaria per l'aggiunta di Items
 */
public class ModItems
{

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Orbitio2.MODID);

    /*
    Struttura di creazione default di un Item

    Ogni item deve essere dichiarato nel file di:
        - Orbitio2.java
        - lang file
        - models file
     */
    public static final RegistryObject<Item> ORBITIO_ITEM = ITEMS.register("orbitio_item",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ORBITIO_TAB)));

    //Registra gli item aggiunti alla classe ModItems
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
