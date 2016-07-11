package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker$IntentBuilder
{
  private final Intent mIntent = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");
  
  public PlacePicker$IntentBuilder()
  {
    mIntent.setPackage("com.google.android.gms");
    mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  public Intent build(Activity paramActivity)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    Resources.Theme localTheme = paramActivity.getTheme();
    TypedValue localTypedValue1 = new TypedValue();
    TypedValue localTypedValue2 = new TypedValue();
    if ((localTheme.resolveAttribute(16843827, localTypedValue1, true)) && (!mIntent.hasExtra("primary_color"))) {
      mIntent.putExtra("primary_color", data);
    }
    if ((localTheme.resolveAttribute(16843828, localTypedValue2, true)) && (!mIntent.hasExtra("primary_color_dark"))) {
      mIntent.putExtra("primary_color_dark", data);
    }
    GoogleApiAvailability.getInstance().zzab(paramActivity);
    return mIntent;
  }
  
  @Deprecated
  public Intent build(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    GoogleApiAvailability.getInstance().zzab(paramContext);
    return mIntent;
  }
  
  public IntentBuilder setLatLngBounds(LatLngBounds paramLatLngBounds)
  {
    zzx.zzw(paramLatLngBounds);
    zzc.zza(paramLatLngBounds, mIntent, "latlng_bounds");
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */