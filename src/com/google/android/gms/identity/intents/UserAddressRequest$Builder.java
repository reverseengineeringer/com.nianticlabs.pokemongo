package com.google.android.gms.identity.intents;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest$Builder
{
  private UserAddressRequest$Builder(UserAddressRequest paramUserAddressRequest) {}
  
  public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification)
  {
    if (zzaDi.zzaDh == null) {
      zzaDi.zzaDh = new ArrayList();
    }
    zzaDi.zzaDh.add(paramCountrySpecification);
    return this;
  }
  
  public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection)
  {
    if (zzaDi.zzaDh == null) {
      zzaDi.zzaDh = new ArrayList();
    }
    zzaDi.zzaDh.addAll(paramCollection);
    return this;
  }
  
  public UserAddressRequest build()
  {
    if (zzaDi.zzaDh != null) {
      zzaDi.zzaDh = Collections.unmodifiableList(zzaDi.zzaDh);
    }
    return zzaDi;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.UserAddressRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */