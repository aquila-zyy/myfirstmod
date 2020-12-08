package aquila.myfirstmod;

import aquila.myfirstmod.registry.BlockRegistry;
import aquila.myfirstmod.registry.ItemRegistry;
import java.util.stream.Collectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("myfirstmod")
public class FirstMod {
  // Directly reference a log4j logger.
  private static final Logger LOGGER = LogManager.getLogger();

  public FirstMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    // ItemRegistry the setup method for modloading
    modEventBus.addListener(this::setup);
    // ItemRegistry the enqueueIMC method for modloading
    modEventBus.addListener(this::enqueueIMC);
    // ItemRegistry the processIMC method for modloading
    modEventBus.addListener(this::processIMC);
    // ItemRegistry the doClientStuff method for modloading
    modEventBus.addListener(this::doClientStuff);

    // ItemRegistry ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
    ItemRegistry.registrar.register(modEventBus);
    BlockRegistry.registrar.register(modEventBus);
  }

  private void setup(final FMLCommonSetupEvent event) {
    // some preinit code
    LOGGER.info("HELLO FROM PREINIT");
    LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
  }

  private void doClientStuff(final FMLClientSetupEvent event) {
    // do something that can only be done on the client
    LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
  }

  private void enqueueIMC(final InterModEnqueueEvent event) {
    // some example code to dispatch IMC to another mod
    InterModComms.sendTo(
        "examplemod",
        "helloworld",
        () -> {
          LOGGER.info("Hello world from the MDK");
          return "Hello world";
        });
  }

  private void processIMC(final InterModProcessEvent event) {
    // some example code to receive and process InterModComms from other mods
    LOGGER.info(
        "Got IMC {}",
        event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) {
    // do something when the server starts
    LOGGER.info("HELLO from server starting");
  }

  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this
  // is subscribing to the MOD
  // Event bus for receiving ItemRegistry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
      // register a new block here
      LOGGER.info("HELLO from ItemRegistry Block");
    }
  }
}
