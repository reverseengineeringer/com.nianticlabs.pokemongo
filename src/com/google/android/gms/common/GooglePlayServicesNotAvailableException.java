package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException
  extends Exception
{
  public final int errorCode;
  
  public GooglePlayServicesNotAvailableException(int paramInt)
  {
    errorCode = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesNotAvailableException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */