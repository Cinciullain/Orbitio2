package net.cinciullain.orbitio2;

import net.cinciullain.orbitio2.item.Orbitio2Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CreativeTabOrbitio2 extends CreativeModeTab
{

    public CreativeTabOrbitio2()
    {
        super("orbitio2tab");
    }

    @NotNull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Orbitio2Items.SATELLITE_BASE.get());
    }

}
