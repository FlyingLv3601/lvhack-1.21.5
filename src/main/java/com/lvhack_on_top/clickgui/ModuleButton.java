package com.lvhack_on_top.clickgui;

import com.lvhack_on_top.modules.Modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ModuleButton {
    private final Modules module;

    public ModuleButton(Modules module) {
        this.module = module;
    }

    public void render(DrawContext context, int x, int y) {
        int color = module.isEnabled() ? 0xFF311456 : 0xFF1f1432 ;
        context.fill(x, y, x + 100, y + 20, color);


        int textColor = module.isEnabled() ? 0xFFE884E8 : 0xFF8f54c4;
        context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, module.getName(), x + 4, y + 6, textColor);

    }

    public void onClick(int button) {
        if (button == 0) {
            module.toggle();
        }
    }
}