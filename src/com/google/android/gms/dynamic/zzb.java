package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class zzb
  extends zzc.zza
{
  private Fragment zzapz;
  
  private zzb(Fragment paramFragment)
  {
    zzapz = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return zzapz.getArguments();
  }
  
  public int getId()
  {
    return zzapz.getId();
  }
  
  public boolean getRetainInstance()
  {
    return zzapz.getRetainInstance();
  }
  
  public String getTag()
  {
    return zzapz.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return zzapz.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return zzapz.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzy(zzapz.getView());
  }
  
  public boolean isAdded()
  {
    return zzapz.isAdded();
  }
  
  public boolean isDetached()
  {
    return zzapz.isDetached();
  }
  
  public boolean isHidden()
  {
    return zzapz.isHidden();
  }
  
  public boolean isInLayout()
  {
    return zzapz.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return zzapz.isRemoving();
  }
  
  public boolean isResumed()
  {
    return zzapz.isResumed();
  }
  
  public boolean isVisible()
  {
    return zzapz.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    zzapz.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    zzapz.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    zzapz.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    zzapz.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    zzapz.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzapz.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    zzapz.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    zzapz.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zzsa()
  {
    return zze.zzy(zzapz.getActivity());
  }
  
  public zzc zzsb()
  {
    return zza(zzapz.getParentFragment());
  }
  
  public zzd zzsc()
  {
    return zze.zzy(zzapz.getResources());
  }
  
  public zzc zzsd()
  {
    return zza(zzapz.getTargetFragment());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */