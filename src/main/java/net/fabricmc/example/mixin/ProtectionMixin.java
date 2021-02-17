package net.fabricmc.example.mixin;

import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public class ProtectionMixin {
    @Inject(method = "getMaxLevel", at = @At("RETURN"), cancellable = true)
    private void init(CallbackInfoReturnable<Integer> level) {
        System.out.println("getMaxLevel Enchants");
        level.setReturnValue(5);
    }
}
