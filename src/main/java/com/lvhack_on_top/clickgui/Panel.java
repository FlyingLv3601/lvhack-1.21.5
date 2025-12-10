package com.lvhack_on_top.clickgui;

import com.lvhack_on_top.modules.Category;
import com.lvhack_on_top.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class Panel {
    float x, y;
    float width = 100;
    float height = 200;
    boolean dragging = false;
    float dragX, dragY;
    Category category;

    private final List<ModuleButton> buttons = new ArrayList<>();
    public Panel(Category category, float X, float Y, List<Modules> allModules) {
        this.category = category;
        this.x = X;
        this.y = Y;
        for (Modules m : allModules) {
            if (m.getCat() == category) {
                buttons.add(new ModuleButton(m));
            }
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        MinecraftClient mc = MinecraftClient.getInstance();

        context.fill((int) x, (int) y, (int) (x + width), (int) (y + height), 0xFF1f1432 );
        context.fill((int) x, (int) y, (int) (x + width), (int) (y + 16), 0xFF4f3075 );
        context.drawCenteredTextWithShadow(mc.textRenderer, category.name(), (int) (x + width / 2), (int) y + 4, 0xFFFFFFFF );

        int btnY = (int) (y + 16);
        for (ModuleButton btn : buttons) {
            btn.render(context, (int) x + 2, btnY);
            btnY += 14;
        }
    }

    public boolean mouseClicked(int mx, int my, int button) {
        if (mx >= x && mx <= x + width && my >= y && my <= y + 16) {
            dragging = true;
            dragX = mx - x;
            dragY = my - y;
            return true;
        }

        int btnY = (int) (y + 16);
        for (ModuleButton btn : buttons) {
            if (mx >= x && mx <= x + width && my >= btnY && my <= btnY + 12) { // 12 = высота кнопки
                btn.onClick(button);
                return true;
            }
            btnY += 14;
        }

        return false;
    }

    public void mouseReleased(int mx, int my, int button) {
        dragging = false;
    }

    public void mouseDragged(int mx, int my) {
        if (dragging) {
            x = mx - dragX;
            y = my - dragY;
        }
    }
}
