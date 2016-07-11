package com.google.android.gms.gcm;

import android.os.Bundle;

public class TaskParams
{
  private final Bundle extras;
  private final String tag;
  
  public TaskParams(String paramString)
  {
    this(paramString, null);
  }
  
  public TaskParams(String paramString, Bundle paramBundle)
  {
    tag = paramString;
    extras = paramBundle;
  }
  
  public Bundle getExtras()
  {
    return extras;
  }
  
  public String getTag()
  {
    return tag;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.TaskParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */