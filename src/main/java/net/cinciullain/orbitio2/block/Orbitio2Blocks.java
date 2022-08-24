package net.cinciullain.orbitio2.block;

import net.cinciullain.orbitio2.Orbitio2;
import net.cinciullain.orbitio2.block.custom.ProvaBlockCustom;
import net.cinciullain.orbitio2.block.custom.ProvaBlockstates;
import net.cinciullain.orbitio2.item.Orbitio2Items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


/*
Ogni blocco deve poi avere un json in:
    - blockstates
    - models:
        - block
        - item
    - textures:
        - block
    -
 */
public class Orbitio2Blocks
{

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Orbitio2.MODID);

    //Aggiunta effettiva del blocco
     public static final RegistryObject<Block> ORBITIO_BLOCK = registerBlock("orbitio_block",
             () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), Orbitio2.TAB_ORBITIO2);

    //Aggiunta effettiva dell'item associato al blocco ma con drop di esperienza
    public static final RegistryObject<Block> ORBITIO_BLOCK_EXPERIENCE = registerBlock("orbitio_block_experience",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),UniformInt.of(3, 7)), Orbitio2.TAB_ORBITIO2);

    //Aggiunta del blocco custom
    public static final RegistryObject<Block> PROVA_BLOCK_CUSTOM = registerBlock("prova_block_custom",
            () -> new ProvaBlockCustom(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), Orbitio2.TAB_ORBITIO2);

    //Aggiunta del blocco con stati
    public static final RegistryObject<Block> PROVA_BLOCKSTATES = registerBlock("prova_blockstates",
            () -> new ProvaBlockstates(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(blockState -> blockState.getValue(ProvaBlockstates.LIT) ? 15 : 0)), Orbitio2.TAB_ORBITIO2);


    /**
     * DA QUA PARTE LA AGGIUNTA EFFETTIVA DEI BLOCCHI DELLA MOD
     *
     * 1 - Antenna Ricezione: Gestione comunicazione con il satellite. TODO: Se avere GUI o no
     * 2 -
     */
    public static final RegistryObject<Block> ANTENNA_RICEZIONE = registerBlock("antenna_ricezione",
            () -> new ProvaBlockCustom(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()), Orbitio2.TAB_ORBITIO2);



    //Registra il blocco
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Registra l'item legato al blocco in gioco
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return Orbitio2Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
