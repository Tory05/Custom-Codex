package net.darkhax.ccodex.util;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static String general = "General Mod Settings";
	
	public static String bookName;
	public static String bookAuthor;
	public static String pageText;

	public static void createConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		bookName = config.get(general, "Name of book to give player", "Custom Codex").getString();
		bookAuthor = config.get(general, "Author of book given to player", "Darkhax").getString();
		pageText = config.get(general, "Text of pages in book", "Thanks for using the Custom Codex Mod").getString();

		config.save();
	}
}