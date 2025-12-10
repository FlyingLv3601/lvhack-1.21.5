package com.lvhack_on_top.clickgui;

import com.lvhack_on_top.modules.Category;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

import static com.lvhack_on_top.modules.ModuleManager.modules;

public class ClickGuiScreen extends Screen {

    private final List<Panel> panels = new ArrayList<>();

    public ClickGuiScreen() {
        super(Text.literal("Click GUI"));
        panels.add(new Panel(Category.COMBAT, 50, 50,modules));
        panels.add(new Panel(Category.MOVEMENT, 200, 50, modules));
        panels.add(new Panel(Category.RENDER, 350, 50, modules));
        panels.add(new Panel(Category.MISC, 500, 50, modules));
        panels.add(new Panel(Category.CLIENT, 650,50, modules));
    }

    @Override
    public void init() {
        super.init();
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawText(this.textRenderer, "Click GUI", 10, 10, 0xFFFFFF, false);
        for(Panel panel : panels) {
            panel.render(context, mouseX, mouseY);
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for(Panel panel : panels) {
            if(panel.mouseClicked((int)mouseX, (int)mouseY, button)) {
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for(Panel panel : panels) {
            panel.mouseReleased((int)mouseX, (int)mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        for(Panel panel : panels) {
            panel.mouseDragged((int)mouseX, (int)mouseY);
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }






}


