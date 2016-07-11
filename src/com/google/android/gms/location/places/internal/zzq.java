package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzq
  implements PlacePhotoMetadata
{
  private int mIndex;
  private final int zzAG;
  private final int zzAH;
  private final String zzaHL;
  private final CharSequence zzaHM;
  
  public zzq(String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3)
  {
    zzaHL = paramString;
    zzAG = paramInt1;
    zzAH = paramInt2;
    zzaHM = paramCharSequence;
    mIndex = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzq)) {
        return false;
      }
      paramObject = (zzq)paramObject;
    } while ((zzAG == zzAG) && (zzAH == zzAH) && (zzw.equal(zzaHL, zzaHL)) && (zzw.equal(zzaHM, zzaHM)));
    return false;
  }
  
  public CharSequence getAttributions()
  {
    return zzaHM;
  }
  
  public int getMaxHeight()
  {
    return zzAH;
  }
  
  public int getMaxWidth()
  {
    return zzAG;
  }
  
  public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient)
  {
    return getScaledPhoto(paramGoogleApiClient, getMaxWidth(), getMaxHeight());
  }
  
  public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, final int paramInt1, final int paramInt2)
  {
    paramGoogleApiClient.zza(new zzf.zza(Places.zzaGz, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzf(this), zzq.zza(zzq.this), paramInt1, paramInt2, zzq.zzb(zzq.this));
      }
    });
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(zzAG), Integer.valueOf(zzAH), zzaHL, zzaHM });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public PlacePhotoMetadata zzxp()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */