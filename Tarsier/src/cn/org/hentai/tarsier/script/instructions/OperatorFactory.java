package cn.org.hentai.tarsier.script.instructions;

import cn.org.hentai.tarsier.script.*;
import cn.org.hentai.tarsier.script.instructions.*;

public final class OperatorFactory
{
    public static Function toInstruction(String operator) throws Exception
    {
        if ("+".equals(operator)) return new Add();
        if ("=".equals(operator)) return new Assign();
        if ("%".equals(operator)) return new Mod();
        if ("*".equals(operator)) return new Multiply();
        if ("-".equals(operator)) return new Subtract();
        if (">".equals(operator)) return new Gt();
        if ("<".equals(operator)) return new Lt();
        if (">=".equals(operator)) return new Get();
        if ("<=".equals(operator)) return new Let();
        if ("&&".equals(operator)) return new And();
        if ("||".equals(operator)) return new Or();
        if ("!".equals(operator)) return new Not();
        if ("++".equals(operator)) return new SelfInc();
        if ("+=".equals(operator)) return new AddNAssign();
        if ("new".equals(operator)) return new New();
        throw new Exception("Unsupported Operator: " + operator);
    }
}
