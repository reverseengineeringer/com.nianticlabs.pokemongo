package com.upsight.android.internal;

import android.content.Context;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.UpsightCoreComponent.Factory;

public class CoreComponentFactory
  implements UpsightCoreComponent.Factory
{
  public UpsightCoreComponent create(Context paramContext)
  {
    return DaggerCoreComponent.builder().contextModule(new ContextModule(paramContext)).build();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.CoreComponentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */