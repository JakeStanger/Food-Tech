package roboguy99.foodTech.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import roboguy99.foodTech.common.tile.electricity.wire.TileWire;
public class BlockWire extends Block implements ITileEntityProvider
{
    public BlockWire(Material material)
    {
        super(material);
        setBlockBounds(0.3f, 0.3f, 0.3f, 0.7f, 0.7f, 0.7f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileWire();
    }

    @Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block b)
    {
        TileEntity tile = w.getTileEntity(x, y, z);
        if(tile instanceof TileWire)
        {
            
        }
    }
}
