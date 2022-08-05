package net.cinciullain.orbitio2.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ProvaBlockCustom extends Block
{
    public ProvaBlockCustom(Properties properties)
    {
        super(properties);
    }

    /*
    Azione eseguita al tasto destro sul blocco.
    Viene eseguita due volte sul serve e due sul client (Main e off hand)
    Per evitare ripezione basta un if
     */
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult)
    {
        /*
        TODO: L'interazione del blocco si ripete due volte, togliendo il commento, perchè si ripete sia per client che server.
         */
        if ((level.isClientSide && interactionHand.equals(InteractionHand.OFF_HAND)))
        {
            player.sendSystemMessage(Component.literal("Right click"));
        }
        /*else if (!level.isClientSide && interactionHand.equals(InteractionHand.OFF_HAND))
        {
            player.sendSystemMessage(Component.literal("Right click"));
        }*/
        else
        {

        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity)
    {
        if (entity instanceof LivingEntity livingEntity)
        {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200));
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
