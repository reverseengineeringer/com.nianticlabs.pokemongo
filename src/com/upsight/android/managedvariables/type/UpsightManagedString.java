package com.upsight.android.managedvariables.type;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightManagedVariablesExtension;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.persistence.UpsightSubscription;

public abstract class UpsightManagedString
  extends UpsightManagedVariable<String>
{
  protected UpsightManagedString(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public static UpsightManagedString fetch(UpsightContext paramUpsightContext, String paramString)
  {
    UpsightManagedVariablesExtension localUpsightManagedVariablesExtension = (UpsightManagedVariablesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.managedvariables");
    if (localUpsightManagedVariablesExtension != null) {
      return (UpsightManagedString)localUpsightManagedVariablesExtension.getApi().fetch(UpsightManagedString.class, paramString);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.managedvariables must be registered in your Android Manifest", new Object[0]);
    return null;
  }
  
  public static UpsightSubscription fetch(UpsightContext paramUpsightContext, String paramString, UpsightManagedVariable.Listener<UpsightManagedString> paramListener)
  {
    UpsightManagedVariablesExtension localUpsightManagedVariablesExtension = (UpsightManagedVariablesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.managedvariables");
    if (localUpsightManagedVariablesExtension != null) {
      return localUpsightManagedVariablesExtension.getApi().fetch(UpsightManagedString.class, paramString, paramListener);
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.managedvariables must be registered in your Android Manifest", new Object[0]);
    return new UpsightManagedVariable.NoOpSubscription();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.type.UpsightManagedString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */