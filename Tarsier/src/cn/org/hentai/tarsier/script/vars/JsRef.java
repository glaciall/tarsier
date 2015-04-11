package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsRef extends Var
{
    public boolean getBooleanValue()
    {
        return true;
    }

    public short getLength()
    {
        // 类别、长度、目标地址
        return 0;
    }

    public byte getType()
    {
        return Var.VAR_REFERENCE;
    }

    public Object getValue() throws Exception
    {
        return null;
    }

    public void setValue(Object args)
    {
        
    }

    public byte[] toBytes()
    {
        return null;
    }
}
