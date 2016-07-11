package com.google.ads.mediation.customevent;

@Deprecated
public abstract interface CustomEventListener
{
  public abstract void onDismissScreen();
  
  public abstract void onFailedToReceiveAd();
  
  public abstract void onLeaveApplication();
  
  public abstract void onPresentScreen();
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */