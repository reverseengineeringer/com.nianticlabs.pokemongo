package crittercism.android;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class e$a
  implements Runnable
{
  private c b;
  
  private e$a(e parame, c paramc)
  {
    b = paramc;
  }
  
  private boolean a(c arg1)
  {
    String str = ???.a();
    synchronized (a.b)
    {
      Iterator localIterator = a.b.iterator();
      while (localIterator.hasNext()) {
        if (str.contains((String)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
  }
  
  private boolean a(String paramString)
  {
    synchronized (a.c)
    {
      Iterator localIterator = a.c.iterator();
      while (localIterator.hasNext()) {
        if (paramString.contains((String)localIterator.next())) {
          return false;
        }
      }
      return true;
    }
  }
  
  public final void run()
  {
    if (a(b)) {
      return;
    }
    ??? = b.a();
    if (a((String)???))
    {
      int i = ((String)???).indexOf("?");
      if (i != -1) {
        b.a(((String)???).substring(0, i));
      }
    }
    synchronized (a.a)
    {
      Iterator localIterator = a.a.iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).a(b);
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */