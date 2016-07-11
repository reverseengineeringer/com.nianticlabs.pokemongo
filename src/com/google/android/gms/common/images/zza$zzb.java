package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlu;
import java.lang.ref.WeakReference;

public final class zza$zzb
  extends zza
{
  private WeakReference<ImageView> zzaee;
  
  public zza$zzb(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    zzb.zzs(paramImageView);
    zzaee = new WeakReference(paramImageView);
  }
  
  public zza$zzb(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    zzb.zzs(paramImageView);
    zzaee = new WeakReference(paramImageView);
  }
  
  private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof zzlu)); i = 0)
    {
      int j = ((zzlu)paramImageView).zzoH();
      if ((zzadX == 0) || (j != zzadX)) {
        break;
      }
      return;
    }
    paramBoolean1 = zzb(paramBoolean1, paramBoolean2);
    if ((zzadY) && (paramDrawable != null)) {
      paramDrawable = paramDrawable.getConstantState().newDrawable();
    }
    for (;;)
    {
      Object localObject = paramDrawable;
      if (paramBoolean1) {
        localObject = zza(paramImageView.getDrawable(), paramDrawable);
      }
      paramImageView.setImageDrawable((Drawable)localObject);
      if ((paramImageView instanceof zzlu))
      {
        paramDrawable = (zzlu)paramImageView;
        if (!paramBoolean3) {
          break label171;
        }
        paramImageView = zzadV.uri;
        label133:
        paramDrawable.zzj(paramImageView);
        if (i == 0) {
          break label176;
        }
      }
      label171:
      label176:
      for (i = zzadX;; i = 0)
      {
        paramDrawable.zzbA(i);
        if (!paramBoolean1) {
          break;
        }
        ((zzls)localObject).startTransition(250);
        return;
        paramImageView = null;
        break label133;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzb)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    Object localObject = (zzb)paramObject;
    paramObject = (ImageView)zzaee.get();
    localObject = (ImageView)zzaee.get();
    if ((localObject != null) && (paramObject != null) && (zzw.equal(localObject, paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)zzaee.get();
    if (localImageView != null) {
      zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.zza.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */