package net.cinciullain.orbitio2.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
}
