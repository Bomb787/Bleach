package bleach.items;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BleachItem extends Item {

	public BleachItem(Settings settings) {
		
		super(settings);
		
	}
	
	@Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        Object serverPlayerEntity;
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity) {
            serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)serverPlayerEntity, stack);
            ((PlayerEntity)serverPlayerEntity).incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            serverPlayerEntity = new ItemStack(Items.GLASS_BOTTLE);
            PlayerEntity playerEntity = (PlayerEntity)user;
            if (!playerEntity.getInventory().insertStack((ItemStack)serverPlayerEntity)) {
                playerEntity.dropItem((ItemStack)serverPlayerEntity, false);
            }
        }
        return stack;
    }
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.DRINK;
		
	}
	
	@Override
	public SoundEvent getDrinkSound() {
		
		return SoundEvents.ENTITY_GENERIC_DRINK;
		
	}
	
	@Override
	public SoundEvent getEatSound() {
		
		return SoundEvents.ENTITY_GENERIC_DRINK;
		
	}
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

}