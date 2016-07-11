package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator()
  {
    public BinderWrapper zzaj(Parcel paramAnonymousParcel)
    {
      return new BinderWrapper(paramAnonymousParcel, null);
    }
    
    public BinderWrapper[] zzbC(int paramAnonymousInt)
    {
      return new BinderWrapper[paramAnonymousInt];
    }
  };
  private IBinder zzaeJ = null;
  
  public BinderWrapper() {}
  
  public BinderWrapper(IBinder paramIBinder)
  {
    zzaeJ = paramIBinder;
  }
  
  private BinderWrapper(Parcel paramParcel)
  {
    zzaeJ = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(zzaeJ);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.BinderWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */