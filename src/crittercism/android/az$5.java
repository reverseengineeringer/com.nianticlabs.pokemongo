package crittercism.android;

import org.json.JSONArray;

final class az$5
  extends di
{
  az$5(az paramaz, Throwable paramThrowable, long paramLong) {}
  
  public final void a()
  {
    if (c.f.b()) {
      return;
    }
    synchronized (c.p)
    {
      if (c.B < 10)
      {
        Object localObject1 = new bk(a, b);
        ((bk)localObject1).a("current_session", c.k);
        ((bk)localObject1).a(c.l);
        f = "he";
        if (c.p.a())
        {
          localObject1 = new JSONArray().put(((bk)localObject1).b());
          new dj(new cu(az.a).a(br.b.f(), (JSONArray)localObject1), new dc(new db(c.u.b(), "/android_v2/handle_exceptions").a()), null).run();
          localObject1 = c;
          B += 1;
          c.p.b();
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.az.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */