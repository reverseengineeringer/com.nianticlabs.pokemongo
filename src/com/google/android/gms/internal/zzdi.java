package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public final class zzdi
  implements zzdk
{
  private void zzb(zziz paramzziz, Map<String, String> paramMap)
  {
    String str2 = (String)paramMap.get("label");
    String str1 = (String)paramMap.get("start_label");
    paramMap = (String)paramMap.get("timestamp");
    if (TextUtils.isEmpty(str2))
    {
      zzb.zzaH("No label given for CSI tick.");
      return;
    }
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No timestamp given for CSI tick.");
      return;
    }
    try
    {
      long l = zzc(Long.parseLong(paramMap));
      paramMap = str1;
      if (TextUtils.isEmpty(str1)) {
        paramMap = "native:view_load";
      }
      paramzziz.zzhn().zza(str2, paramMap, l);
      return;
    }
    catch (NumberFormatException paramzziz)
    {
      zzb.zzd("Malformed timestamp for CSI tick.", paramzziz);
    }
  }
  
  private long zzc(long paramLong)
  {
    return paramLong - zzp.zzbz().currentTimeMillis() + zzp.zzbz().elapsedRealtime();
  }
  
  private void zzc(zziz paramzziz, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No value given for CSI experiment.");
      return;
    }
    paramzziz = paramzziz.zzhn().zzdm();
    if (paramzziz == null)
    {
      zzb.zzaH("No ticker for WebView, dropping experiment ID.");
      return;
    }
    paramzziz.zze("e", paramMap);
  }
  
  private void zzd(zziz paramzziz, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      zzb.zzaH("No name given for CSI extra.");
      return;
    }
    paramzziz = paramzziz.zzhn().zzdm();
    if (paramzziz == null)
    {
      zzb.zzaH("No ticker for WebView, dropping extra parameter.");
      return;
    }
    paramzziz.zze(str, paramMap);
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if ("tick".equals(str)) {
      zzb(paramzziz, paramMap);
    }
    do
    {
      return;
      if ("experiment".equals(str))
      {
        zzc(paramzziz, paramMap);
        return;
      }
    } while (!"extra".equals(str));
    zzd(paramzziz, paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */