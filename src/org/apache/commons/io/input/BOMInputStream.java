package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;

public class BOMInputStream
  extends ProxyInputStream
{
  private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator()
  {
    public int compare(ByteOrderMark paramAnonymousByteOrderMark1, ByteOrderMark paramAnonymousByteOrderMark2)
    {
      int i = paramAnonymousByteOrderMark1.length();
      int j = paramAnonymousByteOrderMark2.length();
      if (i > j) {
        return -1;
      }
      if (j > i) {
        return 1;
      }
      return 0;
    }
  };
  private final List<ByteOrderMark> boms;
  private ByteOrderMark byteOrderMark;
  private int fbIndex;
  private int fbLength;
  private int[] firstBytes;
  private final boolean include;
  private int markFbIndex;
  private boolean markedAtStart;
  
  public BOMInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, false, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
  }
  
  public BOMInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, paramBoolean, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
  }
  
  public BOMInputStream(InputStream paramInputStream, boolean paramBoolean, ByteOrderMark... paramVarArgs)
  {
    super(paramInputStream);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No BOMs specified");
    }
    include = paramBoolean;
    Arrays.sort(paramVarArgs, ByteOrderMarkLengthComparator);
    boms = Arrays.asList(paramVarArgs);
  }
  
  public BOMInputStream(InputStream paramInputStream, ByteOrderMark... paramVarArgs)
  {
    this(paramInputStream, false, paramVarArgs);
  }
  
  private ByteOrderMark find()
  {
    Iterator localIterator = boms.iterator();
    while (localIterator.hasNext())
    {
      ByteOrderMark localByteOrderMark = (ByteOrderMark)localIterator.next();
      if (matches(localByteOrderMark)) {
        return localByteOrderMark;
      }
    }
    return null;
  }
  
  private boolean matches(ByteOrderMark paramByteOrderMark)
  {
    int i = 0;
    while (i < paramByteOrderMark.length())
    {
      if (paramByteOrderMark.get(i) != firstBytes[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int readFirstBytes()
    throws IOException
  {
    getBOM();
    if (fbIndex < fbLength)
    {
      int[] arrayOfInt = firstBytes;
      int i = fbIndex;
      fbIndex = (i + 1);
      return arrayOfInt[i];
    }
    return -1;
  }
  
  public ByteOrderMark getBOM()
    throws IOException
  {
    int i;
    if (firstBytes == null)
    {
      fbLength = 0;
      firstBytes = new int[((ByteOrderMark)boms.get(0)).length()];
      i = 0;
      if (i < firstBytes.length)
      {
        firstBytes[i] = in.read();
        fbLength += 1;
        if (firstBytes[i] >= 0) {
          break label130;
        }
      }
      byteOrderMark = find();
      if ((byteOrderMark != null) && (!include))
      {
        if (byteOrderMark.length() >= firstBytes.length) {
          break label137;
        }
        fbIndex = byteOrderMark.length();
      }
    }
    for (;;)
    {
      return byteOrderMark;
      label130:
      i += 1;
      break;
      label137:
      fbLength = 0;
    }
  }
  
  public String getBOMCharsetName()
    throws IOException
  {
    getBOM();
    if (byteOrderMark == null) {
      return null;
    }
    return byteOrderMark.getCharsetName();
  }
  
  public boolean hasBOM()
    throws IOException
  {
    return getBOM() != null;
  }
  
  public boolean hasBOM(ByteOrderMark paramByteOrderMark)
    throws IOException
  {
    if (!boms.contains(paramByteOrderMark)) {
      throw new IllegalArgumentException("Stream not configure to detect " + paramByteOrderMark);
    }
    return (byteOrderMark != null) && (getBOM().equals(paramByteOrderMark));
  }
  
  /* Error */
  public void mark(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 105	org/apache/commons/io/input/BOMInputStream:fbIndex	I
    //   7: putfield 156	org/apache/commons/io/input/BOMInputStream:markFbIndex	I
    //   10: aload_0
    //   11: getfield 97	org/apache/commons/io/input/BOMInputStream:firstBytes	[I
    //   14: ifnonnull +21 -> 35
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: iload_2
    //   21: putfield 158	org/apache/commons/io/input/BOMInputStream:markedAtStart	Z
    //   24: aload_0
    //   25: getfield 115	org/apache/commons/io/input/BOMInputStream:in	Ljava/io/InputStream;
    //   28: iload_1
    //   29: invokevirtual 160	java/io/InputStream:mark	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -18 -> 19
    //   40: astore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_3
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	BOMInputStream
    //   0	45	1	paramInt	int
    //   18	19	2	bool	boolean
    //   40	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	40	finally
    //   19	32	40	finally
  }
  
  public int read()
    throws IOException
  {
    int i = readFirstBytes();
    if (i >= 0) {
      return i;
    }
    return in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int k = 0;
    int i = 0;
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = k;
    while ((j > 0) && (i >= 0))
    {
      k = readFirstBytes();
      i = k;
      if (k >= 0)
      {
        paramArrayOfByte[paramInt2] = ((byte)(k & 0xFF));
        j -= 1;
        paramInt1 += 1;
        paramInt2 += 1;
        i = k;
      }
    }
    paramInt2 = in.read(paramArrayOfByte, paramInt2, j);
    if (paramInt2 < 0)
    {
      if (paramInt1 > 0) {
        return paramInt1;
      }
      return -1;
    }
    return paramInt1 + paramInt2;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      fbIndex = markFbIndex;
      if (markedAtStart) {
        firstBytes = null;
      }
      in.reset();
      return;
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    while ((paramLong > 0L) && (readFirstBytes() >= 0)) {
      paramLong -= 1L;
    }
    return in.skip(paramLong);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.BOMInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */