package com.google.android.gms.ads.formats;

public final class NativeAdOptions
{
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;
  private final boolean zznW;
  private final int zznX;
  private final boolean zznY;
  
  private NativeAdOptions(Builder paramBuilder)
  {
    zznW = Builder.zza(paramBuilder);
    zznX = Builder.zzb(paramBuilder);
    zznY = Builder.zzc(paramBuilder);
  }
  
  public int getImageOrientation()
  {
    return zznX;
  }
  
  public boolean shouldRequestMultipleImages()
  {
    return zznY;
  }
  
  public boolean shouldReturnUrlsForImageAssets()
  {
    return zznW;
  }
  
  public static final class Builder
  {
    private boolean zznW = false;
    private int zznX = 0;
    private boolean zznY = false;
    
    public NativeAdOptions build()
    {
      return new NativeAdOptions(this, null);
    }
    
    public Builder setImageOrientation(int paramInt)
    {
      zznX = paramInt;
      return this;
    }
    
    public Builder setRequestMultipleImages(boolean paramBoolean)
    {
      zznY = paramBoolean;
      return this;
    }
    
    public Builder setReturnUrlsForImageAssets(boolean paramBoolean)
    {
      zznW = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */