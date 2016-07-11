package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

final class ImageManager$ImageReceiver
  extends ResultReceiver
{
  private final Uri mUri;
  private final ArrayList<zza> zzadQ;
  
  ImageManager$ImageReceiver(ImageManager paramImageManager, Uri paramUri)
  {
    super(new Handler(Looper.getMainLooper()));
    mUri = paramUri;
    zzadQ = new ArrayList();
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
    ImageManager.zzf(zzadR).execute(new ImageManager.zzc(zzadR, mUri, paramBundle));
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
    ImageManager.zzb(zzadR).sendBroadcast(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.ImageReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */