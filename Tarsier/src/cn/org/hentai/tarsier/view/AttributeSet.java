package cn.org.hentai.tarsier.view;

public class AttributeSet
{
	// 
	public static Attribute parse(String attr)
	{
		return null;
	}
	
	public static class Attribute
	{
		protected String name;
		protected Value value;
		protected Value defaultValue;
	}
	
	protected static class Value
	{
		Object val;
	}
}
