package com.lvhack.clickgui;

import com.lvhack.utils.RenderEngineUtil;
import net.minecraft.client.gui.DrawContext;

public class ClickGui {
    private static final String[] categories = {
            "example1", "example2", "example3", "example4"
    };

    public static void categoryDraw(DrawContext context){
        int x = 20;
        int y = 20;
        int width = 100;
        int height = 20;
        int padding = 5;

        for(int i = 0; i < categories.length; i++) {
            int drawX = x + i * (width + padding);
            RenderEngineUtil.category(context, categories[i], drawX, y, width, height);
        }
    }
}

