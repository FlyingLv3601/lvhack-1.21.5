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
        int color = module.isEnabled() ? 0xFF00FF00 : 0xFF404040;
        context.fill(x, y, x + 96, y + 12, color);
        context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, module.getName(), x + 4, y + 2, 0xFFFFFFFF);
    }

    public void onClick(int button) {
        if (button == 0) {
            module.toggle();
        }
    }
}