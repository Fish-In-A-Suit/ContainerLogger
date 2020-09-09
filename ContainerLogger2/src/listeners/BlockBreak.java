package listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import main.Constants;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
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
			Constants.clFile.removeContainerLocation(b.getWorld().getName(),b.getX(), b.getZ());
		}
	}
}
