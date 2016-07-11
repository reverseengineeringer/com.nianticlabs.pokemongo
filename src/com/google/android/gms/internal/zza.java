package com.google.android.gms.internal;

import android.content.Intent;

public class zza
  extends zzr
{
  private Intent zza;
  
  public zza() {}
  
  public zza(zzi paramzzi)
  {
    super(paramzzi);
  }
  
  public String getMessage()
  {
    if (zza != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */