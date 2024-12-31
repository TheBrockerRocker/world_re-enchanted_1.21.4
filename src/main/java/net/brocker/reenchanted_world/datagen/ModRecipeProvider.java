package net.brocker.reenchanted_world.datagen;

import net.brocker.reenchanted_world.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_CARROT_CRAFTABLE = List.of(ModItems.PINK_CARROT);

                createShaped(RecipeCategory.MISC, ModItems.PINK_CARROT)
                        .pattern("GGG")
                        .pattern("GCG")
                        .pattern("GGG")
                        .input('G', Items.GOLD_INGOT)
                        .input('C', Items.CARROT)
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return null;
    }
}