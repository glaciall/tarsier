package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsString extends Var
{
    private int length = 0;
    private byte[] data = null;
    private String value = null;
    
    public JsString()
    {
        this(32);
    }
    
    public JsString(int length)
    {
        this.length = length;
        this.data = new byte[length];
    }
    
    public byte getType()
    {
        return Var.VAR_STRING;
    }

    public String getStringValue()
    {
        return this.value;
    }
    
    public JsString getValue()
    {
        return this;
    }

    public void setValue(Object argv)
    {
        try
        {
            String text = (String)argv;
            this.value = text.substring(1, text.length() - 1);
            byte[] b = this.value.getBytes("UTF-8");
            System.arraycopy(b, 0, this.data, 0, b.length);
        }
        catch(Exception ex) { }
    }
    
    public boolean getBooleanValue()
    {
        return this.data.length > 0;
    }

    public byte[] toBytes()
    {
        return this.data;
    }

    public short getLength()
    {
        return (short)this.data.length;
    }
}
