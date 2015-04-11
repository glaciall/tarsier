package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsNull extends JsFunction
{
    public JsNull()
    {
        // ..
    }

    public byte getType()
    {
        return Var.VAR_NULL;
    }

    public Object getValue()
    {
        return null;
    }

    public void setValue(Object args)
    {
        // ...
    }
    
    public boolean getBooleanValue()
    {
        return false;
    }

    public byte[] toBytes()
    {
        return new byte[] { 0x00 };
    }

    public short getLength()
    {
        return 1;
    }
}
