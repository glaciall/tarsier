package cn.org.hentai.tarsier.font;

public abstract class Font
{
    public static final int FONT_WIDTH_FIXED = 0x01;        // 等宽字体
    public static final int FONT_WIDTH_VARIABLE = 0x02;     // 不定宽字体

    public static final Font getFamily(String fontName)
    {
        return new SongType();
    }

    public abstract byte[] getCharactor(char chr);
    public abstract int getWidth();
}
