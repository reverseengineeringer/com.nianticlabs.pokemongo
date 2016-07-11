package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzgm
  implements Callable<zzhs>
{
  private static final long zzDE = TimeUnit.SECONDS.toMillis(60L);
  private final Context mContext;
  private final zzih zzDF;
  private final zzn zzDG;
  private final zzbc zzDH;
  private boolean zzDI;
  private List<String> zzDJ;
  private final zzhs.zza zzDe;
  private int zzDv;
  private final Object zzpd = new Object();
  private final zzan zzwL;
  
  public zzgm(Context paramContext, zzn paramzzn, zzbc paramzzbc, zzih paramzzih, zzan paramzzan, zzhs.zza paramzza)
  {
    mContext = paramContext;
    zzDG = paramzzn;
    zzDF = paramzzih;
    zzDH = paramzzbc;
    zzDe = paramzza;
    zzwL = paramzzan;
    zzDI = false;
    zzDv = -2;
    zzDJ = null;
  }
  
  private zzh.zza zza(zzbb paramzzbb, zza paramzza, JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException
  {
    if (zzfD()) {
      return null;
    }
    Object localObject = zzc(paramJSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
    {
      zzDJ = ((List)localObject);
      paramzza = paramzza.zza(this, paramJSONObject);
      if (paramzza != null) {
        break;
      }
      zzb.e("Failed to retrieve ad assets.");
      return null;
    }
    paramzza.zza(new zzh(mContext, zzDG, paramzzbb, zzwL, paramJSONObject, paramzza, zzDe.zzHC.zzqj));
    return paramzza;
  }
  
  private zzhs zza(zzh.zza paramzza)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        int j = zzDv;
        int i = j;
        if (paramzza == null)
        {
          i = j;
          if (zzDv == -2) {
            i = 0;
          }
        }
        if (i != -2)
        {
          paramzza = null;
          return new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, i, zzDe.zzHD.zzyZ, zzDJ, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, false, null, null, null, null, null, 0L, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHA, zzDe.zzHD.zzEP, zzDe.zzHw, paramzza);
        }
      }
    }
  }
  
  private zziq<zzc> zza(JSONObject paramJSONObject, final boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    final double d;
    for (String str = paramJSONObject.getString("url");; str = paramJSONObject.optString("url"))
    {
      d = paramJSONObject.optDouble("scale", 1.0D);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      zza(0, paramBoolean1);
      return new zzio(null);
    }
    if (paramBoolean2) {
      return new zzio(new zzc(null, Uri.parse(str), d));
    }
    zzDF.zza(str, new zzih.zza()
    {
      public zzc zzfE()
      {
        zza(2, paramBoolean1);
        return null;
      }
      
      public zzc zzg(InputStream paramAnonymousInputStream)
      {
        try
        {
          paramAnonymousInputStream = zzmt.zzk(paramAnonymousInputStream);
          if (paramAnonymousInputStream == null)
          {
            zza(2, paramBoolean1);
            return null;
          }
        }
        catch (IOException paramAnonymousInputStream)
        {
          for (;;)
          {
            paramAnonymousInputStream = null;
          }
          paramAnonymousInputStream = BitmapFactory.decodeByteArray(paramAnonymousInputStream, 0, paramAnonymousInputStream.length);
          if (paramAnonymousInputStream == null)
          {
            zza(2, paramBoolean1);
            return null;
          }
          paramAnonymousInputStream.setDensity((int)(160.0D * d));
        }
        return new zzc(new BitmapDrawable(Resources.getSystem(), paramAnonymousInputStream), Uri.parse(zzAs), d);
      }
    });
  }
  
  private void zza(zzh.zza paramzza, zzbb paramzzbb)
  {
    if (!(paramzza instanceof zzf)) {
      return;
    }
    final Object localObject = (zzf)paramzza;
    paramzza = new zzb();
    localObject = new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        paramAnonymouszziz = (String)paramAnonymousMap.get("asset");
        zzgm.zza(zzgm.this, localObject, paramAnonymouszziz);
      }
    };
    zzDZ = ((zzdk)localObject);
    paramzzbb.zza("/nativeAdCustomClick", (zzdk)localObject);
  }
  
  private Integer zzb(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      int i = Color.rgb(paramJSONObject.getInt("r"), paramJSONObject.getInt("g"), paramJSONObject.getInt("b"));
      return Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private JSONObject zzb(final zzbb paramzzbb)
    throws TimeoutException, JSONException
  {
    if (zzfD()) {
      return null;
    }
    final zzin localzzin = new zzin();
    final zzb localzzb = new zzb();
    zzdk local1 = new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        paramzzbb.zzb("/nativeAdPreProcess", localzzbzzDZ);
        try
        {
          paramAnonymouszziz = (String)paramAnonymousMap.get("success");
          if (!TextUtils.isEmpty(paramAnonymouszziz))
          {
            localzzin.zzf(new JSONObject(paramAnonymouszziz).getJSONArray("ads").getJSONObject(0));
            return;
          }
        }
        catch (JSONException paramAnonymouszziz)
        {
          zzb.zzb("Malformed native JSON response.", paramAnonymouszziz);
          zzC(0);
          zzx.zza(zzfD(), "Unable to set the ad state error!");
          localzzin.zzf(null);
        }
      }
    };
    zzDZ = local1;
    paramzzbb.zza("/nativeAdPreProcess", local1);
    paramzzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(zzDe.zzHD.body));
    return (JSONObject)localzzin.get(zzDE, TimeUnit.MILLISECONDS);
  }
  
  private void zzb(zzcu paramzzcu, String paramString)
  {
    try
    {
      zzcy localzzcy = zzDG.zzr(paramzzcu.getCustomTemplateId());
      if (localzzcy != null) {
        localzzcy.zza(paramzzcu, paramString);
      }
      return;
    }
    catch (RemoteException paramzzcu)
    {
      zzb.zzd("Failed to call onCustomClick for asset " + paramString + ".", paramzzcu);
    }
  }
  
  private String[] zzc(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    paramString = new String[paramJSONObject.length()];
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString[i] = paramJSONObject.getString(i);
      i += 1;
    }
    return paramString;
  }
  
  private static List<Drawable> zzd(List<zzc> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((Drawable)zze.zzp(((zzc)paramList.next()).zzdv()));
    }
    return localArrayList;
  }
  
  private zzbb zzfC()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (zzfD()) {
      return null;
    }
    String str = (String)zzby.zzvj.get();
    if (zzDe.zzHD.zzBF.indexOf("https") == 0) {}
    for (Object localObject = "https:";; localObject = "http:")
    {
      localObject = (String)localObject + str;
      localObject = (zzbb)zzDH.zza(mContext, zzDe.zzHC.zzqj, (String)localObject, zzwL).get(zzDE, TimeUnit.MILLISECONDS);
      ((zzbb)localObject).zza(zzDG, zzDG, zzDG, zzDG, false, null, null, null, null);
      return (zzbb)localObject;
    }
  }
  
  public void zzC(int paramInt)
  {
    synchronized (zzpd)
    {
      zzDI = true;
      zzDv = paramInt;
      return;
    }
  }
  
  public zziq<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    for (paramJSONObject = paramJSONObject.getJSONObject(paramString);; paramJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return zza(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public List<zziq<zzc>> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws JSONException
  {
    if (paramBoolean1) {}
    ArrayList localArrayList;
    for (paramJSONObject = paramJSONObject.getJSONArray(paramString);; paramJSONObject = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
        break;
      }
      zza(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3) {}
    for (int i = paramJSONObject.length();; i = 1)
    {
      int j = 0;
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
        paramString = localJSONObject;
        if (localJSONObject == null) {
          paramString = new JSONObject();
        }
        localArrayList.add(zza(paramString, paramBoolean1, paramBoolean2));
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public Future<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    throws JSONException
  {
    paramString = paramJSONObject.getJSONObject(paramString);
    boolean bool = paramString.optBoolean("require", true);
    paramJSONObject = paramString;
    if (paramString == null) {
      paramJSONObject = new JSONObject();
    }
    return zza(paramJSONObject, bool, paramBoolean);
  }
  
  public void zza(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      zzC(paramInt);
    }
  }
  
  protected zza zzd(JSONObject paramJSONObject)
    throws JSONException, TimeoutException
  {
    if (zzfD()) {
      return null;
    }
    final String str = paramJSONObject.getString("template_id");
    boolean bool1;
    if (zzDe.zzHC.zzqB != null)
    {
      bool1 = zzDe.zzHC.zzqB.zzwR;
      if (zzDe.zzHC.zzqB == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool2 = zzDe.zzHC.zzqB.zzwT;; bool2 = false)
    {
      if (!"2".equals(str)) {
        break label103;
      }
      return new zzgn(bool1, bool2);
      bool1 = false;
      break;
    }
    label103:
    if ("1".equals(str)) {
      return new zzgo(bool1, bool2);
    }
    if ("3".equals(str))
    {
      str = paramJSONObject.getString("custom_template_id");
      final zzin localzzin = new zzin();
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          localzzin.zzf(zzgm.zza(zzgm.this).zzbo().get(str));
        }
      });
      if (localzzin.get(zzDE, TimeUnit.MILLISECONDS) != null) {
        return new zzgp(bool1);
      }
      zzb.e("No handler for custom template: " + paramJSONObject.getString("custom_template_id"));
    }
    for (;;)
    {
      return null;
      zzC(0);
    }
  }
  
  public zziq<zza> zze(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null) {
      return new zzio(null);
    }
    final String str = localJSONObject.optString("text");
    final int i = localJSONObject.optInt("text_size", -1);
    final Integer localInteger1 = zzb(localJSONObject, "text_color");
    final Integer localInteger2 = zzb(localJSONObject, "bg_color");
    final int j = localJSONObject.optInt("animation_ms", 1000);
    final int k = localJSONObject.optInt("presentation_ms", 4000);
    paramJSONObject = new ArrayList();
    if (localJSONObject.optJSONArray("images") != null) {
      paramJSONObject = zza(localJSONObject, "images", false, false, true);
    }
    for (;;)
    {
      zzip.zza(zzip.zzh(paramJSONObject), new zzip.zza()
      {
        public zza zzf(List<zzc> paramAnonymousList)
        {
          if (paramAnonymousList != null) {
            for (;;)
            {
              try
              {
                if (paramAnonymousList.isEmpty()) {
                  break;
                }
                String str = str;
                List localList = zzgm.zze(paramAnonymousList);
                Integer localInteger1 = localInteger2;
                Integer localInteger2 = localInteger1;
                if (i > 0)
                {
                  paramAnonymousList = Integer.valueOf(i);
                  paramAnonymousList = new zza(str, localList, localInteger1, localInteger2, paramAnonymousList, k + j);
                }
              }
              catch (RemoteException paramAnonymousList)
              {
                zzb.zzb("Could not get attribution icon", paramAnonymousList);
                return null;
              }
              paramAnonymousList = null;
            }
          }
          paramAnonymousList = null;
          return paramAnonymousList;
        }
      });
      paramJSONObject.add(zza(localJSONObject, "image", false, false));
    }
  }
  
  public zzhs zzfB()
  {
    try
    {
      Object localObject1 = zzfC();
      Object localObject2 = zzb((zzbb)localObject1);
      localObject2 = zza((zzbb)localObject1, zzd((JSONObject)localObject2), (JSONObject)localObject2);
      zza((zzh.zza)localObject2, (zzbb)localObject1);
      localObject1 = zza((zzh.zza)localObject2);
      return (zzhs)localObject1;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzd("Malformed native JSON response.", localJSONException);
      if (!zzDI) {
        zzC(0);
      }
      return zza(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzb.zzd("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public boolean zzfD()
  {
    synchronized (zzpd)
    {
      boolean bool = zzDI;
      return bool;
    }
  }
  
  public static abstract interface zza<T extends zzh.zza>
  {
    public abstract T zza(zzgm paramzzgm, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
  
  class zzb
  {
    public zzdk zzDZ;
    
    zzb() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */