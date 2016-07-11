package com.upsight.android.internal.persistence;

public final class Storable
{
  String id;
  String type;
  String value;
  
  Storable(String paramString1, String paramString2, String paramString3)
  {
    id = paramString1;
    type = paramString2;
    value = paramString3;
  }
  
  public static Storable create(String paramString1, String paramString2, String paramString3)
  {
    return new Storable(paramString1, paramString2, paramString3);
  }
  
  public String getID()
  {
    return id;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.Storable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */