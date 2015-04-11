package cn.org.hentai.tarsier.script.statements;

import cn.org.hentai.tarsier.script.Statement;

public final class StatementFactory
{
    public static Statement parse(String code)
    {
        // System.out.println("Statement: " + code);
        // if (code.startsWith("var ")) return new DeclareStatement(code);
        // if (code.startsWith("{")) return new FuncDeclareStatement(code);
        // if (code.matches("^for\\s*\\(.*")) return new ForStatement(code);
        // if (code.matches("^function\\s+\\w+.*")) return new FuncDeclareStatement(code);
        // if (code.matches("^function\\(.*$")) return new FuncDeclareStatement(code);
        // return new InvokeStatement(code);
        return null;
    }
}
