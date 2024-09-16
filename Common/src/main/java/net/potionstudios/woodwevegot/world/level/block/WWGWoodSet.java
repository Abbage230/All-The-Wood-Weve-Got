package net.potionstudios.woodwevegot.world.level.block;

import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWoodSet;

import java.util.ArrayList;
import java.util.function.Supplier;

public class WWGWoodSet {

	private static final ArrayList<WWGWoodSet> woodSets = new ArrayList<>();

	private final Supplier<BWGWoodSet> woodSet;
	private final Supplier<BarrelBlock> barrel;
	private final Supplier<LadderBlock> ladder;
	private final Supplier<ChestBlock> chest;

	public WWGWoodSet(Supplier<BWGWoodSet> woodSet) {
		this.woodSet = woodSet;
		this.barrel = WWGBlocks.registerBlockItem(woodSet.get().name() + "_barrel", WWGBarrelBlock::new, 300);
		this.ladder = WWGBlocks.registerBlockItem(woodSet.get().name() + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)), 300);
		this.chest = WWGBlocks.registerBlockItem(woodSet.get().name() + "_chest", WWGChestBlock::new, 300);
		woodSets.add(this);
	}

	public BWGWoodSet getWoodSet() {
		return woodSet.get();
	}

	public BarrelBlock barrel() {
		return barrel.get();
	}

	public LadderBlock ladder() {
		return ladder.get();
	}

	public ChestBlock chest() {
		return chest.get();
	}

	public String name() {
		return woodSet.get().name();
	}

	public static ArrayList<WWGWoodSet> getWoodSets() {
		return woodSets;
	}
}
