package concern.init;

import concern.Concern;
import concern.effects.BleachStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EffectInit {

    public static final StatusEffect BLEACH = new BleachStatusEffect().addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.8F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

    public static void init() {

        Registry.register(Registry.STATUS_EFFECT, new Identifier(Concern.MOD_ID, "bleach"), BLEACH);

    }

}