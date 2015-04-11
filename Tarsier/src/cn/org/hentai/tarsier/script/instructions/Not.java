package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsBoolean;

public class Not extends Operator
{
    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Not;
    }

    public int getDirection()
    {
        return Function.DIR_RTL;
    }

    public int getOperatorCount()
    {
        return 1;
    }

    public int getPriority()
    {
        return 2;
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        JsBoolean rst = new JsBoolean();
        rst.setValue(!v1.getBooleanValue());
        return rst;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        this.addParameter(expressions.remove(index + 1));
    }

    public short getLength()
    {
        return 0;
    }
    
    public String toString()
    {
        return super.toString("!");
    }
}
