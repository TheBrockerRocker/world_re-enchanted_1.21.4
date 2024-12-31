package net.brocker.reenchanted_world.items;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodCompnents {
    public static final FoodComponent PINK_CARROT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.6f)
            .build();

    public static final ConsumableComponent PINK_CARROT_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 100, 1), 1.0f))
            .build();

}