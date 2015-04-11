package cn.org.hentai.tarsier.script.statements;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsBoolean;
import cn.org.hentai.tarsier.script.vars.VarFactory;

public class ConditionStatement extends Function
{
    Var[] vars = new Var[4];
    public Var getValue() throws Exception
    {
        return this.invoke();
    }
    
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
    
    public Var invoke() throws Exception
    {
        for (int i = 0; i < this.parameters.size(); i++)
        {
            Var v = this.parameters.get(i);
            if (v.getName() != null)
            {
                v = VarFactory.get(v.getName());
                v = v == null ? this.parameters.get(i) : v;
            }
            vars[i] = v;
        }
        return this.invoke(vars[0], vars[1], vars[2], vars[3]);
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        boolean condition = ((Var)v1.getValue()).getBooleanValue();
        if (condition) v2.getValue();
        return null;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        // do nothing here
    }

    public short getLength()
    {
        return 0;
    }

}
