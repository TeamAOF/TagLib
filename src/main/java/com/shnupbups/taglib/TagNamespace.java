package com.shnupbups.taglib;

import net.fabricmc.fabric.api.tag.TagRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public interface TagNamespace {
	String getNamespace();
	
	default Identifier id(String name) {
		return new Identifier(getNamespace(), name);
	}
	
	default Tag<Block> getBlockTag(String name) {
		return TagRegistry.block(id(name));
	}
	
	default Tag<Item> getItemTag(String name) {
		return TagRegistry.item(id(name));
	}
	
	default Tag<Fluid> getFluidTag(String name) {
		return TagRegistry.fluid(id(name));
	}
	
	default Tag<EntityType<?>> getEntityTypeTag(String name) {
		return TagRegistry.entityType(id(name));
	}
}
