package org.legomountain14.reinforcement.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Reinforcement.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.REINFORCED_CONCRETE);
        blockWithItem(ModBlocks.REINFORCED_CONCRETE_POWDER);
        blockWithItem(ModBlocks.REINFORCED_GLOWSTONE);
        blockWithItem(ModBlocks.REINFORCED_STONE_BRICKS);
        blockWithItemWithRenderType(ModBlocks.REINFORCED_GLASS, "translucent");
        blockWithItemWithRenderType(ModBlocks.REINFORCED_TINTED_GLASS, "translucent");


        stairsBlock(ModBlocks.REINFORCED_CONCRETE_STAIRS.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));
        stairsBlock(ModBlocks.REINFORCED_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.REINFORCED_STONE_BRICKS.get()));

        slabBlock(ModBlocks.REINFORCED_CONCRETE_SLAB.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));
        slabBlock(ModBlocks.REINFORCED_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.REINFORCED_STONE_BRICKS.get()), blockTexture(ModBlocks.REINFORCED_STONE_BRICKS.get()));

        pressurePlateBlock(ModBlocks.REINFORCED_PRESSURE_PLATE.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));
        buttonBlock(ModBlocks.REINFORCED_BUTTON.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));


        doorBlockWithRenderType(ModBlocks.REINFORCED_IRON_DOOR.get(), modLoc("block/reinforced_iron_door_bottom"), modLoc("block/reinforced_iron_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.REINFORCED_IRON_TRAPDOOR.get(), modLoc("block/reinforced_iron_trapdoor"), true, "cutout");


        blockItem(ModBlocks.REINFORCED_CONCRETE_STAIRS);
        blockItem(ModBlocks.REINFORCED_STONE_BRICK_STAIRS);
        blockItem(ModBlocks.REINFORCED_CONCRETE_SLAB);
        blockItem(ModBlocks.REINFORCED_STONE_BRICK_SLAB);
        blockItem(ModBlocks.REINFORCED_PRESSURE_PLATE);
//        blockItem(ModBlocks.REINFORCED_IRON_DOOR);
        blockItem(ModBlocks.REINFORCED_IRON_TRAPDOOR, "_bottom");

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }


    private void blockWithItemWithRenderType(DeferredBlock<?> deferredBlock, String renderType) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType(renderType));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("reinforcement:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("reinforcement:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
