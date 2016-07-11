package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.formats.zzc;
import java.io.IOException;
import java.io.InputStream;

class zzgm$5
  implements zzih.zza<zzc>
{
  zzgm$5(zzgm paramzzgm, boolean paramBoolean, double paramDouble, String paramString) {}
  
  public zzc zzfE()
  {
    zzDN.zza(2, zzDX);
    return null;
  }
  
  public zzc zzg(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = zzmt.zzk(paramInputStream);
      if (paramInputStream == null)
      {
        zzDN.zza(2, zzDX);
        return null;
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream = null;
      }
      paramInputStream = BitmapFactory.decodeByteArray(paramInputStream, 0, paramInputStream.length);
      if (paramInputStream == null)
      {
        zzDN.zza(2, zzDX);
        return null;
      }
      paramInputStream.setDensity((int)(160.0D * zzDY));
    }
    return new zzc(new BitmapDrawable(Resources.getSystem(), paramInputStream), Uri.parse(zzAs), zzDY);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgm.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */