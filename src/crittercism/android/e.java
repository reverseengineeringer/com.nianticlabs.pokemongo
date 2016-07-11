package crittercism.android;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class e
{
  List a = new LinkedList();
  final Set b = new HashSet();
  final Set c = new HashSet();
  private Executor d;
  
  public e(Executor paramExecutor)
  {
    this(paramExecutor, new LinkedList(), new LinkedList());
  }
  
  private e(Executor paramExecutor, List paramList1, List paramList2)
  {
    d = paramExecutor;
    a(paramList1);
    b(paramList2);
  }
  
  @Deprecated
  public final void a(c paramc)
  {
    a(paramc, c.a.e);
  }
  
  public final void a(c paramc, c.a parama)
  {
    if (b) {
      return;
    }
    b = true;
    c = parama;
    d.execute(new a(paramc, (byte)0));
  }
  
  public final void a(f paramf)
  {
    synchronized (a)
    {
      a.add(paramf);
      return;
    }
  }
  
  public final void a(List paramList)
  {
    synchronized (b)
    {
      b.addAll(paramList);
      b.remove(null);
      return;
    }
  }
  
  public final void b(List paramList)
  {
    synchronized (c)
    {
      c.addAll(paramList);
      c.remove(null);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private c b;
    
    private a(c paramc)
    {
      b = paramc;
    }
    
    private boolean a(c arg1)
    {
      String str = ???.a();
      synchronized (b)
      {
        Iterator localIterator = b.iterator();
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
      synchronized (c)
      {
        Iterator localIterator = c.iterator();
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
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext()) {
          ((f)localIterator.next()).a(b);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */