package net.cinciullain.orbitio2.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProvaItemCustom extends Item
{
    public ProvaItemCustom(Properties properties)
    {
        super(properties);
    }

    /*
    Azione che viene eseguita quando l'oggetto viene utilizzato con tasto destro
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand)
    {
        /*
        Se non ci si trova lato server, essendo una interazione solo lato client,
        in output faccio apparire un numero random e do un cooldown per il riutilizzo
         */
        if (!level.isClientSide() && interactionHand.equals(InteractionHand.MAIN_HAND))
        {
            player.sendSystemMessage(Component.literal("Numero random: " +
                    RandomSource.createNewThreadLocalInstance().nextInt(100)));
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, interactionHand);
    }

    /*
    Questo metodo permette l'aggiunta di tooltip agli oggetti
    Deve essere aggiunto con questo metodo ad ogni oggetto
     */
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag)
    {
        if(Screen.hasShiftDown())
        {
            componentList.add(Component.literal("Prova descrizione estesa").withStyle(ChatFormatting.GRAY));
        }
        else
        {
            componentList.add(Component.literal("Premi shift per maggiori info").withStyle(ChatFormatting.RED));
        }

        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }
}
