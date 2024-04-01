package net.berryjar.berryjarhubwitdi.menus;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.slot.Slot;
import org.ipvp.canvas.type.ChestMenu;

public class TeleCompassMenu {
    private final BerryJarHubWitDI plugin;

    public TeleCompassMenu(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    public Menu createMenu() {
        return ChestMenu.builder(5).title(ChatColor.DARK_PURPLE + "Menu of Teleportation").build();

    }

    public void displayMenu(Player player) {

        //10 28
        Menu menu = createMenu();
        menu.open(player);

        Slot grassWarp = menu.getSlot(10);
        grassWarp.setItemTemplate(p -> {
            ItemStack grassBlock = new ItemStack(Material.GRASS_BLOCK);
            ItemMeta grassMeta = grassBlock.getItemMeta();
            grassMeta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.ITALIC.toString() + "Classic Survival");
            grassBlock.setItemMeta(grassMeta);
            return grassBlock;
        });

        Slot sgWarp = menu.getSlot(28);
        sgWarp.setItemTemplate(p -> {
            ItemStack sgSword = new ItemStack(Material.IRON_SWORD);
            ItemMeta sgSwordMeta = sgSword.getItemMeta();
            sgSwordMeta.setDisplayName(ChatColor.LIGHT_PURPLE.toString() + ChatColor.ITALIC.toString() + "Survival Games");
            sgSword.setItemMeta(sgSwordMeta);
            return sgSword;

        });

        addSurvivalClickHandler(grassWarp);
    }



    public void addSurvivalClickHandler(Slot slot) {

        slot.setClickHandler(((player, clickInformation) -> {
            WarpManager warpManager = new WarpManager(plugin);
            Warp survivalSpawn = warpManager.getWarp("survivalspawn");
            Location warpLoc = survivalSpawn.getLocation();
            player.teleport(warpLoc);

        }));

    }

//    Menu.Builder pageTemplate = ChestMenu.builder(3).title("Items").redraw(true);
//    Mask itemSlots = BinaryMask.builder(pageTemplate.getDimensions()).pattern("011111110").build();
//    List<Menu> pages = PaginatedMenuBuilder.builder(pageTemplate).slots(itemSlots).nextButton(new ItemStack(Material.ARROW)).nextButtonEmpty(new ItemStack(Material.ARROW)).nextButtonSlot(23).previousButton(new ItemStack(Material.ARROW)).previousButtonEmpty(new ItemStack(Material.ARROW)).previousButtonSlot(21).addItem(new ItemStack(Material.DIRT)).addItem(new ItemStack(Material.GRASS_BLOCK)).addItem(new ItemStack(Material.COBBLESTONE)).addItem(new ItemStack(Material.STONE)).build();

//    Menu.Builder pageTemplate = ChestMenu.builder(3).title("Items").redraw(true);
//    Mask itemSlots = BinaryMask.builder(pageTemplate.getDimensions()).pattern("011111110").build();
//    List<Menu> pages - PaginatedMenuBuilder.builder(pageTemplate).slots(itemSlots).nextButton

}
