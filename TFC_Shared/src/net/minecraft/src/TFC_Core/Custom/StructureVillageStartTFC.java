package net.minecraft.src.TFC_Core.Custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStart;
import net.minecraft.src.*;

public class StructureVillageStartTFC extends StructureStartTFC
{
    /** well ... thats what it does */
    private boolean hasMoreThanTwoComponents = false;

    public StructureVillageStartTFC(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        ArrayList var7 = StructureVillagePiecesTFC.getStructureVillageWeightedPieceList(par2Random, par5);
        ComponentVillageStartPieceTFC var8 = new ComponentVillageStartPieceTFC(par1World.getWorldChunkManager(), 0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2, var7, par5);
        this.components.add(var8);
        var8.buildComponent(var8, this.components, par2Random);
        ArrayList var9 = var8.field_35106_f;
        ArrayList var10 = var8.field_35108_e;
        int var11;

        while (!var9.isEmpty() || !var10.isEmpty())
        {
            StructureComponentTFC var12;

            if (!var9.isEmpty())
            {
                var11 = par2Random.nextInt(var9.size());
                var12 = (StructureComponentTFC)var9.remove(var11);
                var12.buildComponent(var8, this.components, par2Random);
            }
            else
            {
                var11 = par2Random.nextInt(var10.size());
                var12 = (StructureComponentTFC)var10.remove(var11);
                var12.buildComponent(var8, this.components, par2Random);
            }
        }

        this.updateBoundingBox();
        var11 = 0;
        Iterator var14 = this.components.iterator();

        while (var14.hasNext())
        {
            StructureComponentTFC var13 = (StructureComponentTFC)var14.next();

            if (!(var13 instanceof ComponentVillageRoadPieceTFC))
            {
                ++var11;
            }
        }

        this.hasMoreThanTwoComponents = var11 > 2;
    }

    /**
     * currently only defined for Villages, returns true if Village has more than 2 non-road components
     */
    public boolean isSizeableStructure()
    {
        return this.hasMoreThanTwoComponents;
    }
}
