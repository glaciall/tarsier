package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsBoolean;
import cn.org.hentai.tarsier.script.vars.JsNumber;

public class Lt extends Operator
{
    JsBoolean rst = new JsBoolean();
    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Lt;
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

    public final Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        rst.setBooleanValue(v1.getNumberValue() < v2.getNumberValue());
        // if (111 < 222) throw new Exception(rst.toString());
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
        return super.toString("<");
    }

}
