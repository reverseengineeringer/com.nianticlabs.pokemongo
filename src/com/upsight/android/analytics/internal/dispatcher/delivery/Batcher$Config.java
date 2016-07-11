package com.upsight.android.analytics.internal.dispatcher.delivery;

public class Batcher$Config
{
  public final int batchCapacity;
  public final int maxBatchAge;
  
  public Batcher$Config(int paramInt1, int paramInt2)
  {
    batchCapacity = paramInt1;
    maxBatchAge = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Config)paramObject;
    } while ((batchCapacity == batchCapacity) && (maxBatchAge == maxBatchAge));
    return false;
  }
  
  public boolean isValid()
  {
    return (maxBatchAge >= 0) && (batchCapacity > 0);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Batcher.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */