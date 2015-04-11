package cn.org.hentai.tarsier.script.builtin;

import cn.org.hentai.tarsier.script.Var;
import cn.org.hentai.tarsier.script.vars.JsFunction;

public class Debug extends JsFunction
{
    public Var invoke(Object... vars) throws Exception
    {
        for (int i = 0; i < vars.length; i++)
        {
            Var var = (Var)vars[i];
            if (var == null) System.err.println(var);
            if (var.getType() == Var.VAR_NUMBER)
                System.err.println(var.getNumberValue());
            else if (var.getType() == Var.VAR_STRING)
                System.err.println(var.getStringValue());
            else if (var.getType() == Var.VAR_BOOLEAN)
                System.err.println(var.getBooleanValue());
            else System.err.println(vars[i]);
        }
        return null;
    }
}
