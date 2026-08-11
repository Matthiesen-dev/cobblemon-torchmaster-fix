# Cobblemon Torchmaster Fix

<div>
  <img src="https://mods.matthiesen.dev/badges/matthiesenCore.svg" alt="Matthiesen Core">
  <img src="https://mods.matthiesen.dev/badges/cobblemon.svg" alt="Cobblemon">
</div>

This mod adds support for Torchmaster to Cobblemon, allowing Torchmaster's blocks to be used to prevent Cobblemon spawning. This mod is designed
to only work with natural ("wild") Cobblemon spawns, and will not prevent spawns from player-owned Pokemon.

By default, Cobblemon will be added to the Torchmaster's Dreadlamp's block list. You can also add additional overrides using the `torchmaster.toml` config file.

```toml
megaTorchEntityBlockListOverrides = [ "+cobblemon:pokemon"]
```

## Requirements

- [Matthiesen Core](https://modrinth.com/mod/matthiesen-core)
- [Cobblemon](https://modrinth.com/mod/cobblemon)
- [Torchmaster](https://modrinth.com/mod/torchmaster)

## Version Compatibility

| Minecraft Version | Cobblemon Version | Mod Version |
|-------------------|-------------------|-------------|
| 1.21.1            | 1.7.3             | 1.x.x       |

## FastStats Metrics

This mod uses [FastStats](https://faststats.dev) to collect anonymous usage statistics. This helps the developer understand
how this mod is being used and improve it over time. You can learn more about the data collected and how it is used by visiting
[FastStats: Information](https://faststats.dev/info).

You can also view the data collected by this mod on the [FastStats: Cobblemon Torchmaster Fix](https://faststats.dev/project/cobblemon-torchmaster-fix) page.

To opt out of this data collection, set the `enabled` property to `false` in the `<game_directory>/config/matthiesen_core/metrics.properties` file.

## License

MIT - see `LICENSE`.
