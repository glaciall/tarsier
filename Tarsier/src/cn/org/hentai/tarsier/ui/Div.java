package cn.org.hentai.tarsier.ui;

import cn.org.hentai.tarsier.view.UIFlowLayout;
import cn.org.hentai.tarsier.view.UIView;

public class Div extends HTMLElement
{
	private UIFlowLayout view;
	public Div()
	{
		super();
		this.view = new UIFlowLayout();
		this.setWidth(1.0f);
		this.setHeight(Attribute.WRAP_CONTENT);
	}
	
	@Override
	public UIView getContentView()
	{
		return this.view;
	}

}
