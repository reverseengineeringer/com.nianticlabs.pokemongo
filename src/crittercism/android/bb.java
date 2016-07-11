package crittercism.android;

import com.crittercism.app.CrittercismConfig;
import java.util.List;

public final class bb
  extends CrittercismConfig
{
  private String b = "524c99a04002057fcd000001";
  private bn c;
  
  public bb(bn parambn, CrittercismConfig paramCrittercismConfig)
  {
    super(paramCrittercismConfig);
    c = parambn;
  }
  
  public final List a()
  {
    List localList = super.a();
    localList.add(c.b());
    return localList;
  }
  
  public final String b()
  {
    return c.a();
  }
  
  public final String c()
  {
    return c.b();
  }
  
  public final String d()
  {
    return c.d();
  }
  
  public final String e()
  {
    return c.c();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof bb)) {
      return false;
    }
    bb localbb = (bb)paramObject;
    return (super.equals(paramObject)) && (a(c.a(), c.a())) && (a(c.b(), c.b())) && (a(c.d(), c.d())) && (a(c.c(), c.c())) && (a(b, b));
  }
  
  public final String f()
  {
    return b;
  }
  
  public final String g()
  {
    return a;
  }
  
  public final int hashCode()
  {
    return ((((super.hashCode() * 31 + c.a().hashCode()) * 31 + c.b().hashCode()) * 31 + c.d().hashCode()) * 31 + c.c().hashCode()) * 31 + b.hashCode();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */