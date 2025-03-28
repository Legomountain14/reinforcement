package org.legomountain14.reinforcement.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.legomountain14.reinforcement.Reinforcement;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reinforcement.MOD_ID);




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
