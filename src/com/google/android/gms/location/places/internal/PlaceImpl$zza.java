package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;

public class PlaceImpl$zza
{
  private String mName;
  private int mVersionCode = 0;
  private LatLng zzaFS;
  private String zzaFU;
  private Uri zzaFV;
  private float zzaHk;
  private LatLngBounds zzaHl;
  private String zzaHm;
  private boolean zzaHn;
  private float zzaHo;
  private int zzaHp;
  private long zzaHq;
  private String zzaHs;
  private List<String> zzaHt;
  private boolean zzaHu;
  private Bundle zzaHy;
  private List<Integer> zzaHz;
  private String zzapU;
  private String zzwN;
  
  public zza zza(LatLng paramLatLng)
  {
    zzaFS = paramLatLng;
    return this;
  }
  
  public zza zza(LatLngBounds paramLatLngBounds)
  {
    zzaHl = paramLatLngBounds;
    return this;
  }
  
  public zza zzai(boolean paramBoolean)
  {
    zzaHn = paramBoolean;
    return this;
  }
  
  public zza zzaj(boolean paramBoolean)
  {
    zzaHu = paramBoolean;
    return this;
  }
  
  public zza zzdA(String paramString)
  {
    zzwN = paramString;
    return this;
  }
  
  public zza zzdB(String paramString)
  {
    mName = paramString;
    return this;
  }
  
  public zza zzdC(String paramString)
  {
    zzapU = paramString;
    return this;
  }
  
  public zza zzdD(String paramString)
  {
    zzaFU = paramString;
    return this;
  }
  
  public zza zzf(float paramFloat)
  {
    zzaHk = paramFloat;
    return this;
  }
  
  public zza zzg(float paramFloat)
  {
    zzaHo = paramFloat;
    return this;
  }
  
  public zza zzhs(int paramInt)
  {
    zzaHp = paramInt;
    return this;
  }
  
  public zza zzl(Uri paramUri)
  {
    zzaFV = paramUri;
    return this;
  }
  
  public zza zzt(List<Integer> paramList)
  {
    zzaHz = paramList;
    return this;
  }
  
  public zza zzu(List<String> paramList)
  {
    zzaHt = paramList;
    return this;
  }
  
  public PlaceImpl zzxn()
  {
    return new PlaceImpl(mVersionCode, zzwN, zzaHz, Collections.emptyList(), zzaHy, mName, zzapU, zzaFU, zzaHs, zzaHt, zzaFS, zzaHk, zzaHl, zzaHm, zzaFV, zzaHn, zzaHo, zzaHp, zzaHq, zzaHu, PlaceLocalization.zza(mName, zzapU, zzaFU, zzaHs, zzaHt));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceImpl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */