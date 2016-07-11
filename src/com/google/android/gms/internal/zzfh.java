package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzfh
{
  private final String zzAK;
  private final zziz zzoM;
  
  public zzfh(zziz paramzziz)
  {
    this(paramzziz, "");
  }
  
  public zzfh(zziz paramzziz, String paramString)
  {
    zzoM = paramzziz;
    zzAK = paramString;
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      zzoM.zzb("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void zzak(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", zzAK);
      zzoM.zzb("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public void zzal(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("js", paramString);
      zzoM.zzb("onReadyEventReceived", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occured while dispatching ready Event.", paramString);
    }
  }
  
  public void zzam(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      zzoM.zzb("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occured while dispatching state change.", paramString);
    }
  }
  
  public void zzb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzoM.zzb("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  public void zzc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      zzoM.zzb("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while dispatching default position.", localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */