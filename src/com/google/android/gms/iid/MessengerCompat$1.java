package com.google.android.gms.iid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MessengerCompat$1
  implements Parcelable.Creator<MessengerCompat>
{
  public MessengerCompat zzey(Parcel paramParcel)
  {
    paramParcel = paramParcel.readStrongBinder();
    if (paramParcel != null) {
      return new MessengerCompat(paramParcel);
    }
    return null;
  }
  
  public MessengerCompat[] zzgJ(int paramInt)
  {
    return new MessengerCompat[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */