package cn.org.hentai.tarsier.script;

import java.util.ArrayList;
import java.util.Stack;

import cn.org.hentai.tarsier.script.statements.StatementFactory;

public class Scripting
{
    public static ArrayList<Statement> explain(String code)
    {
        // foreach lines
        //      convert statements to expressions
        //      foreach expressions
        //          convert expressions to functions
        // 什么行？
        // 以;号结束为一行
        // 如果有{出现，则以下一个}为结束点
        
        ArrayList<Statement> statements = new ArrayList<Statement>(50);
        
        Stack stack = new Stack();
        boolean isValid = true;
        StringBuilder line = new StringBuilder(4096);
        for (int i = 0, l = code.length(); i < l; i++)
        {
            char ch = code.charAt(i);
            line.append(ch);
            if (isValid && ch == '{')
            {
                stack.push('{');
            }
            if (isValid && ch == '}')
            {
                stack.pop();
                if (stack.isEmpty())
                {
                    System.out.println(line.toString());
                    statements.add(StatementFactory.parse(line.toString()));
                    line.delete(0, 4096);
                }
            }
            
            if (isValid && ch == ';' && stack.isEmpty())
            {
                System.out.println(line.toString());
                statements.add(StatementFactory.parse(line.toString()));
                line.delete(0, 4096);
                continue;
            }
            
            // TODO: 这样子的话，就不能支持在单引号里嵌双引号这种逆天的事情了，先暂时不弄吧
            if (ch == '"' || ch == '\'') isValid = !isValid;
        }
        
        return statements;
    }
}
