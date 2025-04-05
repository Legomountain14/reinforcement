package org.legomountain14.reinforcement.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import org.legomountain14.reinforcement.Reinforcement;
import org.legomountain14.reinforcement.block.ModBlocks;
import net.minecraft.world.item.crafting.*;
import org.legomountain14.reinforcement.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        List<ItemLike> REINFORCED_CONCRETE_POWDER = List.of(ModBlocks.REINFORCED_CONCRETE_POWDER);





        // Reinforced Concrete Powder Recipe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_CONCRETE_POWDER.get(),8)
                .requires(Items.SAND, 4)
                .requires(Items.GRAVEL, 4)
                .requires(Items.IRON_INGOT, 1)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Concrete Recipe
        oreBlasting(recipeOutput, REINFORCED_CONCRETE_POWDER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_CONCRETE.get(), 0.10f, 100, "reinforcement");



        // Reinforced Glass Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.GLASS)
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Tinted Glass Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_TINTED_GLASS.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.TINTED_GLASS)
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Glowstone Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLOWSTONE.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.GLOWSTONE)
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Iron Door Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_IRON_DOOR.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.IRON_NUGGET)
                .define('B', Items.IRON_DOOR)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Iron Trapdoor Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_IRON_TRAPDOOR.get(), 8)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.IRON_NUGGET)
                .define('B', Items.IRON_TRAPDOOR)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Stone Bricks Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_STONE_BRICKS.get(), 8)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.STONE_BRICKS)
                .define('B', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);


        // Reinforced Pressure Plate Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_PRESSURE_PLATE.get(), 4)
                .pattern("AA")
                .define('A', ModBlocks.REINFORCED_CONCRETE)
                .unlockedBy("has_reinforced_concrete", has(ModBlocks.REINFORCED_CONCRETE))
                .save(recipeOutput);


        // Reinforced Button Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_BUTTON.get(), 4)
                .pattern("A")
                .define('A', ModBlocks.REINFORCED_CONCRETE)
                .unlockedBy("has_reinforced_concrete", has(ModBlocks.REINFORCED_CONCRETE))
                .save(recipeOutput);

        // Reinforced Concrete Stairs Recipe
        stairBuilder(ModBlocks.REINFORCED_CONCRETE_STAIRS.get(), Ingredient.of(ModBlocks.REINFORCED_CONCRETE))
                .unlockedBy("has_reinforced_concrete", has(ModBlocks.REINFORCED_CONCRETE))
                .save(recipeOutput);

        // Reinforced Stone Brick Stairs Recipe
        stairBuilder(ModBlocks.REINFORCED_STONE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.REINFORCED_STONE_BRICK_STAIRS))
                .unlockedBy("has_reinforced__stone_bricks", has(ModBlocks.REINFORCED_STONE_BRICKS))
                .save(recipeOutput);


        // Reinforced Concrete Slab Recipe
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_CONCRETE_SLAB.get(), ModBlocks.REINFORCED_CONCRETE.get());


        // Reinforced Stone Brick Slab Recipe
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_STONE_BRICK_SLAB.get(), ModBlocks.REINFORCED_STONE_BRICKS.get());











    }





    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Reinforcement.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
