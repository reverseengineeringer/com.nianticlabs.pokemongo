package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zza();
  private final int mVersionCode;
  List<CountrySpecification> zzaDh;
  
  UserAddressRequest()
  {
    mVersionCode = 1;
  }
  
  UserAddressRequest(int paramInt, List<CountrySpecification> paramList)
  {
    mVersionCode = paramInt;
    zzaDh = paramList;
  }
  
  public static Builder newBuilder()
  {
    UserAddressRequest localUserAddressRequest = new UserAddressRequest();
    localUserAddressRequest.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification)
    {
      if (zzaDh == null) {
        zzaDh = new ArrayList();
      }
      zzaDh.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection)
    {
      if (zzaDh == null) {
        zzaDh = new ArrayList();
      }
      zzaDh.addAll(paramCollection);
      return this;
    }
    
    public UserAddressRequest build()
    {
      if (zzaDh != null) {
        zzaDh = Collections.unmodifiableList(zzaDh);
      }
      return UserAddressRequest.this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.UserAddressRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */