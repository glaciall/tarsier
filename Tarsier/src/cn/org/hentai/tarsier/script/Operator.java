package cn.org.hentai.tarsier.script;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.vars.VarFactory;

public abstract class Operator extends Function
{
    Var[] vars = new Var[4];
    public Var getValue() throws Exception
    {
        Var rst = this.invoke();
        return rst;
    }
    
    public Var invoke() throws Exception
    {
        for (int i = 0; i < this.parameters.size(); i++)
        {
            Var v = this.parameters.get(i);
            if (null == v) continue;
            if (v instanceof Operator) v = ((Operator)v).getValue();
            if (v.getName() != null)
            {
                v = VarFactory.get(v.getName());
                v = v == null ? this.parameters.get(i) : v;
            }
            vars[i] = v;
        }
        return this.invoke(vars[0], vars[1], vars[2], vars[3]);
    }
    
    public final void setValue(Object argv)
    {
        // ...
    }
}
