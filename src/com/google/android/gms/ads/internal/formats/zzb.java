package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzie;
import java.util.Iterator;
import java.util.List;

class zzb
  extends RelativeLayout
{
  private static final float[] zzwj = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private final RelativeLayout zzwk;
  private AnimationDrawable zzwl;
  
  public zzb(Context paramContext, zza paramzza)
  {
    super(paramContext);
    zzx.zzw(paramzza);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    Object localObject2 = new ShapeDrawable(new RoundRectShape(zzwj, null, null));
    ((ShapeDrawable)localObject2).getPaint().setColor(paramzza.getBackgroundColor());
    zzwk = new RelativeLayout(paramContext);
    zzwk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    zzp.zzbx().zza(zzwk, (Drawable)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    if (!TextUtils.isEmpty(paramzza.getText()))
    {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      TextView localTextView = new TextView(paramContext);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localTextView.setId(1195835393);
      localTextView.setTypeface(Typeface.DEFAULT);
      localTextView.setText(paramzza.getText());
      localTextView.setTextColor(paramzza.getTextColor());
      localTextView.setTextSize(paramzza.getTextSize());
      localTextView.setPadding(zzl.zzcF().zzb(paramContext, 4), 0, zzl.zzcF().zzb(paramContext, 4), 0);
      zzwk.addView(localTextView);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, localTextView.getId());
    }
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setId(1195835394);
    localObject1 = paramzza.zzds();
    if (((List)localObject1).size() > 1)
    {
      zzwl = new AnimationDrawable();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Drawable)((Iterator)localObject1).next();
        zzwl.addFrame((Drawable)localObject2, paramzza.zzdt());
      }
      zzp.zzbx().zza(paramContext, zzwl);
    }
    for (;;)
    {
      zzwk.addView(paramContext);
      addView(zzwk);
      return;
      if (((List)localObject1).size() == 1) {
        paramContext.setImageDrawable((Drawable)((List)localObject1).get(0));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    if (zzwl != null) {
      zzwl.start();
    }
    super.onAttachedToWindow();
  }
  
  public ViewGroup zzdu()
  {
    return zzwk;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */