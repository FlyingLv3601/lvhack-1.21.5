package com.lvhack_on_top;

import com.lvhack_on_top.clickgui.ClickGuiScreen;
import com.lvhack_on_top.modules.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LVHACK implements ClientModInitializer {
    public static final String MOD_ID = "lvhack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    KeyBinding openGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.openGui.gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "key.category"
    ));

    @Override
    public void onInitializeClient() {
        LOGGER.info("Client-side Fabric mod loaded!");


        ModuleManager.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(openGui.wasPressed()) {
                client.setScreen(new ClickGuiScreen());
            }
        });
    }
}