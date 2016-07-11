package rx.internal.util;

import java.security.PrivilegedAction;

final class PlatformDependent$1
  implements PrivilegedAction<ClassLoader>
{
  public ClassLoader run()
  {
    return ClassLoader.getSystemClassLoader();
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.PlatformDependent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */