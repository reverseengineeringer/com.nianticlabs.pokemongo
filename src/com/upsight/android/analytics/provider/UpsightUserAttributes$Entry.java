package com.upsight.android.analytics.provider;

public class UpsightUserAttributes$Entry
{
  private Object mDefaultValue;
  private String mKey;
  
  public UpsightUserAttributes$Entry(String paramString, Object paramObject)
  {
    mKey = paramString;
    mDefaultValue = paramObject;
  }
  
  public Object getDefaultValue()
  {
    return mDefaultValue;
  }
  
  public String getKey()
  {
    return mKey;
  }
  
  public Class getType()
  {
    return mDefaultValue.getClass();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.provider.UpsightUserAttributes.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */