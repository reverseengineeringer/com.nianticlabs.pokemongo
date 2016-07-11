package com.google.android.gms.ads.formats;

public final class NativeAdOptions$Builder
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

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdOptions.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */