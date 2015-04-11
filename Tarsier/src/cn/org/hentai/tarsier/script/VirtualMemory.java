package cn.org.hentai.tarsier.script;

public final class VirtualMemory
{
    private static VirtualMemory instance = null;
    private static final int MEMORY_MAX_SIZE = 0xffff;      // 最大内存大小
    private byte[] data = null;
    
    private int lastAllocAddr = 0;              // 上次分配后的下一个位置
    private int lastRecycAddr = -1;             // 上次释放的位置
    
    // 分配内存，并返回变量所在地址
    public synchronized int alloc(byte type, short length)
    {
        System.err.println("Alloc: " + Var.getTypeName(type));
        
        int addr = find(type, length);
        if (addr == -1) return -1;
        
        this.data[addr] = type;
        this.data[addr + 1] = (byte)((length >> 8) & 0xff);
        this.data[addr + 2] = (byte)(length & 0xff);
        
        lastAllocAddr = addr + 3 + length;
        
        return addr;
    }
    
    // 查找可用内存块
    private int find(byte type, short length)
    {
        int addr = -1;
        // 寻找一块大小合适的空间，可以试着记录一下上一次己分配到的位置，以及上一次释放的位置
        if (lastRecycAddr != -1)
        {
            if (length <= getVarLength(lastRecycAddr))
            {
                addr = lastRecycAddr;
                lastRecycAddr = -1;
            }
        }
        if (addr != -1) return addr;
        
        // 查查剩余部分的空间有没有闲余
        for (int i = lastAllocAddr; addr == -1 && i < MEMORY_MAX_SIZE; i++)
        {
            if (i + length > MEMORY_MAX_SIZE) return -1;
            addr = i;
            break;
        }
        
        // TODO: 再不行就只能从头开始找己释放的块了
        return addr;
    }
    
    // 分配内存，赋值
    public synchronized void setValue(Var var) throws Exception
    {
        int addr = var.getAddress();
        if (-1 == addr) throw new Exception("Var doesn't allocated");
        // 如果类型变化了，需要重新分配内存
        byte type = getVarType(addr);
        short len = getVarLength(addr);
        if (type != var.getType() || len != var.getLength())
        {
            markRecycable(addr);
            addr = alloc(var.getType(), var.getLength());
            type = var.getType();
            len = var.getLength();
        }
        
        write(addr, var.toBytes());
    }
    
    // 往指定位置写入值
    private final void write(int addr, byte[] value)
    {
        System.arraycopy(value, 0, this.data, addr + 3, value.length);
    }
    
    // 标记为可回收
    private final void markRecycable(int addr)
    {
        this.data[addr] |= 0x80;
        this.lastRecycAddr = addr;
    }
    
    // 获取变量类型
    private final byte getVarType(int addr)
    {
        return (byte)(this.data[addr] & 0x7f);
    }
    
    // 获取变量长度
    private final short getVarLength(int addr)
    {
        return (short)((this.data[addr + 1] << 8) | this.data[addr + 2]);
    }
    
    // 获取变量的值
    public byte[] getValue(Var var)
    {
        int addr = var.getAddress();
        if (-1 == addr) return null;
        
        short len = getVarLength(addr);
        byte[] value = new byte[len];
        System.arraycopy(this.data, addr + 3, value, 0, len);
        return value;
    }
    
    // 内存回收
    public void gc()
    {
        // TODO: 内存回收是需要重新对所有变量值进行归整，重新安置位置的干活的
    }
    
    // 打印内存数据
    public void dump()
    {
        System.err.println("**********************************************************************");
        System.err.println("Variables in VirtualMemory");
        System.err.println();
        for (int i = 0; i < MEMORY_MAX_SIZE; )
        {
            int addr = i;
            byte type = getVarType(addr);
            short length = getVarLength(addr);
            
            if (type == Var.VAR_UNDEFINED)
            {
                System.err.println("End of VirtualMemory At: " + addr);
                break;
            }
            
            System.err.println("Type: " + Var.getTypeName(type) + ", Length: " + length);
            
            for (int k = addr + 3, l = k + length; k < l; k++)
            {
                byte d = this.data[k];
                String hex = "0" + Integer.toHexString(d).toUpperCase();
                hex = hex.replaceAll("^.*(\\w{2})$", "$1");
                System.err.print(hex);
                System.err.print("  ");
            }
            System.err.println();
            
            i += length + 3;
        }
        
        System.err.println("**********************************************************************");
    }
    
    private VirtualMemory()
    {
        this.data = new byte[MEMORY_MAX_SIZE];
    }
    
    public static synchronized VirtualMemory getInstance()
    {
        if (null == instance) instance = new VirtualMemory();
        return instance;
    }
}
