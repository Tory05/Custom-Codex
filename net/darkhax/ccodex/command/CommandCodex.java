package net.darkhax.ccodex.command;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.ccodex.helper.BookHelper;
import net.darkhax.ccodex.util.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandCodex extends CommandBase {

	@Override
    public int getRequiredPermissionLevel() {
		
        return 0;
    }
    
	@Override
	public String getCommandName() {
		return "codex";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] astring) {
		
		if (sender instanceof EntityPlayer) {
			
		    EntityPlayer player = (EntityPlayer)sender;
		    
			if (player.inventory.getFirstEmptyStack() != -1){
				
				BookHelper.setBookInfo(Config.bookAuthor, Config.bookName, Config.page1, Config.page2, Config.page3, Config.page4, Config.page5);
				player.inventory.addItemStackToInventory(BookHelper.book);
			}
			
			else {
				
				sendChatToPlayer("<Custom Codex>: Warning your inventory is full and you can not recieve the custom codex");
			}
		    
		}
	}

	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "commands.codex.usage";
    }
	
	/**
	 * @param message: Simple string to send to the player in chat. 
	 */
	@SideOnly(Side.CLIENT)
	public static void sendChatToPlayer(String message) {
		FMLClientHandler.instance().getClient().thePlayer.sendChatMessage(message);
	}
}