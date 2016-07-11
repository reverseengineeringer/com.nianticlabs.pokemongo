package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzgr
public final class zzes
  implements MediationAdRequest
{
  private final Date zzaT;
  private final Set<String> zzaV;
  private final boolean zzaW;
  private final Location zzaX;
  private final int zzsR;
  private final int zzzI;
  
  public zzes(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2)
  {
    zzaT = paramDate;
    zzsR = paramInt1;
    zzaV = paramSet;
    zzaX = paramLocation;
    zzaW = paramBoolean;
    zzzI = paramInt2;
  }
  
  public Date getBirthday()
  {
    return zzaT;
  }
  
  public int getGender()
  {
    return zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return zzaV;
  }
  
  public Location getLocation()
  {
    return zzaX;
  }
  
  public boolean isTesting()
  {
    return zzaW;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return zzzI;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */