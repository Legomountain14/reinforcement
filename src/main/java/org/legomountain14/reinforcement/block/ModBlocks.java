package org.legomountain14.reinforcement.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    // Reinforced Concrete
    public static final DeferredBlock<Block> REINFORCED_CONCRETE = registerBlock("reinforced_concrete",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    // Reinforced Concrete Powder
    public static final DeferredBlock<Block> REINFORCED_CONCRETE_POWDER = registerBlock("reinforced_concrete_powder",
            () -> new FallingBlock(BlockBehaviour.Properties.of()
                    .strength(0.5F)
                    .sound(SoundType.SAND)
            ) {
                @Override
                protected MapCodec<? extends FallingBlock> codec() {
                    return null;
                }
            });

    // Reinforced Glass
    public static final DeferredBlock<Block> REINFORCED_GLASS = registerBlock("reinforced_glass",
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

    // Reinforced Glass
    public static final DeferredBlock<Block> REINFORCED_TINTED_GLASS = registerBlock("reinforced_tinted_glass",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(5.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(ModBlocks::never)
                    .isSuffocating(ModBlocks::never)
                    .isViewBlocking(ModBlocks::never)
            ));





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
