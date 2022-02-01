package bleach.init;

import bleach.Bleach;
import bleach.items.BleachItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit {
	
	public static final Item BLEACH = register(new BleachItem(new Item.Settings()
			.recipeRemainder(Items.GLASS_BOTTLE)
			.group(ItemGroup.BREWING)
			.maxCount(1)
			.food(new FoodComponent.Builder()
					.hunger(0)
					.saturationModifier(0.0f)
					.alwaysEdible()
					.statusEffect(new StatusEffectInstance(EffectInit.BLEACH, 2400), 1.0F)
					.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 2400), 1.0F)
					.build())), "bleach");
	
	public static final Item BRINE = register(new Item(new Item.Settings()
			.group(ItemGroup.BREWING)
			.maxCount(1)), "brine");

	static <T extends Item> T register(T item, String id) {
		Registry.register(Registry.ITEM, new Identifier(Bleach.MOD_ID, id), item);
		return item;
	}

}