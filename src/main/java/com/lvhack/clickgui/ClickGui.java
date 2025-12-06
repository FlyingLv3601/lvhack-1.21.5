package com.lvhack.clickgui;

import com.lvhack.utils.RenderEngineUtil;
import net.minecraft.client.gui.DrawContext;

import com.lvhack.modules.Modules;

public class ClickGui {

    public static void ClickGuiRender(DrawContext context) {
        categoryDraw(context);
        combatModules(context);
        movementModules(context);
        renderModules(context);
        miscModules(context);
    }

    private static final String[] categories = {
            "Combat", "Movement", "render", "misc"
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

    public static void combatModules(DrawContext context){
        int x = 20;
        int y = 40;
        int width = 100;
        int height = 20;
        for(int i = 0; i < Modules.combat.length; i++) {
            int drawY = y + i * height;
            RenderEngineUtil.moduleDraw(context, Modules.combat[i], x, drawY, width, height);
        }
    }
    public static void movementModules(DrawContext context){
        int x = 125;
        int y = 40;
        int width = 100;
        int height = 20;
        for(int i = 0; i < Modules.Movements.length; i++) {
            int drawY = y + i * height;
            RenderEngineUtil.moduleDraw(context, Modules.Movements[i], x, drawY, width, height);
        }
    }
    public static void renderModules(DrawContext context){
        int x = 230;
        int y = 40;
        int width = 100;
        int height = 20;
        for(int i = 0; i < Modules.Render.length; i++) {
            int drawY = y + i * height;
            RenderEngineUtil.moduleDraw(context, Modules.Render[i], x, drawY, width, height);
        }
    }
    public static void miscModules(DrawContext context){
        int x = 335;
        int y = 40;
        int width = 100;
        int height = 20;
        for(int i = 0; i < Modules.misc.length; i++) {
            int drawY = y + i * height;
            RenderEngineUtil.moduleDraw(context, Modules.misc[i], x, drawY, width, height);
        }
    }


}

