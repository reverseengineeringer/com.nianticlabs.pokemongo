package crittercism.android;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class df
{
  private Context a;
  private List b;
  
  public df(Context paramContext)
  {
    a = paramContext;
    b = new ArrayList();
  }
  
  public final void a()
  {
    Object localObject = new ArrayList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(new Thread((di)localIterator.next()));
    }
    localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext()) {
      ((Thread)localIterator.next()).start();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Thread)((Iterator)localObject).next()).join();
    }
  }
  
  public final void a(bs parambs, cz paramcz, String paramString1, String paramString2, String paramString3, au paramau, cx paramcx)
  {
    try
    {
      if (parambs.b() > 0)
      {
        bs localbs = parambs.a(a);
        paramcz = paramcz.a(localbs, parambs, paramString3, a, paramau);
        parambs = new dh(localbs, parambs, paramau, new db(paramString1, paramString2).a(), paramcz, paramcx);
        b.add(parambs);
      }
      return;
    }
    finally
    {
      parambs = finally;
      throw parambs;
    }
  }
  
  public final void a(dg paramdg, ExecutorService paramExecutorService)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      di localdi = (di)localIterator.next();
      if (!paramdg.a(localdi)) {
        paramExecutorService.execute(localdi);
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.df
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */