package com.lvhack.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class RenderEngineUtil {
    static int colorText = 0xFFeee9e9;
    static int buttonBg = 0xADB85EAA;//0xFFFF90FF;
    static int colorBg = 0xADCF6BA9;


    public static void textRender(DrawContext context, String text, int x, int y){

        context.drawText(MinecraftClient.getInstance().textRenderer, text, x, y, colorText, false);
    }

    public static void drawCenteredText(DrawContext context, String text, int x, int y) {
        int textWidth = MinecraftClient.getInstance().textRenderer.getWidth(text);
        context.drawText(MinecraftClient.getInstance().textRenderer, text, x - textWidth / 2, y, colorText, false);
    }

    public static void category(DrawContext context, String text, int x, int y, int width, int height) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        int textWidth = textRenderer.getWidth(text);
        int textX = x + (width - textWidth) / 2;
        int textY = y + (height - textRenderer.fontHeight) / 2;
        context.fill(x, y, x + width, y + height, colorBg);
        context.drawText(textRenderer, text, textX, textY, colorText, false);
    }
    public static void moduleDraw(DrawContext context, String text, int x, int y, int width, int height) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        int textWidth = textRenderer.getWidth(text);
        int textX = x + (width - textWidth) / 2;
        int textY = y + (height - textRenderer.fontHeight) / 2;
        context.fill(x, y, x + width, y + height, buttonBg);
        context.drawText(textRenderer, text, textX, textY, colorText, false);
    }

}
