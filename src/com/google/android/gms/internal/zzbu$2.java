package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzbu$2
  extends zzbu<Integer>
{
  zzbu$2(String paramString, Integer paramInteger)
  {
    super(paramString, paramInteger, null);
  }
  
  public Integer zzc(SharedPreferences paramSharedPreferences)
  {
    return Integer.valueOf(paramSharedPreferences.getInt(getKey(), ((Integer)zzde()).intValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbu.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */