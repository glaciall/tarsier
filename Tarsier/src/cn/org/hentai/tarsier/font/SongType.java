﻿package cn.org.hentai.tarsier.font;

public final class SongType extends Font
{
    protected SongType()
    {
        // ...
    }

    public byte[] getCharactor(char chr)
    {
        if (chr < 0x20 || chr > 0x7e) chr = 0x3f;
        byte[] bits = new byte[12];
        System.arraycopy(charBits, chr - 0x20, bits, 0, 12);
        return bits;
    }

    public int getWidth()
    {
        return Font.FONT_WIDTH_VARIABLE;
    }

    private static final byte[] charBits = new byte[]
    {
        /*--  文字:     --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  !  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x20,0x20,0x20,0x20,0x20,0x00,0x20,0x00,0x00,

        /*--  文字:  "  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x28,0x50,0x50,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  #  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x28,0x28,(byte)0xFC,0x28,0x50,(byte)0xFC,0x50,0x50,0x00,0x00,

        /*--  文字:  $  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x20,0x78,(byte)0xA8,(byte)0xA0,0x60,0x30,0x28,(byte)0xA8,(byte)0xF0,0x20,0x00,

        /*--  文字:  %  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x48,(byte)0xA8,(byte)0xB0,0x50,0x28,0x34,0x54,0x48,0x00,0x00,

        /*--  文字:  &  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x50,0x50,0x78,(byte)0xA8,(byte)0xA8,(byte)0x90,0x6C,0x00,0x00,

        /*--  文字:  '  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x40,0x40,(byte)(byte)0x80,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  (  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x04,0x08,0x10,0x10,0x10,0x10,0x10,0x10,0x08,0x04,0x00,

        /*--  文字:  )  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x40,0x20,0x10,0x10,0x10,0x10,0x10,0x10,0x20,0x40,0x00,

        /*--  文字:  *  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x20,(byte)0xA8,0x70,0x70,(byte)0xA8,0x20,0x00,0x00,0x00,

        /*--  文字:  +  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x20,0x20,(byte)0xF8,0x20,0x20,0x20,0x00,0x00,0x00,

        /*--  文字:  ,  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x40,0x40,(byte)(byte)0x80,

        /*--  文字:  -  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xF8,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  .  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x40,0x00,0x00,

        /*--  文字:  /  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x08,0x10,0x10,0x10,0x20,0x20,0x40,0x40,0x40,(byte)0x80,0x00,

        /*--  文字:  0  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  1  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x60,0x20,0x20,0x20,0x20,0x20,0x70,0x00,0x00,

        /*--  文字:  2  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,0x10,0x20,0x40,(byte)0x80,(byte)0xF8,0x00,0x00,

        /*--  文字:  3  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,0x08,0x30,0x08,0x08,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  4  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x10,0x30,0x50,0x50,(byte)0x90,0x78,0x10,0x18,0x00,0x00,

        /*--  文字:  5  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,(byte)0x80,(byte)0x80,(byte)0xF0,0x08,0x08,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  6  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x90,(byte)0x80,(byte)0xF0,(byte)0x88,(byte)0x88,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  7  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,(byte)0x90,0x10,0x20,0x20,0x20,0x20,0x20,0x00,0x00,

        /*--  文字:  8  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,0x70,(byte)0x88,(byte)0x88,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  9  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,(byte)0x88,0x78,0x08,0x48,0x70,0x00,0x00,

        /*--  文字:  :  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x20,0x00,0x00,0x00,0x00,0x20,0x00,0x00,

        /*--  文字:  ;  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x20,0x00,0x00,0x00,0x20,0x20,0x00,

        /*--  文字:  <  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x04,0x08,0x10,0x20,0x40,0x20,0x10,0x08,0x04,0x00,0x00,

        /*--  文字:  =  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,(byte)0xF8,0x00,0x00,(byte)0xF8,0x00,0x00,0x00,0x00,

        /*--  文字:  >  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x40,0x20,0x10,0x08,0x04,0x08,0x10,0x20,0x40,0x00,0x00,

        /*--  文字:  ?  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,0x10,0x20,0x20,0x00,0x20,0x00,0x00,

        /*--  文字:  @  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x98,(byte)0xA8,(byte)0xA8,(byte)0xB8,(byte)0x80,0x78,0x00,0x00,

        /*--  文字:  A  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x20,0x30,0x50,0x50,0x78,0x48,(byte)0xCC,0x00,0x00,

        /*--  文字:  B  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF0,0x48,0x48,0x70,0x48,0x48,0x48,(byte)0xF0,0x00,0x00,

        /*--  文字:  C  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x78,(byte)0x88,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  D  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF0,0x48,0x48,0x48,0x48,0x48,0x48,(byte)0xF0,0x00,0x00,

        /*--  文字:  E  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,0x48,0x50,0x70,0x50,0x40,0x48,(byte)0xF8,0x00,0x00,

        /*--  文字:  F  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,0x48,0x50,0x70,0x50,0x40,0x40,(byte)0xE0,0x00,0x00,

        /*--  文字:  G  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x38,0x48,(byte)0x80,(byte)0x80,(byte)0x9C,(byte)0x88,0x48,0x30,0x00,0x00,

        /*--  文字:  H  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xCC,0x48,0x48,0x78,0x48,0x48,0x48,(byte)0xCC,0x00,0x00,

        /*--  文字:  I  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,0x20,0x20,0x20,0x20,0x20,0x20,(byte)0xF8,0x00,0x00,

        /*--  文字:  J  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x7C,0x10,0x10,0x10,0x10,0x10,0x10,(byte)0x90,(byte)0xE0,0x00,

        /*--  文字:  K  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xEC,0x48,0x50,0x60,0x50,0x50,0x48,(byte)0xEC,0x00,0x00,

        /*--  文字:  L  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xE0,0x40,0x40,0x40,0x40,0x40,0x44,(byte)0xFC,0x00,0x00,

        /*--  文字:  M  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xD8,(byte)0xD8,(byte)0xD8,(byte)0xD8,(byte)0xA8,(byte)0xA8,(byte)0xA8,(byte)0xA8,0x00,0x00,

        /*--  文字:  N  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xDC,0x48,0x68,0x68,0x58,0x58,0x48,(byte)0xE8,0x00,0x00,

        /*--  文字:  O  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,0x70,0x00,0x00,

        /*--  文字:  P  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF0,0x48,0x48,0x70,0x40,0x40,0x40,(byte)0xE0,0x00,0x00,

        /*--  文字:  Q  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x70,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0xE8,(byte)0x98,0x70,0x18,0x00,

        /*--  文字:  R  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF0,0x48,0x48,0x70,0x50,0x48,0x48,(byte)0xEC,0x00,0x00,

        /*--  文字:  S  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x78,(byte)0x88,(byte)0x80,0x60,0x10,0x08,(byte)0x88,(byte)0xF0,0x00,0x00,

        /*--  文字:  T  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,(byte)0xA8,0x20,0x20,0x20,0x20,0x20,0x70,0x00,0x00,

        /*--  文字:  U  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xCC,0x48,0x48,0x48,0x48,0x48,0x48,0x30,0x00,0x00,

        /*--  文字:  V  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xCC,0x48,0x48,0x50,0x50,0x30,0x20,0x20,0x00,0x00,

        /*--  文字:  W  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xA8,(byte)0xA8,(byte)0xA8,0x70,0x50,0x50,0x50,0x50,0x00,0x00,

        /*--  文字:  X  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xD8,0x50,0x50,0x20,0x20,0x50,0x50,(byte)0xD8,0x00,0x00,

        /*--  文字:  Y  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xD8,0x50,0x50,0x20,0x20,0x20,0x20,0x70,0x00,0x00,

        /*--  文字:  Z  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xF8,(byte)0x90,0x10,0x20,0x20,0x40,0x48,(byte)0xF8,0x00,0x00,

        /*--  文字:  [  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x38,0x20,0x20,0x20,0x20,0x20,0x20,0x20,0x20,0x38,0x00,

        /*--  文字:  \  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x40,0x40,0x40,0x20,0x20,0x10,0x10,0x10,0x08,0x00,0x00,

        /*--  文字:  ]  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x70,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x70,0x00,

        /*--  文字:  ^  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x20,0x50,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  _  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,(byte)0xFC,

        /*--  文字:  `  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x20,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,

        /*--  文字:  a  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x30,0x48,0x38,0x48,0x3C,0x00,0x00,

        /*--  文字:  b  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xC0,0x40,0x40,0x70,0x48,0x48,0x48,0x70,0x00,0x00,

        /*--  文字:  c  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x38,0x48,0x40,0x40,0x38,0x00,0x00,

        /*--  文字:  d  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x18,0x08,0x08,0x38,0x48,0x48,0x48,0x3C,0x00,0x00,

        /*--  文字:  e  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x30,0x48,0x78,0x40,0x38,0x00,0x00,

        /*--  文字:  f  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x1C,0x20,0x20,0x78,0x20,0x20,0x20,0x78,0x00,0x00,

        /*--  文字:  g  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x3C,0x48,0x30,0x40,0x78,0x44,0x38,

        /*--  文字:  h  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xC0,0x40,0x40,0x70,0x48,0x48,0x48,(byte)0xEC,0x00,0x00,

        /*--  文字:  i  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x20,0x00,0x00,0x60,0x20,0x20,0x20,0x70,0x00,0x00,

        /*--  文字:  j  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x10,0x00,0x00,0x30,0x10,0x10,0x10,0x10,0x10,(byte)0xE0,

        /*--  文字:  k  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xC0,0x40,0x40,0x5C,0x50,0x70,0x48,(byte)0xEC,0x00,0x00,

        /*--  文字:  l  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,(byte)0xE0,0x20,0x20,0x20,0x20,0x20,0x20,(byte)0xF8,0x00,0x00,

        /*--  文字:  m  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xF0,(byte)0xA8,(byte)0xA8,(byte)0xA8,(byte)0xA8,0x00,0x00,

        /*--  文字:  n  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xF0,0x48,0x48,0x48,(byte)0xEC,0x00,0x00,

        /*--  文字:  o  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x30,0x48,0x48,0x48,0x30,0x00,0x00,

        /*--  文字:  p  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xF0,0x48,0x48,0x48,0x70,0x40,(byte)0xE0,

        /*--  文字:  q  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x38,0x48,0x48,0x48,0x38,0x08,0x1C,

        /*--  文字:  r  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xD8,0x60,0x40,0x40,(byte)0xE0,0x00,0x00,

        /*--  文字:  s  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x78,0x40,0x30,0x08,0x78,0x00,0x00,

        /*--  文字:  t  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x20,0x20,0x70,0x20,0x20,0x20,0x18,0x00,0x00,

        /*--  文字:  u  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xD8,0x48,0x48,0x48,0x3C,0x00,0x00,

        /*--  文字:  v  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xEC,0x48,0x50,0x30,0x20,0x00,0x00,

        /*--  文字:  w  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xA8,(byte)0xA8,0x70,0x50,0x50,0x00,0x00,

        /*--  文字:  x  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xD8,0x50,0x20,0x50,(byte)0xD8,0x00,0x00,

        /*--  文字:  y  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,(byte)0xEC,0x48,0x50,0x30,0x20,0x20,(byte)0xC0,

        /*--  文字:  z  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x00,0x00,0x00,0x00,0x78,0x10,0x20,0x20,0x78,0x00,0x00,

        /*--  文字:  {  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x18,0x10,0x10,0x10,0x20,0x10,0x10,0x10,0x10,0x18,0x00,

        /*--  文字:  |  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,

        /*--  文字:  }  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x00,0x60,0x20,0x20,0x20,0x10,0x20,0x20,0x20,0x20,0x60,0x00,

        /*--  文字:  ~  --*/
        /*--  宋体9;  此字体下对应的点阵为：宽x高=6x12   --*/
        /*--  宽度不是8的倍数，现调整为：宽度x高度=8x12  --*/
        0x40,(byte)0xA4,0x18,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
    };
}
