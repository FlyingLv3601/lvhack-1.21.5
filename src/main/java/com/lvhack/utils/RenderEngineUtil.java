package com.lvhack.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class RenderEngineUtil {

    public static void textRender(DrawContext context, String text, int x, int y){
        int color = 0xFFB6C1;
        context.drawText(MinecraftClient.getInstance().textRenderer, text, x, y, color, false);
    }

    public static void drawCenteredText(DrawContext context, String text, int x, int y) {
        int color = 0xFFB6C1;
        int textWidth = MinecraftClient.getInstance().textRenderer.getWidth(text);
        context.drawText(MinecraftClient.getInstance().textRenderer, text, x - textWidth / 2, y, color, false);
    }
}
