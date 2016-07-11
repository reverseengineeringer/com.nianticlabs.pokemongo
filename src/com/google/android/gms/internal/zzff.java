package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzff
{
  private final boolean zzAv;
  private final boolean zzAw;
  private final boolean zzAx;
  private final boolean zzAy;
  private final boolean zzAz;
  
  private zzff(zza paramzza)
  {
    zzAv = zza.zza(paramzza);
    zzAw = zza.zzb(paramzza);
    zzAx = zza.zzc(paramzza);
    zzAy = zza.zzd(paramzza);
    zzAz = zza.zze(paramzza);
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", zzAv).put("tel", zzAw).put("calendar", zzAx).put("storePicture", zzAy).put("inlineVideo", zzAz);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class zza
  {
    private boolean zzAv;
    private boolean zzAw;
    private boolean zzAx;
    private boolean zzAy;
    private boolean zzAz;
    
    public zzff zzeh()
    {
      return new zzff(this, null);
    }
    
    public zza zzo(boolean paramBoolean)
    {
      zzAv = paramBoolean;
      return this;
    }
    
    public zza zzp(boolean paramBoolean)
    {
      zzAw = paramBoolean;
      return this;
    }
    
    public zza zzq(boolean paramBoolean)
    {
      zzAx = paramBoolean;
      return this;
    }
    
    public zza zzr(boolean paramBoolean)
    {
      zzAy = paramBoolean;
      return this;
    }
    
    public zza zzs(boolean paramBoolean)
    {
      zzAz = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */