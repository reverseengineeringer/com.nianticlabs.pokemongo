package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzgr;

@zzgr
final class zzb$zza
  extends Exception
{
  private final int zzDv;
  
  public zzb$zza(String paramString, int paramInt)
  {
    super(paramString);
    zzDv = paramInt;
  }
  
  public int getErrorCode()
  {
    return zzDv;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */