package com.upsight.android.internal;

import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import java.util.UUID;

class ContextModule$2
  implements StorableIdFactory
{
  ContextModule$2(ContextModule paramContextModule) {}
  
  public String createObjectID()
  {
    return UUID.randomUUID().toString();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */