package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzbu$3
  extends zzbu<Long>
{
  zzbu$3(String paramString, Long paramLong)
  {
    super(paramString, paramLong, null);
  }
  
  public Long zzd(SharedPreferences paramSharedPreferences)
  {
    return Long.valueOf(paramSharedPreferences.getLong(getKey(), ((Long)zzde()).longValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbu.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */