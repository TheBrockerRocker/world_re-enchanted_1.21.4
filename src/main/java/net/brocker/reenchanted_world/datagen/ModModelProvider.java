package net.brocker.reenchanted_world.datagen;

import net.brocker.reenchanted_world.WorldReenchanted;
import net.brocker.reenchanted_world.blocks.BlockSet;
import net.brocker.reenchanted_world.blocks.ModBlocks;
import net.brocker.reenchanted_world.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void generateBlockStateModelsForBlockSet(BlockStateModelGenerator blockStateModelGenerator, BlockSet blockSet) {
        BlockStateModelGenerator.BlockTexturePool pool = blockStateModelGenerator.registerCubeAllModelTexturePool(blockSet.BLOCK);

        blockSet.STAIR.ifPresent(pool::stairs);
        blockSet.SLAB.ifPresent(pool::slab);

        blockSet.BUTTON.ifPresent(pool::button);
        blockSet.PRESSURE_PLATE.ifPresent(pool::pressurePlate);

        blockSet.FENCE.ifPresent(pool::fence);
        blockSet.FENCE_GATE.ifPresent(pool::fenceGate);

        blockSet.WALL.ifPresent(pool::wall);

        blockSet.DOOR.ifPresent(blockStateModelGenerator::registerDoor);
        blockSet.TRAPDOOR.ifPresent(blockStateModelGenerator::registerTrapdoor);

        blockSet.CHISELED.ifPresent(blockStateModelGenerator::registerSimpleCubeAll);

        WorldReenchanted.LOGGER.info("Generated models for " + blockSet.NAME + " blockset");
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateBlockStateModelsForBlockSet(blockStateModelGenerator, ModBlocks.SPEED_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_CARROT, Models.GENERATED);
    }
}
