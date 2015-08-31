package cn.org.hentai.tarsier.view.text;

import cn.org.hentai.tarsier.graphic.Brush;
import cn.org.hentai.tarsier.graphic.Image;
import cn.org.hentai.tarsier.graphic.Painter;

// tag <strike>
public class Strike extends Text
{
	@Override
	protected void onDraw(Image image)
	{
		super.onDraw(image);
		Painter painter = image.getPainter();
		Brush brush = new Brush();
		brush.setColor(0xff000000);
		painter.setBrush(brush);
		painter.drawLine(0, this.layout.height / 2, this.layout.width, this.layout.height / 2);
	}
}
