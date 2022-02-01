package concern.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class BleachDamageSource extends EntityDamageSource {

    public BleachDamageSource(String name, Entity source) {
        super(name, source);
    }

    @Override
    public Text getDeathMessage(LivingEntity entity) {
        String string = "death.attack.bleach";
        return new TranslatableText(string, entity.getDisplayName());
    }

}