package cn.org.hentai.tarsier.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import cn.org.hentai.tarsier.script.*;
import cn.org.hentai.tarsier.script.instructions.*;
import cn.org.hentai.tarsier.script.statements.*;
import cn.org.hentai.tarsier.script.vars.*;

public class Test
{
    static String[] operators = new String[]
    { 
        ".", "-", "++", "--", "!", "~", "/", "*", "%", "+", "-", "<<", ">>", ">", ">=", "<", "<=", "==",
        "!=", "&", "^", "|", "&&", "||", "?:", "=", "/=", "*=", "%=", "+=", "-=", "<<=", ">>=", "&=", "^=", "|=", ",", "{", "}", "(", ")", ";"
    };
                                    
    static String[] reservedWords = new String[]
    {
        "break", "catch", "continue", "do", "while", "for", "in", "function", "if", "else",
        "return", "this", "throw", "try", "var", "with", "delete", "typeof", "instanceof", "new"
        // catch/do/while/in/this/throw/try/with/delete/typeof/instanceof 不需要实现
        // 只实现var/for/if/else/function/return/break/continue
    };
    
    // 判断是否是运算符
    public static boolean isOperator(String op)
    {
        if ("(".equals(op)) return false;
        if (")".equals(op)) return false;
        for (int i = 0; i < operators.length; i++)
        {
            if (operators[i].equals(op)) return true;
        }
        if ("new".equals(op)) return true;
        if ("typeof".equals(op)) return true;
        if ("delete".equals(op)) return true;
        if ("instanceof".equals(op)) return true;
        if ("typeof".equals(op)) return true;
        
        return false;
    }
    
    // 判断是否是合法的语句单元
    public static boolean isLegalToken(String token)
    {
        char fchar = token.charAt(0);
        // TODO: 正则表达式？？？
        if (Character.isLetter(fchar))
        {
            // 如果首字符是字母，可能是保留字或字面量或是变量名
            // 如果是这种的话，则要求后面的每一个字符都是字母或数字或是下划线
            for (int i = 1; i < token.length(); i++)
            {
                char ch = token.charAt(i);
                if (ch == '_') continue;
                if (!Character.isLetterOrDigit(ch)) return false;
            }
            return true;
        }
        else if (Character.isDigit(fchar))
        {
            // 如果是数字的话，要包含上小数点
            // 暂时就不鼓捣十六进制这种逆天的东西了
            boolean hasDot = false;
            for (int i = 1; i < token.length(); i++)
            {
                char ch = token.charAt(i);
                if (ch == '.' && !hasDot)
                {
                    hasDot = true;
                    continue;
                }
                if (!Character.isDigit(ch)) return false;
            }
            return true;
        }
        else if (fchar == '\'')
        {
            // 可能是单引号包起来的字符串
            return token.charAt(token.length() - 1) == '\'';
        }
        else if (fchar == '"')
        {
            // 可能是双引号包起来的字符串
            return token.charAt(token.length() - 1) == '"';
        }
        else
        {
            // 如果是运算符，则看看是不是还是一个合法的运算符
            for (int i = 0; i < operators.length; i++)
            {
                if (token.equals(operators[i])) return true;
            }
            return false;
        }
    }

    // 测试方法
    public static void main(String[] args) throws Exception
    {
        // TODO: 负号怎么处理？
        String script = "var iaaaa = (3 + (3 + 1 * (7 * 9))) * 7 * 5;var s = 0;";
        // script = "var i = 'aaaaaaaaaaa';";
        script += "for (var i = 0; i < 100; i++)";
        script += "{";
        script += "     s += i;";
        script += "     if (s ==                100) break;";
        script += "     else if (s > 50) continue;";
        script += "     (function(){ return s * s; })();";
        script += "}";
        script += "window.alert(s);";
        // script = "var s = 'aaaaa*&)#)*@)(*)(@aaa\"aaa             aaa';";
        // script = "var i = a(1, a(2) + 3);";
        // script = "var i = 1 + 3 - 4 * 5 + 3;";
        // script = "for (var i = 0; i < 100 && i > 1; i = i + 1) { i = i; }";
        script = "var s = 0;";
        script += "for (var i = 0; i < 100; i++) { s += i; }";
        script += "debug(s);";
        // script = "var s = 1 < 3;";
        // script = "debug(112233, 1222, 3333, 4444, 5555, 'aaaaaaaa');";
        
        try
        {
            // 分割为token块
            // 按语句拆分为函数调用序列
            ArrayList<Var> statements = toStatements(toTokens(script));
            
            JsFunction debug = new cn.org.hentai.tarsier.script.builtin.Debug();
            VarFactory.create("debug", debug);
            
            long time = System.nanoTime();
            for (int i = 0; i < statements.size(); i++)
            {
                System.out.println("Statement[" + i + "]:----------------------------------------------- ");
                System.out.println(statements.get(i));
                statements.get(i).getValue();
                // System.out.println("Statement[" + i + "]: " + rst);
            }
            time = (System.nanoTime() - time) / 1000;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            
            Var s = VarFactory.get("s");
            System.out.println(s);
            System.out.println(s.getBooleanValue());
            System.out.println(s.getNumberValue());
            System.out.println("Spend: " + (time / 1000) + " ms");
            
            // TODO: 运算符需要重组，以避免-号匹配不正确的问题，暂时先不鼓捣
            // function语句，参数怎么处理？相当于var，但是又不是特别相似
        }
        catch(Exception ex)
        {
            ex.printStackTrace(System.out);
            // VirtualMemory.getInstance().dump();
        }
    }
    
    // 把脚本源码转为token序列
    public static ArrayList<String> toTokens(String script) throws Exception
    {
        ArrayList<String> tokens = new ArrayList<String>();
        String token = "";
        
        int tLen = 0, wLen = 0;
        int maxLength = 256;
        for (int i = 0, l = script.length(); i < l; i += (tLen == 0 ? 1 : tLen))
        {
            // 依无意义的空格、换行及运算符进行分割
            // 字母或数字就一直连，直到非字母及数字为止
            // 运算符按最大匹配法连
            wLen = 0;
            tLen = 0;
            token = "";
            int k = i + 1, o = i + maxLength;
            o = o > l ? l : o;

            for (; k <= o; k++)
            {
                String word = script.substring(i, k);
                wLen = k - i;
                // 如果是合法的TOKEN
                if (isLegalToken(word))
                {
                    tLen = wLen;
                    token = word;
                }
            }
            if (tLen > 0) tokens.add(token);
        }
        return tokens;
    }
    
    // 把token序列转为语句单元
    public static ArrayList<Var> toStatements(ArrayList<String> tokens) throws Exception
    {
        String token = null;
        ArrayList<Var> statements = new ArrayList<Var>();
        ArrayList<Function> expressions = null;
        for (int i = 0; i < tokens.size(); )
        {
            int type = 0;
            int skipStatements = -1;
            boolean isEnd = false;
            boolean isBlock = false;
            Stack blocks = new Stack();
            String flag = null;
            ArrayList<String> statement = new ArrayList<String>();;
            while (!isEnd)
            {
                token = tokens.get(i++);
                if ("for".equals(token)) skipStatements = 3;
                if (skipStatements == -1) skipStatements = 1;
                if (null == flag) flag = token;
                
                if ("{".equals(token))
                {
                    isBlock = true;
                    blocks.push(token);
                }
                if ("}".equals(token)) blocks.pop();
                
                statement.add(token);
                
                if (";".equals(token)) skipStatements -= 1;
                if (!isBlock && ";".equals(token) && skipStatements == 0)
                {
                    isEnd = true;
                    break;
                }
                
                if (isBlock && blocks.isEmpty())
                {
                    isEnd = true;
                    break;
                }
            }
            // statements.add(statement);
            // 这里应该交给语句处理器处理
            // TODO: 如果有空的;如何处置？
            statements.add(toExpression(statement));
        }
        return statements;
    }
    
