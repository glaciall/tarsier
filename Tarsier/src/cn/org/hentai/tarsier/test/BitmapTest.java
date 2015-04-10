package cn.org.hentai.tarsier.test;

import java.io.File;

import cn.org.hentai.tarsier.graphic.Bitmap;

public class BitmapTest
{
	public static void main(String[] args) throws Exception
	{
		long time = System.currentTimeMillis();
		Bitmap bitmap = new Bitmap(800, 800, 0xff0000);
		bitmap.output(new File("c:\\test.bmp"));
		time = System.currentTimeMillis() - time;
		System.out.println("Spend: " + time);
	}
}
