package cn.org.hentai.tarsier.view;

import cn.org.hentai.tarsier.graphic.Image;

public class UITextView extends UIView
{
	private int textSize;
	private int textColor;
	private String fontFamily;
	public UITextView()
	{
		super();
		this.textColor = 0xff000000;
		this.fontFamily = "System";
		this.layout.width = UIView.WRAP_CONTENT;
		this.layout.height = UIView.WRAP_CONTENT;
	}
	
	@Override
	protected void onMeasure(int width, int height)
	{
		// 如果宽高都固定
		
		// 如果宽度固定，高度不固定
		// 如果宽度不固定，高度固定
		// 如果宽高都不固定
	}

	@Override
	protected void onDraw(Image image)
	{

	}
}
