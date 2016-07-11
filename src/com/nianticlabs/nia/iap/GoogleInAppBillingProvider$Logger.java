package com.nianticlabs.nia.iap;

import com.nianticlabs.nia.contextservice.ContextService;

class GoogleInAppBillingProvider$Logger
{
  private final String tag;
  
  public GoogleInAppBillingProvider$Logger(Class paramClass)
  {
    tag = paramClass.toString();
  }
  
  void assertOnServiceThread(String paramString)
  {
    if (!ContextService.onServiceThread()) {
      severe(tag + ": Must be on the service thread: " + paramString, new Object[0]);
    }
  }
  
  void dev(String paramString, Object... paramVarArgs) {}
  
  void error(String paramString, Object... paramVarArgs) {}
  
  void severe(String paramString, Object... paramVarArgs) {}
  
  void warning(String paramString, Object... paramVarArgs) {}
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GoogleInAppBillingProvider.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */