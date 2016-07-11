package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
  final int version;
  final int zzafq;
  int zzafr;
  String zzafs;
  IBinder zzaft;
  Scope[] zzafu;
  Bundle zzafv;
  Account zzafw;
  
  public GetServiceRequest(int paramInt)
  {
    version = 2;
    zzafr = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    zzafq = paramInt;
  }
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount)
  {
    version = paramInt1;
    zzafq = paramInt2;
    zzafr = paramInt3;
    zzafs = paramString;
    if (paramInt1 < 2) {}
    for (zzafw = zzaG(paramIBinder);; zzafw = paramAccount)
    {
      zzafu = paramArrayOfScope;
      zzafv = paramBundle;
      return;
      zzaft = paramIBinder;
    }
  }
  
  private Account zzaG(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zzb(zzp.zza.zzaH(paramIBinder));
    }
    return localAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public GetServiceRequest zzc(Account paramAccount)
  {
    zzafw = paramAccount;
    return this;
  }
  
  public GetServiceRequest zzc(zzp paramzzp)
  {
    if (paramzzp != null) {
      zzaft = paramzzp.asBinder();
    }
    return this;
  }
  
  public GetServiceRequest zzcl(String paramString)
  {
    zzafs = paramString;
    return this;
  }
  
  public GetServiceRequest zzd(Collection<Scope> paramCollection)
  {
    zzafu = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public GetServiceRequest zzg(Bundle paramBundle)
  {
    zzafv = paramBundle;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */