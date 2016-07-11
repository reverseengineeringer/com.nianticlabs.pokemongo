package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException
  extends Exception
{
  private final Intent mIntent;
  
  public UserRecoverableException(String paramString, Intent paramIntent)
  {
    super(paramString);
    mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    return new Intent(mIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.UserRecoverableException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */