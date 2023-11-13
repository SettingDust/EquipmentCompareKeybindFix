package settingdust.equipmentcomparekeybindfix.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeyBinding.class, priority = 1500)
public class MixinKeyBinding {
    @TargetHandler(mixin = "com.anthonyhilyard.equipmentcompare.mixin.KeyMappingMixin", name = "resetMapping")
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "HEAD"), cancellable = true)
    private static void avoidLogic(CallbackInfo original, CallbackInfo ci) {
        ci.cancel();
    }
}
