package cn.org.hentai.tarsier.script;

import java.util.ArrayList;

public abstract class Statement
{
    public abstract Function toInstructions() throws Exception;
}
