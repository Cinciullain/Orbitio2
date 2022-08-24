package net.cinciullain.orbitio2.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SatelliteBase extends Item
{
    public SatelliteBase(Properties properties)
    {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand)
    {
        if(level.isClientSide())
        {
            if(interactionHand.equals(InteractionHand.MAIN_HAND))
            {
                player.sendSystemMessage(Component.literal("Satellite launched!"));
                //player.getHandSlots();
                player.getItemInHand(InteractionHand.MAIN_HAND);
            }
            else
            {
                //Niente
            }
        }
        else
        {
            //Server side
        }

        return super.use(level, player, interactionHand);
    }


    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag)
    {
        if(Screen.hasShiftDown())
        {
            componentList.add(Component.literal("This satellite will be orbiting the world, once you" +
                    "right click while holding it").withStyle(ChatFormatting.GRAY));
        }
        else
        {
            componentList.add(Component.literal("Hold SHIFT to get more info").withStyle(ChatFormatting.RED));
        }

        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}
