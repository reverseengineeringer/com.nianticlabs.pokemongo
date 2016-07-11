package com.upsight.android.managedvariables.experience;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightManagedVariablesExtension;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import java.util.List;

public abstract class UpsightUserExperience
{
  public static void registerHandler(UpsightContext paramUpsightContext, Handler paramHandler)
  {
    UpsightManagedVariablesExtension localUpsightManagedVariablesExtension = (UpsightManagedVariablesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.managedvariables");
    if (localUpsightManagedVariablesExtension != null)
    {
      localUpsightManagedVariablesExtension.getApi().registerUserExperienceHandler(paramHandler);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.managedvariables must be registered in your Android Manifest", new Object[0]);
  }
  
  public abstract Handler getHandler();
  
  public abstract void registerHandler(Handler paramHandler);
  
  public static abstract interface Handler
  {
    public abstract boolean onReceive();
    
    public abstract void onSynchronize(List<String> paramList);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.experience.UpsightUserExperience
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */