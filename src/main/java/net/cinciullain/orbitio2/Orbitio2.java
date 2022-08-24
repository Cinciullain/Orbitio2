package net.cinciullain.orbitio2;

import net.cinciullain.orbitio2.block.Orbitio2Blocks;
import net.cinciullain.orbitio2.item.Orbitio2Items;
import net.cinciullain.orbitio2.villager.ModVillagers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Orbitio2.MODID)
public class Orbitio2
{
    public static final String MODID = "orbitio2";
    public static final String MODNAME = "Orbitio 2";

    public static final CreativeTabOrbitio2 TAB_ORBITIO2 = new CreativeTabOrbitio2();

    public Orbitio2()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Registra gli item aggiunti alla classe ModItems
        Orbitio2Items.register(modEventBus);

        //Registra i blocchi aggiunti alla classe Orbitio2Blocks
        Orbitio2Blocks.register(modEventBus);

        //Registra i villager aggiunti alla classe ModVillagers
        ModVillagers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //Questa lambda gestisce la parte dei villager
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    /*

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    */

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
