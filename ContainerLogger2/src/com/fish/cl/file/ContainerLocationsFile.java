package com.fish.cl.file;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import com.fish.cl.main.ContainerLogger;

public class ContainerLocationsFile extends AbstractFile {

	public ContainerLocationsFile(ContainerLogger cl) {
		super(cl,"containerLocations.yml");
	}
	
	/**
	 * Adds a container location to the specific world node
	 * @param worldName
	 * @param x
	 * @param z
	 */
	public void addContainerLocation(String worldName, int x, int z) {
		Bukkit.getLogger().info("Adding container location: " + worldName + " | " + x + ", " + z);
		
		ConfigurationSection worldSection = config.getConfigurationSection(worldName);
		if(worldSection == null) {
			worldSection = config.createSection(worldName);
		}
		
		/*
		 * check if the node already exists
		 *   a) yes: edit
		 *   b) no: add
		 */
		
		String id = ""  + x + "," + z;
		boolean locationExists = false;
		for(String location : worldSection.getKeys(false)) {
			if(location.equals(id)) {
				locationExists = true;
				worldSection.set(id, worldSection.getInt(location) + 1);
				break;
			}
		}
		
		if(!locationExists) {
			worldSection.set(id, 1);
		}
	}
	
	public void removeContainerLocation(String worldName, int x, int z) {
		Bukkit.getLogger().info("Removing container location: " + worldName + " | " + x + ", " + z);
		
		ConfigurationSection worldSection = config.getConfigurationSection(worldName);
		if(worldSection == null) {
			Bukkit.getLogger().info("No worldSection on container break event. Natural container or error.");
			worldSection = config.createSection(worldName);
		}
		
		/*
		 * check if the node already exists
		 *   a) yes: edit
		 *   b) no: add
		 */
		
		String id = ""  + x + "," + z;
		boolean locationExists = false;
		for(String location : worldSection.getKeys(false)) {
			if(location.equals(id)) {
				locationExists = true;
				worldSection.set(id, worldSection.getInt(location) - 1);
				break;
			}
		}
		
		if(!locationExists) {
			//worldSection.set(id, 1);
			Bukkit.getLogger().info("Location for container break event doesnt exist. Either natural container or error.");
		}
	}

}
