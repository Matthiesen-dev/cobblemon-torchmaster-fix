package dev.matthiesen.cobblemon_torchmaster_fix.common;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.matthiesen.common.matthiesen_lib_api.abstracts.AbstractCommonMod;
import dev.matthiesen.common.matthiesen_lib_api.core.interfaces.MatthiesenLibServerEventHandler;
import dev.matthiesen.libs.faststats.Token;
import kotlin.Unit;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.MobSpawnType;
import net.xalcon.torchmaster.events.EventResult;
import net.xalcon.torchmaster.events.EventResultContainer;
import net.xalcon.torchmaster.events.TorchmasterEventHandler;
import org.jetbrains.annotations.Nullable;

public class CobblemonTorchMasterFixCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_torchmaster_fix";
    public static final String MOD_NAME = "Cobblemon TorchMaster Fix";
    public static @Token final String METRICS_TOKEN = "7983d999278f74aa2b63c425bad05530";

    public static final CobblemonTorchMasterFixCommon INSTANCE = new CobblemonTorchMasterFixCommon();

    private boolean eventsListening;

    public boolean getEventsListening() {
        return eventsListening;
    }

    public void setEventsListening(boolean value) {
        this.eventsListening = value;
    }

    public CobblemonTorchMasterFixCommon() {
        super(MOD_ID, MOD_NAME);
    }

    public void initialize() {
        super.initialize();
        registerServerEventHandler(getServerEventHandler());
        createInfoLog("Initialized");
    }

    @Override
    public @Nullable @Token String getMetricsToken() {
        return METRICS_TOKEN;
    }

    @Override
    public Runnable reload() {
        return null;
    }

    public MatthiesenLibServerEventHandler getServerEventHandler() {
        return new MatthiesenLibServerEventHandler() {
            @Override
            public void onServerStart(MinecraftServer server) {
                createInfoLog("Server started, setting up");
                if (CobblemonTorchMasterFixCommon.INSTANCE.getEventsListening()) return;
                CobblemonTorchMasterFixCommon.INSTANCE.setEventsListening(true);
                CobblemonEvents.POKEMON_ENTITY_SPAWN.subscribe(Priority.LOWEST, (event) -> {
                    PokemonEntity pokemonEntity = event.getEntity();
                    if (!pokemonEntity.getPokemon().isWild()) return Unit.INSTANCE;

                    var spawnedPos = pokemonEntity.position();

                    EventResultContainer eventResultContainer = new EventResultContainer(EventResult.DEFAULT);
                    TorchmasterEventHandler.onCheckSpawn(MobSpawnType.NATURAL, pokemonEntity, spawnedPos, eventResultContainer);

                    if (eventResultContainer.getResult() == EventResult.DENY) event.cancel();

                    return Unit.INSTANCE;
                });
            }
        };
    }
}
