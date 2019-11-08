package com.shnupbups.taglib;

import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class FunctionalTags implements TagNamespace {
	public static final FunctionalTags INSTANCE = new FunctionalTags();
	
	public static final Tag<Block> CLIMBABLE = INSTANCE.getBlockTag("climbable");
	
	@Override
	public String getNamespace() {
		return "taglib";
	}
	
	private FunctionalTags() {}
}
