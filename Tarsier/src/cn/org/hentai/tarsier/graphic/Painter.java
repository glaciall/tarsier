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
	
	public void drawImage()
	{
		
	}
	
	public static int argb(int red, int green, int blue, int alpha)
	{
		return 0x00;
	}
}
