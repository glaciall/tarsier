package cn.org.hentai.tarsier.script.statements;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.*;
import cn.org.hentai.tarsier.script.vars.VarFactory;

public class ForStatement extends Function
{
    @Override
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
        Var[] vars = new Var[this.parameters.size()];
        for (int i = 0; i < vars.length; i++)
        {
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
    
    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        return invoke((Object)v1, (Object)v2, (Object)v3, (Object)v4);
    }
    
    public Var invoke(Object... vars) throws Exception
    {
        // 需要4个参数
        Function initSeg = (Function)vars[0];
        if (initSeg != null) initSeg.invoke();
        
        Function ifSeg = (Function)vars[1];
        Function stepSeg = (Function)vars[2];
        
        // 第四个起，全都是表达式序列吗？？？？
        int i = 3, l = vars.length;
        for (;ifSeg.invoke().getBooleanValue(); 
            stepSeg.invoke())
        {
            for (i = 3; i < l; i++)
            {
                ((Var)vars[i]).getValue();
            }
        }
        
        return null;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        // ..
    }

    public short getLength()
    {
        return 0;
    }
}
