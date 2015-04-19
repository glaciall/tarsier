package cn.org.hentai.tarsier.ui;

import java.util.HashMap;
import java.util.LinkedList;

import cn.org.hentai.tarsier.view.Layout;
import cn.org.hentai.tarsier.view.UIView;

public abstract class HTMLElement
{
	private LinkedList<HTMLElement> children;
	private HashMap<String, String> attributes;
	private HTMLElement parentNode;
	protected Layout layout;
	
	protected HTMLElement()
	{
		this.parentNode = null;
		this.layout = new Layout();
		this.children = new LinkedList<HTMLElement>();
		this.attributes = new HashMap<String, String>();
	}
	
	// 元素树模型相关
	public HTMLElement appendChild(HTMLElement node)
	{
		return this;
	}
	
	public HTMLElement appendChild(int index, HTMLElement node)
	{
		this.children.add(index, node);
		node.setParentNode(this);
		return this;
	}
	
	protected final void setParentNode(HTMLElement node)
	{
		this.parentNode = node;
	}
	
	public HTMLElement getParentNode()
	{
		return this.parentNode;
	}
	
	public HTMLElement removeChild(HTMLElement node)
	{
		return this;
	}
	
	public LinkedList<HTMLElement> getChildren()
	{
		return this.children;
	}
	
	public HTMLElement getChildAt(int index)
	{
		return this.children.get(index);
	}
	
	// 自定义属性集
	public HTMLElement setAttribute(String name, String value)
	{
		this.attributes.put(name, value);
		return this;
	}
	
	public String getAttribute(String name)
	{
		return this.attributes.get(name);
	}
	
	// 元素表现层相关
	public abstract UIView getContentView();
	public UIView getWrapperView()
	{
		UIView view = this.getContentView();
		view.setLayout(this.layout);
		return view;
	}
	
	// 布局属性相关
	public HTMLElement setWidth(int width)
	{
		this.layout.width = width;
		this.layout.widthPercent = -1.0f;
		return this;
	}
	
	public HTMLElement setWidth(float widthPercent)
	{
		this.layout.widthPercent = widthPercent;
		return this;
	}
	
	public HTMLElement setHeight(int height)
	{
		this.layout.height = height;
		this.layout.heightPercent = -1.0f;
		return this;
	}
	
	public HTMLElement setHeight(float heightPercent)
	{
		this.layout.heightPercent = heightPercent;
		return this;
	}
	
	public HTMLElement setMargin(int top, int right, int bottom, int left)
	{
		this.setMarginTop(top);
		this.setMarginRight(right);
		this.setMarginBottom(bottom);
		this.setMarginLeft(left);
		return this;
	}
	
	public HTMLElement setMarginTop(int margin)
	{
		this.layout.margin[0] = margin;
		return this;
	}
	
	public HTMLElement setMarginRight(int margin)
	{
		this.layout.margin[1] = margin;
		return this;
	}
	
	public HTMLElement setMarginBottom(int margin)
	{
		this.layout.margin[2] = margin;
		return this;
	}
	
	public HTMLElement setMarginLeft(int margin)
	{
		this.layout.margin[3] = margin;
		return this;
	}
	
	public HTMLElement setPadding(int top, int right, int bottom, int left)
	{
		this.setPaddingTop(top);
		this.setPaddingRight(right);
		this.setPaddingBottom(bottom);
		this.setPaddingLeft(left);
		return this;
	}
	
	public HTMLElement setPaddingTop(int padding)
	{
		this.layout.padding[0] = padding;
		return this;
	}
	
	public HTMLElement setPaddingRight(int padding)
	{
		this.layout.padding[1] = padding;
		return this;
	}
	
	public HTMLElement setPaddingBottom(int padding)
	{
		this.layout.padding[2] = padding;
		return this;
	}
	
	public HTMLElement setPaddingLeft(int padding)
	{
		this.layout.padding[3] = padding;
		return this;
	}
	
	public HTMLElement setVisibility(int visibility)
	{
		this.layout.visibility = visibility;
		return this;
	}
	
	public HTMLElement setDisplay(int display)
	{
		this.layout.display = display;
		return this;
	}
	
	public HTMLElement setPosition(int position)
	{
		this.layout.position = position;
		return this;
	}
	
	public HTMLElement setZIndex(int index)
	{
		this.layout.zIndex = index;
		return this;
	}
	
	public HTMLElement setTop(int offset)
	{
		this.layout.top = offset;
		return this;
	}
	
	public HTMLElement setRight(int offset)
	{
		this.layout.right = offset;
		return this;
	}
	
	public HTMLElement setBottom(int offset)
	{
		this.layout.bottom = offset;
		return this;
	}
	
	public HTMLElement setLeft(int offset)
	{
		this.layout.left = offset;
		return this;
	}
}
