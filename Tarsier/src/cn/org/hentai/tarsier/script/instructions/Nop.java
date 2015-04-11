package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.Operator;
import cn.org.hentai.tarsier.script.Var;

// 什么都不做的函数，等同于;
public class Nop extends Operator
{
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

    public Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        return null;
    }

    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        
    }

    public short getLength()
    {
        return 0;
    }

    public String toString()
    {
        return super.toString(";");
    }
}
