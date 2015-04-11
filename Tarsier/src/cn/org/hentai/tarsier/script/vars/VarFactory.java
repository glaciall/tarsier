package cn.org.hentai.tarsier.script.vars;

import java.util.HashMap;
import java.util.Iterator;

import cn.org.hentai.tarsier.script.Var;

public final class VarFactory
{
    private static VarFactory instance = null;
    private HashMap<String, Var> variables = null;
    
    private VarFactory()
    {
        variables = new HashMap<String, Var>(100);
    }
    
    private void newVar(String name, Var var)
    {
        this.variables.put(name, var);
    }
    
    private Var getVar(String name)
    {
        return this.variables.get(name);
    }
    
    private synchronized void convertVar(Var src, Var dest)
    {
        this.variables.put(src.getName(), dest);
    }
    
    private void _dump()
    {
        System.out.println("---------------------------------------");
        System.out.println("Variables: ");
        System.out.println(this.variables);
        System.out.println("---------------------------------------");
    }
    
    public static void dump()
    {
        getInstance()._dump();
    }
    
    private static synchronized VarFactory getInstance()
    {
        if (null == instance) instance = new VarFactory();
        return instance;
    }
    
    public static Var create(String name, String value)
    {
        Var var = null;
        // 字符串/布尔值/数值/null
        if (value != null)
        {
            if ("true".equals(value)) var = new JsBoolean();
            else if ("false".equals(value)) var = new JsBoolean();
            else if (value.matches("^\\-?\\d+(\\.\\d+)?$")) var = new JsNumber();
            else if (value.charAt(0) == '"') var = new JsString();
            else if (value.charAt(0) == '\'') var = new JsString();
        }
        if (null == var)
        {
            var = getInstance().getVar(name);
            if (null == var) var = new JsNull();
            var.setName(name);
            return var;
        }
        
        var.setValue(value);
        if (null != name)
        {
            getInstance().newVar(name, var);
            var.setName(name);
        }
        return var;
    }
    
    public static Var create(String name, Var var)
    {
        getInstance().newVar(name, var);
        return var;
    }
    
    public static Var get(String name)
    {
        return getInstance().getVar(name);
    }
    
    public static Var create(int value)
    {
        Var var = new JsNumber();
        var.setValue(value);
        return var;
    }
    
    public static Var create(String name)
    {
        Var var = new JsNull();
        getInstance().newVar(name, var);
        return var;
    }
    
    public static Var convert(Var src, Var dest)
    {
        getInstance().convertVar(src, dest);
        dest.setName(src.getName());
        return dest;
    }
}
