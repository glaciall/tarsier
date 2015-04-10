package cn.org.hentai.tarsier.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;

import javax.swing.*;

import cn.org.hentai.tarsier.view.Canvas;

public final class TestWindow extends JFrame
{
	public TestWindow()
	{
		super();
		init();
	}
	
	private void init()
	{
		initWindow();
		initControlPanel();
		initBrowser();
	}
	
	private void initWindow()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(1, 1));
		
		Canvas canvas = new Canvas();
		canvas.setSize(400, 400);
		contentPane.add(canvas);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tarsier - Explore the World");
		// 真TM全屏
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);
		
		setVisible(true);
		
		// Insets in = getInsets();			// 获取窗口位置
		
		// Rectangle rect = getRootPane().getBounds();
		// System.out.println(rect.width + "," + rect.height);
		
		addWindowListener(new WindowAdapter()
		{
			// public void windowClosing(WindowEvent e)
			// {
				// ....
			// }
		});
	}
	
	private void initControlPanel()
	{
		// ...
	}
	
	private void initBrowser()
	{
		// ...
	}
	
	public static void main(String[] args) throws Exception
	{
		TestWindow window = new TestWindow();
	}
}
