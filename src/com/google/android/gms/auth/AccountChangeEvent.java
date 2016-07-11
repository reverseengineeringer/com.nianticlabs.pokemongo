package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final int mVersion;
  final long zzRr;
  final String zzRs;
  final int zzRt;
  final int zzRu;
  final String zzRv;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    mVersion = paramInt1;
    zzRr = paramLong;
    zzRs = ((String)zzx.zzw(paramString1));
    zzRt = paramInt2;
    zzRu = paramInt3;
    zzRv = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    mVersion = 1;
    zzRr = paramLong;
    zzRs = ((String)zzx.zzw(paramString1));
    zzRt = paramInt1;
    zzRu = paramInt2;
    zzRv = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      paramObject = (AccountChangeEvent)paramObject;
    } while ((mVersion == mVersion) && (zzRr == zzRr) && (zzw.equal(zzRs, zzRs)) && (zzRt == zzRt) && (zzRu == zzRu) && (zzw.equal(zzRv, zzRv)));
    return false;
    return false;
  }
  
  public String getAccountName()
  {
    return zzRs;
  }
  
  public String getChangeData()
  {
    return zzRv;
  }
  
  public int getChangeType()
  {
    return zzRt;
  }
  
  public int getEventIndex()
  {
    return zzRu;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(mVersion), Long.valueOf(zzRr), zzRs, Integer.valueOf(zzRt), Integer.valueOf(zzRu), zzRv });
  }
  
  public String toString()
  {
    String str = "UNKNOWN";
    switch (zzRt)
    {
    }
    for (;;)
    {
      return "AccountChangeEvent {accountName = " + zzRs + ", changeType = " + str + ", changeData = " + zzRv + ", eventIndex = " + zzRu + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */