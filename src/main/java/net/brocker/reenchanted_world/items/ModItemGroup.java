package net.brocker.reenchanted_world.items;

import net.brocker.reenchanted_world.WorldReenchanted;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup WORLD_REENCHANTED_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WorldReenchanted.MOD_ID, "world_reenchanted_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_CARROT))
                    .displayName(Text.translatable("itemGroup.world_reenchanted_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModItems.PINK_CARROT));

                    }).build());
    public static void registerModItemGroups() {
        WorldReenchanted.LOGGER.info("Registering Mod Item Groups for " + WorldReenchanted.MOD_ID);
    }
}

