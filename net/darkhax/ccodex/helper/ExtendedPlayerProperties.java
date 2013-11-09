package net.darkhax.ccodex.helper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "ExtendedPlayer";

	private final EntityPlayer player;

	private boolean haBook;

	public ExtendedPlayerProperties(EntityPlayer player) {

		this.player = player;
		this.haBook = false;
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME, new ExtendedPlayerProperties(player));
	}

	public static final ExtendedPlayerProperties get(EntityPlayer player) {
		return (ExtendedPlayerProperties) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setBoolean("hasBook", this.haBook);

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		this.haBook = properties.getBoolean("hasBook");
	}

	@Override
	public void init(Entity entity, World world) {
	}
	
	public void setTrue() {
		
		this.haBook = true;
	}
	
	public void setFalse() {
		
		this.haBook = false;
	}
	
	public boolean hasBook() {
		
		return this.haBook;
	}
}