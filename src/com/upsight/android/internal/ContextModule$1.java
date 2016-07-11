package com.upsight.android.internal;

import android.util.Log;
import com.upsight.android.internal.logger.LogWriter;
import com.upsight.android.logger.UpsightLogger.Level;

class ContextModule$1
  implements LogWriter
{
  ContextModule$1(ContextModule paramContextModule) {}
  
  private void logMessage(String paramString1, UpsightLogger.Level paramLevel, String paramString2)
  {
    switch (ContextModule.3.$SwitchMap$com$upsight$android$logger$UpsightLogger$Level[paramLevel.ordinal()])
    {
    default: 
      return;
    case 1: 
      Log.v(paramString1, paramString2);
      return;
    case 2: 
      Log.d(paramString1, paramString2);
      return;
    case 3: 
      Log.i(paramString1, paramString2);
      return;
    case 4: 
      Log.w(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public void write(String paramString1, UpsightLogger.Level paramLevel, String paramString2)
  {
    if (paramString2.length() > 4000)
    {
      int j = paramString2.length() / 4000;
      int i = 0;
      if (i <= j)
      {
        int k = (i + 1) * 4000;
        if (k >= paramString2.length()) {
          logMessage(paramString1, paramLevel, paramString2.substring(i * 4000));
        }
        for (;;)
        {
          i += 1;
          break;
          logMessage(paramString1, paramLevel, paramString2.substring(i * 4000, k));
        }
      }
    }
    else
    {
      logMessage(paramString1, paramLevel, paramString2);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */