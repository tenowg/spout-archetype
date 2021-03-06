#**
 This file is part of the Spout Plugin Archetype. If you have found this useful
 or would like to offer suggestions, please contact me.

 @author Craig <tenowg@thedemgel.com>
 @author Atheriel
*###
#if (${includeHeaders} == "true" || ${includeHeaders} == "yes" || ${includeHeaders} == "y")
#parse("HEADER.txt")
#end
package ${package}.configuration;

import java.io.File;
import java.util.logging.Level;

import org.spout.cereal.config.ConfigurationException;
import org.spout.cereal.config.ConfigurationHolder;
import org.spout.cereal.config.ConfigurationHolderConfiguration;
import org.spout.cereal.config.yaml.YamlConfiguration;

import ${package}.${pluginName}Plugin;

/**
 * Provides an example of a class that has a configuration file.
 */
public class ${pluginName}Configuration extends ConfigurationHolderConfiguration {

	// Messages
	public static final ConfigurationHolder SOME_SETTING = new ConfigurationHolder("SomeSetting", "some", "setting");

	public ${pluginName}Configuration(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}

	@Override
	public void load() {
		try {
			super.load();
			super.save();
		} catch (ConfigurationException e) {
			${pluginName}Plugin.getInstance().getLogger().log(Level.WARNING, "Error loading ${pluginName} configuration: ", e);
		}
	}

	@Override
	public void save() {
		try {
			super.save();
		} catch (ConfigurationException e) {
			${pluginName}Plugin.getInstance().getLogger().log(Level.WARNING, "Error saving ${pluginName} configuration: ", e);
		}
	}
}
