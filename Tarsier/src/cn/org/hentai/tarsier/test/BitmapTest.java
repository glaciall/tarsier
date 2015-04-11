package cn.org.hentai.tarsier.test;

import java.io.File;

import cn.org.hentai.tarsier.font.Font;
import cn.org.hentai.tarsier.graphic.Bitmap;
import cn.org.hentai.tarsier.graphic.Brush;
import cn.org.hentai.tarsier.graphic.Image;
import cn.org.hentai.tarsier.graphic.Painter;

public class BitmapTest
{
	public static void main(String[] args) throws Exception
	{
		long time = System.currentTimeMillis();
		Bitmap bitmap = null;
		
		Image img = new Image();
		img.alloc(800, 800, 0xffffffff);
		Painter painter = new Painter(img);
		Brush brush = new Brush();
		brush.setColor(0xffff0000);
		painter.setBrush(brush);
		// painter.drawRect(18, 18, 400, 400);
		painter.drawText(20, 20, "Hello World.", Font.getFamily("System"));
		painter.drawRect(200, 200, 400, 400);
		painter.drawCircle(400, 400, 100);
		bitmap = Image.toBitmap(img);
		
		bitmap.output(new File("c:\\test.bmp"));
		time = System.currentTimeMillis() - time;
		System.out.println("Spend: " + time);
	}
}
