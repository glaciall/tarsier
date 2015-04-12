package cn.org.hentai.tarsier.view;

public class AttributeSet
{
	public int top;
	public int right;
	public int bottom;
	public int left;
	
	public AttributeSet(int value)
	{
		this.top = value;
		this.right = value;
		this.bottom = value;
		this.left = value;
	}
	
	public AttributeSet(int t, int r, int b, int l)
	{
		this.top = t;
		this.right = r;
		this.bottom = b;
		this.left = l;
	}
}
