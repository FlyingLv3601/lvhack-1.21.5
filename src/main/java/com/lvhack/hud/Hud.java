package com.lvhack.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.server.MinecraftServer;
import org.w3c.dom.Text;


import com.lvhack.utils.RenderEngineUtil;

public class Hud {




    public static void getPlayerFps(MinecraftClient client, DrawContext context) {
        int fps = client.getCurrentFps();
        //render text
        RenderEngineUtil.textRender(context, "fps: " + fps, 5,  10);
    }
    public static void getPlayerPosition(MinecraftClient client, DrawContext context) {
       double x = (int) client.player.getX();
       double y = (int) client.player.getY();
       double z = (int) client.player.getZ();

        //render text
        RenderEngineUtil.textRender(context, "x: " + x + " y: " + y + "z: " + z, 5,  20);
    }
    public static void header(MinecraftClient client, DrawContext context) {
        String clientName = "lvhack";
        //render text
        RenderEngineUtil.textRender(context, clientName, 5,  30);
    }

    public static void hello(MinecraftClient client, DrawContext context) {
        String userNickName = client.player.getName().getString();
        //render text
        RenderEngineUtil.textRender(context, "Hello " + userNickName, 5,  40);
    }

    public static void hud(DrawContext context){
        MinecraftClient client = MinecraftClient.getInstance();
        getPlayerFps(client, context);
        getPlayerPosition(client,context);
        header(client,context);
        hello(client, context);
    }
}
