package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Function;
import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsBoolean;

public class Equals extends Operator
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
        return 7;
    }

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        JsBoolean result = new JsBoolean();
        // 如果类型不一致，直接报错吧
        if (v1.getType() != v2.getType()) throw new Exception("== 值类型不一致");
        
        // 如果是数值、boolean类型的，直接对比值就可以了
        if (v1.getType() == Var.VAR_NUMBER)
        {
            result.setBooleanValue(v1.getNumberValue() == v2.getNumberValue());
            return result;
        }
        if (v1.getType() == Var.VAR_BOOLEAN)
        {
            result.setBooleanValue(v1.getBooleanValue() == v2.getBooleanValue());
            return result;
        }
        // 如果是JsObject、JsFunction类型，直接比较Address就可以了
        if (v1.getType() == Var.VAR_OBJECT || v1.getType() == Var.VAR_ARRAY || v1.getType() == Var.VAR_FUNCTION)
        {
            result.setBooleanValue(v1.getAddress() == v2.getAddress());
            return result;
        }
        
        // 如果是JsString类型的，需要用字符串匹配
        if (v1.getType() == Var.VAR_STRING)
        {
            result.setBooleanValue(v1.getStringValue().equals(v2.getStringValue()));
        }
        
        return null;
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

    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Equals;
    }
    
    public String toString()
    {
        return super.toString("==");
    }
}
