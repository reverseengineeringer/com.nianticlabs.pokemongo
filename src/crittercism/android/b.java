package crittercism.android;

import android.util.SparseArray;

public enum b
{
  private static SparseArray e;
  private int f;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    e = localSparseArray;
    localSparseArray.put(0, a);
    e.put(1, b);
  }
  
  private b(int paramInt1)
  {
    f = paramInt1;
  }
  
  public static b a(int paramInt)
  {
    b localb2 = (b)e.get(paramInt);
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = c;
    }
    return localb1;
  }
  
  public final int a()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */