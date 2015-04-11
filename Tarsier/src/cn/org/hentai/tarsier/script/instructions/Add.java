package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsNumber;

public class Add extends Operator
{
    JsNumber result = new JsNumber();
    public int getDirection()
    {
        return Function.DIR_LTR;
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
        // TODO: 如果两个参数里，任何一个是字符串呢？艹艹艹艹艹
        result.setNumberValue(v1.getNumberValue() + v2.getNumberValue());
        return result;
    }
    
    public int getOperatorCount()
    {
        return 2;
    }

    public short getLength()
    {
        return 0;
    }

    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Add;
    }
    
    public String toString()
    {
        return super.toString("+");
    }
}
