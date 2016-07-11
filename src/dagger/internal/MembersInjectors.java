package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors
{
  public static <T> MembersInjector<T> delegatingTo(MembersInjector<? super T> paramMembersInjector)
  {
    return paramMembersInjector;
  }
  
  public static <T> MembersInjector<T> noOp()
  {
    return NoOpMembersInjector.INSTANCE;
  }
  
  private static enum NoOpMembersInjector
    implements MembersInjector<Object>
  {
    INSTANCE;
    
    private NoOpMembersInjector() {}
    
    public void injectMembers(Object paramObject)
    {
      if (paramObject == null) {
        throw new NullPointerException();
      }
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.MembersInjectors
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */