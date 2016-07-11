package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzz();
  final int mVersionCode;
  private boolean zzabG;
  IBinder zzaeH;
  private ConnectionResult zzagq;
  private boolean zzagr;
  
  public ResolveAccountResponse(int paramInt)
  {
    this(new ConnectionResult(paramInt, null));
  }
  
  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzaeH = paramIBinder;
    zzagq = paramConnectionResult;
    zzabG = paramBoolean1;
    zzagr = paramBoolean2;
  }
  
  public ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse)) {
        return false;
      }
      paramObject = (ResolveAccountResponse)paramObject;
    } while ((zzagq.equals(zzagq)) && (zzpq().equals(((ResolveAccountResponse)paramObject).zzpq())));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz.zza(this, paramParcel, paramInt);
  }
  
  public zzp zzpq()
  {
    return zzp.zza.zzaH(zzaeH);
  }
  
  public ConnectionResult zzpr()
  {
    return zzagq;
  }
  
  public boolean zzps()
  {
    return zzabG;
  }
  
  public boolean zzpt()
  {
    return zzagr;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */