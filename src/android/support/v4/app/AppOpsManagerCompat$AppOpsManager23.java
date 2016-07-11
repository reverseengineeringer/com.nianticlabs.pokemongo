package android.support.v4.app;

import android.content.Context;

class AppOpsManagerCompat$AppOpsManager23
  extends AppOpsManagerCompat.AppOpsManagerImpl
{
  private AppOpsManagerCompat$AppOpsManager23()
  {
    super(null);
  }
  
  public int noteOp(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    return AppOpsManagerCompat23.noteOp(paramContext, paramString1, paramInt, paramString2);
  }
  
  public int noteProxyOp(Context paramContext, String paramString1, String paramString2)
  {
    return AppOpsManagerCompat23.noteProxyOp(paramContext, paramString1, paramString2);
  }
  
  public String permissionToOp(String paramString)
  {
    return AppOpsManagerCompat23.permissionToOp(paramString);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.AppOpsManagerCompat.AppOpsManager23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */