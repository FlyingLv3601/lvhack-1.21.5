package com.lvhack.hud;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import org.w3c.dom.Text;


import com.lvhack.utils.RenderEngineUtil;

public class Hud {




    public static void getPlayerFps(MinecraftClient client, DrawContext context, int w, int h) {
        int fps = client.getCurrentFps();
        //render text
        RenderEngineUtil.textRender(context, "fps: " + fps, 3,  15);
    }
    public static void getPlayerPosition(MinecraftClient client, DrawContext context, int w, int h) {
       double x = (int) client.player.getX();
       double y = (int) client.player.getY();
       double z = (int) client.player.getZ();

        //render text
        RenderEngineUtil.textRender(context, "x: " + x + " y: " + y + "z: " + z, 3, h - 100);
    }
    public static void waterMark(MinecraftClient client, DrawContext context, int w, int h) {
        String clientName = "lvhack";
        //render text
        RenderEngineUtil.textRender(context, clientName, 5,  5);
    }

    public static void welcome(MinecraftClient client, DrawContext context, int w, int h) {
        String userNickName = client.player.getName().getString();
        //render text
        RenderEngineUtil.drawCenteredText(context, "welcome, " + userNickName + "!!!", w / 2,  3);
    }
    public static void speed(MinecraftClient client, DrawContext context, int w, int h) {
        double speedX = client.player.getVelocity().x * 20;
        double speedZ = client.player.getVelocity().z * 20;
        double speeds = Math.sqrt(speedX * speedX + speedZ * speedZ);
        String speed = String.format("%.2f", speeds);
        RenderEngineUtil.textRender(context, "Speed, " + speed, 5,  h - 25);

    }
    public static void directrion(MinecraftClient client, DrawContext context, int w, int h) {


    }

    public static void hud(DrawContext context){
        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();



        getPlayerFps(client, context, height, width);
        getPlayerPosition(client,context, height, width);
        waterMark(client,context, height, width);
        welcome(client, context, height, width);
        speed(client, context, height, width);
        directrion(client, context, height, width);
    }
}
