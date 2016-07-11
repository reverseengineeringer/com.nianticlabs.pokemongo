package crittercism.android;

import java.net.SocketImpl;
import java.net.SocketImplFactory;

public final class ad
  implements SocketImplFactory
{
  private Class a;
  private SocketImplFactory b;
  private e c;
  private d d;
  
  public ad(Class paramClass, e parame, d paramd)
  {
    c = parame;
    d = paramd;
    a = paramClass;
    paramClass = a;
    if (paramClass == null) {
      throw new cl("Class was null");
    }
    try
    {
      paramClass.newInstance();
      return;
    }
    catch (Throwable paramClass)
    {
      throw new cl("Unable to create new instance", paramClass);
    }
  }
  
  public ad(SocketImplFactory paramSocketImplFactory, e parame, d paramd)
  {
    c = parame;
    d = paramd;
    b = paramSocketImplFactory;
    paramSocketImplFactory = b;
    if (paramSocketImplFactory == null) {
      throw new cl("Factory was null");
    }
    try
    {
      if (paramSocketImplFactory.createSocketImpl() == null) {
        throw new cl("Factory does not work");
      }
    }
    catch (Throwable paramSocketImplFactory)
    {
      throw new cl("Factory does not work", paramSocketImplFactory);
    }
  }
  
  public final SocketImpl createSocketImpl()
  {
    Object localObject1 = null;
    if (b != null) {
      localObject1 = b.createSocketImpl();
    }
    while (localObject1 != null)
    {
      return new ac(c, d, (SocketImpl)localObject1);
      Object localObject2 = a;
      try
      {
        localObject2 = (SocketImpl)a.newInstance();
        localObject1 = localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
    }
    return (SocketImpl)localObject1;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */