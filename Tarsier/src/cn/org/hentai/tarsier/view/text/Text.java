package cn.org.hentai.tarsier.view.text;

import cn.org.hentai.tarsier.font.Font;
import cn.org.hentai.tarsier.graphic.Brush;
import cn.org.hentai.tarsier.graphic.Image;
import cn.org.hentai.tarsier.graphic.Painter;
import cn.org.hentai.tarsier.view.UIView;

public class Text extends UIView
{
	private int fontSize;
	private int textColor;
	private String fontFamily;
	private String text;
	
	public Text()
	{
		super();
		this.textColor = 0xff000000;
		this.fontFamily = "System";
		this.layout.width = UIView.WRAP_CONTENT;
		this.layout.height = UIView.WRAP_CONTENT;
	}
	
	public void setFontSize(int size)
	{
		this.fontSize = size;
	}
	
	public void setTextColor(int argb)
	{
		this.textColor = argb;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public void setFontFamily(String familyName)
	{
		this.fontFamily = familyName;
	}
	
	@Override
	protected void onDraw(Image image)
	{
		Brush brush = new Brush();
		brush.color = this.textColor;
		Painter painter = image.getPainter();
		painter.setBrush(brush);
		painter.drawText(0, 0, this.text, Font.getFamily(this.fontFamily));
	}

	@Override
	protected void onMeasure(int width, int height)
	{
		this.reportDimension(width, height);
	}
}
