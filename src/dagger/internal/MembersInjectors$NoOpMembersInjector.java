package dagger.internal;

import dagger.MembersInjector;

 enum MembersInjectors$NoOpMembersInjector
  implements MembersInjector<Object>
{
  INSTANCE;
  
  private MembersInjectors$NoOpMembersInjector() {}
  
  public void injectMembers(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.MembersInjectors.NoOpMembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */