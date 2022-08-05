package net.cinciullain.orbitio2.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

/*
I blockstates sono una forma di configurazione per i blocchi che permettono di personalizzare la loro forma e il loro comportamento.
Hanno infatti diversi "stati", che possono essere configurati, in questo esempio sfrutto la lampada di redstone.
 */
public class ProvaBlockstates extends Block
{
    //Ogni volta che si aggiunge una proprietà, bisogna sovrascrivere il metodo createBlockStateDefiniion() come mostrato nell'esempio di sotto
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public ProvaBlockstates(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos,
                                 Player player, InteractionHand interactionHand, BlockHitResult blockHitResult)
    {
        if (!level.isClientSide() && interactionHand.equals(InteractionHand.MAIN_HAND))
        {
            level.setBlock(blockPos, blockState.cycle(LIT), 3);
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(LIT);
    }
}