    // 把语句单元转为函数表达式
    public static Function toExpression(ArrayList<String> statement) throws Exception
    {
        int i = 0;
        String token = statement.get(0);
        Stack brackets = new Stack();
        Function expression = null;
        if ("if".equals(token))
        {
            // 条件判断语句
            // TODO: 需要生成ConditionStatement的Invoker包装
            // TODO: 要不要把那些都包装成Invoker的包装
            // expression = new Invoker();
            // expression.addParameter(new ConditionStatement());
            expression = new ConditionStatement();
            // 获取条件判断部分
            for (i = 1; i < statement.size(); i++)
            {
                token = statement.get(i);
                
                if ("(".equals(token)) brackets.push('(');
                if (")".equals(token)) brackets.pop();
                
                if (brackets.isEmpty())
                {
                    expression.addParameter(parse(statement.subList(2, i)).get(0));
                    break;
                }
            }
            
            i++;
            
            // 去掉{}？？？
            if (statement.get(i).equals("{"))
            {
                statement.remove(statement.size() - 1);
                statement.remove(i);
            }
            
            // 再对语句组进行处理，加到它的参数里来
            ArrayList<String> sub = new ArrayList<String>();
            for (int s = i; s < statement.size(); s++)
                sub.add(statement.get(s));
            ArrayList<Var> statements = toStatements(sub);
            for (int s = 0; s < statements.size(); s++)
                expression.addParameter(statements.get(s));
        }
        else if ("else".equals(token))
        {
            // 条件分支语句
            // TODO: 这TM先不整，闹心
        }
        else if ("for".equals(token))
        {
            // 循环语句
            // 对语句进行重组，然后对每一块再做一次这个事情
            // TODO: 需要生成ForStatement的Invoker包装
            // TODO: 循环体内的break和continue还有return如何处理？
            
            // 第一组：初始化，只运行一次
            // 第二组：条件语句，直到取值为false为止
            // 第三组：递增语句，直到循环结束为止
            // 第四组：循环体，有break、continue和return的可能性
            // 先建立Invoker
            // expression = new Invoker();
            // expression.addParameter(new ForStatement());
            expression = new ForStatement();
            
            // 先把前三组弄出来再说吧
            int sIdx = 2;
            int nops = 0;
            for (i = 1; i < statement.size(); i++)
            {
                token = statement.get(i);
                
                if ("(".equals(token)) brackets.push('(');
                if (")".equals(token)) brackets.pop();
                
                if (";".equals(token))
                {
                    expression.addParameter(parse(statement.subList(sIdx, i)).get(0));
                    sIdx = i + nops++;
                    continue;
                }
                
                if (brackets.isEmpty())
                {
                    expression.addParameter(parse(statement.subList(sIdx, i)).get(0));
                    break;
                }
            }
            
            // 处理第四组的语句块，如果有{}的话，先脱个壳
            ArrayList<String> blocks = new ArrayList<String>();
            int l = statement.size();
            for (i++; i < l; i++)
            {
                token = statement.get(i);
                if (blocks.size() == 0 && "{".equals(token)) continue;
                if (i  == l - 1 && "}".equals(token)) continue;
                blocks.add(token);
            }
            ArrayList<Var> subStatements = toStatements(blocks);
            for (i = 0; i < subStatements.size(); i++)
            {
                expression.addParameter(subStatements.get(i));
            }
        }
        else if ("function".equals(token))
        {
            // 函数声明语句，只属于稍稍特殊一点的声明
            // 参数、局部变量等如何处理？
            // 匿名函数如何处理？
        }
        else if ("var".equals(token))
        {
            // 对运算符进行排序，让运算符去把语句都拿走
            statement.remove(statement.size() - 1);
            expression = (Function)parse(statement).get(0);
        }
        else
        {
            // 普通变量声明、函数调用语句
            statement.remove(statement.size() - 1);
            expression = (Function)parse(statement).get(0);
        }
        return expression;
    }
    
