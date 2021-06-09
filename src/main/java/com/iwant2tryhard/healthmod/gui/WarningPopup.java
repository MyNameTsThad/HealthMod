package com.iwant2tryhard.healthmod.gui;

import com.iwant2tryhard.healthmod.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.Sys;

public class WarningPopup extends Gui
{
    public float displayPercent = 50;
    public float warnPercent = 25;
    public float criticalPercent = 12.5f;
    public boolean showImage = true;
    public boolean showVignette = true;

    private final ResourceLocation tex = new ResourceLocation(Reference.MOD_ID, "textures/maintex.png");
    private final int main_width = 196;
    private final int main_height = 14;

    private final int iconwarn_width = 22;
    private final int iconwarn_height = 26;
    private final int icondisplay_width = 24;
    private final int icondisplay_height = 26;
    private final int iconcritical_width = 22;
    private final int iconcritical_height = 26;


    public int mainposx = Minecraft.getMinecraft().displayWidth / 4 - main_width / 2;
    public int mainposy = Minecraft.getMinecraft().displayHeight / 4 - main_height / 2;
    public int iconposx = mainposx;
    public int iconposy = mainposy + 45;

    //boolean isWaiting;

    @SubscribeEvent
    public void RenderOverlay(RenderGameOverlayEvent event)
    {

        if (event.type == RenderGameOverlayEvent.ElementType.TEXT)
        {
            Minecraft mc = Minecraft.getMinecraft();
            mc.renderEngine.bindTexture(tex);
            float health = mc.thePlayer.getHealth();
            float healthpercent = (mc.thePlayer.getHealth() / mc.thePlayer.getMaxHealth() * 100);

            if (healthpercent < displayPercent && healthpercent >= warnPercent)
            {
                //drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2 + 1, mc.displayHeight / 4 - main_height / 2 + 1, 0, 14, main_width, main_height);
                //drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2, mc.displayHeight / 4 - main_height / 2, 0, 0, main_width, main_height);
                mc.fontRendererObj.drawString("Your health is " + Math.round(healthpercent) + "%", mc.displayWidth / 4 - main_width / 2, mc.displayHeight / 4 - main_height / 2 + main_height - 15, 16160000, true);
                if (showImage)
                {
                    mc.renderEngine.bindTexture(tex);
                    drawTexturedModalRect(mc.displayWidth / 4 - icondisplay_width / 2, mc.displayHeight / 4 - icondisplay_height / 2 + 30, 24, 29, icondisplay_width, icondisplay_height);
                }
            }
            if (healthpercent < warnPercent && healthpercent >= criticalPercent)
            {
                drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2 + 1 - 15, mc.displayHeight / 4 - main_height / 2 + 1 - 15, 0, 14, main_width, main_height);
                drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2 - 15, mc.displayHeight / 4 - main_height / 2 - 15, 0, 0, main_width, main_height);
                mc.fontRendererObj.drawString("Your health is " + Math.round(healthpercent) + "%", mc.displayWidth / 4 - main_width / 2- 15, mc.displayHeight / 4 - main_height / 2 + main_height - 15, 16160000, true);
                if (showImage)
                {
                    mc.renderEngine.bindTexture(tex);
                    drawTexturedModalRect(mc.displayWidth / 4 - iconwarn_width / 2, mc.displayHeight / 4 - iconwarn_height / 2 + 30, 1, 29, iconwarn_width, iconwarn_height);
                }
                if (showVignette)
                {
                    mc.renderEngine.bindTexture(tex);
                    drawTexturedModalRect(0, 0, 1, 200, 27, 27);
                    drawTexturedModalRect(mc.displayWidth / 2 - 27, 0, 29, 200, 27, 27);
                    drawTexturedModalRect(0, mc.displayHeight / 2 - 27, 1, 228, 27, 27);
                    drawTexturedModalRect(mc.displayWidth / 2 - 27, mc.displayHeight / 2 - 27, 29, 228, 27, 27);
                }
            }
            if (healthpercent < criticalPercent)
            {
                drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2 + 1 - 15, mc.displayHeight / 4 - main_height / 2 + 1 - 15, 0, 14, main_width, main_height);
                drawTexturedModalRect(mc.displayWidth / 4 - main_width / 2 - 15, mc.displayHeight / 4 - main_height / 2 - 15, 0, 0, main_width, main_height);
                mc.fontRendererObj.drawString("Your health is " + Math.round(healthpercent) + "%", mc.displayWidth / 4 - main_width / 2 - 15, mc.displayHeight / 4 - main_height / 2 + main_height - 15, 16160000, true);
                if (showImage)
                {
                    mc.renderEngine.bindTexture(tex);
                    drawTexturedModalRect(mc.displayWidth / 4 - iconcritical_width / 2, mc.displayHeight / 4 - iconcritical_height / 2 + 30, 49, 29, iconcritical_width, iconcritical_height);
                }
                if (showVignette)
                {
                    mc.renderEngine.bindTexture(tex);
                    drawTexturedModalRect(0, 0, 1, 200, 27, 27);
                    drawTexturedModalRect(mc.displayWidth / 2 - 27, 0, 1, 228, 27, 27);
                    drawTexturedModalRect(0, mc.displayHeight / 2 - 27, 29, 200, 27, 27);
                    drawTexturedModalRect(mc.displayWidth / 2 - 27, mc.displayHeight / 2 - 27, 29, 228, 27, 27);
                }
            }


        }
    }
    /*@SubscribeEvent
    public void DebugChat(RenderGameOverlayEvent event)
    {
        if (event.type == RenderGameOverlayEvent.ElementType.CHAT)
        {
            Minecraft mc = Minecraft.getMinecraft();

        }
    }*/
}
