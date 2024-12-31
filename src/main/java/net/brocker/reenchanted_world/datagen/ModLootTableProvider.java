package net.brocker.reenchanted_world.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    private final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture;

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
        this.registryLookupFuture = registryLookup;
    }

    @Override
    public void generate() {
        // addDrop(ModBlocks.EXAMPLE_BLOCK);

        // ores
        // addDrop(ModBlocks.EXAMPLE_BLOCK, oreDrops(ModBlocks.EXAMPLE_BLOCK, ModItems.EXAMPLE_ITEM));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        // Resolve the registry lookup at the time of use
        RegistryWrapper.Impl<Enchantment> registryWrapper = registryLookupFuture.join().getOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))).apply(
                ApplyBonusLootFunction.oreDrops(registryWrapper.getOrThrow(Enchantments.FORTUNE))
        )));
    }
}