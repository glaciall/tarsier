package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsObject extends Var
{
    public JsObject()
    {
        // ...
    }
    
    public byte getType()
    {
        return Var.VAR_OBJECT;
    }

    public Object getValue()
    {
        return null;
    }

    public void setValue(Object argv)
    {
        // System.err.println("Value from text: " + args[0]);
    }
    
    public boolean getBooleanValue()
    {
        return true;
    }
    
    public byte[] toBytes()
    {
        return null;
    }

    public short getLength()
    {
        return 0;
    }
}
