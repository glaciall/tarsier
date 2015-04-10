package cn.org.hentai.tarsier.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import cn.org.hentai.tarsier.graphic.Bitmap;
import cn.org.hentai.tarsier.graphic.Image;

public abstract class UIView
{
	public Layout layout;
	protected int indexAtDocument;				// Ԫ���ڵ�ǰ�ĵ��е����
	protected int indexAtParent;				// Ԫ����ֱ�Ӹ���Ԫ���е�����
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
		// �Ȼ���Ԫ�ص����
		this.onDraw(this.image);
		// �ٽ���Ԫ�ص���۸������Լ�����
		// �����Ԫ�ص�clipֵΪfalse����Ԫ�صĻ���Ӧ��Ҫ����󣬴��ܹ���������λ���ϵ���Ԫ��
		// �����ǵ�������positionΪabsolute��Ԫ��
		
		LinkedList<UIView> childs = (LinkedList<UIView>) this.subViews.subList(0, this.subViews.size());
		Collections.sort(childs, new Comparator<UIView>()
		{
			public int compare(UIView view1, UIView view2)
			{
				// ���zIndex��ͬ�����һ��Ԫ�صĲ㼶Ҫ����ǰһ��Ԫ��
				if (view1.layout.zIndex == view2.layout.zIndex)
				{
					return view1.indexAtParent - view2.indexAtParent;
				}
				return view1.layout.zIndex - view2.layout.zIndex;
			}
		});
		
		for (int i = 0; i < 0; i++)
		{
			
		}
		
		return this.image;
	}
	
	public final void invalidate()
	{
		this.invalidated = true;
	}
}
