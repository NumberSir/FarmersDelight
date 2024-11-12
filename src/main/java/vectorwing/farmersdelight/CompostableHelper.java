package vectorwing.farmersdelight;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

//This is hacky and tbh not even needed but hey
public class CompostableHelper {
    protected static void apply() {
        JsonElement je = new Gson().fromJson(COMPOSTABLES, JsonElement.class);
        if (je != null) {
            var j = je.getAsJsonObject().get("values");
            for (var v : j.getAsJsonObject().asMap().entrySet()) {
                Item i = BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(v.getKey().toString()));
                CompostingChanceRegistry.INSTANCE.add(i, v.getValue().getAsJsonObject().get("chance").getAsFloat());
            }
        }
    }

    //just here so we can copy paste FD one here
    private static final String COMPOSTABLES = """
            
            {
              "values": {
                "farmersdelight:apple_pie": {
                  "chance": 1.0
                },
                "farmersdelight:apple_pie_slice": {
                  "chance": 0.85
                },
                "farmersdelight:brown_mushroom_colony": {
                  "chance": 1.0
                },
                "farmersdelight:cabbage": {
                  "chance": 0.65
                },
                "farmersdelight:cabbage_leaf": {
                  "chance": 0.5
                },
                "farmersdelight:cabbage_seeds": {
                  "chance": 0.3
                },
                "farmersdelight:cake_slice": {
                  "chance": 0.85
                },
                "farmersdelight:chocolate_pie": {
                  "chance": 1.0
                },
                "farmersdelight:chocolate_pie_slice": {
                  "chance": 0.85
                },
                "farmersdelight:dumplings": {
                  "chance": 1.0
                },
                "farmersdelight:honey_cookie": {
                  "chance": 0.85
                },
                "farmersdelight:kelp_roll": {
                  "chance": 0.85
                },
                "farmersdelight:kelp_roll_slice": {
                  "chance": 0.5
                },
                "farmersdelight:onion": {
                  "chance": 0.65
                },
                "farmersdelight:pie_crust": {
                  "chance": 0.65
                },
                "farmersdelight:pumpkin_slice": {
                  "chance": 0.5
                },
                "farmersdelight:raw_pasta": {
                  "chance": 0.85
                },
                "farmersdelight:red_mushroom_colony": {
                  "chance": 1.0
                },
                "farmersdelight:rice": {
                  "chance": 0.3
                },
                "farmersdelight:rice_bale": {
                  "chance": 0.85
                },
                "farmersdelight:rice_panicle": {
                  "chance": 0.3
                },
                "farmersdelight:rotten_tomato": {
                  "chance": 0.85
                },
                "farmersdelight:sandy_shrub": {
                  "chance": 0.3
                },
                "farmersdelight:straw": {
                  "chance": 0.3
                },
                "farmersdelight:stuffed_pumpkin_block": {
                  "chance": 1.0
                },
                "farmersdelight:sweet_berry_cheesecake": {
                  "chance": 1.0
                },
                "farmersdelight:sweet_berry_cheesecake_slice": {
                  "chance": 0.85
                },
                "farmersdelight:sweet_berry_cookie": {
                  "chance": 0.85
                },
                "farmersdelight:tomato": {
                  "chance": 0.65
                },
                "farmersdelight:tomato_seeds": {
                  "chance": 0.3
                },
                "farmersdelight:tree_bark": {
                  "chance": 0.3
                },
                "farmersdelight:wild_beetroots": {
                  "chance": 0.65
                },
                "farmersdelight:wild_cabbages": {
                  "chance": 0.65
                },
                "farmersdelight:wild_carrots": {
                  "chance": 0.65
                },
                "farmersdelight:wild_onions": {
                  "chance": 0.65
                },
                "farmersdelight:wild_potatoes": {
                  "chance": 0.65
                },
                "farmersdelight:wild_rice": {
                  "chance": 0.65
                },
                "farmersdelight:wild_tomatoes": {
                  "chance": 0.65
                }
              }
            }
            """;

}