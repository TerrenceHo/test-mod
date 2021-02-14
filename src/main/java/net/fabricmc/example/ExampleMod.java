package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		System.out.println("Hello Kevin!");
		System.out.println("Debug change.");
		Registry.register(Registry.ITEM, new Identifier("tutorial", "golden_mob_head"), GOLDEN_MOB_HEAD);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "enchanted_golden_mob_head"), Enchanted_Golden_Mob_Head);

	}

	public static final Item GOLDEN_MOB_HEAD = new Item(
			new FabricItemSettings()
					.group(ItemGroup.MISC)
					.food(new FoodComponent.Builder()
							.alwaysEdible()
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5, 1), 1f)
							.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*22, 1), 1f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*120), 1f)
							.hunger(4)
							.saturationModifier(9.6f)
							.build()
					)
					.maxCount(64)
					.rarity(Rarity.RARE)
	);

	public static final Item Enchanted_Golden_Mob_Head = new Item(
			new FabricItemSettings()
					.group(ItemGroup.MISC)
					.food(new FoodComponent.Builder()
							.alwaysEdible()
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5, 3), 1f)
							.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*22, 2), 1f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*120, 2), 1f)
							.hunger(4)
							.saturationModifier(9.6f)
							.build()
					)
					.maxCount(64)
					.rarity(Rarity.EPIC)
	);
}

class GoldenMobHead extends Item {
	public GoldenMobHead(Settings settings) {
		super(settings);
	}
}

class EnchantedGoldenMobHead extends Item {
	public EnchantedGoldenMobHead(Settings settings) {
		super(settings);
	}

	@Override
	public Text getName() {
		return new TranslatableText("Enchanted Golden Mob Head");
	}
}