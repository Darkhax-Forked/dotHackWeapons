package mod.azure.rcraft;

import java.util.ArrayList;
import java.util.List;

import mod.azure.rcraft.proxy.CommonProxy;
import mod.azure.rcraft.util.LootHandler;
import mod.azure.rcraft.util.MMORPGHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RcraftMod.modid, version = RcraftMod.version, dependencies = RcraftMod.dependencies)
public class RcraftMod {

	public static final String modid = "rcraft";
	public static final String MODNAME = "dotHack Weapons";
	public static final String version = "1.7.2";
	public static final String dependencies = "required-after:ebwizardry;after:mmorpg";

	@SidedProxy(clientSide = "mod.azure.rcraft.proxy.ClientProxy", serverSide = "mod.azure.rcraft.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs tab = new Tab(modid);

	@Mod.Instance
	public static RcraftMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init();
		MinecraftForge.EVENT_BUS.register(new LootHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit();
		if(Loader.isModLoaded("mmorpg")) {
			MinecraftForge.EVENT_BUS.register(new MMORPGHandler());
		}
	} 
}