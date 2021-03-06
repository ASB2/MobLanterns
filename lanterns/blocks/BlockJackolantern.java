package lanterns.blocks;

import java.util.List;

import lanterns.Lanterns;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockJackolantern extends BlockDirectional{

	public BlockJackolantern(int id, Material material) {
		super(id, material.pumpkin);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightValue(1F);
		this.setUnlocalizedName(BlockIds.JACKOLANTERN_UNLOCALIZED_NAME);
		
	}
	
	
	//icon junk
	@SideOnly(Side.CLIENT)
    private Icon topIcon;
    @SideOnly(Side.CLIENT)
    private Icon faceIcon;
    @SideOnly(Side.CLIENT)
    private Icon blockIcon;
    @SideOnly(Side.CLIENT)
    
    
    @Override
    public void registerIcons(IconRegister register){
    	 topIcon = register.registerIcon(BlockIds.TEXTURE_LOCATION + ":" + BlockIds.JACOLANTERNTOP);
         faceIcon = register.registerIcon(BlockIds.TEXTURE_LOCATION + ":" + BlockIds.JACKOLANTERNFRONT);
         blockIcon = register.registerIcon(BlockIds.TEXTURE_LOCATION + ":" + BlockIds.JACKOLANTERNSIDE);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int metadata)
    {
      if (side == 1) return this.topIcon;
      else if (side == 0) return this.topIcon;
      else if (metadata == 2 && side == 2) return this.faceIcon;
      else if (metadata == 3 && side == 5) return this.faceIcon;
      else if (metadata == 0 && side == 3) return this.faceIcon;
      else if (metadata == 1 && side == 4) return this.faceIcon;
      else return this.blockIcon;
    }
    
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int whichDirectionFacing = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }
   
}