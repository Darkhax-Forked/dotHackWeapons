package mod.azure.rcraft;

import java.util.ArrayList;
import java.util.List;

import mod.azure.rcraft.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = RcraftMod.modid, version = RcraftMod.version, dependencies = RcraftMod.dependencies)
public class RcraftMod {

	public static final String modid = "rcraft";
	public static final String MODNAME = "dotHack Weapons";
	public static final String version = "1.5.5";
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
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit();
        if(Loader.isModLoaded("mmorpg")) {
        	MMORPGHandler.registerMMORPG();
        }
    } 
}