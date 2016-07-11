package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzgr;
import java.util.ArrayList;
import java.util.List;

@zzgr
public final class zzf
{
  private Bundle mExtras;
  private Location zzaX;
  private boolean zzoN;
  private long zzsQ;
  private int zzsR;
  private List<String> zzsS;
  private boolean zzsT;
  private int zzsU;
  private String zzsV;
  private SearchAdRequestParcel zzsW;
  private String zzsX;
  private Bundle zzsY;
  private Bundle zzsZ;
  private List<String> zzta;
  private String zztb;
  private String zztc;
  
  public zzf()
  {
    zzsQ = -1L;
    mExtras = new Bundle();
    zzsR = -1;
    zzsS = new ArrayList();
    zzsT = false;
    zzsU = -1;
    zzoN = false;
    zzsV = null;
    zzsW = null;
    zzaX = null;
    zzsX = null;
    zzsY = new Bundle();
    zzsZ = new Bundle();
    zzta = new ArrayList();
    zztb = null;
    zztc = null;
  }
  
  public zzf(AdRequestParcel paramAdRequestParcel)
  {
    zzsQ = zzsB;
    mExtras = extras;
    zzsR = zzsC;
    zzsS = zzsD;
    zzsT = zzsE;
    zzsU = zzsF;
    zzoN = zzsG;
    zzsV = zzsH;
    zzsW = zzsI;
    zzaX = zzsJ;
    zzsX = zzsK;
    zzsY = zzsL;
    zzsZ = zzsM;
    zzta = zzsN;
    zztb = zzsO;
    zztc = zzsP;
  }
  
  public zzf zza(Location paramLocation)
  {
    zzaX = paramLocation;
    return this;
  }
  
  public AdRequestParcel zzcA()
  {
    return new AdRequestParcel(6, zzsQ, mExtras, zzsR, zzsS, zzsT, zzsU, zzoN, zzsV, zzsW, zzaX, zzsX, zzsY, zzsZ, zzta, zztb, zztc);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */