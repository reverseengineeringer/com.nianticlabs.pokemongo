package com.voxelbusters.nativeplugins.features.sharing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import com.voxelbusters.nativeplugins.defines.Enums.eShareOptions;
import com.voxelbusters.nativeplugins.utilities.Debug;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SharingActivity
  extends Activity
{
  final int SEND_MAIL_REQUEST_CODE = 2;
  final int SEND_SMS_REQUEST_CODE = 3;
  final int SHARE_ON_WHATS_APP_REQUEST_CODE = 4;
  final int SHARING_REQUEST_CODE = 1;
  Bundle bundleInfo;
  File currentImageFileShared = null;
  
  private void shareItem(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString)
  {
    Object localObject = NativePluginHelper.getCurrentContext();
    Intent localIntent = new Intent("android.intent.action.SEND");
    boolean bool;
    label56:
    int i;
    if (StringUtility.isNullOrEmpty(paramString3))
    {
      bool = false;
      localIntent.setType(getMimeType(paramString4, bool));
      if (!StringUtility.isNullOrEmpty(paramString2)) {
        break label364;
      }
      localIntent.putExtra("android.intent.extra.TEXT", paramString1);
      if (!StringUtility.isNullOrEmpty(paramString3)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(paramString3));
      }
      localIntent.addCategory("android.intent.category.DEFAULT");
      int j = 0;
      int k = 0;
      i = k;
      if (paramArrayOfString != null)
      {
        i = k;
        if (StringUtility.contains(Enums.eShareOptions.MESSAGE.ordinal(), paramArrayOfString))
        {
          i = k;
          if (StringUtility.contains(Enums.eShareOptions.MAIL.ordinal(), paramArrayOfString))
          {
            i = k;
            if (StringUtility.contains(Enums.eShareOptions.WHATSAPP.ordinal(), paramArrayOfString)) {
              i = 1;
            }
          }
        }
      }
      paramString1 = ((Context)localObject).getPackageManager().queryIntentActivities(localIntent, 0);
      if (paramString1.isEmpty()) {
        break label514;
      }
      paramString2 = new ArrayList();
      paramString3 = paramString1.iterator();
      label230:
      if (paramString3.hasNext()) {
        break label398;
      }
      if (paramString2.isEmpty()) {
        break label508;
      }
      paramString1 = Intent.createChooser((Intent)paramString2.remove(0), "Share via");
      paramString1.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramString2.toArray(new Parcelable[0]));
      paramString1.addFlags(1);
      startActivityForResult(paramString1, 1);
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramString1 = new AlertDialog.Builder(this).setTitle("Share").setMessage("No services found!").setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            NativePluginHelper.sendMessage("SharingFinished", "failed");
            finish();
          }
        });
        paramString1.setOnKeyListener(new DialogInterface.OnKeyListener()
        {
          public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            if (paramAnonymousInt == 4)
            {
              NativePluginHelper.sendMessage("SharingFinished", "failed");
              finish();
            }
            return true;
          }
        });
        paramString1.create().show();
      }
      return;
      bool = true;
      break;
      label364:
      localIntent.putExtra("android.intent.extra.TEXT", paramString1 + "\n" + paramString2);
      break label56;
      label398:
      paramString4 = (ResolveInfo)paramString3.next();
      if (activityInfo != null) {}
      for (paramString1 = activityInfo.packageName;; paramString1 = null)
      {
        if ((paramString1 == null) || (SharingHelper.checkIfPackageMatchesShareOptions(paramString1, paramArrayOfString)) || ((i != 0) && (!SharingHelper.isSocialNetwork(paramString1)))) {
          break label506;
        }
        localObject = new Intent(localIntent);
        ((Intent)localObject).setComponent(new ComponentName(paramString1, activityInfo.name));
        ((Intent)localObject).setPackage(paramString1);
        paramString2.add(localObject);
        break;
      }
      label506:
      break label230;
      label508:
      i = 1;
      continue;
      label514:
      i = 1;
    }
  }
  
  String getMimeType(String paramString, boolean paramBoolean)
  {
    String str = "text/plain";
    if (paramBoolean) {
      str = "image/*";
    }
    if ("mail".equals(paramString)) {
      str = "message/rfc822";
    }
    return str;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      NativePluginHelper.sendMessage("SharingFinished", "closed");
    }
    for (;;)
    {
      finish();
      return;
      if (paramInt1 == 2) {
        NativePluginHelper.sendMessage("MailShareFinished", "closed");
      } else if (paramInt1 == 3) {
        NativePluginHelper.sendMessage("MessagingShareFinished", "closed");
      } else if (paramInt1 == 4) {
        NativePluginHelper.sendMessage("WhatsAppShareFinished", "closed");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (bundleInfo == null) {
      bundleInfo = getIntent().getExtras();
    }
    paramBundle = bundleInfo.getString("type");
    if (StringUtility.isNullOrEmpty(paramBundle))
    {
      shareItem(bundleInfo.getString("message"), bundleInfo.getString("url"), bundleInfo.getString("image-path"), paramBundle, bundleInfo.getStringArray("exclude-list"));
      return;
    }
    if (paramBundle.equals("sms"))
    {
      shareWithSMS(bundleInfo);
      return;
    }
    if (paramBundle.equals("mail"))
    {
      shareWithEmail(bundleInfo);
      return;
    }
    if (paramBundle.equals("whatsapp"))
    {
      shareOnWhatsApp(bundleInfo);
      return;
    }
    Debug.log("NativePlugins.Sharing", "Sharing not implemented for this type " + paramBundle);
  }
  
  void shareOnWhatsApp(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("message");
    paramBundle = paramBundle.getString("image-path");
    if (StringUtility.isNullOrEmpty(paramBundle)) {}
    for (boolean bool = false;; bool = true)
    {
      String str2 = getMimeType("whatsapp", bool);
      Intent localIntent = new Intent("android.intent.action.SEND");
      if (str1 != null) {
        localIntent.putExtra("android.intent.extra.TEXT", str1);
      }
      if (paramBundle != null) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(paramBundle));
      }
      localIntent.setType(str2);
      localIntent.setPackage("com.whatsapp");
      startActivityForResult(localIntent, 4);
      return;
    }
  }
  
  void shareWithEmail(Bundle paramBundle)
  {
    int i = 0;
    Object localObject = paramBundle.getCharSequence("body");
    String str1 = paramBundle.getString("subject");
    String[] arrayOfString1 = paramBundle.getStringArray("to-recipient-list");
    String[] arrayOfString2 = paramBundle.getStringArray("cc-recipient-list");
    String[] arrayOfString3 = paramBundle.getStringArray("bcc-recipient-list");
    paramBundle = paramBundle.getStringArray("attachment");
    String str2 = getMimeType("mail", false);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType(str2);
    localIntent.putExtra("android.intent.extra.TEXT", (CharSequence)localObject);
    localIntent.putExtra("android.intent.extra.SUBJECT", str1);
    localIntent.putExtra("android.intent.extra.EMAIL", arrayOfString1);
    localIntent.putExtra("android.intent.extra.CC", arrayOfString2);
    localIntent.putExtra("android.intent.extra.BCC", arrayOfString3);
    int j;
    if (paramBundle != null)
    {
      localIntent.setAction("android.intent.action.SEND_MULTIPLE");
      localObject = new ArrayList();
      j = paramBundle.length;
    }
    for (;;)
    {
      if (i >= j)
      {
        localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject);
        startActivityForResult(localIntent, 2);
        return;
      }
      ((ArrayList)localObject).add(Uri.parse(paramBundle[i]));
      i += 1;
    }
  }
  
  void shareWithSMS(Bundle paramBundle)
  {
    String str = paramBundle.getString("message");
    String[] arrayOfString = paramBundle.getStringArray("to-recipient-list");
    paramBundle = "";
    Object localObject = paramBundle;
    int j;
    int i;
    if (arrayOfString != null)
    {
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        localObject = paramBundle;
        paramBundle = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + (String)localObject));
        paramBundle.putExtra("sms_body", str);
        startActivityForResult(paramBundle, 3);
        return;
      }
      localObject = arrayOfString[i];
      paramBundle = paramBundle + (String)localObject + ";";
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.sharing.SharingActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */