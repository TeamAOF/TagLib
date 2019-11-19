package com.shnupbups.taglib;

import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class FunctionalTags implements TagNamespace {
	public static final FunctionalTags INSTANCE = new FunctionalTags();
	
	public static final Tag<Block> CLIMBABLE = INSTANCE.getBlockTag("climbable");
	public static final Tag<Block> ETERNALLY_FLAMMABLE = INSTANCE.getBlockTag("eternally_flammable");
	
	@Override
	public String getNamespace() {
		return "taglib";
	}
	
	private FunctionalTags() {}
}
