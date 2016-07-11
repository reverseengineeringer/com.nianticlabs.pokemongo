package com.crittercism.app;

import crittercism.android.az;
import crittercism.android.be;
import crittercism.android.bg;
import crittercism.android.dx;

public abstract class Transaction
{
  public az a;
  
  public static Transaction a(String paramString)
  {
    if ((paramString == null) || (paramString != null)) {}
    try
    {
      if (paramString.length() == 0)
      {
        dx.b("Transaction was created with a null/zero-length name. Returning no-op transaction", new IllegalStateException("Transaction created with null/zero-length name"));
        return new be();
      }
      localaz = az.A();
      if (b) {
        if (localaz.B())
        {
          paramString = new be();
          return paramString;
        }
      }
    }
    catch (ThreadDeath paramString)
    {
      az localaz;
      throw paramString;
      paramString = new bg(localaz, paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
      return new be();
    }
    dx.b("Transaction was created before Crittercism.initialize() was called. Returning no-op transaction", new IllegalStateException("Transaction created before Crittercism.initialize()"));
    paramString = new be();
    return paramString;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract int d();
}

/* Location:
 * Qualified Name:     com.crittercism.app.Transaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */