package cn.org.hentai.tarsier.font;

import cn.org.hentai.tarsier.graphic.Rect;

public abstract class Font
{
    public static final int FONT_WIDTH_FIXED = 0x01;        // 等宽字体
    public static final int FONT_WIDTH_VARIABLE = 0x02;     // 不定宽字体

    public static final Font getFamily(String fontName)
    {
        return new FontFamilySystem();
    }
    
    public Symbol getSymbol(char chr)
    {
    	return this.getSymbol(chr, 12, false, false);
    }
    
    public abstract Symbol getSymbol(char chr, int size, boolean italic, boolean bold);
    
    public abstract int getWidthType();
    public abstract Rect measureText(String text);
}
