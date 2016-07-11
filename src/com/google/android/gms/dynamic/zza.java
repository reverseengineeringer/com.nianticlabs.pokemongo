package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T zzapn;
  private Bundle zzapo;
  private LinkedList<zza> zzapp;
  private final zzf<T> zzapq = new zzf()
  {
    public void zza(T paramAnonymousT)
    {
      zza.zza(zza.this, paramAnonymousT);
      paramAnonymousT = zza.zza(zza.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((zza.zza)paramAnonymousT.next()).zzb(zza.zzb(zza.this));
      }
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };
  
  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (zzapn != null)
    {
      paramzza.zzb(zzapn);
      return;
    }
    if (zzapp == null) {
      zzapp = new LinkedList();
    }
    zzapp.add(paramzza);
    if (paramBundle != null)
    {
      if (zzapo != null) {
        break label76;
      }
      zzapo = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(zzapq);
      return;
      label76:
      zzapo.putAll(paramBundle);
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    final int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(localContext);
    String str2 = zzg.zzc(localContext, i, GooglePlayServicesUtil.zzaf(localContext));
    String str1 = zzg.zzh(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    if (str1 != null)
    {
      paramFrameLayout = new Button(localContext);
      paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramFrameLayout.setText(str1);
      localLinearLayout.addView(paramFrameLayout);
      paramFrameLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          zzry.startActivity(GooglePlayServicesUtil.zzbj(i));
        }
      });
    }
  }
  
  private void zzer(int paramInt)
  {
    while ((!zzapp.isEmpty()) && (((zza)zzapp.getLast()).getState() >= paramInt)) {
      zzapp.removeLast();
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 1;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 2;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(zza.zzb(zza.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (zzapn == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (zzapn != null)
    {
      zzapn.onDestroy();
      return;
    }
    zzer(1);
  }
  
  public void onDestroyView()
  {
    if (zzapn != null)
    {
      zzapn.onDestroyView();
      return;
    }
    zzer(2);
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    zza(paramBundle2, new zza()
    {
      public int getState()
      {
        return 0;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (zzapn != null) {
      zzapn.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (zzapn != null)
    {
      zzapn.onPause();
      return;
    }
    zzer(5);
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (zzapn != null) {
      zzapn.onSaveInstanceState(paramBundle);
    }
    while (zzapo == null) {
      return;
    }
    paramBundle.putAll(zzapo);
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (zzapn != null)
    {
      zzapn.onStop();
      return;
    }
    zzer(4);
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zzf<T> paramzzf);
  
  public T zzrZ()
  {
    return zzapn;
  }
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */