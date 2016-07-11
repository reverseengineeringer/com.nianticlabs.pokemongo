package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh
  extends zzc.zza
{
  private Fragment zzafl;
  
  private zzh(Fragment paramFragment)
  {
    zzafl = paramFragment;
  }
  
  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzh(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return zzafl.getArguments();
  }
  
  public int getId()
  {
    return zzafl.getId();
  }
  
  public boolean getRetainInstance()
  {
    return zzafl.getRetainInstance();
  }
  
  public String getTag()
  {
    return zzafl.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return zzafl.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return zzafl.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzy(zzafl.getView());
  }
  
  public boolean isAdded()
  {
    return zzafl.isAdded();
  }
  
  public boolean isDetached()
  {
    return zzafl.isDetached();
  }
  
  public boolean isHidden()
  {
    return zzafl.isHidden();
  }
  
  public boolean isInLayout()
  {
    return zzafl.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return zzafl.isRemoving();
  }
  
  public boolean isResumed()
  {
    return zzafl.isResumed();
  }
  
  public boolean isVisible()
  {
    return zzafl.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    zzafl.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    zzafl.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    zzafl.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    zzafl.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    zzafl.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzafl.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    zzafl.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    zzafl.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zzsa()
  {
    return zze.zzy(zzafl.getActivity());
  }
  
  public zzc zzsb()
  {
    return zza(zzafl.getParentFragment());
  }
  
  public zzd zzsc()
  {
    return zze.zzy(zzafl.getResources());
  }
  
  public zzc zzsd()
  {
    return zza(zzafl.getTargetFragment());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */