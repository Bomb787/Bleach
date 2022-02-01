package bleach.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleachStatusEffect extends StatusEffect {

	public BleachStatusEffect() {
		
		super(StatusEffectCategory.HARMFUL, 0xFFFFFF);
		
	}
	
	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		
		return true;
		
	}
	
	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		
		if(entity.canTakeDamage()) {
			
			Entity e = (Entity) entity;
				
			entity.damage(new BleachDamageSource("bleach", e), 2);
			
		}
		
	}

}