package cn.org.hentai.tarsier.script;

import java.util.ArrayList;

public abstract class Expression
{
    public abstract ArrayList<Function> toInstructions();
}
