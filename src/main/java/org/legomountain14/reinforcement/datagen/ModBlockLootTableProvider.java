package org.legomountain14.reinforcement.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.legomountain14.reinforcement.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.REINFORCED_CONCRETE.get());
        dropSelf(ModBlocks.REINFORCED_CONCRETE_POWDER.get());
        dropSelf(ModBlocks.REINFORCED_GLOWSTONE.get());
        dropSelf(ModBlocks.REINFORCED_IRON_TRAPDOOR.get());
        dropSelf(ModBlocks.REINFORCED_STONE_BRICKS.get());
        dropSelf(ModBlocks.REINFORCED_CONCRETE_POWDER.get());
        dropSelf(ModBlocks.REINFORCED_GLASS.get());
        dropSelf(ModBlocks.REINFORCED_TINTED_GLASS.get());
        dropSelf(ModBlocks.REINFORCED_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.REINFORCED_BUTTON.get());
        add(ModBlocks.REINFORCED_IRON_DOOR.get(),
                block -> createDoorTable(ModBlocks.REINFORCED_IRON_DOOR.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
