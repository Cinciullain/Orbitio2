package net.cinciullain.orbitio2.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.cinciullain.orbitio2.Orbitio2;
import net.cinciullain.orbitio2.item.ModItems;
import net.cinciullain.orbitio2.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Orbitio2.MODID)
public class ModEvents
{

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent tradesEvent)
    {
        if(tradesEvent.getType() == VillagerProfession.TOOLSMITH)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = tradesEvent.getTrades();
            ItemStack stack = new ItemStack(ModItems.PROVA_ITEM_CUSTOM.get(), 1);

            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if(tradesEvent.getType() == ModVillagers.PROVA_MASTER.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = tradesEvent.getTrades();
            ItemStack stack = new ItemStack(ModItems.ORBITIO_ITEM.get(), 15);

            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02F));
        }
    }
}
