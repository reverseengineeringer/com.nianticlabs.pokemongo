package org.apache.commons.io.filefilter;

import java.io.Serializable;

public class MagicNumberFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -547733176983104172L;
  private final long byteOffset;
  private final byte[] magicNumbers;
  
  public MagicNumberFileFilter(String paramString)
  {
    this(paramString, 0L);
  }
  
  public MagicNumberFileFilter(String paramString, long paramLong)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The magic number cannot be null");
    }
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("The offset cannot be negative");
    }
    magicNumbers = paramString.getBytes();
    byteOffset = paramLong;
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0L);
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("The magic number cannot be null");
    }
    if (paramArrayOfByte.length == 0) {
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("The offset cannot be negative");
    }
    magicNumbers = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, magicNumbers, 0, paramArrayOfByte.length);
    byteOffset = paramLong;
  }
  
  /* Error */
  public boolean accept(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +73 -> 74
    //   4: aload_1
    //   5: invokevirtual 66	java/io/File:isFile	()Z
    //   8: ifeq +66 -> 74
    //   11: aload_1
    //   12: invokevirtual 69	java/io/File:canRead	()Z
    //   15: ifeq +59 -> 74
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: aload_0
    //   25: getfield 44	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   28: arraylength
    //   29: newarray <illegal type>
    //   31: astore 7
    //   33: new 71	java/io/RandomAccessFile
    //   36: dup
    //   37: aload_1
    //   38: ldc 73
    //   40: invokespecial 76	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 46	org/apache/commons/io/filefilter/MagicNumberFileFilter:byteOffset	J
    //   49: invokevirtual 80	java/io/RandomAccessFile:seek	(J)V
    //   52: aload_1
    //   53: aload 7
    //   55: invokevirtual 84	java/io/RandomAccessFile:read	([B)I
    //   58: istore_2
    //   59: aload_0
    //   60: getfield 44	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   63: arraylength
    //   64: istore_3
    //   65: iload_2
    //   66: iload_3
    //   67: if_icmpeq +9 -> 76
    //   70: aload_1
    //   71: invokestatic 90	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_0
    //   77: getfield 44	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   80: aload 7
    //   82: invokestatic 96	java/util/Arrays:equals	([B[B)Z
    //   85: istore 4
    //   87: aload_1
    //   88: invokestatic 90	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   91: iload 4
    //   93: ireturn
    //   94: astore_1
    //   95: aload 5
    //   97: astore_1
    //   98: aload_1
    //   99: invokestatic 90	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore 5
    //   106: aload 6
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 90	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   113: aload 5
    //   115: athrow
    //   116: astore 5
    //   118: goto -9 -> 109
    //   121: astore 5
    //   123: goto -25 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	MagicNumberFileFilter
    //   0	126	1	paramFile	java.io.File
    //   58	10	2	i	int
    //   64	4	3	j	int
    //   85	7	4	bool	boolean
    //   22	74	5	localObject1	Object
    //   104	10	5	localObject2	Object
    //   116	1	5	localObject3	Object
    //   121	1	5	localIOException	java.io.IOException
    //   19	88	6	localObject4	Object
    //   31	50	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	44	94	java/io/IOException
    //   24	44	104	finally
    //   44	65	116	finally
    //   76	87	116	finally
    //   44	65	121	java/io/IOException
    //   76	87	121	java/io/IOException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(new String(magicNumbers));
    localStringBuilder.append(",");
    localStringBuilder.append(byteOffset);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.MagicNumberFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */