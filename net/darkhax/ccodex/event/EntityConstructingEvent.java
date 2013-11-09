package net.darkhax.ccodex.event;

import net.darkhax.ccodex.helper.ExtendedPlayerProperties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class EntityConstructingEvent {
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event) {

		if (event.entity instanceof EntityPlayer && ExtendedPlayerProperties.get((EntityPlayer) event.entity) == null) {
			
			ExtendedPlayerProperties.register((EntityPlayer) event.entity);
		}

		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME) == null) {
			
			event.entity.registerExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME, new ExtendedPlayerProperties((EntityPlayer) event.entity));
		}
	}
}