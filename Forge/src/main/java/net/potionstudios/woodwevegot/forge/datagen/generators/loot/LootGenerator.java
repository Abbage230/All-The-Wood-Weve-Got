package net.potionstudios.woodwevegot.forge.datagen.generators.loot;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;

public class LootGenerator extends LootTableProvider {
    public LootGenerator(PackOutput output) {
        super(output, Collections.emptySet(), ImmutableList.of(
                new SubProviderEntry(BlockLootGenerator::new, LootContextParamSets.BLOCK)
        ));
    }
}
