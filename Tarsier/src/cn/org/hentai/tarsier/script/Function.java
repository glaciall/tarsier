package cn.org.hentai.tarsier.script;

import java.util.ArrayList;
import cn.org.hentai.tarsier.script.vars.*;
import cn.org.hentai.tarsier.script.vars.VarFactory;

public abstract class Function extends Var
{
    public static final int DIR_LTR = 0x01;
    public static final int DIR_RTL = 0x02;
    
    protected ArrayList<Var> parameters = new ArrayList<Var>();
    
    public Function addParameters(Var v1, Var v2)
    {
        this.parameters.add(v1);
        this.parameters.add(v2);
        return this;
    }
    
    public Function addParameter(Var var)
    {
        this.parameters.add(var);
        return this;
    }
    
    public void clearParameters()
    {
        this.parameters.clear();
    }
    
    public Var invoke() throws Exception
    {
        Var[] vars = new Var[this.parameters.size()];
        for (int i = 0; i < vars.length; i++)
        {
            Var v = this.parameters.get(i);
            if (v instanceof Operator) v = ((Operator)v).getValue();
            if (v.getName() != null)
            {
                v = VarFactory.get(v.getName());
                v = v == null ? this.parameters.get(i) : v;
            }
            vars[i] = v;
        }
        return this.invoke(vars);
    }
    
    public final boolean hasParameters()
    {
        return this.parameters.size() > 0;
    }
    
    public abstract Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception;
    public Var invoke(Object... vars) throws Exception
    {
        return null;
    }
    public abstract int getPriority();
    public abstract int getDirection();
    public abstract int getOperatorCount();
    public abstract void reform(int index, ArrayList<Var> expressions) throws Exception;
    
    public boolean getBooleanValue()
    {
        return true;
    }
    
    public byte getType()
    {
        return Var.VAR_FUNCTION;
    }
    
    public final void setValue(Object... value)
    {
        // ...
    }
    
    public String toString()
    {
        return this.toString(null);
    }
    
    public String toString(String operator)
    {
        String result = (null == operator ? this.getClass().getSimpleName() : operator) + " : {";
        for (int i = 0; i < parameters.size(); i++)
        {
            result += i + " : " + parameters.get(i) + ", ";
        }
        result += "}";
        return result;
    }
    
    public void setValue(Object argv)
    {
        // ...
    }
    
    public Object getValue() throws Exception
    {
        return null;
    }
    
    public byte[] toBytes()
    {
        return null;
    }
    
    public abstract boolean equals(Object val);
}
