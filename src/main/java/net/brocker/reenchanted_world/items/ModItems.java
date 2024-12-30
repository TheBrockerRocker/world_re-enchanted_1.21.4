package net.brocker.reenchanted_world.items;

import net.brocker.reenchanted_world.WorldReenchanted;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EXAMPLE_ITEM = register(
            new Item(
                    new Item.Settings()
                            .registryKey(
                                    getItemRegistryKey(getId("example_item"))
                            )
            ),
            getId("example_item")
    );

    private static Identifier getId(String name) {
        return Identifier.of(WorldReenchanted.MOD_ID, name);
    }
    private static RegistryKey<Item> getItemRegistryKey(Identifier id) {
        return  RegistryKey.of(RegistryKeys.ITEM, id);
    }
    private static Item register(Item item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void registerModItems() {
        WorldReenchanted.LOGGER.info("Registering Mod Items for " + WorldReenchanted.MOD_ID);
    }
}
