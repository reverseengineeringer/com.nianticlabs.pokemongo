package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zzadG = new Object();
  private static HashSet<Uri> zzadH = new HashSet();
  private static ImageManager zzadI;
  private static ImageManager zzadJ;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzadK;
  private final zzb zzadL;
  private final zzlv zzadM;
  private final Map<zza, ImageReceiver> zzadN;
  private final Map<Uri, ImageReceiver> zzadO;
  private final Map<Uri, Long> zzadP;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext.getApplicationContext();
    mHandler = new Handler(Looper.getMainLooper());
    zzadK = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      zzadL = new zzb(mContext);
      if (zzmx.zzqx()) {
        zzoB();
      }
    }
    for (;;)
    {
      zzadM = new zzlv();
      zzadN = new HashMap();
      zzadO = new HashMap();
      zzadP = new HashMap();
      return;
      zzadL = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return zzb(paramContext, false);
  }
  
  private Bitmap zza(zza.zza paramzza)
  {
    if (zzadL == null) {
      return null;
    }
    return (Bitmap)zzadL.get(paramzza);
  }
  
  public static ImageManager zzb(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzadJ == null) {
        zzadJ = new ImageManager(paramContext, true);
      }
      return zzadJ;
    }
    if (zzadI == null) {
      zzadI = new ImageManager(paramContext, false);
    }
    return zzadI;
  }
  
  private void zzoB()
  {
    mContext.registerComponentCallbacks(new zze(zzadL));
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzby(paramInt);
    zza(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzby(paramInt);
    zza(paramOnImageLoadedListener);
  }
  
  public void zza(zza paramzza)
  {
    zzb.zzci("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramzza).run();
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zza> zzadQ;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      mUri = paramUri;
      zzadQ = new ArrayList();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, mUri, paramBundle));
    }
    
    public void zzb(zza paramzza)
    {
      zzb.zzci("ImageReceiver.addImageRequest() must be called in the main thread");
      zzadQ.add(paramzza);
    }
    
    public void zzc(zza paramzza)
    {
      zzb.zzci("ImageReceiver.removeImageRequest() must be called in the main thread");
      zzadQ.remove(paramzza);
    }
    
    public void zzoE()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class zzb
    extends zzmg<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }
    
    private static int zzaj(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((getApplicationInfoflags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!zzmx.zzqu())) {
          break label55;
        }
      }
      label55:
      for (int i = ImageManager.zza.zza(localActivityManager);; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class zzc
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzadS;
    
    public zzc(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      mUri = paramUri;
      zzadS = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      zzb.zzcj("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (zzadS != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(zzadS.getFileDescriptor());
        bool1 = bool2;
        Object localObject;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          for (;;)
          {
            zzadS.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, mUri, localBitmap, bool1, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.w("ImageManager", "Latch interrupted while posting " + mUri);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + mUri, localOutOfMemoryError);
            bool1 = true;
            localObject = localCountDownLatch;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("ImageManager", "closed failed", localIOException);
          }
        }
      }
    }
  }
  
  private final class zzd
    implements Runnable
  {
    private final zza zzadT;
    
    public zzd(zza paramzza)
    {
      zzadT = paramzza;
    }
    
    public void run()
    {
      zzb.zzci("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(zzadT);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(zzadT);
        ((ImageManager.ImageReceiver)localObject1).zzc(zzadT);
      }
      zza.zza localzza = zzadT.zzadV;
      if (uri == null)
      {
        zzadT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.zza(ImageManager.this, localzza);
      if (localObject1 != null)
      {
        zzadT.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          zzadT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(uri);
      }
      zzadT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, uri);
        ImageManager.zze(ImageManager.this).put(uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zzb(zzadT);
      if (!(zzadT instanceof zza.zzc)) {
        ImageManager.zza(ImageManager.this).put(zzadT, localObject1);
      }
      synchronized (ImageManager.zzoC())
      {
        if (!ImageManager.zzoD().contains(uri))
        {
          ImageManager.zzoD().add(uri);
          ((ImageManager.ImageReceiver)localObject1).zzoE();
        }
        return;
      }
    }
  }
  
  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb zzadL;
    
    public zze(ImageManager.zzb paramzzb)
    {
      zzadL = paramzzb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      zzadL.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        zzadL.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      zzadL.trimToSize(zzadL.size() / 2);
    }
  }
  
  private final class zzf
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private boolean zzadU;
    private final CountDownLatch zzoS;
    
    public zzf(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      mUri = paramUri;
      mBitmap = paramBitmap;
      zzadU = paramBoolean;
      zzoS = paramCountDownLatch;
    }
    
    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = paramImageReceiver.size();
      int i = 0;
      if (i < j)
      {
        zza localzza = (zza)paramImageReceiver.get(i);
        if (paramBoolean) {
          localzza.zza(ImageManager.zzb(ImageManager.this), mBitmap, false);
        }
        for (;;)
        {
          if (!(localzza instanceof zza.zzc)) {
            ImageManager.zza(ImageManager.this).remove(localzza);
          }
          i += 1;
          break;
          ImageManager.zzd(ImageManager.this).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localzza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      zzb.zzci("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (mBitmap != null) {
        bool = true;
      }
      while (ImageManager.zzh(ImageManager.this) != null) {
        if (zzadU)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          zzadU = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(mUri), mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(mUri);
      if (??? != null) {
        zza((ImageManager.ImageReceiver)???, bool);
      }
      zzoS.countDown();
      synchronized (ImageManager.zzoC())
      {
        ImageManager.zzoD().remove(mUri);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */