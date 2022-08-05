package net.cinciullain.orbitio2.villager;

import com.google.common.collect.ImmutableSet;
import net.cinciullain.orbitio2.Orbitio2;
import net.cinciullain.orbitio2.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Orbitio2.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Orbitio2.MODID);

    /*
    Oggetto con cui il villager prendere la professione
    maxTickets: quanti utilizzi l'oggetto può avere
     */
    public static final RegistryObject<PoiType> PROVA_BLOCK_CUSTOM_POI = POI_TYPES.register("prova_block_custom_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.PROVA_BLOCK_CUSTOM.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> PROVA_MASTER = VILLAGER_PROFESSIONS.register("prova_master",
            () -> new VillagerProfession("prova_master", x -> x.get() == PROVA_BLOCK_CUSTOM_POI.get(),
                    x -> x.get() == PROVA_BLOCK_CUSTOM_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs()
    {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class)
                    .invoke(null, PROVA_BLOCK_CUSTOM_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
