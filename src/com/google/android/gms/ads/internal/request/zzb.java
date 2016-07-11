package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmn;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzb
  extends zzhz
  implements zzc.zza
{
  private final Context mContext;
  AdResponseParcel zzDf;
  private Runnable zzDg;
  private final Object zzDh = new Object();
  private final zza.zza zzEe;
  private final AdRequestInfoParcel.zza zzEf;
  zzhz zzEg;
  private final zzan zzwL;
  zzee zzzA;
  private AdRequestInfoParcel zzzz;
  
  public zzb(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza.zza paramzza1)
  {
    zzEe = paramzza1;
    mContext = paramContext;
    zzEf = paramzza;
    zzwL = paramzzan;
  }
  
  private void zzc(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaG(paramString);
      if (zzDf != null) {
        break label84;
      }
    }
    label84:
    for (zzDf = new AdResponseParcel(paramInt);; zzDf = new AdResponseParcel(paramInt, zzDf.zzzc))
    {
      paramString = new zzhs.zza(zzzz, zzDf, zzzA, null, paramInt, -1L, zzDf.zzEO, null);
      zzEe.zza(paramString);
      return;
      com.google.android.gms.ads.internal.util.client.zzb.zzaH(paramString);
      break;
    }
  }
  
  public void onStop()
  {
    synchronized (zzDh)
    {
      if (zzEg != null) {
        zzEg.cancel();
      }
      return;
    }
  }
  
  zzhz zzb(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return zzc.zza(mContext, paramAdRequestInfoParcel, this);
  }
  
  public void zzb(AdResponseParcel arg1)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received ad response.");
    zzDf = ???;
    long l = zzp.zzbz().elapsedRealtime();
    synchronized (zzDh)
    {
      zzEg = null;
      try
      {
        if ((zzDf.errorCode != -2) && (zzDf.errorCode != -3)) {
          throw new zza("There was a problem getting an ad response. ErrorCode: " + zzDf.errorCode, zzDf.errorCode);
        }
      }
      catch (zza ???)
      {
        zzc(???.getErrorCode(), ???.getMessage());
        zzid.zzIE.removeCallbacks(zzDg);
        return;
      }
    }
    zzfG();
    if (zzzz.zzqn.zztg != null) {}
    for (??? = zzc(zzzz);; ??? = null)
    {
      zzw(zzDf.zzEU);
      if (!TextUtils.isEmpty(zzDf.zzES)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(zzDf.zzES);
          ??? = new zzhs.zza(zzzz, zzDf, zzzA, ???, -2, l, zzDf.zzEO, localJSONObject);
          zzEe.zza(???);
          zzid.zzIE.removeCallbacks(zzDg);
          return;
        }
        catch (Exception localException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void zzbn()
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdLoaderBackgroundTask started.");
    ??? = zzwL.zzab().zzb(mContext);
    zzDg = new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          if (zzEg == null) {
            return;
          }
          onStop();
          zzb.zza(zzb.this, 2, "Timed out waiting for ad response.");
          return;
        }
      }
    };
    zzid.zzIE.postDelayed(zzDg, ((Long)zzby.zzvv.get()).longValue());
    long l = zzp.zzbz().elapsedRealtime();
    zzzz = new AdRequestInfoParcel(zzEf, (String)???, l);
    synchronized (zzDh)
    {
      zzEg = zzb(zzzz);
      if (zzEg == null)
      {
        zzc(0, "Could not start the ad request service.");
        zzid.zzIE.removeCallbacks(zzDg);
      }
      return;
    }
  }
  
  protected AdSizeParcel zzc(AdRequestInfoParcel paramAdRequestInfoParcel)
    throws zzb.zza
  {
    if (zzDf.zzEN == null) {
      throw new zza("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = zzDf.zzEN.split("x");
    if (localObject.length != 2) {
      throw new zza("Invalid ad size format from the ad response: " + zzDf.zzEN, 0);
    }
    for (;;)
    {
      int i;
      AdSizeParcel localAdSizeParcel;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = zzqn.zztg;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localAdSizeParcel = localObject[i];
        float f = mContext.getResources().getDisplayMetrics().density;
        if (width == -1)
        {
          j = (int)(widthPixels / f);
          if (height != -2) {
            break label257;
          }
          k = (int)(heightPixels / f);
          if ((m != j) || (n != k)) {
            break label267;
          }
          return new AdSizeParcel(localAdSizeParcel, zzqn.zztg);
        }
      }
      catch (NumberFormatException paramAdRequestInfoParcel)
      {
        throw new zza("Invalid ad size number from the ad response: " + zzDf.zzEN, 0);
      }
      int j = width;
      continue;
      label257:
      int k = height;
      continue;
      label267:
      i += 1;
    }
    throw new zza("The ad size from the ad response was not one of the requested sizes: " + zzDf.zzEN, 0);
  }
  
  protected void zzfG()
    throws zzb.zza
  {
    if (zzDf.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(zzDf.body)) {
        throw new zza("No fill from ad server.", 3);
      }
      zzp.zzby().zza(mContext, zzDf.zzEv);
    } while (!zzDf.zzEK);
    try
    {
      zzzA = new zzee(zzDf.body);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new zza("Could not parse mediation config: " + zzDf.body, 0);
    }
  }
  
  protected void zzw(boolean paramBoolean)
  {
    zzp.zzby().zzA(paramBoolean);
    zzbk localzzbk = zzp.zzby().zzE(mContext);
    if ((localzzbk != null) && (!localzzbk.isAlive()))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("start fetching content...");
      localzzbk.zzct();
    }
  }
  
  @zzgr
  static final class zza
    extends Exception
  {
    private final int zzDv;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzDv = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzDv;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */