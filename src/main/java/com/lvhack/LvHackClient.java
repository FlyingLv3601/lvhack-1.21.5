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

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class LvHackClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lvhack");

    @Override
    public void onInitializeClient() {

        ClientCommandRegistrationCallback.EVENT.register(
                (CommandDispatcher<FabricClientCommandSource> dispatcher,
                 CommandRegistryAccess registryAccess) -> {
                    dispatcher.register(literal("lvhack")
                            .executes((CommandContext<FabricClientCommandSource> context) -> {
                                MinecraftClient client = MinecraftClient.getInstance();

                                HudRenderCallback.EVENT.register((drawcontext, world) -> {
                                    Hud.hud(drawcontext);
                                });
                                return 1;
                            })
                    );
                }
        );
    }
}