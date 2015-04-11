package cn.org.hentai.tarsier.script.vars;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Var;

public class JsArray extends JsObject
{
    private short length = 0;
    private ArrayList<Var> items = null;
    
    public JsArray()
    {
        this.items = new ArrayList<Var>();
    }
    
    public byte getType()
    {
        return Var.VAR_ARRAY;
    }

    public Object getValue()
    {
        return null;
    }

    public void setValue(Object args)
    {
        
    }
    
    public boolean getBooleanValue()
    {
        return this.length > 0;
    }

    public byte[] toBytes()
    {
        return null;
    }

    public short getLength()
    {
        return this.length;
    }
}
