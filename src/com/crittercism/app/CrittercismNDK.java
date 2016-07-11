package com.crittercism.app;

import android.content.Context;
import android.content.res.AssetManager;
import crittercism.android.dx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CrittercismNDK
{
  private static final String LEGACY_SO_FILE_NAME = "libcrittercism-ndk.so";
  private static final String LIBRARY_NAME = "crittercism-v3";
  private static final String SO_FILE_NAME = "libcrittercism-v3.so";
  private static boolean isNdkInstalled = false;
  
  public static boolean copyLibFromAssets(Context paramContext, File paramFile)
  {
    
    try
    {
      paramFile.getParentFile().mkdirs();
      paramFile = new FileOutputStream(paramFile);
      paramContext = getJarredLibFileStream(paramContext);
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        int i = paramContext.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        paramFile.write(arrayOfByte, 0, i);
      }
      paramContext.close();
    }
    catch (Exception paramContext)
    {
      dx.b("Could not install breakpad library: " + paramContext.toString());
      return false;
    }
    paramFile.close();
    return true;
  }
  
  public static boolean doNdkSharedLibrariesExist(Context paramContext)
  {
    try
    {
      getJarredLibFileStream(paramContext);
      return true;
    }
    catch (IOException paramContext) {}
    return false;
  }
  
  public static File getInstalledLibraryFile(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + "/com.crittercism/lib/";
    return new File(paramContext + "libcrittercism-v3.so");
  }
  
  public static InputStream getJarredLibFileStream(Context paramContext)
  {
    String str = "armeabi";
    if (System.getProperty("os.arch").contains("v7")) {
      str = "armeabi" + "-v7a";
    }
    return paramContext.getAssets().open(str + "/libcrittercism-v3.so");
  }
  
  public static native boolean installNdk(String paramString);
  
  public static void installNdkLib(Context paramContext, String paramString)
  {
    boolean bool = true;
    paramString = paramContext.getFilesDir().getAbsolutePath() + "/" + paramString;
    if (doNdkSharedLibrariesExist(paramContext)) {
      bool = loadLibraryFromAssets(paramContext);
    }
    while (!bool)
    {
      return;
      try
      {
        System.loadLibrary("crittercism-v3");
      }
      catch (Throwable paramContext)
      {
        bool = false;
      }
    }
    try
    {
      if (installNdk(paramString))
      {
        new File(paramString).mkdirs();
        isNdkInstalled = true;
        return;
      }
      dx.c("Unable to initialize NDK crash reporting.");
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean isNdkCrashReportingInstalled()
  {
    return isNdkInstalled;
  }
  
  public static boolean loadLibraryFromAssets(Context paramContext)
  {
    File localFile2 = new File(paramContext.getFilesDir(), "/com.crittercism/lib/");
    File localFile1 = new File(localFile2, "libcrittercism-v3.so");
    localFile2 = new File(localFile2, "libcrittercism-ndk.so");
    if (!localFile1.exists())
    {
      if (!copyLibFromAssets(paramContext, localFile1))
      {
        localFile1.delete();
        return false;
      }
      localFile2.delete();
    }
    try
    {
      System.load(localFile1.getAbsolutePath());
      return true;
    }
    catch (Throwable paramContext)
    {
      dx.a("Unable to install NDK library", paramContext);
      localFile1.delete();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.crittercism.app.CrittercismNDK
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */