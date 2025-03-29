package org.legomountain14.reinforcement.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reinforcement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        basicItem(ModItems.ITEM.get());
    }
}
