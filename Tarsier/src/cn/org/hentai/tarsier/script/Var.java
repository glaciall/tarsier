package cn.org.hentai.tarsier.script;

public abstract class Var
{
    public static final byte VAR_UNDEFINED = 0x00;
    public static final byte VAR_NUMBER = 0x01;
    public static final byte VAR_STRING = 0x02;
    public static final byte VAR_BOOLEAN = 0x03;
    public static final byte VAR_NULL = 0x04;
    public static final byte VAR_OBJECT = 0x05;
    public static final byte VAR_ARRAY = 0x06;
    public static final byte VAR_FUNCTION = 0x07;
    public static final byte VAR_REFERENCE = 0x08;
    
    private int address = -1;
    private String name = null;
    
    public final int getAddress()
    {
        return address;
    }
    
    public final void setAddress(int addr)
    {
        this.address = addr;
    }
    
    public final String getName()
    {
        return this.name;
    }
    
    public final void setName(String name)
    {
        this.name = name;
    }
    
    public abstract byte getType();
    
    public abstract void setValue(Object arg);
    
    public abstract Object getValue() throws Exception;
    public abstract short getLength();
    public abstract boolean getBooleanValue();
    public double getNumberValue()
    {
        return 0.0d;
    }
    public void setNumberValue(double val)
    {
        // ...
    }
    public String getStringValue()
    {
        return null;
    }
    
    public abstract byte[] toBytes();
    
    public static final String getTypeName(byte type)
    {
        if (type == VAR_NUMBER) return "Number";
        else if (type == VAR_STRING) return "String";
        else if (type == VAR_BOOLEAN) return "Boolean";
        else if (type == VAR_NULL) return "Null";
        else if (type == VAR_OBJECT) return "Object";
        else if (type == VAR_ARRAY) return "Array";
        else if (type == VAR_FUNCTION) return "Function";
        else return "Undefined";
    }
    
    public String toString()
    {
        return this.getClass().getSimpleName() + "[" + this.name + "]";
    }
}
