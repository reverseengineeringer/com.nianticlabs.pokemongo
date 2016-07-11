package com.google.android.gms.common.api;

public abstract interface Api$ApiOptions
{
  public static abstract interface HasOptions
    extends Api.ApiOptions
  {}
  
  public static final class NoOptions
    implements Api.ApiOptions.NotRequiredOptions
  {}
  
  public static abstract interface NotRequiredOptions
    extends Api.ApiOptions
  {}
  
  public static abstract interface Optional
    extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
  {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.ApiOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */