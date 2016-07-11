package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzm
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzBW;
  private final zzo zzBX;
  
  public zzm(Context paramContext, int paramInt, zzo paramzzo)
  {
    super(paramContext);
    zzBX = paramzzo;
    setOnClickListener(this);
    zzBW = new ImageButton(paramContext);
    zzBW.setImageResource(17301527);
    zzBW.setBackgroundColor(0);
    zzBW.setOnClickListener(this);
    zzBW.setPadding(0, 0, 0, 0);
    zzBW.setContentDescription("Interstitial close button");
    paramInt = zzl.zzcF().zzb(paramContext, paramInt);
    addView(zzBW, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void onClick(View paramView)
  {
    if (zzBX != null) {
      zzBX.zzeE();
    }
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        zzBW.setVisibility(4);
        return;
      }
      zzBW.setVisibility(8);
      return;
    }
    zzBW.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */