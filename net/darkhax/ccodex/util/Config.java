package net.darkhax.ccodex.util;

import java.awt.List;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static String general = "General Mod Settings";
	
	public static String bookName;
	public static String bookAuthor;
	public static String page1;
	public static String page2;
	public static String page3;
	public static String page4;
	public static String page5;

	public static void createConfig(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		bookName = config.get(general, "Name of book to give player", "Custom Codex").getString();
		bookAuthor = config.get(general, "Author of book given to player", "Darkhax").getString();
		page1 = config.get(general, "Text for the first of the book", "").getString();
		page2 = config.get(general, "Text for the second of the book", "").getString();
		page3 = config.get(general, "Text for the third of the book", "").getString();
		page4 = config.get(general, "Text for the fourth of the book", "").getString();
		page5 = config.get(general, "Text for the fifth of the book", "").getString();
		
		config.save();
	}
}