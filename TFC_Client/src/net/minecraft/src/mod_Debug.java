package net.minecraft.src;

import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.src.TFC_Core.*;
import net.minecraft.src.TFC_Game.*;
import net.minecraft.src.TFC_Mining.*;
import net.minecraft.src.forge.*;

public class mod_Debug extends NetworkMod
{
	private KeyBinding Key_Rain = new KeyBinding("Key_Rain", 103);
	private KeyBinding Key_Creative = new KeyBinding("Key_Creative", 104);

	@Override
	public void keyboardEvent(KeyBinding var1) 
	{
		Minecraft minecraft = ModLoader.getMinecraftInstance();
		if (var1 == this.Key_Rain)
		{
			if(!minecraft.theWorld.isRaining())
				minecraft.theWorld.worldInfo.setRaining(true);//setRainStrength(1.7F);    
			else
				minecraft.theWorld.worldInfo.setRaining(false);
		}
		else if (var1 == this.Key_Creative)
		{
			if(minecraft.theWorld.worldInfo.getGameType() == 0)
			{
				NBTTagCompound nbt = minecraft.theWorld.worldInfo.getNBTTagCompound();
				nbt.setInteger("GameType", 1);
				minecraft.theWorld.worldInfo = new WorldInfo(nbt);
				minecraft.playerController = new PlayerControllerCreative(minecraft);
				minecraft.thePlayer.capabilities.isCreativeMode = true;
				minecraft.thePlayer.capabilities.allowFlying = true;
			}
			else if(minecraft.theWorld.worldInfo.getGameType() == 1)
			{
				NBTTagCompound nbt = minecraft.theWorld.worldInfo.getNBTTagCompound();
				nbt.setInteger("GameType", 0);
				minecraft.theWorld.worldInfo = new WorldInfo(nbt);
				minecraft.playerController = new PlayerControllerSP(minecraft);
				minecraft.thePlayer.capabilities.isCreativeMode = false;
				minecraft.thePlayer.capabilities.allowFlying = false;
				minecraft.thePlayer.capabilities.isFlying = false;
			}
		}

	}

	@Override
	public boolean clientSideRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean serverSideRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVersion() 
	{
		return "1";
	}

	@Override
	public void load() 
	{
		ModLoader.registerKey(this, this.Key_Rain, false);
		ModLoader.registerKey(this, this.Key_Creative, false);
		ModLoader.addLocalization("Key_Rain", "Toggle Rain");
		ModLoader.addLocalization("Key_Creative", "Toggle Creative");
		ModLoader.setInGameHook(this, true, false);


	}

}
