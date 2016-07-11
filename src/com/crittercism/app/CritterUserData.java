package com.crittercism.app;

import crittercism.android.dx;
import java.util.Map;

public class CritterUserData
{
  private Map a;
  private final boolean b;
  
  CritterUserData(Map paramMap, boolean paramBoolean)
  {
    a = paramMap;
    b = paramBoolean;
  }
  
  public boolean crashedOnLastLoad()
  {
    if (!a.containsKey("crashedOnLastLoad"))
    {
      if (b) {
        dx.c("User has opted out of Crittercism.  Returning false.");
      }
      for (;;)
      {
        return false;
        dx.c("CritterUserData instance has no value for crashedOnLastLoad().  Defaulting to false.");
      }
    }
    return ((Boolean)a.get("crashedOnLastLoad")).booleanValue();
  }
  
  public String getRateMyAppMessage()
  {
    if (!a.containsKey("message"))
    {
      if (!b) {
        break label41;
      }
      dx.c("User has opted out of Crittercism.  Returning null.");
    }
    for (;;)
    {
      return (String)a.get("message");
      label41:
      dx.c("CritterUserData instance has no value for getRateMyAppMessage().  Returning null.");
    }
  }
  
  public String getRateMyAppTitle()
  {
    if (!a.containsKey("title"))
    {
      if (!b) {
        break label41;
      }
      dx.c("User has opted out of Crittercism.  Returning null.");
    }
    for (;;)
    {
      return (String)a.get("title");
      label41:
      dx.c("CritterUserData instance has no value for getRateMyAppTitle().  Returning null.");
    }
  }
  
  public String getUserUUID()
  {
    if (!a.containsKey("userUUID"))
    {
      if (!b) {
        break label41;
      }
      dx.c("User has opted out of Crittercism.  Returning null.");
    }
    for (;;)
    {
      return (String)a.get("userUUID");
      label41:
      dx.c("CritterUserData instance has no value for getUserUUID().  Returning null.");
    }
  }
  
  public boolean isOptedOut()
  {
    if (!a.containsKey("optOutStatus")) {
      return b;
    }
    return ((Boolean)a.get("optOutStatus")).booleanValue();
  }
  
  public boolean shouldShowRateMyAppAlert()
  {
    if (!a.containsKey("shouldShowRateAppAlert"))
    {
      if (b) {
        dx.c("User has opted out of Crittercism.  Returning false.");
      }
      for (;;)
      {
        return false;
        dx.c("CritterUserData instance has no value for shouldShowMyRateAppAlert().  Defaulting to false.");
      }
    }
    return ((Boolean)a.get("shouldShowRateAppAlert")).booleanValue();
  }
}

/* Location:
 * Qualified Name:     com.crittercism.app.CritterUserData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */