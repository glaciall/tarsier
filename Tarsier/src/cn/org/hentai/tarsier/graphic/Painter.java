package cn.org.hentai.tarsier.graphic;

public final class Painter
{
	private Image image;
	private Brush brush;
	public Painter(Image image)
	{
		this.image = image;
	}
	
	public void setBrush(Brush brush)
	{
		this.brush = brush;
	}
	
	public void drawDot(int x, int y)
	{
		this.image.setPixel(x, y, this.brush.color);
	}
	
	public void drawLine(int x1, int y1, int x2, int y2)
	{
		
	}
	
	public void drawRect(int x, int y, int width, int height)
	{
		
	}
	
	public void drawRoundRect(int x, int y, int width, int height, int radius)
	{
		
	}
	
	public void drawCircle(int x, int y, int radius)
	{
		
	}
	
	public void drawText()
	{
		
	}
	
	public void drawImage(int x, int y, Image img)
	{
		// 暂时不想处理超出边界的元素的事情
		if (img.getWidth() + x > this.image.getWidth()) return;
		if (img.getHeight() + y > this.image.getHeight()) return;
		for (int iy= 0, ey = y + img.getHeight(); y < ey; y++, iy++)
		{
			for (int ix = 0, ex = x + img.getWidth(); x < ex; x++, ix++)
			{
				int color = this.image.getPixel(x, y);
				color = Painter.mix(img.getPixel(ix, iy), color);
				this.image.setPixel(x, y, color);
			}
		}
	}
	
	public static int argb(int red, int green, int blue, int alpha)
	{
		return 0x00;
	}
	
	public static int mix(int frontend, int backend)
	{
		return frontend;
	}
}
