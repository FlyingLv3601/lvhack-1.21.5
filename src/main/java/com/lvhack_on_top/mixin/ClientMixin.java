package com.lvhack_on_top.mixin;

import com.lvhack_on_top.modules.ModuleManager;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientMixin{
    @Inject(method = "tick", at= @At("HEAD"))
    private void tick(CallbackInfo info){
        for(var module : ModuleManager.getModules()){
            module.onTick();
        }
    }
}
