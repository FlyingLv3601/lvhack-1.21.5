package com.lvhack_on_top.modules.Client;

import com.lvhack_on_top.modules.Category;
import com.lvhack_on_top.modules.Modules;

public class HudModule extends Modules {
    public HudModule() {
        super("Hud", Category.CLIENT);

        this.enabledOnStart = true;
    }

    @Override
    public void onEnable() {
        //renderhud
    }
}
