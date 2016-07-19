package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzdz.zzb;
import com.google.android.gms.internal.zzdz.zzd;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzis.zza;
import com.google.android.gms.internal.zzis.zzc;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzm
  extends zzhz
{
  static final long zzFi = TimeUnit.SECONDS.toMillis(10L);
  private static boolean zzFj = false;
  private static zzdz zzFk = null;
  private static zzdl zzFl = null;
  private static zzdp zzFm = null;
  private static zzdk zzFn = null;
  private static final Object zzpy = new Object();
  private final Context mContext;
  private final Object zzDh = new Object();
  private final zza.zza zzEe;
  private final AdRequestInfoParcel.zza zzEf;
  private zzdz.zzd zzFo;
  
  public zzm(Context paramContext, AdRequestInfoParcel.zza paramzza, zza.zza arg3)
  {
    super(true);
    zzEe = ???;
    mContext = paramContext;
    zzEf = paramzza;
    synchronized (zzpy)
    {
      if (!zzFj)
      {
        zzFm = new zzdp();
        zzFl = new zzdl(paramContext.getApplicationContext(), zzqj);
        zzFn = new zzc();
        zzFk = new zzdz(mContext.getApplicationContext(), zzEf.zzqj, (String)zzby.zzul.get(), new zzb(), new zza());
        zzFj = true;
      }
      return;
    }
  }
  
  private JSONObject zza(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    Bundle localBundle = zzEn.extras.getBundle("sdk_less_server_data");
    String str = zzEn.extras.getString("sdk_less_network_id");
    if (localBundle == null) {}
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = zzgu.zza(mContext, paramAdRequestInfoParcel, zzp.zzbB().zzC(mContext), null, null, new zzbr((String)zzby.zzul.get()), null, null, new ArrayList());
    } while (localJSONObject == null);
    try
    {
      paramAdRequestInfoParcel = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
      localHashMap = new HashMap();
      localHashMap.put("request_id", paramString);
      localHashMap.put("network_id", str);
      localHashMap.put("request_param", localJSONObject);
      localHashMap.put("data", localBundle);
      if (paramAdRequestInfoParcel != null)
      {
        localHashMap.put("adid", paramAdRequestInfoParcel.getId());
        if (!paramAdRequestInfoParcel.isLimitAdTrackingEnabled()) {
          break label203;
        }
        i = 1;
        localHashMap.put("lat", Integer.valueOf(i));
      }
    }
    catch (IOException paramAdRequestInfoParcel)
    {
      for (;;)
      {
        try
        {
          HashMap localHashMap;
          paramAdRequestInfoParcel = zzp.zzbv().zzz(localHashMap);
          return paramAdRequestInfoParcel;
        }
        catch (JSONException paramAdRequestInfoParcel)
        {
          int i;
          return null;
        }
        paramAdRequestInfoParcel = paramAdRequestInfoParcel;
        zzb.zzd("Cannot get advertising id info", paramAdRequestInfoParcel);
        paramAdRequestInfoParcel = null;
        continue;
        i = 0;
      }
    }
    catch (IllegalStateException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesNotAvailableException paramAdRequestInfoParcel)
    {
      for (;;) {}
    }
    catch (GooglePlayServicesRepairableException paramAdRequestInfoParcel)
    {
      label203:
      for (;;) {}
    }
  }
  
  protected static void zzc(zzbb paramzzbb)
  {
    paramzzbb.zza("/loadAd", zzFm);
    paramzzbb.zza("/fetchHttpRequest", zzFl);
    paramzzbb.zza("/invalidRequest", zzFn);
  }
  
  protected static void zzd(zzbb paramzzbb)
  {
    paramzzbb.zzb("/loadAd", zzFm);
    paramzzbb.zzb("/fetchHttpRequest", zzFl);
    paramzzbb.zzb("/invalidRequest", zzFn);
  }
  
  private AdResponseParcel zzf(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    final Object localObject = UUID.randomUUID().toString();
    final JSONObject localJSONObject = zza(paramAdRequestInfoParcel, (String)localObject);
    if (localJSONObject == null) {
      paramAdRequestInfoParcel = new AdResponseParcel(0);
    }
    for (;;)
    {
      return paramAdRequestInfoParcel;
      long l1 = zzp.zzbz().elapsedRealtime();
      Future localFuture = zzFm.zzY((String)localObject);
      zza.zzJt.post(new Runnable()
      {
        public void run()
        {
          zzm.zza(zzm.this, zzm.zzfO().zzdO());
          zzm.zzb(zzm.this).zza(new zzis.zzc()new zzis.zza
          {
            public void zzb(zzbe paramAnonymous2zzbe)
            {
              try
              {
                paramAnonymous2zzbe.zza("AFMA_getAdapterLessMediationAd", zzFq);
                return;
              }
              catch (Exception paramAnonymous2zzbe)
              {
                zzb.zzb("Error requesting an ad url", paramAnonymous2zzbe);
                zzm.zzfN().zzZ(zzFr);
              }
            }
          }, new zzis.zza()
          {
            public void run()
            {
              zzm.zzfN().zzZ(zzFr);
            }
          });
        }
      });
      long l2 = zzFi;
      long l3 = zzp.zzbz().elapsedRealtime();
      try
      {
        localObject = (JSONObject)localFuture.get(l2 - (l3 - l1), TimeUnit.MILLISECONDS);
        if (localObject == null) {
          return new AdResponseParcel(-1);
        }
      }
      catch (CancellationException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(-1);
      }
      catch (TimeoutException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(2);
      }
      catch (ExecutionException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(0);
        localObject = zzgu.zza(mContext, paramAdRequestInfoParcel, ((JSONObject)localObject).toString());
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (errorCode == -3) {
          continue;
        }
        paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
        if (!TextUtils.isEmpty(body)) {
          continue;
        }
        return new AdResponseParcel(3);
      }
      catch (InterruptedException paramAdRequestInfoParcel)
      {
        for (;;) {}
      }
    }
  }
  
  public void onStop()
  {
    synchronized (zzDh)
    {
      zza.zzJt.post(new Runnable()
      {
        public void run()
        {
          if (zzm.zzb(zzm.this) != null)
          {
            zzm.zzb(zzm.this).release();
            zzm.zza(zzm.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzbn()
  {
    zzb.zzaF("SdkLessAdLoaderBackgroundTask started.");
    final Object localObject = new AdRequestInfoParcel(zzEf, null, -1L);
    AdResponseParcel localAdResponseParcel = zzf((AdRequestInfoParcel)localObject);
    long l = zzp.zzbz().elapsedRealtime();
    localObject = new zzhs.zza((AdRequestInfoParcel)localObject, localAdResponseParcel, null, null, errorCode, l, zzEO, null);
    zza.zzJt.post(new Runnable()
    {
      public void run()
      {
        zzm.zza(zzm.this).zza(localObject);
        if (zzm.zzb(zzm.this) != null)
        {
          zzm.zzb(zzm.this).release();
          zzm.zza(zzm.this, null);
        }
      }
    });
  }
  
  public static class zza
    implements zzdz.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzd(paramzzbb);
    }
  }
  
  public static class zzb
    implements zzdz.zzb<zzbb>
  {
    public void zza(zzbb paramzzbb)
    {
      zzm.zzc(paramzzbb);
    }
  }
  
  public static class zzc
    implements zzdk
  {
    public void zza(zziz paramzziz, Map<String, String> paramMap)
    {
      paramzziz = (String)paramMap.get("request_id");
      paramMap = (String)paramMap.get("errors");
      zzb.zzaH("Invalid request: " + paramMap);
      zzm.zzfN().zzZ(paramzziz);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */