package com.upsight.android.analytics.internal.provider;

import com.upsight.android.UpsightContext;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UserAttributes_Factory
  implements Factory<UserAttributes>
{
  private final MembersInjector<UserAttributes> membersInjector;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!UserAttributes_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserAttributes_Factory(MembersInjector<UserAttributes> paramMembersInjector, Provider<UpsightContext> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<UserAttributes> create(MembersInjector<UserAttributes> paramMembersInjector, Provider<UpsightContext> paramProvider)
  {
    return new UserAttributes_Factory(paramMembersInjector, paramProvider);
  }
  
  public UserAttributes get()
  {
    UserAttributes localUserAttributes = new UserAttributes((UpsightContext)upsightProvider.get());
    membersInjector.injectMembers(localUserAttributes);
    return localUserAttributes;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.UserAttributes_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */