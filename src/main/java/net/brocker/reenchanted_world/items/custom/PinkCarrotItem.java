package net.brocker.reenchanted_world.items.custom;

import net.brocker.reenchanted_world.WorldReenchanted;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class PinkCarrotItem extends Item {
    public PinkCarrotItem(Settings settings) {
        super(settings);
    }

    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.6f)
            .build();

    public static final ConsumableComponent CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.SPEED, 15 * 20, 1), 1.0f))
            .build();
}
