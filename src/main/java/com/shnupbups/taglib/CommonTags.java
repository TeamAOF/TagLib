package com.shnupbups.taglib;

import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class CommonTags implements TagNamespace {
	public static final CommonTags INSTANCE = new CommonTags();
	
	public static final Tag<Block> AIR = INSTANCE.getBlockTag("air");
	public static final Tag<Block> BEACON_PYRAMID = INSTANCE.getBlockTag("beacon_pyramid");
	public static final Tag<Block> CLIMBABLE = INSTANCE.getBlockTag("climbable");
	public static final Tag<Block> COBBLESTONE = INSTANCE.getBlockTag("cobblestone");
	public static final Tag<Block> COMMAND_BLOCKS = INSTANCE.getBlockTag("command_blocks");
	public static final Tag<Block> CONCRETE = INSTANCE.getBlockTag("concrete");
	public static final Tag<Block> CONRETE_POWDERS = INSTANCE.getBlockTag("concrete_powders");
	public static final Tag<Block> CORAL_FANS = INSTANCE.getBlockTag("coral_fans");
	public static final Tag<Block> DEAD_CORAL_BLOCKS = INSTANCE.getBlockTag("dead_coal_blocks");
	public static final Tag<Block> DEAD_CORAL_FANS = INSTANCE.getBlockTag("dead_coral_fans");
	public static final Tag<Block> DEAD_CORAL_PLANTS = INSTANCE.getBlockTag("dead_coral_plants");
	public static final Tag<Block> DEAD_CORALS = INSTANCE.getBlockTag("dead_corals");
	public static final Tag<Block> DEAD_FLOOR_CORAL_FANS = INSTANCE.getBlockTag("dead_floor_coral_fans");
	public static final Tag<Block> DEAD_WALL_CORAL_FANS = INSTANCE.getBlockTag("dead_wall_coral_fans");
	public static final Tag<Block> END_ORES = INSTANCE.getBlockTag("end_ores");
	public static final Tag<Block> ETERNALLY_FLAMMABLE = INSTANCE.getBlockTag("eternally_flammable");
	
	@Override
	public String getNamespace() {
		return "c";
	}
	
	private CommonTags() {}
}
