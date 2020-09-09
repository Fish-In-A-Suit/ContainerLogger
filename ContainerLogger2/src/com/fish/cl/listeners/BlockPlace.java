package com.fish.cl.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.fish.cl.main.Constants;

public class BlockPlace implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Block b = e.getBlock();
		Material bMat = b.getType();
		
		boolean isContainer = false;
		for(Material mat : Constants.containerBlocks) {
			if(bMat == mat) {
				isContainer = true;
				break;
			}
		}
		
		if(isContainer) {
			Constants.clFile.addContainerLocation(b.getWorld().getName(),b.getX(), b.getZ());
		}
	}

}
