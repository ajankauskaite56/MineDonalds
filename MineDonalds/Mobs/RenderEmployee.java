package MineDonalds.Mobs;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEmployee extends RenderLiving
{
    private static final ResourceLocation field_110903_f = new ResourceLocation("minedonalds:textures/entity/Employee.png");
    private static final ResourceLocation field_110904_g = new ResourceLocation("minedonalds:textures/entity/Employee.png");
    private static final ResourceLocation field_110908_h = new ResourceLocation("minedonalds:textures/entity/Employee.png");
    private static final ResourceLocation field_110907_k = new ResourceLocation("minedonalds:textures/entity/Employee.png");
    private static final ResourceLocation field_110905_l = new ResourceLocation("minedonalds:textures/entity/Employee.png");
    private static final ResourceLocation field_110906_m = new ResourceLocation("minedonalds:textures/entity/Employee.png");

    /** Model of the villager. */
    protected ModelEmployee villagerModel;

    public RenderEmployee()
    {
        super(new ModelEmployee(0.0F), 0.5F);
        this.villagerModel = (ModelEmployee)this.mainModel;
    }

    /**
     * Determines wether Villager Render pass or not.
     */
    protected int shouldVillagerRenderPass(EntityVillager par1EntityVillager, int par2, float par3)
    {
        return -1;
    }

    public void renderVillager(EntityVillager par1EntityVillager, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityVillager, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110902_a(EntityVillager par1EntityVillager)
    {
        switch (par1EntityVillager.getProfession())
        {
            case 0:
                return field_110904_g;
            case 1:
                return field_110908_h;
            case 2:
                return field_110907_k;
            case 3:
                return field_110905_l;
            case 4:
                return field_110906_m;
            default:
                return VillagerRegistry.getVillagerSkin(par1EntityVillager.getProfession(), field_110903_f);
        }
    }

    protected void renderVillagerEquipedItems(EntityVillager par1EntityVillager, float par2)
    {
        super.renderEquippedItems(par1EntityVillager, par2);
    }

    protected void preRenderVillager(EntityVillager par1EntityVillager, float par2)
    {
        float f1 = 0.9375F;

        if (par1EntityVillager.getGrowingAge() < 0)
        {
            f1 = (float)((double)f1 * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((EntityVillager)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderVillager((EntityVillager)par1EntityLivingBase, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldVillagerRenderPass((EntityVillager)par1EntityLivingBase, par2, par3);
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderVillagerEquipedItems((EntityVillager)par1EntityLivingBase, par2);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((EntityVillager)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110902_a((EntityVillager)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((EntityVillager)par1Entity, par2, par4, par6, par8, par9);
    }

	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minedonalds:textures/entity/Employee.png");
	}
}