package cn.org.hentai.tarsier.view;

public class Layout
{
	public int width;
	public float widthPercent;
	protected int measuredWidth;
	
	public int height;
	public float heightPercent;
	protected int measuredHeight;
	
	public int left;
	protected int offsetLeft;
	public int top;
	protected int offsetTop;
	public int right;
	protected int offsetRight;
	public int bottom;
	protected int offsetBottom;
	
	public int visibility;		// hidden,visible
	public int display;			// none,block,inline
	public int position;		// absolute,relative,static
	public int zIndex;
	
	public int[] padding = new int[4];
	public int[] margin = new int[4];
	
	public Layout()
	{
		// ...
	}
	
	public Layout(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
}
