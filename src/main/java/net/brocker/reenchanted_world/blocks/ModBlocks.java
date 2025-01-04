package net.brocker.reenchanted_world.blocks;

import net.brocker.reenchanted_world.WorldReenchanted;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class ModBlocks {

    public static final BlockSet SPEED_BLOCK = new BlockSet("speed_block",
            AbstractBlock.Settings.create().strength(1f,4).velocityMultiplier(2f)).addSlab();


    // public static final BlockSet EXAMPLE_BLOCK = new BlockSet(
    //         "example_block",
    //         AbstractBlock.Settings.create()
                     // -1f hardness means the block can't be broken or moved,
                     // having a resistance of 6 means it can be destroyed by explosions
    //                 .strength(1f, 4).requiresTool().sounds(BlockSoundGroup.TUFF)
    // ).addStairs().addSlab().addWall().addPressurePlate(BlockSetType.IRON).addButton(BlockSetType.IRON, 20).addChiseled().addFence();

    public static void registerModBlocks() {
        WorldReenchanted.LOGGER.info("Registering Mod Blocks for " + WorldReenchanted.MOD_ID);
    }
}
