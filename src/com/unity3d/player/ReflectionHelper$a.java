package com.unity3d.player;

import java.lang.reflect.Member;

final class ReflectionHelper$a
{
  public volatile Member a;
  private final Class b;
  private final String c;
  private final String d;
  private final int e;
  
  ReflectionHelper$a(Class paramClass, String paramString1, String paramString2)
  {
    b = paramClass;
    c = paramString1;
    d = paramString2;
    e = (((b.hashCode() + 527) * 31 + c.hashCode()) * 31 + d.hashCode());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        break;
      }
      paramObject = (a)paramObject;
    } while ((e == e) && (d.equals(d)) && (c.equals(c)) && (b.equals(b)));
    return false;
    return false;
  }
  
  public final int hashCode()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.ReflectionHelper.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */