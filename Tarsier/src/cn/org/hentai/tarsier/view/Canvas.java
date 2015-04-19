package cn.org.hentai.tarsier.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.org.hentai.tarsier.ui.Div;

public class Canvas extends javax.swing.JComponent
{
	@Override
	protected void paintComponent(Graphics g)
	{
		try
		{
			Div div = new Div();
			div.setWidth(this.getWidth()).setHeight(this.getHeight());
			
			Image pageSurface = div.getWrapperView().getImage().toNativeImage();
			g.drawImage(pageSurface, 0, 0, null);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
