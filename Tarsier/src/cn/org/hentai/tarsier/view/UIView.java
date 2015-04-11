package cn.org.hentai.tarsier.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import cn.org.hentai.tarsier.graphic.Bitmap;
import cn.org.hentai.tarsier.graphic.Image;
import cn.org.hentai.tarsier.graphic.Painter;

public abstract class UIView
{
	public Layout layout;
	protected int indexAtDocument;				// 元素在当前文档中的序号
	protected int indexAtParent;				// 元素在直接父级元素中的序列
	protected int backgroundColor;
	
	private float alpha;
	private float scale;
	private boolean clip;
	
	protected UIView parentView;
	protected LinkedList<UIView> subViews;
	
	private Image image;
	private boolean invalidated;
	
	public UIView()
	{
		this.image = new Image();
		this.alpha = 1.0f;
		this.scale = 1.0f;
		this.clip = false;
		this.parentView = null;
		this.invalidated = true;
		this.layout = new Layout();
		this.subViews = new LinkedList<UIView>();
	}
	
	// build dom tree
	public void addView(UIView child)
	{
		this.addViewAt(this.subViews.size(), child);
	}
	
	public void addViewAt(int index, UIView child)
	{
		this.subViews.add(index, child);
		child.parentView = this;
		child.indexAtParent = this.subViews.size() - 1;
	}
	
	public final UIView getChildAt(int index)
	{
		return this.subViews.get(index);
	}
	
	// measure
	protected abstract void onMeasure();
	
	
	// layout
	protected void onLayout()
	{
		// do nothing here
	}
	
	// graphics
	protected abstract void onDraw(Image image);
	
	public final Image getImage()
	{
		if (!this.invalidated) return this.image;
		// measure, layout and draw
		this.onMeasure();
		this.onLayout();
		this.image.alloc(this.layout.measuredWidth, this.layout.measuredHeight, this.backgroundColor);
		// 先画本元素的外观
		this.onDraw(this.image);
		// 再将子元素的外观覆盖在自己上面
		// 如果该元素的clip值为false，则本元素的画布应该要无穷大，大到能够容纳任意位置上的子元素
		// 或者是单独考虑position为absolute的元素
		
		LinkedList<UIView> childs = (LinkedList<UIView>) this.subViews.subList(0, this.subViews.size());
		Collections.sort(childs, new Comparator<UIView>()
		{
			public int compare(UIView view1, UIView view2)
			{
				// 如果zIndex相同，则后一个元素的层级要高于前一个元素
				if (view1.layout.zIndex == view2.layout.zIndex)
				{
					return view1.indexAtParent - view2.indexAtParent;
				}
				return view1.layout.zIndex - view2.layout.zIndex;
			}
		});
		
		// 将子元素画在当前画布的上面
		for (int i = 0; i < childs.size(); i++)
		{
			UIView child = childs.get(i);
			Image img = child.getImage();
			Painter painter = this.image.getPainter();
			painter.drawImage(child.layout.x, child.layout.y, img);
		}
		
		return this.image;
	}
	
	public final void invalidate()
	{
		this.invalidated = true;
	}
}
