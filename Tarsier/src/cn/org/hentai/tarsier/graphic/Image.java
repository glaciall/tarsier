package cn.org.hentai.tarsier.graphic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

public final class Image
{
	private int width;
	private int height;
	private int backgroundColor;
	private int[] dots;
	private Painter painter;
	
	public Image()
	{
		this.width = 0;
		this.height = 0;
		this.painter = new Painter(this);
	}
	
	public void alloc(int width, int height, int bgcolor)
	{
		this.width = width;
		this.height = height;
		this.dots = new int[width * height];
		
		this.backgroundColor = bgcolor;
		if (bgcolor == 0x00) return;
		
		for (int i = 0; i < this.dots.length; i++)
			this.dots[i] = bgcolor;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public void setPixel(int x, int y, int color)
	{
		this.dots[x + y * this.width] = color;
	}
	
	public int getPixel(int x, int y)
	{
		return this.dots[x + y * this.width];
	}
	
	public Painter getPainter()
	{
		return this.painter;
	}
	
	public Image clip(int x, int y, int width, int height)
	{
		Image img = new Image();
		img.alloc(width - x, height - y, this.backgroundColor);
		for (; y < height; y++)
		{
			for (; x < width; x++)
			{
				img.setPixel(x, y, this.getPixel(x, y));
			}
		}
		return img;
	}
	
	public static Bitmap toBitmap(Image img)
	{
		Bitmap bitmap = new Bitmap(img.getWidth(), img.getHeight());
		for (int y = 0; y < img.getHeight(); y++)
		{
			for (int x = 0; x < img.getWidth(); x++)
				bitmap.setPixel(x, y, img.getPixel(x, y));
		}
		return bitmap;
	}
	
	public java.awt.Image toNativeImage() throws Exception
	{
		return toNativeImage(0, 0, this.width, this.height);
	}
	
	public java.awt.Image toNativeImage(int x, int y, int width, int height) throws Exception
	{
		Image copy = this;
		if (width != this.width || height != this.height)
			copy = this.clip(x, y, width, height);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream(width * height * 4);
		Image.toBitmap(copy).output(baos);
		ByteArrayInputStream cacheImage = new ByteArrayInputStream(baos.toByteArray());
		return ImageIO.read(cacheImage);
	}
}
