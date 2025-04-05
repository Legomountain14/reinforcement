package org.legomountain14.reinforcement.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reinforcement.MOD_ID);


    public static final Supplier<CreativeModeTab> REINFORCED_BLOCKS_TAB = CREATIVE_MODE_TAB.register("reinforced_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.REINFORCED_STONE_BRICKS))
                    .title(Component.translatable("item_group.reinforcement.reinforced_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.REINFORCED_STONE_BRICKS);
                        output.accept(ModBlocks.REINFORCED_CONCRETE);
                        output.accept(ModBlocks.REINFORCED_CONCRETE_POWDER);
                        output.accept(ModBlocks.REINFORCED_GLASS);
                        output.accept(ModBlocks.REINFORCED_TINTED_GLASS);
                        output.accept(ModBlocks.REINFORCED_GLOWSTONE);
                        output.accept(ModBlocks.REINFORCED_IRON_TRAPDOOR);
                        output.accept(ModBlocks.REINFORCED_IRON_DOOR);
                        output.accept(ModBlocks.REINFORCED_PRESSURE_PLATE);
                        output.accept(ModBlocks.REINFORCED_BUTTON);
                        output.accept(ModBlocks.REINFORCED_CONCRETE_STAIRS);
                        output.accept(ModBlocks.REINFORCED_STONE_BRICK_STAIRS);
                        output.accept(ModBlocks.REINFORCED_CONCRETE_SLAB);
                        output.accept(ModBlocks.REINFORCED_STONE_BRICK_SLAB);
                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
