package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsBoolean;
import cn.org.hentai.tarsier.script.vars.JsNumber;

public class Get extends Operator
{
    JsBoolean rst = new JsBoolean();
    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Get;
    }

    public int getDirection()
    {
        return Function.DIR_LTR;
    }

    public int getOperatorCount()
    {
        return 2;
    }

    public int getPriority()
    {
        return 6;
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        JsNumber n1 = (JsNumber)v1;
        JsNumber n2 = (JsNumber)v2;
        
        rst.setBooleanValue(n1.getNumberValue() >= n2.getNumberValue());
        
        return rst;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        this.addParameter(expressions.remove(index - 1));
        this.addParameter(expressions.remove(index));
    }

    public short getLength()
    {
        return 0;
    }

    public String toString()
    {
        return super.toString(">=");
    }
    
}