    // 普通表达式解析
    public static ArrayList<Var> parse(List<String> statement) throws Exception
    {
        // System.out.println("*******************************************************************");
        // System.out.println("Sub Statements: ");
        // System.out.println(statement);
        // System.out.println("*******************************************************************");
        
        if ("var".equals(statement.get(0))) statement.remove(0);
        
        ArrayList<String> operators = new ArrayList<String>();
        
        // 创建运算符集合
        Stack brackets = new Stack();
        Stack range = new Stack();
        
        boolean isBracket = false;
        boolean isOperator = true;              // 一开头就写括号的就是范围限定符，肯定不是函数调用
        ArrayList<String> mergedStatement = new ArrayList<String>();
        // 返回的function是最后一个要进行计算的function
        Function result = null;
        
        ArrayList<Var> expressions = new ArrayList<Var>();
        ArrayList<Function> instructs = new ArrayList<Function>();
        
        // 根据[]()进行语句重组
        for (int i = 0, s = 0; i < statement.size(); )
        {
            // 什么样的算调用运算符，什么样的算是括号呢？
            // ()[]属于范围限定符吧，不过()有时候属于调用
            // 什么情况下属于调用呢？当前面一个token为运算符时，它才属于范围限定符
            // TODO: 我艹，这个括号的定义不正确，应该是当前的东西是值是，它是调用，否则为括号
            s = i;
            String token = statement.get(i++);
            Var exp = null;
            // TODO: 正确的作法应该是如果前一个是值，那这个就是调用
            if (isOperator && "(".equals(token))
            {
                // 找到范围限定符了，这时候怎么做呢？
                // 要对这个括号进行取值，那就是要计算这个括号内的表达式的值
                // 那这里就需要找到后面的结束括号才行了，然后对这个子串，再执行一次parse方法，爽
                brackets.push('(');
                while (!brackets.isEmpty())
                {
                    token = statement.get(i++);
                    if ("(".equals(token)) brackets.push('(');
                    if (")".equals(token)) brackets.pop();
                }
                exp = parse(statement.subList(s + 1, i - 1)).get(0);
            }
            
            // 处理函数调用
            if (!isOperator && "(".equals(token))
            {
                // 括号内的是参数分组，以逗号分开的
                brackets.push('(');
                while (!brackets.isEmpty())
                {
                    // if (i >= statement.size()) break;
                    token = statement.get(i++);
                    if ("(".equals(token)) brackets.push('(');
                    if (")".equals(token)) brackets.pop();
                }
                // 把上一个弄下来作为主体，再往里面加参数
                exp = new Invoker();
                System.out.println(expressions);
                Function fn = (Function)expressions.remove(expressions.size() - 1);
                ((Function)exp).addParameter(fn);
                ArrayList<String> paramExp = new ArrayList<String>();
                brackets.push('(');
                for (int x = s + 1, ps = i - 1; x <= ps; x++)
                {
                    // parameters.add(statement.get(x));
                    String param = statement.get(x);
                    // 碰到逗号，就把前面的表达式加到参数里去
                    // TODO: 怎么样确定括号的范围？？？？
                    // fn.addParameters(parse(param));
                    if ("(".equals(param))
                    {
                        brackets.push('(');
                        paramExp.add("(");
                        continue;
                    }
                    if (")".equals(param)) brackets.pop();
                    if (!",".equals(param) && !brackets.isEmpty())
                    {
                        paramExp.add(statement.get(x));
                    }
                    if (",".equals(param) || brackets.isEmpty())
                    {
                        if (paramExp.size() > 0) ((Function)exp).addParameter(parse(paramExp).get(0));
                        paramExp.clear();
                        continue;
                    }
                }
            }
            
            // 现在处理[]？？？
            if ("[".equals(token))
            {
                range.push('[');
                while (!range.isEmpty())
                {
                    token = statement.get(i++);
                    if ("[".equals(token)) range.push('[');
                    if ("]".equals(token)) range.pop();
                }
                exp = parse(statement.subList(s + 1, i - 1)).get(0);
            }
            
            isOperator = isOperator(token);
            // if (exp instanceof Function) isOperator = false;        // TODO: 这里解决掉了()的识别问题了吗？
            if (isOperator)
            {
                instructs.add(OperatorFactory.toInstruction(token));
                expressions.add(OperatorFactory.toInstruction(token));
            }
            else if (exp != null)
            {
                expressions.add(exp);
            }
            else
            {
                // 字面量，数字、true/false、null、字符串等
                // 变量名
                String expName = token;
                String expValue = null;
                if (token.matches("^(\\-?\\d+(\\.\\d+)?)|(true|false)|(null)|(('|\").*)$"))
                {
                    expName = null;
                    expValue = token;
                }
                exp = VarFactory.create(expName, expValue);
                expressions.add(exp);
            }
        }
        
        Function[] ops = instructs.toArray(new Function[0]);
        Arrays.sort(ops, new Comparator<Function>()
        {
            public int compare(Function f1, Function f2)
            {
                return f1.getPriority() - f2.getPriority();
            }
        });
        
        // 根据优先级排序，让运算符去取运算因子
        for (int i = 0; i < ops.length; i++)
        {
            if (null == result) result = ops[i];
            
            // 从优先级最高的开始
            // 语句里的表达式要合并起来
            // 处理掉一个运算符，就需要把它变成函数
            // 这个函数将作为新的函数的引用值
            // 最终一个表达式变成一个函数调用
            // 如果有逗号的话，那就是多条语句，也就应该是有多个函数结果
            
            for (int k = 0; k < expressions.size(); k++)
            {
                // 去掉表达式里第一个这个啥啥啥号
                Var var = expressions.get(k);
                if (!var.equals(ops[i])) continue;
                // System.out.println("Found At: " + k);
                // 把自己及参数删掉，转为函数调用
                // 自己的位置是k
                // 参数的位置依据var的方向及参数数量来定
                Function op = (Function)var;
                // TODO: ++这种运算符，要根据前后的表达式的值来决定取前一个还是后一个
                op.reform(k, expressions);
                break;
            }
        }
        
        return expressions;
    }
}

