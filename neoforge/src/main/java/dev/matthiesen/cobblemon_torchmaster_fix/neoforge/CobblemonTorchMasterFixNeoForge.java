package dev.matthiesen.cobblemon_torchmaster_fix.neoforge;

import dev.matthiesen.cobblemon_torchmaster_fix.common.CobblemonTorchMasterFixCommon;
import net.neoforged.fml.common.Mod;

@Mod(CobblemonTorchMasterFixCommon.MOD_ID)
public final class CobblemonTorchMasterFixNeoForge {
    public CobblemonTorchMasterFixNeoForge() {
        var instance = CobblemonTorchMasterFixCommon.INSTANCE;
        instance.createInfoLog("Loading for NeoForge Mod Loader");
        instance.initialize();
    }
}
