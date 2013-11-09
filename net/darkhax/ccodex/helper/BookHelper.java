package net.darkhax.ccodex.helper;

import java.util.HashMap;
import java.util.Map;

import net.darkhax.ccodex.util.Config;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class BookHelper {

	public static ItemStack book = new ItemStack(Item.writtenBook);
	
	public static NBTTagList bookPages = new NBTTagList("pages");
	
	/**
	 * @param author: Author for the book.
	 * @param name: Display name for the book.
	 * @param content: Content for the pages of the books.
	 */
	public static void setBookInfo(String author, String name, String page1, String page2, String page3, String page4, String page5) {
		
		if (!book.hasTagCompound()) {
			
			book.setTagCompound(new NBTTagCompound());
		}	
		
		checkContent("1", page1);
		checkContent("2", page2);
		checkContent("3", page3);
		checkContent("4", page4);
		checkContent("5", page5);
		book.stackTagCompound.setString("author", author);
		book.stackTagCompound.setString("title", name);	
		book.stackTagCompound.setTag("pages", bookPages);
	}	
	
	/**
	 * @param tag: Tag to look up. author title and pages.
	 * @return: String output equal to that stacks tag.
	 */
	public static String getBookInfo(String tag) {
		
		String output;
		output = book.stackTagCompound.getString(tag);
		return output;	
	}
	
	public static void checkContent(String page, String content) {
		
		if (content != null && content != "") {
			bookPages.appendTag(new NBTTagString(page, content));
		}
	}
}
