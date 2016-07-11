package com.google.ads;

public enum AdRequest$ErrorCode
{
  private final String description;
  
  static
  {
    NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
  }
  
  private AdRequest$ErrorCode(String paramString)
  {
    description = paramString;
  }
  
  public String toString()
  {
    return description;
  }
}

/* Location:
 * Qualified Name:     com.google.ads.AdRequest.ErrorCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */