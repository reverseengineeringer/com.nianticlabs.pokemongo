package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzbu$1
  extends zzbu<Boolean>
{
  zzbu$1(String paramString, Boolean paramBoolean)
  {
    super(paramString, paramBoolean, null);
  }
  
  public Boolean zzb(SharedPreferences paramSharedPreferences)
  {
    return Boolean.valueOf(paramSharedPreferences.getBoolean(getKey(), ((Boolean)zzde()).booleanValue()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbu.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */