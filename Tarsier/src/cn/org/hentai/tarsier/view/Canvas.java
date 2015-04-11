package cn.org.hentai.tarsier.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Canvas extends javax.swing.JComponent
{
	@Override
	protected void paintComponent(Graphics g)
	{
		try
		{
			UIFlowLayout div = new UIFlowLayout();
			Layout layout = new Layout(this.getWidth(), this.getHeight());
			div.setLayout(layout);
			
			Image pageSurface = div.getImage().toNativeImage();
			g.drawImage(pageSurface, 0, 0, null);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
