package mod.azure.rcraft.items;

import com.robertx22.api.MineAndSlashAPI;
import com.robertx22.config.non_mine_items.ConfigItem;
import com.robertx22.items.gearitems.bases.IGearItem;
import com.robertx22.items.gearitems.bases.IWeapon;
import com.robertx22.items.gearitems.weapons.ItemStaff;

import mod.azure.rcraft.IMultiType;
import mod.azure.rcraft.RcraftMod;
import mod.azure.rcraft.config.StaffConfigItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemMagic extends ItemStaff implements IMultiType, IGearItem, IWeapon  {
	
	private final int maxTypes;

	public ItemMagic(String name, int maxTypes) {
		super();
		this.maxTypes = maxTypes;
		this.setTranslationKey(name);
		this.setRegistryName(new ResourceLocation(RcraftMod.modid, name));
		this.setCreativeTab(RcraftMod.tab);
	}
	
	public int getMaxTypes() {
		return this.maxTypes;
	}
	
	public int getType(ItemStack stack) {
		return stack.getItemDamage() + 1;
	}
	
	@Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> variants) {
		if (this.isInCreativeTab(tab)) {
			for (int meta = 0; meta < this.getMaxTypes(); meta++) {
				variants.add(new ItemStack(this, 1, meta));
			}
		}
	}

	public String getTranslationKey(ItemStack stack) {
		return this.getTranslationKey();
	}
	
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

	stack.damageItem(1, attacker);

	return true;
    }
	
	public void MineAndSlashComatibleItem() {
        MineAndSlashAPI.addCompatibleItem("rcraft:harvestcleric", new StaffConfigItem() );	
	}

}
