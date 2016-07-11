package com.nianticlabs.nia.location;

import android.location.Location;
import com.nianticlabs.nia.contextservice.ServiceStatus;

public abstract interface Provider$ProviderListener
{
  public abstract void onProviderLocation(Location paramLocation);
  
  public abstract void onProviderStatus(ServiceStatus paramServiceStatus);
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.Provider.ProviderListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */