package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsNumber;

public class SelfInc extends Operator
{
    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof SelfInc;
    }

    public int getDirection()
    {
        return Function.DIR_LTR;
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
        v1.setNumberValue(v1.getNumberValue() + 1);
        return v1;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        Var var = expressions.get(index - 1);
        if (var.getName() != null)
        {
            expressions.remove(index - 1);
            this.addParameter(var);
        }
        else
        {
            var = expressions.get(index + 1);
            if (var.getName() == null) throw new Exception("++ 运算符未找到变量表达式");
            expressions.remove(index + 1);
            this.addParameter(var);
        }
    }

    public short getLength()
    {
        return 0;
    }
    
    public String toString()
    {
        return super.toString("++");
    }
}
