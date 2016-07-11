package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgr
public class zzh
{
  public static final zzh zztd = new zzh();
  
  public static zzh zzcB()
  {
    return zztd;
  }
  
  public AdRequestParcel zza(Context paramContext, zzy paramzzy)
  {
    Object localObject1 = paramzzy.getBirthday();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      str1 = paramzzy.getContentUrl();
      i = paramzzy.getGender();
      localObject1 = paramzzy.getKeywords();
      if (((Set)localObject1).isEmpty()) {
        break label223;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      bool1 = paramzzy.isTestDevice(paramContext);
      j = paramzzy.zzcQ();
      localLocation = paramzzy.getLocation();
      localBundle = paramzzy.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramzzy.getManualImpressionsEnabled();
      str2 = paramzzy.getPublisherProvidedId();
      localObject2 = paramzzy.zzcN();
      if (localObject2 == null) {
        break label229;
      }
    }
    label223:
    label229:
    for (Object localObject2 = new SearchAdRequestParcel((SearchAdRequest)localObject2);; localObject2 = null)
    {
      Object localObject3 = null;
      Context localContext = paramContext.getApplicationContext();
      paramContext = (Context)localObject3;
      if (localContext != null)
      {
        paramContext = localContext.getPackageName();
        paramContext = zzp.zzbv().zza(Thread.currentThread().getStackTrace(), paramContext);
      }
      return new AdRequestParcel(6, l, localBundle, i, (List)localObject1, bool1, j, bool2, str2, (SearchAdRequestParcel)localObject2, localLocation, str1, paramzzy.zzcP(), paramzzy.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramzzy.zzcR())), paramzzy.zzcM(), paramContext);
      l = -1L;
      break;
      localObject1 = null;
      break label59;
    }
  }
  
  public RewardedVideoAdRequestParcel zza(Context paramContext, zzy paramzzy, String paramString)
  {
    return new RewardedVideoAdRequestParcel(zza(paramContext, paramzzy), paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */