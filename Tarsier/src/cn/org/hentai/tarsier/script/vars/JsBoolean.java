package cn.org.hentai.tarsier.script.vars;

import cn.org.hentai.tarsier.script.Var;

public class JsBoolean extends Var
{
    private boolean value;
    
    public JsBoolean()
    {
        // ...
    }
    
    public byte getType()
    {
        return Var.VAR_BOOLEAN;
    }

    public Object getValue()
    {
        return value;
    }
    
    public void setBooleanValue(boolean bool)
    {
        this.value = bool;
    }

    public void setValue(Object argv)
    {
        if (argv instanceof Boolean) this.value = (Boolean)argv;
        else this.value = "true".equals(argv);
    }
    
    public boolean getBooleanValue()
    {
        return this.value;
    }

    public byte[] toBytes()
    {
        return new byte[] { (byte) (this.value ? 0x01 : 0x00) };
    }

    public short getLength()
    {
        return 1;
    }
}
