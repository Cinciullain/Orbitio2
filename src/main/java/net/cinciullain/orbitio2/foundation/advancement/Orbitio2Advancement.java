package net.cinciullain.orbitio2.foundation.advancement;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.function.UnaryOperator;

//TODO: aggiungere texture background
public class Orbitio2Advancement
{
    private String advID;
    private String advTitle;
    private String advDescription;
    private Orbitio2Advancement parent;
    private Advancement.Builder forgeBuilder;

    public Orbitio2Advancement(String advID, UnaryOperator<AdvancementBuilder> builder) {
        this.advID = advID;
        this.forgeBuilder = Advancement.Builder.advancement();
    }

    class AdvancementBuilder
    {
        private TaskType taskType = TaskType.NORMAL;
        private boolean externalTrigger;
        private int keyIndex;
        private ItemStack advIcon;

        AdvancementBuilder setTaskType(TaskType taskType)
        {
            this.taskType = taskType;
            return this;
        }

        AdvancementBuilder setAdvTitle(String advTitle)
        {
            Orbitio2Advancement.this.advTitle = advTitle;
            return this;
        }

        AdvancementBuilder setAdvDescription(String advDescription)
        {
            Orbitio2Advancement.this.advDescription = advDescription;
            return this;
        }

        AdvancementBuilder preceedingAdv(Orbitio2Advancement preceedingAdv)
        {
            Orbitio2Advancement.this.parent = preceedingAdv;
            return this;
        }

        AdvancementBuilder setAdvIcon(ItemProviderEntry<?> item)
        {
            return setAdvIcon(item.asStack());
        }

        AdvancementBuilder setAdvIcon(ItemLike item)
        {
            return setAdvIcon(new ItemStack(item));
        }

        AdvancementBuilder setAdvIcon(ItemStack stack)
        {
            advIcon = stack;
            return this;
        }

        AdvancementBuilder externalTrigger(CriterionTriggerInstance trigger)
        {
            forgeBuilder.addCriterion(String.valueOf(keyIndex), trigger);
            externalTrigger = true;
            keyIndex++;
            return this;
        }

        AdvancementBuilder awardedForFree()
        {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}));
        }

        AdvancementBuilder whenItemCollected(TagKey<Item> tag)
        {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance
                    .hasItems(new ItemPredicate(tag, null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY,
                            EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)));
        }

        AdvancementBuilder whenItemCollected(ItemLike itemProvider)
        {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(itemProvider));
        }

        AdvancementBuilder whenItemCollected(ItemProviderEntry<?> item)
        {
            return whenItemCollected(item.asStack().getItem());
        }

        AdvancementBuilder whenIconCollected() {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(advIcon.getItem()));
        }
    }
}
