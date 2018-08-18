package org.burgersim.pgeg.block;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockModOre extends BlockOre {
    private IItemProvider drop;
    private int xpMin;
    private int xpMax;

    public BlockModOre(Builder builder, IItemProvider drop, int xpMin, int xpMax) {
        super(builder);
        this.drop = drop;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }


    public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
        return drop;
    }

    @Override
    public void spawnItems(IBlockState state, World world, BlockPos blockPos, float p_spawnItems_4_, int p_spawnItems_5_) {
        super.spawnItems(state, world, blockPos, p_spawnItems_4_, p_spawnItems_5_);
        int xp = MathHelper.getInt(world.rand, xpMin, xpMax);
        this.dropXpOnBlockBreak(world, blockPos, xp);
    }
}
