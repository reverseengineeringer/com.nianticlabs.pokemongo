package com.google.android.gms.internal;

import java.util.Iterator;

final class zzmh$zza<T>
  implements Iterator<T>
{
  boolean mCanRemove = false;
  int mIndex;
  final int mOffset;
  int mSize;
  
  zzmh$zza(zzmh paramzzmh, int paramInt)
  {
    mOffset = paramInt;
    mSize = paramzzmh.colGetSize();
  }
  
  public boolean hasNext()
  {
    return mIndex < mSize;
  }
  
  public T next()
  {
    Object localObject = zzagL.colGetEntry(mIndex, mOffset);
    mIndex += 1;
    mCanRemove = true;
    return (T)localObject;
  }
  
  public void remove()
  {
    if (!mCanRemove) {
      throw new IllegalStateException();
    }
    mIndex -= 1;
    mSize -= 1;
    mCanRemove = false;
    zzagL.colRemoveAt(mIndex);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */