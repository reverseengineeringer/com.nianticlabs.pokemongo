package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.webkit.WebSettings;

public class zzie$zzd
  extends zzie.zzf
{
  public String getDefaultUserAgent(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }
  
  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    }
    try
    {
      Object localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
      Object localObject1 = Bitmap.createBitmap((Bitmap)localObject3);
      Object localObject2 = RenderScript.create(paramContext);
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
      localObject3 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject3);
      localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
      localScriptIntrinsicBlur.setRadius(paramFloat);
      localScriptIntrinsicBlur.setInput((Allocation)localObject3);
      localScriptIntrinsicBlur.forEach((Allocation)localObject2);
      ((Allocation)localObject2).copyTo((Bitmap)localObject1);
      localObject1 = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject1);
      return (Drawable)localObject1;
    }
    catch (RuntimeException localRuntimeException) {}
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    super.zza(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */