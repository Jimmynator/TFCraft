package net.minecraft.src;

public class BiomeGenRiverTFC extends BiomeGenBase
{
	public BiomeGenRiverTFC(int i)
	{
		super(i);
		spawnableCreatureList.clear();
		((BiomeDecoratorTFC)this.biomeDecorator).looseRocksPerChunk = 4;
		((BiomeDecoratorTFC)this.biomeDecorator).looseRocksChancePerChunk = 90;
	}
}
