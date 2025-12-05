package com.lvhack;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.command.CommandRegistryAccess;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvhack.hud.Hud;
import com.lvhack.clickgui.ClickGui;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class LvHackClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lvhack");
    public static boolean hud = true;
    public static boolean openGui = false;


    @Override
    public void onInitializeClient() {

        //render hud

        HudRenderCallback.EVENT.register((drawcontext, world) -> {
           if(hud == true){
               Hud.hud(drawcontext);
           }
        });

        //clickGUi

        HudRenderCallback.EVENT.register((DrawContext, world) -> {
            if(openGui == true){
                ClickGui.categoryDraw(DrawContext);
            }
        });


        ClientCommandRegistrationCallback.EVENT.register(
                (CommandDispatcher<FabricClientCommandSource> dispatcher,
                 CommandRegistryAccess registryAccess) -> {



                    dispatcher.register(literal("lvhack")
                            .executes((CommandContext<FabricClientCommandSource> context) -> {
                                MinecraftClient client = MinecraftClient.getInstance();
                                openGui = !openGui;return 1;
                            })
                    );

                    dispatcher.register(literal("lvhackHud")
                            .executes((CommandContext<FabricClientCommandSource> context) -> {
                                hud = !hud;return 1;
                            })
                    );



                }
        );
    }
}