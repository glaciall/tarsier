package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsNumber;

public class Subtract extends Operator
{
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
        return 4;
    }
    
    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        this.addParameter(expressions.remove(index - 1));
        this.addParameter(expressions.remove(index));
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        JsNumber n1 = (JsNumber)v1;
        JsNumber n2 = (JsNumber)v2;
        
        double result = (Double)n1.getValue() - (Double)n2.getValue();
        JsNumber v = new JsNumber();
        v.setValue(result);
        return v;
    }

    public short getLength()
    {
        return 0;
    }

    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Subtract;
    }
    
    public String toString()
    {
        return super.toString("-");
    }
}
