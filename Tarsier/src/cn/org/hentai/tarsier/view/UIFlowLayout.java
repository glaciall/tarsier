package cn.org.hentai.tarsier.view;

import cn.org.hentai.tarsier.font.Font;
import cn.org.hentai.tarsier.graphic.Brush;
import cn.org.hentai.tarsier.graphic.Image;
import cn.org.hentai.tarsier.graphic.Painter;

public class UIFlowLayout extends UIView
{
	public UIFlowLayout()
	{
		super();
	}
	
	@Override
	protected void onMeasure(int width, int height)
	{
		
		this.reportDimension(width, height);
	}

	@Override
	protected void onLayout()
	{
		
	}
	
	@Override
	protected void onDraw(Image image)
	{
		Brush brush = new Brush();
		brush.color = 0xffff0000;
		Painter painter = image.getPainter();
		painter.setBrush(brush);
		painter.drawText(this.layout.measuredWidth / 2, this.layout.measuredHeight / 2, "Hello Tarsier", Font.getFamily("System"));
	}
}
