package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzbz
{
  private Context mContext = null;
  private String zzqV = null;
  private boolean zzvA;
  private String zzvB;
  private Map<String, String> zzvC;
  
  public zzbz(Context paramContext, String paramString)
  {
    mContext = paramContext;
    zzqV = paramString;
    zzvA = ((Boolean)zzby.zzuQ.get()).booleanValue();
    zzvB = ((String)zzby.zzuR.get());
    zzvC = new LinkedHashMap();
    zzvC.put("s", "gmob_sdk");
    zzvC.put("v", "3");
    zzvC.put("os", Build.VERSION.RELEASE);
    zzvC.put("sdk", Build.VERSION.SDK);
    zzvC.put("device", zzp.zzbv().zzgE());
    paramString = zzvC;
    if (paramContext.getApplicationContext() != null) {}
    for (paramContext = paramContext.getApplicationContext().getPackageName();; paramContext = paramContext.getPackageName())
    {
      paramString.put("app", paramContext);
      paramContext = zzp.zzbB().zzC(mContext);
      zzvC.put("network_coarse", Integer.toString(zzGE));
      zzvC.put("network_fine", Integer.toString(zzGF));
      return;
    }
  }
  
  Context getContext()
  {
    return mContext;
  }
  
  String zzbV()
  {
    return zzqV;
  }
  
  boolean zzdg()
  {
    return zzvA;
  }
  
  String zzdh()
  {
    return zzvB;
  }
  
  Map<String, String> zzdi()
  {
    return zzvC;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */