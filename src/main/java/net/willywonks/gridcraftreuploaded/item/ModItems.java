package net.willywonks.gridcraftreuploaded.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.willywonks.gridcraftreuploaded.GridCraftReuploaded;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GridCraftReuploaded.MODID);

    public static final DeferredItem<Item> IDENTITYDISK = ITEMS.register("iddisk",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
