package net.cinciullain.orbitio2.item;

import net.cinciullain.orbitio2.Orbitio2;
import net.cinciullain.orbitio2.item.custom.ProvaItemCustom;
import net.cinciullain.orbitio2.item.custom.SatelliteBase;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/*
Classe necessaria per l'aggiunta di Items
 */
public class Orbitio2Items
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
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    public static final RegistryObject<Item> PROVA_ITEM_CUSTOM = ITEMS.register("prova_item_custom",
            () -> new ProvaItemCustom(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2).stacksTo(1)));

    /******************************************************/
    /*                      ITEMS                         */
    /******************************************************/

    /****************** MODULI SATELLITE ******************/

    public static final RegistryObject<Item> MODULO_SATELLITE_BASE = ITEMS.register("modulo_satellite_base",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    public static final RegistryObject<Item> MODULO_SATELLITE_BLOCKS = ITEMS.register("modulo_satellite_blocks",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    public static final RegistryObject<Item> MODULO_SATELLITE_ENTITIES = ITEMS.register("modulo_satellite_entities",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    /* Al momento superfluo, deciderò in futuro se aggiungerlo

    public static final RegistryObject<Item> MODULO_SATELLITE_OCEAN_DUNGEON = ITEMS.register("modulo_satellite_ocean_dungeon",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));
    */

    public static final RegistryObject<Item> MODULO_SATELLITE_PILLAGERS = ITEMS.register("modulo_satellite_pillagers",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    /* Al momento superfluo, deciderò in futuro se aggiungerlo

    public static final RegistryObject<Item> MODULO_SATELLITE_PLAYERS = ITEMS.register("modulo_satellite_players",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));
    */

    public static final RegistryObject<Item> MODULO_SATELLITE_PORTALE_END = ITEMS.register("modulo_satellite_portale_end",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    public static final RegistryObject<Item> MODULO_SATELLITE_VILLAGERS = ITEMS.register("modulo_satellite_villagers",
            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2)));

    /********************* SATELLITI **********************/

//    public static final RegistryObject<Item> SATELLITE_BASE = ITEMS.register("satellite_base",
//            () -> new Item(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2).stacksTo(1)));

    public static final RegistryObject<Item> SATELLITE_BASE = ITEMS.register("satellite_base",
            () -> new SatelliteBase(new Item.Properties().tab(Orbitio2.TAB_ORBITIO2).stacksTo(1)));

    /******************************************************/
    /*                      ITEMS END                     */
    /******************************************************/

    //Registra gli item aggiunti alla classe ModItems
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
