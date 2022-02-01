package bleach;

import bleach.init.EffectInit;
import bleach.init.ItemInit;
import net.fabricmc.api.ModInitializer;

public class Bleach implements ModInitializer {
	
	public static final String MOD_ID = "bleach";
	
	public static ItemInit ITEMS;

	@Override
	public void onInitialize() {
		
		EffectInit.init();
		ITEMS = new ItemInit();
		
	}

}