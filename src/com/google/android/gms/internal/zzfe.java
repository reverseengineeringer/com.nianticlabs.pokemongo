package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfe
  extends zzfh
{
  private final Context mContext;
  private final Map<String, String> zzvS;
  
  public zzfe(zziz paramzziz, Map<String, String> paramMap)
  {
    super(paramzziz, "storePicture");
    zzvS = paramMap;
    mContext = paramzziz.zzgZ();
  }
  
  public void execute()
  {
    if (mContext == null)
    {
      zzak("Activity context is not available");
      return;
    }
    if (!zzp.zzbv().zzL(mContext).zzcY())
    {
      zzak("Feature is not supported by the device.");
      return;
    }
    final String str1 = (String)zzvS.get("iurl");
    if (TextUtils.isEmpty(str1))
    {
      zzak("Image url cannot be empty.");
      return;
    }
    if (!URLUtil.isValidUrl(str1))
    {
      zzak("Invalid image url: " + str1);
      return;
    }
    final String str2 = zzaj(str1);
    if (!zzp.zzbv().zzaB(str2))
    {
      zzak("Image type not recognized: " + str2);
      return;
    }
    AlertDialog.Builder localBuilder = zzp.zzbv().zzK(mContext);
    localBuilder.setTitle(zzp.zzby().zzd(R.string.store_picture_title, "Save image"));
    localBuilder.setMessage(zzp.zzby().zzd(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
    localBuilder.setPositiveButton(zzp.zzby().zzd(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = (DownloadManager)zzfe.zza(zzfe.this).getSystemService("download");
        try
        {
          paramAnonymousDialogInterface.enqueue(zzg(str1, str2));
          return;
        }
        catch (IllegalStateException paramAnonymousDialogInterface)
        {
          zzak("Could not store picture.");
        }
      }
    });
    localBuilder.setNegativeButton(zzp.zzby().zzd(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzak("User canceled the download.");
      }
    });
    localBuilder.create().show();
  }
  
  String zzaj(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  DownloadManager.Request zzg(String paramString1, String paramString2)
  {
    paramString1 = new DownloadManager.Request(Uri.parse(paramString1));
    paramString1.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, paramString2);
    zzp.zzbx().zza(paramString1);
    return paramString1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */