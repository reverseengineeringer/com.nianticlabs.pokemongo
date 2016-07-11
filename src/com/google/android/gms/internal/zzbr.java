package com.google.android.gms.internal;

import android.text.TextUtils;

@zzgr
public final class zzbr
{
  private String zzuc;
  private int zzud = -1;
  
  public zzbr()
  {
    this((String)zzby.zzul.zzde(), -1);
  }
  
  public zzbr(String paramString)
  {
    this(paramString, -1);
  }
  
  public zzbr(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)zzby.zzul.zzde();
    }
    for (;;)
    {
      zzuc = paramString;
      zzud = paramInt;
      return;
    }
  }
  
  public String zzdc()
  {
    return zzuc;
  }
  
  public int zzdd()
  {
    return zzud;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */