package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();
  final int mVersion;
  final List<AccountChangeEvent> zzoQ;
  
  AccountChangeEventsResponse(int paramInt, List<AccountChangeEvent> paramList)
  {
    mVersion = paramInt;
    zzoQ = ((List)zzx.zzw(paramList));
  }
  
  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    mVersion = 1;
    zzoQ = ((List)zzx.zzw(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<AccountChangeEvent> getEvents()
  {
    return zzoQ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */