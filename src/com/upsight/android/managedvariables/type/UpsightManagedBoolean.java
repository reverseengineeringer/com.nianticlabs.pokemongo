package com.upsight.android.managedvariables.type;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightManagedVariablesExtension;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.persistence.UpsightSubscription;

public abstract class UpsightManagedBoolean
  extends UpsightManagedVariable<Boolean>
{
  protected UpsightManagedBoolean(String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  public static UpsightManagedBoolean fetch(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightManagedVariablesExtension localUpsightManagedVariablesExtension = (UpsightManagedVariablesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.managedvariables");
    if (localUpsightManagedVariablesExtension != null) {
      return (UpsightManagedBoolean)localUpsightManagedVariablesExtension.getApi().fetch(UpsightManagedBoolean.class, paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.managedvariables must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static UpsightSubscription fetch(UpsightContext paramUpsightContext, String paramString, UpsightManagedVariable.Listener<UpsightManagedBoolean> paramListener)
  {
    UpsightManagedVariablesExtension localUpsightManagedVariablesExtension = (UpsightManagedVariablesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.managedvariables");
    if (localUpsightManagedVariablesExtension != null) {
      return localUpsightManagedVariablesExtension.getApi().fetch(UpsightManagedBoolean.class, paramString, paramListener);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.managedvariables must be registered in your Android Manifest", new Object[0]);
    return new UpsightManagedVariable.NoOpSubscription();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.type.UpsightManagedBoolean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */