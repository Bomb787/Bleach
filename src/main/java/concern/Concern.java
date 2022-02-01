package concern;

import concern.init.EffectInit;
import concern.init.ItemInit;
import net.fabricmc.api.ModInitializer;

public class Concern implements ModInitializer {

    public static final String MOD_ID = "concern";

    public static ItemInit ITEMS;

    @Override
    public void onInitialize() {

        EffectInit.init();
        ITEMS = new ItemInit();

    }

}