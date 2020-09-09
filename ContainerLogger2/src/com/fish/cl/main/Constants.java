package com.fish.cl.main;

import org.bukkit.Material;

import com.fish.cl.file.ContainerLocationsFile;

public class Constants {
	
	public static Material[] containerBlocks;
	public static ContainerLocationsFile clFile;

	
	public static void init(ContainerLogger plugin) {
		containerBlocks = new Material[]{
				Material.CHEST,
				Material.TRAPPED_CHEST,
				Material.FURNACE,
				Material.DISPENSER,
				Material.DROPPER,
				Material.HOPPER,
				Material.CHEST_MINECART,
				Material.HOPPER_MINECART,
				Material.FURNACE_MINECART,
				Material.SHULKER_BOX,
		};
		
		clFile = new ContainerLocationsFile(plugin);
	}

}
