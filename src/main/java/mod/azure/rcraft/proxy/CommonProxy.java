package mod.azure.rcraft.proxy;

import static net.minecraftforge.fml.relauncher.Side.SERVER;

import mod.azure.rcraft.RcraftMod;
import mod.azure.rcraft.util.Register;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = RcraftMod.modid, value = SERVER)
public class CommonProxy {


	public void preInit() {

	}

	public void init() {

	}

	public void postInit() {
		
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> e) {
			IForgeRegistry<Item> registry = e.getRegistry();

			for (Item item : Register.itemList) {
				registry.register(item);
			}

			Register.variantList = NonNullList.create();
			for (Item item :  Register.itemList) {
				item.getSubItems(RcraftMod.tab, Register.variantList);
			}
		}
	}
}