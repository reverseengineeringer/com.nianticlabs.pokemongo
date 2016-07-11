package com.nianticlabs.nia.contextservice;

import com.google.android.gms.common.ConnectionResult;

public abstract interface GoogleApiManager$Listener
{
  public abstract void onConnected();
  
  public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  
  public abstract void onDisconnected();
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.contextservice.GoogleApiManager.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */