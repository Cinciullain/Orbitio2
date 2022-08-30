package net.cinciullain.orbitio2.foundation.advancement;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class AllAdvancements implements DataProvider
{
    public static final List<Orbitio2Advancement> ENTRIES = new ArrayList<>();
    public static final Orbitio2Advancement START = null,
    //Entries
    END = null;

    private static Orbitio2Advancement create(String id, UnaryOperator<Orbitio2Advancement.AdvancementBuilder> builder)
    {
        return new Orbitio2Advancement(id, builder);
    }

    //

    @Override
    public void run(CachedOutput cachedOutput) throws IOException
    {

    }

    @Override
    public String getName()
    {
        return "Orbitio's Advancements";
    }

    public static void register() {}
}
