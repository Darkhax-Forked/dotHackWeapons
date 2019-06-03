package mod.azure.rcraft.items.baubles;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import mod.azure.rcraft.items.ItemBase;
import net.minecraft.item.ItemStack;

public class BaublesBeltItem extends ItemBase implements IBauble {

	public BaublesBeltItem(String name) {
		super(name);
	}

	@Override
    public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
    }

}