package cn.org.hentai.tarsier.graphic;

import cn.org.hentai.tarsier.font.Font;
import cn.org.hentai.tarsier.font.Symbol;

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
		// 超出边界的直接舍弃
		if (x < 0 || y < 0) return;
		if (x > this.image.getWidth() || y > this.image.getHeight()) return;
		
		// TODO: 笔触大小未使用
		this.image.setPixel(x, y, this.brush.color);
	}
	
	public void drawLine(int x1, int y1, int x2, int y2)
	{
		// TODO: 斜线暂时不需要，嘻嘻
		
		// 竖线
		if (x1 == x2)
		{
			for (; y1 <= y2; y1++) this.drawDot(x1, y1);
		}
		
		// 横线
		if (y1 == y2)
		{
			for (; x1 <= x2; x1++) this.drawDot(x1, y1);
		}
	}
	
	public void drawRect(int x, int y, int width, int height)
	{
		// 上
		this.drawLine(x, y, x + width, y);
		// 下
		this.drawLine(x, y + height, x + width, y + height);
		// 左
		this.drawLine(x, y, x, y + height);
		// 右
		this.drawLine(x + width, y, x + width, y + height);
	}
	
	public void drawRoundRect(int x, int y, int width, int height, int radius)
	{
		
	}
	
	// TODO: 像素点比较密集的地方，可以使用低透明度的颜色来平滑化，待测试
	public void drawCircle(int rx, int ry, int radius)
	{
		int rr = radius * radius;
		for (int sy = 0; sy < radius; sy++)
		{
			int x = (int)Math.sqrt(rr - sy * sy);
			// 右下
			this.drawDot(rx + x, ry + sy);
			// 右上
			this.drawDot(rx + x, ry - sy);
			// 左下
			this.drawDot(rx - x, ry + sy);
			// 左上
			this.drawDot(rx -x, ry - sy);
		}
		for (int sx = 0, ex = radius / 2; sx < ex; sx++)
		{
			int y = (int)Math.sqrt(rr - sx *sx);
			// 右下
			this.drawDot(rx + sx, ry + y);
			// 右上
			this.drawDot(rx + sx, ry - y);
			// 左下
			this.drawDot(rx - sx, ry + y);
			// 左上
			this.drawDot(rx - sx, ry - y);
		}
	}
	
	public void drawText(int x, int y, String text, Font font)
	{
		for (int i = 0; i < text.length(); i++)
		{
			char chr = text.charAt(i);
			Symbol symbol = font.getSymbol(chr);
			int ty = y;
			for (int k = 0; k < symbol.dotMatrix.length; k++)
			{
				byte dotMatrix = symbol.dotMatrix[k];
				int tx = x;
				for (int s = 0; s < 8; s++)
				{
					tx += 1;
					boolean dot = ((dotMatrix >> (7 - s)) & 0x01) == 0x01;
					if (dot) this.drawDot(tx, ty);
				}
				ty += 1;
			}
			x += symbol.width;
		}
	}
	
	public void drawImage(int x, int y, Image img)
	{
		// TODO: 暂时不想处理超出边界的元素的事情
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
	
	public static int argb(int alpha, int red, int green, int blue)
	{
		return 0x00;
	}
	
	public static int mix(int frontend, int backend)
	{
		// TODO: 可耻的以后再补AlphaBlend
		return frontend;
	}
}
