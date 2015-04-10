package cn.org.hentai.tarsier.graphic;

public class Brush
{
	public int color;
	public int size;
	public Brush()
	{
		this.color = 0xff000000;
		this.size = 1;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
}
