package crittercism.android;

import java.io.File;

public final class eb
{
  public static void a(File paramFile)
  {
    if (!paramFile.getAbsolutePath().contains("com.crittercism")) {
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 38	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: new 44	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: new 48	java/io/InputStreamReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 55	java/io/InputStreamReader:read	()I
    //   33: istore_1
    //   34: iload_1
    //   35: iconst_m1
    //   36: if_icmpeq +39 -> 75
    //   39: aload 4
    //   41: iload_1
    //   42: i2c
    //   43: invokevirtual 59	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: goto -18 -> 29
    //   50: astore 4
    //   52: aload_0
    //   53: astore_3
    //   54: aload 4
    //   56: astore_0
    //   57: aload_3
    //   58: ifnull +7 -> 65
    //   61: aload_3
    //   62: invokevirtual 64	java/io/InputStream:close	()V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 65	java/io/InputStreamReader:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_0
    //   76: invokevirtual 64	java/io/InputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 65	java/io/InputStreamReader:close	()V
    //   83: aload 4
    //   85: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: areturn
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_2
    //   92: goto -35 -> 57
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_0
    //   100: astore_3
    //   101: aload 4
    //   103: astore_0
    //   104: goto -47 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   33	9	1	i	int
    //   28	71	2	localInputStreamReader	java.io.InputStreamReader
    //   1	100	3	localFile	File
    //   9	31	4	localStringBuilder	StringBuilder
    //   50	34	4	localObject1	Object
    //   95	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	50	finally
    //   39	47	50	finally
    //   11	20	89	finally
    //   20	29	95	finally
  }
}

/* Location:
 * Qualified Name:     crittercism.android.eb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */