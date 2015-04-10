package cn.org.hentai.tarsier.graphic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class Bitmap
{
	private int width;
	private int height;
	private int fitBytes;
	private byte[] bytes;
	
	public Bitmap(int width, int height)
	{
		this(width, height, 0xffffff);
	}
	
	public Bitmap(int width, int height, int bgcolor)
	{
		this.width = width;
		this.height = height;
		
		this.init(bgcolor);
	}
	
	private void init(int bgcolor)
	{
		int biSizeImage = (width * 24 + 31) / 32 * 4 * height;
		int imgBytes = BitmapFormat.BYTES_OF_HEADER + biSizeImage;
		this.fitBytes = biSizeImage / height - (width * 3);
		
		this.bytes = new byte[imgBytes];
		
		this.setHeaderValue(BitmapFormat.bfType, 0x4d42);
        this.setHeaderValue(BitmapFormat.bfSize, biSizeImage + 0x36);
        this.setHeaderValue(BitmapFormat.bfReserved, 0x00);
        this.setHeaderValue(BitmapFormat.bfOffBits, 0x36);
        this.setHeaderValue(BitmapFormat.biSize, 0x28);
        this.setHeaderValue(BitmapFormat.biWidth, width);
        this.setHeaderValue(BitmapFormat.biHeight, height);
        this.setHeaderValue(BitmapFormat.biPlanes, 0x01);
        this.setHeaderValue(BitmapFormat.biBitCount, 0x18);
        this.setHeaderValue(BitmapFormat.biCompression, 0x00);
        this.setHeaderValue(BitmapFormat.biSizeImage, biSizeImage);
        this.setHeaderValue(BitmapFormat.biXPelsPerMeter, 0x00);
        this.setHeaderValue(BitmapFormat.biYPelsPerMeter, 0x00);
        this.setHeaderValue(BitmapFormat.biClrUsed, 0x00);
        this.setHeaderValue(BitmapFormat.biClrImportant, 0x00);
        
        for (int y = 0; y < this.height; y++)
        	for (int x = 0; x < this.width; x++)
        		this.setPixel(x, y, bgcolor);
	}
	
	public void output(OutputStream writer) throws Exception
	{
		try
		{
			for (int i = 0, k = (int)Math.ceil(this.bytes.length / 512f); i < k; i++)
			{
				int len = i < k - 1 ? 512 : this.bytes.length % 512;
				writer.write(this.bytes, i * 512, len);
			}
		}
		finally
		{
			// try { writer.close(); } catch (Exception e) { }
		}
	}
	
	public void output(File file) throws Exception
	{
		FileOutputStream writer = null;
		try
		{
			writer = new FileOutputStream(file);
			output(writer);
		}
		finally
		{
			try { writer.close(); } catch(Exception e) { }
		}
	}
	
	public void setPixel(int x, int y, int color)
	{
		y = this.height - y - 1;
		int offset = (this.width * 3 * y + this.fitBytes * y + x * 3) + BitmapFormat.BYTES_OF_HEADER;
		this.bytes[offset] = (byte)(color & 0xff);
		this.bytes[offset + 1] = (byte)((color >> 8) & 0xff);
		this.bytes[offset + 2] = (byte)((color >> 16) & 0xff);
	}
	
	public void setHeaderValue(HeaderField header, int value)
	{
		int len = header.length;
		this.bytes[header.offset] = (byte)(value & 0xff);
		this.bytes[header.offset + 1] = (byte)((value >> 8) & 0xff);
		if (len == 0x02) return;
		this.bytes[header.offset + 2] = (byte)((value >> 16) & 0xff);
		this.bytes[header.offset + 3] = (byte)((value >> 24) & 0xff);
	}
	
	public static class BitmapFormat
	{
		public static final int BYTES_OF_HEADER = 0x36;
		
		public static final HeaderField bfType = new HeaderField(0, 0x02);				// 总是BM
		public static final HeaderField bfSize = new HeaderField(2, 0x04);				// BMP图像文件的大小
		public static final HeaderField bfReserved = new HeaderField(6, 0x04);			// 总为0，本该是bfReserved1和bfReserved2
		public static final HeaderField bfOffBits = new HeaderField(10, 0x04);			// BMP图像数据的地址
		public static final HeaderField biSize = new HeaderField(14, 0x04);				// 本结构的大小，根据不同的操作系统而不同，在Windows中，此字段的值总为28h字节=40字节
		public static final HeaderField biWidth = new HeaderField(18, 0x04);			// BMP图像的宽度，单位像素
		public static final HeaderField biHeight = new HeaderField(22, 0x04);			// 总为0
		public static final HeaderField biPlanes = new HeaderField(26, 0x02);			// 总为0
		public static final HeaderField biBitCount = new HeaderField(28, 0x02);			// BMP图像的色深，即一个像素用多少位表示，常见有1、4、8、16、24和32，分别对应单色、16色、256色、16位高彩色、24位真彩色和32位增强型真彩色
		public static final HeaderField biCompression = new HeaderField(30, 0x04);		// ...
		public static final HeaderField biSizeImage = new HeaderField(34, 0x04);		// BMP图像数据大小，必须是4的倍数，图像数据大小不是4的倍数时用0填充补足
		public static final HeaderField biXPelsPerMeter = new HeaderField(38, 0x04);	// 水平分辨率，单位像素/m
		public static final HeaderField biYPelsPerMeter = new HeaderField(42, 0x04);	// 垂直分辨率，单位像素/m
		public static final HeaderField biClrUsed = new HeaderField(46, 0x04);			// BMP图像使用的颜色，0表示使用全部颜色，对于256色位图来说，此值为100h=256
		public static final HeaderField biClrImportant = new HeaderField(50, 0x04);		// 重要的颜色数，此值为0时所有颜色都重要，对于使用调色板的BMP图像来说，当显卡不能够显示所有颜色时，此值将辅助驱动程序显示颜色
	}
	
	private static class HeaderField
	{
		public int offset;
		public int length;
		public HeaderField(int offset, int length)
		{
			this.offset = offset;
			this.length = length;
		}
	}
}
