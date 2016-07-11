package crittercism.android;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class bs
{
  public final File a;
  public String b;
  public List c;
  private cj d;
  private int e;
  private int f;
  private int g;
  private a h;
  private boolean i = false;
  
  public bs(Context paramContext, br parambr)
  {
    this(new File(paramContext.getFilesDir().getAbsolutePath() + "//com.crittercism//" + str), parambr.c(), parambr.d(), parambr.e(), parambr.b(), parambr.f());
  }
  
  private bs(File paramFile, a parama, cj paramcj, int paramInt1, int paramInt2, String paramString)
  {
    h = parama;
    d = paramcj;
    g = paramInt1;
    f = paramInt2;
    b = paramString;
    a = paramFile;
    paramFile.mkdirs();
    d();
    e = h().length;
    c = new LinkedList();
  }
  
  /* Error */
  private boolean c(ch paramch)
  {
    // Byte code:
    //   0: new 31	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 89	crittercism/android/bs:a	Ljava/io/File;
    //   8: aload_1
    //   9: invokeinterface 114 1 0
    //   14: invokespecial 117	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_2
    //   21: new 119	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 121	java/io/FileOutputStream
    //   28: dup
    //   29: aload 4
    //   31: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_1
    //   41: aload_2
    //   42: invokeinterface 129 2 0
    //   47: aload_2
    //   48: invokevirtual 134	java/io/OutputStream:close	()V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_3
    //   54: new 33	java/lang/StringBuilder
    //   57: dup
    //   58: ldc -120
    //   60: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 4
    //   65: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: invokestatic 144	crittercism/android/dx:a	()V
    //   72: goto -32 -> 40
    //   75: astore_1
    //   76: aload 4
    //   78: invokevirtual 147	java/io/File:delete	()Z
    //   81: pop
    //   82: new 33	java/lang/StringBuilder
    //   85: dup
    //   86: ldc -107
    //   88: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload 4
    //   93: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload_1
    //   103: invokestatic 152	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aload 4
    //   111: invokevirtual 147	java/io/File:delete	()Z
    //   114: pop
    //   115: new 33	java/lang/StringBuilder
    //   118: dup
    //   119: ldc -102
    //   121: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload 4
    //   126: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   129: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aload_1
    //   136: invokestatic 152	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_2
    //   140: invokevirtual 134	java/io/OutputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_1
    //   146: aload 4
    //   148: invokevirtual 147	java/io/File:delete	()Z
    //   151: pop
    //   152: new 33	java/lang/StringBuilder
    //   155: dup
    //   156: ldc -107
    //   158: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 4
    //   163: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: aload_1
    //   173: invokestatic 152	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: aload_2
    //   180: invokevirtual 134	java/io/OutputStream:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: aload 4
    //   188: invokevirtual 147	java/io/File:delete	()Z
    //   191: pop
    //   192: new 33	java/lang/StringBuilder
    //   195: dup
    //   196: ldc -107
    //   198: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: aload 4
    //   203: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   206: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: aload_1
    //   213: invokestatic 152	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: iconst_0
    //   217: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	bs
    //   0	218	1	paramch	ch
    //   20	160	2	localObject	Object
    //   37	2	3	localBufferedOutputStream	java.io.BufferedOutputStream
    //   53	1	3	localFileNotFoundException	FileNotFoundException
    //   17	185	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   21	38	53	java/io/FileNotFoundException
    //   47	51	75	java/io/IOException
    //   40	47	108	java/io/IOException
    //   139	143	145	java/io/IOException
    //   40	47	178	finally
    //   109	139	178	finally
    //   179	183	185	java/io/IOException
  }
  
  private boolean d()
  {
    String str;
    if (!a.isDirectory())
    {
      i = true;
      str = a.getAbsolutePath();
      if (!a.exists()) {
        break label69;
      }
      new IOException(str + " is not a directory");
    }
    while (!i)
    {
      return true;
      label69:
      new FileNotFoundException(str + " does not exist");
    }
    return false;
  }
  
  private void e()
  {
    while ((b() > i()) && (f())) {}
  }
  
  private boolean f()
  {
    a locala1 = h;
    if (h == null) {}
    do
    {
      return false;
      a locala2 = h;
      File[] arrayOfFile = g();
      locala1 = null;
      if (arrayOfFile.length > a) {
        locala1 = arrayOfFile[a];
      }
    } while ((locala1 == null) || (!locala1.delete()));
    return true;
  }
  
  private File[] g()
  {
    File[] arrayOfFile = h();
    Arrays.sort(arrayOfFile);
    return arrayOfFile;
  }
  
  private File[] h()
  {
    File[] arrayOfFile2 = a.listFiles();
    File[] arrayOfFile1 = arrayOfFile2;
    if (arrayOfFile2 == null) {
      arrayOfFile1 = new File[0];
    }
    return arrayOfFile1;
  }
  
  private int i()
  {
    try
    {
      int j = f;
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final bs a(Context paramContext)
  {
    String str = a.getName();
    str = str + "_" + UUID.randomUUID().toString();
    return new bs(new File(paramContext.getFilesDir().getAbsolutePath() + "//com.crittercism/pending/" + str), h, d, g, f, b);
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 95	crittercism/android/bs:d	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 98	crittercism/android/bs:h	()[Ljava/io/File;
    //   18: astore_3
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: aload_3
    //   23: arraylength
    //   24: if_icmpge -13 -> 11
    //   27: aload_3
    //   28: iload_1
    //   29: aaload
    //   30: invokevirtual 147	java/io/File:delete	()Z
    //   33: pop
    //   34: iload_1
    //   35: iconst_1
    //   36: iadd
    //   37: istore_1
    //   38: goto -17 -> 21
    //   41: astore_3
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_3
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	bs
    //   20	18	1	j	int
    //   6	2	2	bool	boolean
    //   18	10	3	arrayOfFile	File[]
    //   41	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	41	finally
    //   14	19	41	finally
    //   21	34	41	finally
  }
  
  public final void a(bs parambs)
  {
    if (parambs == null) {}
    int j;
    do
    {
      return;
      j = a.getName().compareTo(a.getName());
    } while (j == 0);
    bs localbs2;
    if (j < 0) {
      localbs2 = parambs;
    }
    for (;;)
    {
      synchronized (this) {}
      try
      {
        if ((!d()) || (!parambs.d()))
        {
          return;
          parambs = finally;
          throw parambs;
          localbs2 = this;
          ??? = parambs;
        }
        else
        {
          File[] arrayOfFile = g();
          j = 0;
          while (j < arrayOfFile.length)
          {
            File localFile = new File(a, arrayOfFile[j].getName());
            arrayOfFile[j].renameTo(localFile);
            j += 1;
          }
          parambs.e();
          parambs = c.iterator();
          while (parambs.hasNext()) {
            ((bt)parambs.next()).d();
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 95	crittercism/android/bs:d	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: ifnull -4 -> 11
    //   18: new 31	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: getfield 89	crittercism/android/bs:a	Ljava/io/File;
    //   26: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 160	java/io/File:exists	()Z
    //   38: ifeq -27 -> 11
    //   41: aload_1
    //   42: invokevirtual 147	java/io/File:delete	()Z
    //   45: pop
    //   46: goto -35 -> 11
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	bs
    //   0	54	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   18	46	49	finally
  }
  
  public final boolean a(ch arg1)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = d();
        if (!bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        if (e >= g)
        {
          dx.b();
          bool1 = bool2;
          continue;
        }
        j = b();
      }
      finally {}
      int j;
      if (j == i())
      {
        bool1 = bool2;
        if (!f()) {}
      }
      else if (j > i())
      {
        i = true;
        bool1 = bool2;
      }
      else
      {
        bool1 = c(???);
        if (bool1) {
          e += 1;
        }
        synchronized (c)
        {
          Iterator localIterator = c.iterator();
          if (localIterator.hasNext()) {
            ((bt)localIterator.next()).c();
          }
        }
      }
    }
  }
  
  public final int b()
  {
    try
    {
      int j = h().length;
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean b(ch paramch)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 95	crittercism/android/bs:d	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: new 31	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: getfield 89	crittercism/android/bs:a	Ljava/io/File;
    //   25: aload_1
    //   26: invokeinterface 114 1 0
    //   31: invokespecial 117	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: invokevirtual 147	java/io/File:delete	()Z
    //   37: pop
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 238	crittercism/android/bs:c	(Lcrittercism/android/ch;)Z
    //   43: istore_2
    //   44: goto -31 -> 13
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	bs
    //   0	52	1	paramch	ch
    //   6	38	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   17	44	47	finally
  }
  
  /* Error */
  public final List c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 243	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 244	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: invokespecial 95	crittercism/android/bs:d	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_3
    //   22: areturn
    //   23: aload_0
    //   24: getfield 81	crittercism/android/bs:d	Lcrittercism/android/cj;
    //   27: astore 4
    //   29: aload_0
    //   30: invokespecial 173	crittercism/android/bs:g	()[Ljava/io/File;
    //   33: astore 4
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_1
    //   38: aload 4
    //   40: arraylength
    //   41: if_icmpge -22 -> 19
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 81	crittercism/android/bs:d	Lcrittercism/android/cj;
    //   49: aload 4
    //   51: iload_1
    //   52: aaload
    //   53: invokevirtual 249	crittercism/android/cj:a	(Ljava/io/File;)Lcrittercism/android/bq;
    //   56: invokeinterface 253 2 0
    //   61: pop
    //   62: iload_1
    //   63: iconst_1
    //   64: iadd
    //   65: istore_1
    //   66: goto -29 -> 37
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bs
    //   36	30	1	j	int
    //   14	2	2	bool	boolean
    //   9	36	3	localArrayList	java.util.ArrayList
    //   69	4	3	localObject1	Object
    //   27	23	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	69	finally
    //   23	35	69	finally
    //   37	62	69	finally
  }
  
  public static final class a
  {
    int a;
    
    public a(int paramInt)
    {
      a = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */