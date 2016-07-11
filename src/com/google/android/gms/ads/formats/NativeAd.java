package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public abstract class NativeAd
{
  protected abstract Object zzaH();
  
  public static abstract class Image
  {
    public abstract Drawable getDrawable();
    
    public abstract double getScale();
    
    public abstract Uri getUri();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */