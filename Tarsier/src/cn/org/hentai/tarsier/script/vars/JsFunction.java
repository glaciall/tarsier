package cn.org.hentai.tarsier.script.vars;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Var;

public class JsFunction extends Function
{
    public boolean equals(Object val)
    {
        return false;
    }

    public int getDirection()
    {
        return 0;
    }
    
    public int getOperatorCount()
    {
        return 0;
    }

    public int getPriority()
    {
        return 0;
    }

    public Var invoke(Var vars) throws Exception
    {
        JsNumber i = new JsNumber();
        i.setValue(123);
        return i;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        
    }

    public short getLength()
    {
        return 0;
    }

    public Object getValue()
    {
        JsRef ref = new JsRef();
        ref.setValue(this);
        return ref;
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        return null;
    }
}
