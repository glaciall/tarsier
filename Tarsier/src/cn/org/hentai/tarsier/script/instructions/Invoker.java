package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.statements.ForStatement;
import cn.org.hentai.tarsier.script.vars.VarFactory;

public class Invoker extends Operator
{
    private boolean filled = false;
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
        Var[] vars = new Var[this.parameters.size()];
        for (int i = 0, l = vars.length; i < l; i++)
        {
            // Var v = this.parameters.remove(l - i - 1);
            Var v = this.parameters.get(i);
            if (v.getName() != null)
            {
                v = VarFactory.get(v.getName());
                v = v == null ? this.parameters.get(i) : v;
            }
            vars[i] = v;
        }
        return this.invoke(vars);
    }

    public Var invoke(Var... vars) throws Exception
    {
        Function fn = (Function)vars[0];
        fn.clearParameters();
        for (int i = 1; i < vars.length; i++)
        {
            fn.addParameter(vars[i]);
        }
        return fn.invoke();
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        // ...
    }

    public short getLength()
    {
        return 0;
    }
    
    public String toString()
    {
        return super.toString("()");
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        // return this.invoke(v1, v2, v3, v4);
        return null;
    }
}
