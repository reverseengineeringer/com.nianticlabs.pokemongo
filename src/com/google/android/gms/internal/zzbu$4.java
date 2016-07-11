package com.google.android.gms.internal;

import android.content.SharedPreferences;

final class zzbu$4
  extends zzbu<String>
{
  zzbu$4(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, null);
  }
  
  public String zze(SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getString(getKey(), (String)zzde());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbu.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */