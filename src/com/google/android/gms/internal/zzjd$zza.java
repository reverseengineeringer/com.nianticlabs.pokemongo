package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzgr
public class zzjd$zza
  extends MutableContextWrapper
{
  private Activity zzJn;
  private Context zzKC;
  private Context zzqZ;
  
  public zzjd$zza(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }
  
  public Object getSystemService(String paramString)
  {
    return zzKC.getSystemService(paramString);
  }
  
  public void setBaseContext(Context paramContext)
  {
    zzqZ = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null)
    {
      zzJn = localActivity;
      zzKC = paramContext;
      super.setBaseContext(zzqZ);
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if ((zzJn != null) && (!zzmx.isAtLeastL()))
    {
      zzJn.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    zzqZ.startActivity(paramIntent);
  }
  
  public Activity zzgZ()
  {
    return zzJn;
  }
  
  public Context zzha()
  {
    return zzKC;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */