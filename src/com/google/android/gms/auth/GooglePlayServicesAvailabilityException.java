package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int zzRy;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    zzRy = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return zzRy;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.GooglePlayServicesAvailabilityException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */