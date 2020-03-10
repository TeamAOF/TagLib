package com.shnupbups.taglib;

import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class FunctionalTags implements TagNamespace {
	public static final FunctionalTags INSTANCE = new FunctionalTags();
	
	public static final Tag<Block> ETERNALLY_FLAMMABLE = INSTANCE.getBlockTag("eternally_flammable");
	public static final Tag<Block> SUPPORTS_SOUL_FIRE = INSTANCE.getBlockTag("supports_soul_fire");
	public static final Tag<Block> SUPPORTS_TURTLE_EGGS = INSTANCE.getBlockTag("supports_soul_fire");
	
	@Override
	public String getNamespace() {
		return "taglib";
	}
	
	private FunctionalTags() {}
}
