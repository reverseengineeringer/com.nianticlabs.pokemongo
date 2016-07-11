package com.voxelbusters.nativeplugins.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtility
{
  public static final int IMAGE_QUALITY = 100;
  
  public static void createDirectoriesIfUnAvailable(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public static String createFileFromStream(InputStream paramInputStream, File paramFile, String paramString)
  {
    paramString = new File(paramFile, paramString);
    createPathIfUnAvailable(paramFile, paramString);
    for (;;)
    {
      try
      {
        paramFile = new FileOutputStream(paramString);
        arrayOfByte = new byte['Ѐ'];
        i = paramInputStream.read(arrayOfByte);
        if (i > 0) {
          continue;
        }
        paramFile.close();
        paramInputStream.close();
      }
      catch (Exception paramInputStream)
      {
        byte[] arrayOfByte;
        int i;
        paramInputStream.printStackTrace();
        continue;
      }
      return paramString.getAbsolutePath();
      paramFile.write(arrayOfByte, 0, i);
    }
  }
  
  static void createPathIfUnAvailable(File paramFile1, File paramFile2)
  {
    if (!paramFile2.exists()) {}
    try
    {
      paramFile1.mkdirs();
      paramFile2.createNewFile();
      return;
    }
    catch (IOException paramFile1)
    {
      Debug.error("NativePlugins.FileUtils", "Creating file failed!");
      paramFile1.printStackTrace();
    }
  }
  
  public static Uri createSharingFileUri(Context paramContext, byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = ApplicationUtility.hasExternalStorageWritable(paramContext);
    paramString1 = getSavedFile(paramArrayOfByte, paramInt, ApplicationUtility.getExternalTempDirectoryIfExists(paramContext, paramString1), paramString2, false);
    Debug.log("NativePlugins.Sharing", "Saving temp at " + paramString1);
    paramArrayOfByte = null;
    if (!StringUtility.isNullOrEmpty(paramString1)) {
      if (bool) {
        break label84;
      }
    }
    label84:
    for (paramArrayOfByte = FileProvider.getUriForFile(paramContext, ApplicationUtility.getFileProviderAuthoityName(paramContext), new File(paramString1));; paramArrayOfByte = Uri.fromFile(new File(paramString1)))
    {
      paramContext.grantUriPermission(ApplicationUtility.getPackageName(paramContext), paramArrayOfByte, 3);
      return paramArrayOfByte;
    }
  }
  
  public static ByteArrayOutputStream getBitmapStream(String paramString)
  {
    paramString = BitmapFactory.decodeFile(new File(paramString).getAbsolutePath());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  public static String getContentsOfFile(String paramString)
  {
    String str = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = new BufferedReader(new FileReader(paramString));
        if (localObject1 == null) {
          break label100;
        }
        paramString = (String)localObject4;
      }
      catch (IOException localIOException2)
      {
        paramString = (String)localObject3;
        Object localObject1 = localObject2;
        label82:
        localIOException2.printStackTrace();
        continue;
      }
      for (;;)
      {
        try
        {
          str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            if (localObject1 == null) {
              break;
            }
          }
        }
        catch (IOException localIOException3)
        {
          break label82;
        }
        try
        {
          ((BufferedReader)localObject1).close();
          return paramString;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return paramString;
        }
      }
      str = paramString + str;
      paramString = str;
      continue;
      label100:
      paramString = localIOException3;
    }
  }
  
  public static String getFilePathromURI(Context paramContext, Uri paramUri)
  {
    return new File(paramUri.toString()).getAbsolutePath();
  }
  
  public static String getSavedFile(byte[] paramArrayOfByte, int paramInt, File paramFile, String paramString, boolean paramBoolean)
  {
    return getSavedFile(paramArrayOfByte, paramInt, paramFile, paramString, paramBoolean, true);
  }
  
  public static String getSavedFile(byte[] paramArrayOfByte, int paramInt, File paramFile, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject3 = null;
    localObject2 = null;
    Object localObject1 = localObject3;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject3;
      if (paramInt > 0)
      {
        createDirectoriesIfUnAvailable(paramFile.getAbsolutePath());
        paramFile = new File(paramFile, paramString);
        if (paramFile.exists()) {
          paramFile.delete();
        }
      }
    }
    try
    {
      paramFile.createNewFile();
      if (paramBoolean2)
      {
        paramFile.setReadable(true, false);
        paramFile.setWritable(true, false);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new FileOutputStream(paramFile);
        }
        catch (FileNotFoundException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = (byte[])localObject2;
          continue;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = (byte[])localObject2;
          continue;
        }
        try
        {
          paramString.write(paramArrayOfByte);
          paramString.close();
          paramArrayOfByte = paramFile.getAbsolutePath();
          localObject1 = paramArrayOfByte;
          if (paramArrayOfByte != null)
          {
            localObject1 = paramArrayOfByte;
            if (paramBoolean1) {
              localObject1 = "file://" + paramArrayOfByte;
            }
          }
          return (String)localObject1;
        }
        catch (IOException paramArrayOfByte)
        {
          continue;
        }
        catch (FileNotFoundException paramArrayOfByte)
        {
          continue;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static String getSavedFileFromUri(Context paramContext, Uri paramUri, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 220	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 226	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   19: astore_1
    //   20: new 154	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 155	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_0
    //   28: sipush 1024
    //   31: newarray <illegal type>
    //   33: astore 5
    //   35: aload_1
    //   36: aload 5
    //   38: invokevirtual 47	java/io/InputStream:read	([B)I
    //   41: iconst_m1
    //   42: if_icmpne +34 -> 76
    //   45: aload_0
    //   46: invokevirtual 229	java/io/ByteArrayOutputStream:flush	()V
    //   49: aload_0
    //   50: invokevirtual 233	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: astore_1
    //   54: aload_0
    //   55: ifnull +7 -> 62
    //   58: aload_0
    //   59: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   62: aload_1
    //   63: ifnull +55 -> 118
    //   66: aload_1
    //   67: aload_1
    //   68: arraylength
    //   69: aload_2
    //   70: aload_3
    //   71: iconst_1
    //   72: invokestatic 96	com/voxelbusters/nativeplugins/utilities/FileUtility:getSavedFile	([BILjava/io/File;Ljava/lang/String;Z)Ljava/lang/String;
    //   75: areturn
    //   76: aload_0
    //   77: aload 5
    //   79: invokevirtual 235	java/io/ByteArrayOutputStream:write	([B)V
    //   82: goto -47 -> 35
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 214	java/io/FileNotFoundException:printStackTrace	()V
    //   90: aload 4
    //   92: astore_1
    //   93: goto -39 -> 54
    //   96: astore_1
    //   97: aload 5
    //   99: astore_0
    //   100: aload_1
    //   101: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   104: aload 4
    //   106: astore_1
    //   107: goto -53 -> 54
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   115: goto -53 -> 62
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: goto -21 -> 100
    //   124: astore_1
    //   125: aload 6
    //   127: astore_0
    //   128: goto -42 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   0	131	1	paramUri	Uri
    //   0	131	2	paramFile	File
    //   0	131	3	paramString	String
    //   7	98	4	localObject1	Object
    //   1	97	5	arrayOfByte	byte[]
    //   4	122	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	35	85	java/io/FileNotFoundException
    //   35	54	85	java/io/FileNotFoundException
    //   76	82	85	java/io/FileNotFoundException
    //   14	28	96	java/io/IOException
    //   58	62	110	java/io/IOException
    //   28	35	120	java/io/IOException
    //   35	54	120	java/io/IOException
    //   76	82	120	java/io/IOException
    //   14	28	124	java/io/FileNotFoundException
  }
  
  public static Uri getSavedFileUri(byte[] paramArrayOfByte, int paramInt, File paramFile, String paramString, boolean paramBoolean)
  {
    return Uri.fromFile(new File(getSavedFile(paramArrayOfByte, paramInt, paramFile, paramString, paramBoolean, true)));
  }
  
  public static String getSavedLocalFileFromUri(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    return getSavedFileFromUri(paramContext, paramUri, paramContext.getDir(paramString1, 0), paramString2);
  }
  
  public static String getScaledImagePath(String paramString1, File paramFile, String paramString2, float paramFloat, boolean paramBoolean)
  {
    paramString1 = new File(paramString1);
    paramFile = getScaledImagePathFromBitmap(BitmapFactory.decodeFile(paramString1.getAbsolutePath()), paramFile, paramString2, paramFloat);
    if (paramBoolean) {
      paramString1.delete();
    }
    return paramFile;
  }
  
  /* Error */
  public static String getScaledImagePathFromBitmap(Bitmap paramBitmap, File paramFile, String paramString, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: new 16	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial 32	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 9
    //   17: aload_1
    //   18: aload 9
    //   20: invokestatic 36	com/voxelbusters/nativeplugins/utilities/FileUtility:createPathIfUnAvailable	(Ljava/io/File;Ljava/io/File;)V
    //   23: aconst_null
    //   24: astore_1
    //   25: aconst_null
    //   26: astore 8
    //   28: new 38	java/io/FileOutputStream
    //   31: dup
    //   32: aload 9
    //   34: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: iconst_0
    //   39: istore 5
    //   41: iconst_0
    //   42: istore 4
    //   44: aload_0
    //   45: ifnull +23 -> 68
    //   48: aload_0
    //   49: invokevirtual 255	android/graphics/Bitmap:getWidth	()I
    //   52: i2f
    //   53: fload_3
    //   54: fmul
    //   55: f2i
    //   56: istore 5
    //   58: aload_0
    //   59: invokevirtual 258	android/graphics/Bitmap:getHeight	()I
    //   62: i2f
    //   63: fload_3
    //   64: fmul
    //   65: f2i
    //   66: istore 4
    //   68: iload 5
    //   70: ifeq +49 -> 119
    //   73: iload 4
    //   75: ifeq +44 -> 119
    //   78: aload_0
    //   79: iload 5
    //   81: iload 4
    //   83: iconst_1
    //   84: invokestatic 262	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   87: getstatic 265	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   90: bipush 100
    //   92: aload_2
    //   93: invokevirtual 167	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   96: pop
    //   97: aload 9
    //   99: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: astore_0
    //   103: aload_2
    //   104: ifnull +119 -> 223
    //   107: aload_2
    //   108: invokevirtual 266	java/io/OutputStream:flush	()V
    //   111: aload_2
    //   112: invokevirtual 52	java/io/OutputStream:close	()V
    //   115: aload_0
    //   116: astore_1
    //   117: aload_1
    //   118: areturn
    //   119: ldc 71
    //   121: ldc_w 268
    //   124: invokestatic 79	com/voxelbusters/nativeplugins/utilities/Debug:error	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 7
    //   129: astore_0
    //   130: goto -27 -> 103
    //   133: astore_1
    //   134: aload_2
    //   135: astore_0
    //   136: aload_1
    //   137: astore_2
    //   138: aload_0
    //   139: astore_1
    //   140: ldc 71
    //   142: new 100	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 270
    //   149: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: invokevirtual 273	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 79	com/voxelbusters/nativeplugins/utilities/Debug:error	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: astore_1
    //   167: aload_2
    //   168: invokevirtual 214	java/io/FileNotFoundException:printStackTrace	()V
    //   171: aload 6
    //   173: astore_1
    //   174: aload_0
    //   175: ifnull -58 -> 117
    //   178: aload_0
    //   179: invokevirtual 266	java/io/OutputStream:flush	()V
    //   182: aload_0
    //   183: invokevirtual 52	java/io/OutputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_0
    //   196: aload_1
    //   197: ifnull +11 -> 208
    //   200: aload_1
    //   201: invokevirtual 266	java/io/OutputStream:flush	()V
    //   204: aload_1
    //   205: invokevirtual 52	java/io/OutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   215: goto -7 -> 208
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   223: aload_0
    //   224: areturn
    //   225: astore_0
    //   226: aload_2
    //   227: astore_1
    //   228: goto -32 -> 196
    //   231: astore_2
    //   232: aload 8
    //   234: astore_0
    //   235: goto -97 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramBitmap	Bitmap
    //   0	238	1	paramFile	File
    //   0	238	2	paramString	String
    //   0	238	3	paramFloat	float
    //   42	40	4	i	int
    //   39	41	5	j	int
    //   1	171	6	localObject1	Object
    //   4	124	7	localObject2	Object
    //   26	207	8	localObject3	Object
    //   15	83	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   48	68	133	java/io/FileNotFoundException
    //   78	103	133	java/io/FileNotFoundException
    //   119	127	133	java/io/FileNotFoundException
    //   178	186	188	java/io/IOException
    //   28	38	195	finally
    //   140	165	195	finally
    //   167	171	195	finally
    //   200	208	210	java/io/IOException
    //   107	115	218	java/io/IOException
    //   48	68	225	finally
    //   78	103	225	finally
    //   119	127	225	finally
    //   28	38	231	java/io/FileNotFoundException
  }
  
  public static void replaceFile(byte[] paramArrayOfByte, File paramFile, String paramString)
  {
    if (paramArrayOfByte != null) {
      getSavedFile(paramArrayOfByte, paramArrayOfByte.length, paramFile, paramString, false);
    }
    do
    {
      return;
      paramArrayOfByte = new File(paramFile, paramString);
    } while (!paramArrayOfByte.exists());
    paramArrayOfByte.delete();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.FileUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */