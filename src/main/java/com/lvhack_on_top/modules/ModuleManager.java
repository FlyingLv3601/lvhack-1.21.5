package com.lvhack_on_top.modules;

import com.lvhack_on_top.modules.Client.ColorModules;
import com.lvhack_on_top.modules.Client.HudModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final List<Modules> modules = new ArrayList<>();

    public static void addModule(Modules module) {
        modules.add(module);
    }

    public static void init() {
        addModule(new ColorModules());
        addModule(new HudModule());

        for (Modules module : modules) {
            if (module.isEnabledOnStart()) {
                module.setEnabled(true);
                module.onEnable();
            }
        }
    }

    public static List<Modules> getModules() {
        return modules;
    }

    public static List<Modules> getModulesByCategory(Category category) {
        List<Modules> catModules = new ArrayList<>();
        for (Modules module : modules) {
            if (module.getCat() == category) {
                catModules.add(module);
            }
        }
        return catModules;
    }
}
