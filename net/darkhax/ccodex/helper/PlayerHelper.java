package net.darkhax.ccodex.helper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.ccodex.util.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerHelper {
	
	public static void givePlayerBook(EntityPlayer player) {
		
		if (!hasHadBook(player)) {
			
			if (player.inventory.getFirstEmptyStack() != -1){
				
				BookHelper.setBookInfo(Config.bookAuthor, Config.bookName, Config.page1, Config.page2, Config.page3, Config.page4, Config.page5);
				player.inventory.addItemStackToInventory(BookHelper.book);
			}
			
			else {
				
				sendChatToPlayer("<Custom Codex>: Warning your inventory is full and you can not recieve the custom codex");
			}
		}
	}
	
	public static boolean hasHadBook(EntityPlayer player) {
		
		boolean hasBook = false;
		if (player != null && player.getEntityData().hasKey("hasBook")) {
			
			if (player.getEntityData().getBoolean("hasBook") == true) {
				hasBook = true;
			}
		}
		
		return hasBook;
	}
	
	@SideOnly(Side.CLIENT)
	public static void sendChatToPlayer(String message) {
		FMLClientHandler.instance().getClient().thePlayer.sendChatMessage(message);
	}
}
