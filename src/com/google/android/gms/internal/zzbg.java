package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class zzbg
  implements zzbf
{
  private final zzbe zzrL;
  private final HashSet<AbstractMap.SimpleEntry<String, zzdk>> zzrM;
  
  public zzbg(zzbe paramzzbe)
  {
    zzrL = paramzzbe;
    zzrM = new HashSet();
  }
  
  public void zza(String paramString, zzdk paramzzdk)
  {
    zzrL.zza(paramString, paramzzdk);
    zzrM.add(new AbstractMap.SimpleEntry(paramString, paramzzdk));
  }
  
  public void zza(String paramString1, String paramString2)
  {
    zzrL.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzrL.zza(paramString, paramJSONObject);
  }
  
  public void zzb(String paramString, zzdk paramzzdk)
  {
    zzrL.zzb(paramString, paramzzdk);
    zzrM.remove(new AbstractMap.SimpleEntry(paramString, paramzzdk));
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzrL.zzb(paramString, paramJSONObject);
  }
  
  public void zzck()
  {
    Iterator localIterator = zzrM.iterator();
    while (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      zzb.v("Unregistering eventhandler: " + ((zzdk)localSimpleEntry.getValue()).toString());
      zzrL.zzb((String)localSimpleEntry.getKey(), (zzdk)localSimpleEntry.getValue());
    }
    zzrM.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */