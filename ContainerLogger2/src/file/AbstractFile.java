package file;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import main.ContainerLogger;

public class AbstractFile {
	protected ContainerLogger plugin;
	protected File file;
	protected FileConfiguration config;
	
	public AbstractFile(ContainerLogger cl, String fileName) {
		plugin = cl;
		this.file = new File(plugin.getDataFolder(), fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
