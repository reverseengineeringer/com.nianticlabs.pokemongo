package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgr
public class zzdy
  extends zzdv
{
  private static final Set<String> zzyk = Collections.synchronizedSet(new HashSet());
  private static final DecimalFormat zzyl = new DecimalFormat("#,###");
  private File zzym;
  private boolean zzyn;
  
  public zzdy(zziz paramzziz)
  {
    super(paramzziz);
    paramzziz = paramzziz.getContext().getCacheDir();
    if (paramzziz == null) {
      zzb.zzaH("Context.getCacheDir() returned null");
    }
    do
    {
      return;
      zzym = new File(paramzziz, "admobVideoStreams");
      if ((!zzym.isDirectory()) && (!zzym.mkdirs()))
      {
        zzb.zzaH("Could not create preload cache directory at " + zzym.getAbsolutePath());
        zzym = null;
        return;
      }
    } while ((zzym.setReadable(true, false)) && (zzym.setExecutable(true, false)));
    zzb.zzaH("Could not set cache file permissions at " + zzym.getAbsolutePath());
    zzym = null;
  }
  
  private File zza(File paramFile)
  {
    return new File(zzym, paramFile.getName() + ".done");
  }
  
  private static void zzb(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.setLastModified(System.currentTimeMillis());
      return;
    }
    try
    {
      paramFile.createNewFile();
      return;
    }
    catch (IOException paramFile) {}
  }
  
  public void abort()
  {
    zzyn = true;
  }
  
  public boolean zzab(String paramString)
  {
    if (zzym == null)
    {
      zza(paramString, null, "noCacheDir", null);
      return false;
    }
    while (zzdK() > ((Integer)zzby.zzuy.get()).intValue()) {
      if (!zzdL())
      {
        zzb.zzaH("Unable to expire stream cache");
        zza(paramString, null, "expireFailed", null);
        return false;
      }
    }
    ??? = zzac(paramString);
    File localFile = new File(zzym, (String)???);
    Object localObject4 = zza(localFile);
    int i;
    if ((localFile.isFile()) && (((File)localObject4).isFile()))
    {
      i = (int)localFile.length();
      zzb.zzaF("Stream cache hit at " + paramString);
      zza(paramString, localFile.getAbsolutePath(), i);
      return true;
    }
    String str = zzym.getAbsolutePath() + paramString;
    synchronized (zzyk)
    {
      if (zzyk.contains(str))
      {
        zzb.zzaH("Stream cache already in progress at " + paramString);
        zza(paramString, localFile.getAbsolutePath(), "inProgress", null);
        return false;
      }
    }
    zzyk.add(str);
    Object localObject7 = null;
    for (;;)
    {
      try
      {
        ??? = new URL(paramString).openConnection();
        i = ((Integer)zzby.zzuD.get()).intValue();
        ((URLConnection)???).setConnectTimeout(i);
        ((URLConnection)???).setReadTimeout(i);
        if ((??? instanceof HttpURLConnection))
        {
          i = ((HttpURLConnection)???).getResponseCode();
          if (i >= 400) {
            localObject6 = "badUrl";
          }
        }
      }
      catch (IOException localIOException2)
      {
        int k;
        int m;
        Object localObject2;
        localObject5 = null;
        localObject6 = "error";
        continue;
      }
      try
      {
        localObject4 = "HTTP request failed. Code: " + Integer.toString(i);
        try
        {
          throw new IOException("HTTP status code " + i + " at " + paramString);
        }
        catch (IOException localIOException1) {}
      }
      catch (IOException localIOException3)
      {
        localObject5 = null;
        continue;
        continue;
        continue;
      }
      try
      {
        ((FileOutputStream)localObject7).close();
        if (zzyn)
        {
          zzb.zzaG("Preload aborted for URL \"" + paramString + "\"");
          if ((localFile.exists()) && (!localFile.delete())) {
            zzb.zzaH("Could not delete partial cache file at " + localFile.getAbsolutePath());
          }
          zza(paramString, localFile.getAbsolutePath(), (String)localObject6, (String)localObject4);
          zzyk.remove(str);
          return false;
          k = localIOException1.getContentLength();
          if (k < 0)
          {
            zzb.zzaH("Stream cache aborted, missing content-length header at " + paramString);
            zza(paramString, localFile.getAbsolutePath(), "contentLengthMissing", null);
            zzyk.remove(str);
            return false;
          }
          localObject6 = zzyl.format(k);
          m = ((Integer)zzby.zzuz.get()).intValue();
          if (k > m)
          {
            zzb.zzaH("Content length " + (String)localObject6 + " exceeds limit at " + paramString);
            localObject2 = "File too big for full file cache. Size: " + (String)localObject6;
            zza(paramString, localFile.getAbsolutePath(), "sizeExceeded", (String)localObject2);
            zzyk.remove(str);
            return false;
          }
          zzb.zzaF("Caching " + (String)localObject6 + " bytes from " + paramString);
          localObject6 = Channels.newChannel(((URLConnection)localObject2).getInputStream());
          localObject2 = new FileOutputStream(localFile);
        }
        try
        {
          localObject7 = ((FileOutputStream)localObject2).getChannel();
          ByteBuffer localByteBuffer = ByteBuffer.allocate(1048576);
          zzmn localzzmn = zzp.zzbz();
          i = 0;
          long l1 = localzzmn.currentTimeMillis();
          zzik localzzik = new zzik(((Long)zzby.zzuC.get()).longValue());
          long l2 = ((Long)zzby.zzuB.get()).longValue();
          int j = ((ReadableByteChannel)localObject6).read(localByteBuffer);
          if (j >= 0)
          {
            j = i + j;
            if (j > m)
            {
              localObject7 = "sizeExceeded";
              localObject6 = localObject7;
            }
          }
          try
          {
            localObject4 = "File too big for full file cache. Size: " + Integer.toString(j);
            localObject6 = localObject7;
            try
            {
              throw new IOException("stream cache file size limit exceeded");
            }
            catch (IOException localIOException6)
            {
              localObject7 = localObject2;
              localObject2 = localIOException6;
            }
          }
          catch (IOException localIOException7)
          {
            localObject5 = null;
            localObject8 = localIOException3;
            localObject3 = localIOException7;
          }
          localIOException6.flip();
          if (((FileChannel)localObject7).write(localIOException6) > 0) {
            continue;
          }
          localIOException6.clear();
          if (localzzmn.currentTimeMillis() - l1 > 1000L * l2)
          {
            localObject7 = "downloadTimeout";
            localObject6 = localObject7;
            localObject4 = "Timeout exceeded. Limit: " + Long.toString(l2) + " sec";
            localObject6 = localObject7;
            throw new IOException("stream cache time limit exceeded");
          }
          if (zzyn)
          {
            try
            {
              throw new IOException("abort requested");
            }
            catch (IOException localIOException4)
            {
              localObject6 = "externalAbort";
              localObject7 = localObject2;
              Object localObject9 = null;
              localObject2 = localIOException4;
              localObject5 = localObject9;
            }
            continue;
          }
          i = j;
          if (!localzzik.tryAcquire()) {
            continue;
          }
          zza(paramString, localFile.getAbsolutePath(), j, k, false);
          i = j;
          continue;
          ((FileOutputStream)localObject2).close();
          if (zzb.zzN(3))
          {
            localObject6 = zzyl.format(i);
            zzb.zzaF("Preloaded " + (String)localObject6 + " bytes from " + paramString);
          }
          localFile.setReadable(true, false);
          zzb((File)localObject5);
          zza(paramString, localFile.getAbsolutePath(), i);
          zzyk.remove(str);
          return true;
        }
        catch (IOException localIOException8)
        {
          Object localObject5 = null;
          localObject6 = "error";
          Object localObject8 = localObject3;
          Object localObject3 = localIOException8;
        }
        zzb.zzd("Preload failed for URL \"" + paramString + "\"", (Throwable)localObject2);
      }
      catch (IOException localIOException5) {}catch (NullPointerException localNullPointerException) {}
    }
  }
  
  public int zzdK()
  {
    int i = 0;
    int k = 0;
    if (zzym == null) {
      return k;
    }
    File[] arrayOfFile = zzym.listFiles();
    int m = arrayOfFile.length;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (!arrayOfFile[j].getName().endsWith(".done")) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public boolean zzdL()
  {
    if (zzym == null) {
      return false;
    }
    Object localObject = null;
    long l1 = Long.MAX_VALUE;
    File[] arrayOfFile = zzym.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.getName().endsWith(".done")) {
        break label134;
      }
      long l2 = localFile.lastModified();
      if (l2 >= l1) {
        break label134;
      }
      localObject = localFile;
      l1 = l2;
    }
    label134:
    for (;;)
    {
      i += 1;
      break;
      boolean bool2;
      if (localObject != null)
      {
        bool2 = ((File)localObject).delete();
        localObject = zza((File)localObject);
        bool1 = bool2;
        if (!((File)localObject).isFile()) {}
      }
      for (boolean bool1 = bool2 & ((File)localObject).delete();; bool1 = false) {
        return bool1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */