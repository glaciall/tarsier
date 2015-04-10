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
		
		public static final HeaderField bfType = new HeaderField(0, 0x02);				// ����BM
		public static final HeaderField bfSize = new HeaderField(2, 0x04);				// BMPͼ���ļ��Ĵ�С
		public static final HeaderField bfReserved = new HeaderField(6, 0x04);			// ��Ϊ0��������bfReserved1��bfReserved2
		public static final HeaderField bfOffBits = new HeaderField(10, 0x04);			// BMPͼ�����ݵĵ�ַ
		public static final HeaderField biSize = new HeaderField(14, 0x04);				// ���ṹ�Ĵ�С�����ݲ�ͬ�Ĳ���ϵͳ����ͬ����Windows�У����ֶε�ֵ��Ϊ28h�ֽ�=40�ֽ�
		public static final HeaderField biWidth = new HeaderField(18, 0x04);			// BMPͼ��Ŀ�ȣ���λ����
		public static final HeaderField biHeight = new HeaderField(22, 0x04);			// ��Ϊ0
		public static final HeaderField biPlanes = new HeaderField(26, 0x02);			// ��Ϊ0
		public static final HeaderField biBitCount = new HeaderField(28, 0x02);			// BMPͼ���ɫ���һ�������ö���λ��ʾ��������1��4��8��16��24��32���ֱ��Ӧ��ɫ��16ɫ��256ɫ��16λ�߲�ɫ��24λ���ɫ��32λ��ǿ�����ɫ
		public static final HeaderField biCompression = new HeaderField(30, 0x04);		// ...
		public static final HeaderField biSizeImage = new HeaderField(34, 0x04);		// BMPͼ�����ݴ�С��������4�ı�����ͼ�����ݴ�С����4�ı���ʱ��0��䲹��
		public static final HeaderField biXPelsPerMeter = new HeaderField(38, 0x04);	// ˮƽ�ֱ��ʣ���λ����/m
		public static final HeaderField biYPelsPerMeter = new HeaderField(42, 0x04);	// ��ֱ�ֱ��ʣ���λ����/m
		public static final HeaderField biClrUsed = new HeaderField(46, 0x04);			// BMPͼ��ʹ�õ���ɫ��0��ʾʹ��ȫ����ɫ������256ɫλͼ��˵����ֵΪ100h=256
		public static final HeaderField biClrImportant = new HeaderField(50, 0x04);		// ��Ҫ����ɫ������ֵΪ0ʱ������ɫ����Ҫ������ʹ�õ�ɫ���BMPͼ����˵�����Կ����ܹ���ʾ������ɫʱ����ֵ����������������ʾ��ɫ
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
