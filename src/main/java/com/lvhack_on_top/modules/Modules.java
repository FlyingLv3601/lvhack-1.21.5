/*
code by LV3601
блять вам буду кто спиздит пизды дам ебаный рот я пока понял как эту поебатню написать помер 3 раза сука
 */

package com.lvhack_on_top.modules;

import net.minecraft.client.MinecraftClient;

public abstract class Modules {
    public MinecraftClient mc =  MinecraftClient.getInstance();
    private final String name;
    private final Category category;
    private boolean enabled = false;

    public Modules(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (enabled){onEnable();}
        else{onDisable();}
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}

    public String getName() {
        return name;
    }

    public Category getCat() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
