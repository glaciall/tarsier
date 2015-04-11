package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsNumber extends Var
{
    private double value;
    
    public JsNumber()
    {
        // ..
    }
    
    public byte getType()
    {
        return Var.VAR_NUMBER;
    }

    public Object getValue()
    {
        return this;
    }

    public void setValue(Object argv)
    {
        this.value = Double.valueOf(argv.toString());
    }
    
    public boolean getBooleanValue()
    {
        return this.value != 0.0d;
    }
    
    public double getNumberValue()
    {
        return this.value;
    }
    
    public void setNumberValue(double val)
    {
        this.value = val;
    }
    
    public short getLength()
    {
        return 8;
    }

    public byte[] toBytes()
    {
        byte[] data = new byte[8];
        long val = Double.doubleToLongBits(value);
        for (int i = 0; i < 8; i++)
            data[i] = (byte)((val >> ((7 - i) * 8)) & 0xff);
        return data;
    }
}
