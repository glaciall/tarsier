package cn.org.hentai.tarsier.ui;

import java.util.HashMap;
import java.util.LinkedList;

import cn.org.hentai.tarsier.view.UIView;

public abstract class HTMLElement
{
	private LinkedList<HTMLElement> children;
	private HashMap<String, String> attributes;
	
	private HTMLElement()
	{
		this.children = new LinkedList<HTMLElement>();
		this.attributes = new HashMap<String, String>();
	}
	
	public HTMLElement appendChild(HTMLElement node)
	{
		return this;
	}
	
	public HTMLElement appendChild(int index, HTMLElement node)
	{
		return this;
	}
	
	public HTMLElement removeChild(HTMLElement node)
	{
		return this;
	}
	
	public HTMLElement setAttribute(String name, String value)
	{
		this.attributes.put(name, value);
		return this;
	}
	
	public String getAttribute(String name)
	{
		return this.attributes.get(name);
	}
	
	public abstract UIView getContentView();
	public UIView getWrappperView()
	{
		return this.getContentView();
	}
}
