package dev.matthiesen.cobblemon_torchmaster_fix.fabric;

import dev.matthiesen.cobblemon_torchmaster_fix.common.CobblemonTorchMasterFixCommon;
import net.fabricmc.api.ModInitializer;

public class CobblemonTorchMasterFixFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        var instance = CobblemonTorchMasterFixCommon.INSTANCE;
        instance.createInfoLog("Loading for Fabric Mod Loader");
        instance.initialize();
    }
}
