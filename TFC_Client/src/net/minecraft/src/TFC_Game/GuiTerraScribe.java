package net.minecraft.src.TFC_Game;

import net.minecraft.src.*;
import net.minecraft.src.TFC_Core.GuiContainerTFC;
import net.minecraft.src.TFC_Game.*;

import org.lwjgl.opengl.GL11;


public class GuiTerraScribe extends GuiContainerTFC
{
	private TileEntityTerraScribe FirepitEntity;


	public GuiTerraScribe(InventoryPlayer inventoryplayer, TileEntityTerraScribe tileentityfirepit, World world)
	{
		super(new ContainerTerraScribe(inventoryplayer,tileentityfirepit,world) );
		FirepitEntity = tileentityfirepit;
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int r = mc.renderEngine.getTexture("/bioxx/scribegui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
        mc.renderEngine.bindTexture(r);
        int w = (width - 176) / 2;
        int h = (height - 184) / 2;
        drawTexturedModalRect(w, h, 0, 0, 175, 183);
//        if(sluiceInventory.waterInput && sluiceInventory.waterOutput)
//        {
//            int l = 12;//sluiceInventory.getProcessScaled(12); 
//            drawTexturedModalRect(s + 62, (t + 36 + 12) - l, 176, 12 - l, 14, l + 2);
//        }
//        int i1 = sluiceInventory.getProcessScaled(24);
//       drawTexturedModalRect(s + 79, t + 34, 176, 14, i1+1, 16);
        int i1;// = FirepitEntity.getMaterialScaled(50);
        //(guiX,guiY,sourceMinX,sourceMinY,sourceMaxX,sourceMaxY
        //drawTexturedModalRect(w + 34, h + 16 + i1, 176, 31+i1, 9, 50);
        //i1 = FirepitEntity.getTemperatureScaled(49);
        //drawTexturedModalRect(w + 125, h + 63 - i1, 185, 31, 15, 6);
		
	}
	
	protected void drawGuiContainerForegroundLayer()
    {        

    }
	
	public void drawCenteredString(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.drawString(s, i - fontrenderer.getStringWidth(s) / 2, j, k);
    }


}
