package net.minecraft.src.TFC_Core;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import net.minecraft.src.*;

public class GuiTerraLogPile extends GuiContainerTFC
{
    public GuiTerraLogPile(InventoryPlayer inventoryplayer, TileEntityTerraLogPile wb, World world, int i, int j, int k)
    {
        super(new ContainerTerraLogPile(inventoryplayer, wb,world, i, j, k));
    }

    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer()
    {
    	drawCenteredString(fontRenderer,"Log Pile", 87, 6, 0x000000);
        //fontRenderer.drawString("Log Pile", 28, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture("/bioxx/logpilegui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
    }
    
    public void drawCenteredString(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.drawString(s, i - fontrenderer.getStringWidth(s) / 2, j, k);
    }
}
