package org.legomountain14.reinforcement.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.block.ModBlocks;
import org.legomountain14.reinforcement.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reinforcement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleBlockItem(ModBlocks.REINFORCED_IRON_DOOR.get());
        basicItem(ModBlocks.REINFORCED_IRON_DOOR.asItem());
        buttonItem(ModBlocks.REINFORCED_BUTTON, ModBlocks.REINFORCED_CONCRETE);

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Reinforcement.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
