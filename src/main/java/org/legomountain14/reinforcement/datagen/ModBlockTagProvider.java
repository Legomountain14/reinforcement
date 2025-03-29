package org.legomountain14.reinforcement.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Reinforcement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.REINFORCED_CONCRETE.get())
                .add(ModBlocks.REINFORCED_GLOWSTONE.get())
                .add(ModBlocks.REINFORCED_IRON_TRAPDOOR.get())
                .add(ModBlocks.REINFORCED_IRON_DOOR.get())
                .add(ModBlocks.REINFORCED_STONE_BRICKS.get())
                .add(ModBlocks.REINFORCED_CONCRETE_POWDER.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.REINFORCED_TINTED_GLASS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.REINFORCED_CONCRETE.get())
                .add(ModBlocks.REINFORCED_GLOWSTONE.get())
                .add(ModBlocks.REINFORCED_IRON_TRAPDOOR.get())
                .add(ModBlocks.REINFORCED_IRON_DOOR.get())
                .add(ModBlocks.REINFORCED_STONE_BRICKS.get())
                .add(ModBlocks.REINFORCED_CONCRETE_POWDER.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.REINFORCED_TINTED_GLASS.get());
    }
}
