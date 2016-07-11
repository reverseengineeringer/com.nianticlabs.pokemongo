package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import java.lang.ref.WeakReference;

public final class zza$zzc
  extends zza
{
  private WeakReference<ImageManager.OnImageLoadedListener> zzaef;
  
  public zza$zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    zzb.zzs(paramOnImageLoadedListener);
    zzaef = new WeakReference(paramOnImageLoadedListener);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzc)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (zzc)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)zzaef.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)zzaef.get();
    if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzw.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzw.equal(zzadV, zzadV))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzadV });
  }
  
  protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)zzaef.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(zzadV.uri, paramDrawable, paramBoolean3);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.zza.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */