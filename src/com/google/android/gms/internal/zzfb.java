package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfb
  extends zzfh
{
  private final Context mContext;
  private final Map<String, String> zzvS;
  private String zzzV;
  private long zzzW;
  private long zzzX;
  private String zzzY;
  private String zzzZ;
  
  public zzfb(zziz paramzziz, Map<String, String> paramMap)
  {
    super(paramzziz, "createCalendarEvent");
    zzvS = paramMap;
    mContext = paramzziz.zzgZ();
    zzec();
  }
  
  private String zzah(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)zzvS.get(paramString))) {
      return "";
    }
    return (String)zzvS.get(paramString);
  }
  
  private long zzai(String paramString)
  {
    paramString = (String)zzvS.get(paramString);
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  private void zzec()
  {
    zzzV = zzah("description");
    zzzY = zzah("summary");
    zzzW = zzai("start_ticks");
    zzzX = zzai("end_ticks");
    zzzZ = zzah("location");
  }
  
  Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", zzzV);
    localIntent.putExtra("eventLocation", zzzZ);
    localIntent.putExtra("description", zzzY);
    if (zzzW > -1L) {
      localIntent.putExtra("beginTime", zzzW);
    }
    if (zzzX > -1L) {
      localIntent.putExtra("endTime", zzzX);
    }
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public void execute()
  {
    if (mContext == null)
    {
      zzak("Activity context is not available.");
      return;
    }
    if (!zzp.zzbv().zzL(mContext).zzdb())
    {
      zzak("This feature is not available on the device.");
      return;
    }
    AlertDialog.Builder localBuilder = zzp.zzbv().zzK(mContext);
    localBuilder.setTitle(zzp.zzby().zzd(R.string.create_calendar_title, "Create calendar event"));
    localBuilder.setMessage(zzp.zzby().zzd(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
    localBuilder.setPositiveButton(zzp.zzby().zzd(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = createIntent();
        zzp.zzbv().zzb(zzfb.zza(zzfb.this), paramAnonymousDialogInterface);
      }
    });
    localBuilder.setNegativeButton(zzp.zzby().zzd(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzak("Operation denied by user.");
      }
    });
    localBuilder.create().show();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */