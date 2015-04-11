package cn.org.hentai.tarsier.script.instructions;

import java.util.ArrayList;

import cn.org.hentai.tarsier.script.*;
import cn.org.hentai.tarsier.script.vars.VarFactory;

public class Assign extends Operator
{
    private Object value = null;
    public synchronized Var invoke(Var v1, Var v2, Var v3, Var v4) throws Exception
    {
        Var dest = VarFactory.convert(v1, v2);
        dest.setAddress(v1.getAddress());
        /*
        // dest.setValue(vars[1].getValue());
        int addr = dest.getAddress();
        VirtualMemory vm = VirtualMemory.getInstance();
        if (addr == -1) addr = vm.alloc(dest.getType(), dest.getLength());
        if (-1 == addr) throw new Exception("Memory overflow");
        dest.setAddress(addr);
        vm.setValue(dest);
        */
        this.value = dest.getValue();
        return dest;
    }
    
    public void reform(int index, ArrayList<Var> expressions) throws Exception
    {
        this.addParameter(expressions.remove(index - 1));
        this.addParameter(expressions.remove(index));
    }

    public int getOperatorCount()
    {
        return 2;
    }

    public short getLength()
    {
        return 0;
    }

    public int getDirection()
    {
        return Function.DIR_RTL;
    }

    public int getPriority()
    {
        return 14;
    }
    
    public boolean equals(Object val)
    {
        if (this.hasParameters()) return false;
        return val instanceof Assign;
    }
    
    public String toString()
    {
        return super.toString("=");
    }
}
