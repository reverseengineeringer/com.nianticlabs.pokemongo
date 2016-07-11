package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback
  implements Parcelable
{
  public static final Parcelable.Creator<PendingCallback> CREATOR = new Parcelable.Creator()
  {
    public PendingCallback zzet(Parcel paramAnonymousParcel)
    {
      return new PendingCallback(paramAnonymousParcel);
    }
    
    public PendingCallback[] zzgD(int paramAnonymousInt)
    {
      return new PendingCallback[paramAnonymousInt];
    }
  };
  final IBinder zzaeJ;
  
  public PendingCallback(Parcel paramParcel)
  {
    zzaeJ = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBinder getIBinder()
  {
    return zzaeJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(zzaeJ);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.PendingCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */