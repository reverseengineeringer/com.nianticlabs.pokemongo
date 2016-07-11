package rx.observers;

final class SerializedObserver$FastList
{
  Object[] array;
  int size;
  
  public void add(Object paramObject)
  {
    int i = size;
    Object[] arrayOfObject2 = array;
    Object[] arrayOfObject1;
    if (arrayOfObject2 == null)
    {
      arrayOfObject1 = new Object[16];
      array = arrayOfObject1;
    }
    for (;;)
    {
      arrayOfObject1[i] = paramObject;
      size = (i + 1);
      return;
      arrayOfObject1 = arrayOfObject2;
      if (i == arrayOfObject2.length)
      {
        arrayOfObject1 = new Object[(i >> 2) + i];
        System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, i);
        array = arrayOfObject1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.observers.SerializedObserver.FastList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */