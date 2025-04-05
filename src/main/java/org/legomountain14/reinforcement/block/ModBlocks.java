package org.legomountain14.reinforcement.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Reinforcement.MOD_ID);

    // START BLOCKS

    // Reinforced Stone Bricks
    public static final DeferredBlock<Block> REINFORCED_STONE_BRICKS = registerBlock("reinforced_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    // Reinforced Concrete
    public static final DeferredBlock<Block> REINFORCED_CONCRETE = registerBlock("reinforced_concrete",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    // Reinforced Concrete Powder
    public static final DeferredBlock<FallingBlock> REINFORCED_CONCRETE_POWDER = registerBlock("reinforced_concrete_powder",
            () -> new FallingBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(0.5F)
                    .sound(SoundType.SAND)
            ) {
                @Override
                protected MapCodec<? extends FallingBlock> codec() {
                    return null;
                }
            });

    // Reinforced Glass
    public static final DeferredBlock<TransparentBlock> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(ModBlocks::never)
                    .isSuffocating(ModBlocks::never)
                    .isViewBlocking(ModBlocks::never)
            ));

    // Reinforced Tinted Glass
    public static final DeferredBlock<TintedGlassBlock> REINFORCED_TINTED_GLASS = registerBlock("reinforced_tinted_glass",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(ModBlocks::never)
                    .isSuffocating(ModBlocks::never)
                    .isViewBlocking(ModBlocks::never)
            ));


    // Reinforced Glowstone
    public static final DeferredBlock<Block> REINFORCED_GLOWSTONE = registerBlock("reinforced_glowstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.PLING)
                    .strength(5.0F, 1200.0F)
                    .sound(SoundType.GLASS)
                    .lightLevel(p_50872_ -> 15)
                    .isRedstoneConductor(ModBlocks::never)
            ));

    // Reinforced Iron Door
    public static final DeferredBlock<DoorBlock> REINFORCED_IRON_DOOR = registerBlock("reinforced_iron_door",
            () -> new DoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 1200.0F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            ));

    // Reinforced Iron Trapdoor
    public static final DeferredBlock<TrapDoorBlock> REINFORCED_IRON_TRAPDOOR = registerBlock("reinforced_iron_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 1200.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
            ));

    // Reinforced Pressure Plate
    public static final DeferredBlock<PressurePlateBlock> REINFORCED_PRESSURE_PLATE = registerBlock("reinforced_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .strength(5.0F, 1200.0F)
                    .pushReaction(PushReaction.DESTROY)
            ));


    // Reinforced Button
    public static final DeferredBlock<ButtonBlock> REINFORCED_BUTTON = registerBlock("reinforced_button",
            () -> new ButtonBlock(BlockSetType.IRON, 15, BlockBehaviour.Properties.of()
                    .strength(2.5F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .noCollission()));


    // Reinforced Concrete Stairs
    public static final DeferredBlock<StairBlock> REINFORCED_CONCRETE_STAIRS = registerBlock("reinforced_concrete_stairs",
            () -> new StairBlock(ModBlocks.REINFORCED_CONCRETE.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()));


    // Reinforced Stone Brick Stairs
    public static final DeferredBlock<StairBlock> REINFORCED_STONE_BRICK_STAIRS = registerBlock("reinforced_stone_brick_stairs",
            () -> new StairBlock(ModBlocks.REINFORCED_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()));

    // Reinforced Concrete Slab
    public static final DeferredBlock<SlabBlock> REINFORCED_CONCRETE_SLAB = registerBlock("reinforced_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()));

    // Reinforced Stone Brick Slab
    public static final DeferredBlock<SlabBlock> REINFORCED_STONE_BRICK_SLAB = registerBlock("reinforced_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()));








    // END BLOCKS

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }



    // Block Item Registrar
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
}
