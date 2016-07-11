package com.upsight.android;

import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.logger.UpsightLogger.Level;
import java.util.EnumSet;

class UpsightContextCompat$NoOpLogger
  implements UpsightLogger
{
  public void d(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void i(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
  
  public void setLogLevel(String paramString, EnumSet<UpsightLogger.Level> paramEnumSet) {}
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void v(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void w(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightContextCompat.NoOpLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */