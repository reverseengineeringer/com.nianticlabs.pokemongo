package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeleteRequest> CREATOR = new zzf();
  final int mVersionCode;
  private final Credential zzSD;
  
  DeleteRequest(int paramInt, Credential paramCredential)
  {
    mVersionCode = paramInt;
    zzSD = paramCredential;
  }
  
  public DeleteRequest(Credential paramCredential)
  {
    this(1, paramCredential);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Credential getCredential()
  {
    return zzSD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.DeleteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */