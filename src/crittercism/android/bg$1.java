package crittercism.android;

import java.util.Iterator;
import java.util.List;

final class bg$1
  extends di
{
  bg$1(List paramList, az paramaz) {}
  
  public final void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      synchronized ((bg)localIterator.next())
      {
        if (bg.a(???) == bg.a.b) {
          b.n.b(???);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bg.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */