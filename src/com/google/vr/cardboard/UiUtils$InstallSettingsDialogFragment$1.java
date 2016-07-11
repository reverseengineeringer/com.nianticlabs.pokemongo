package com.google.vr.cardboard;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

class UiUtils$InstallSettingsDialogFragment$1
  implements DialogInterface.OnClickListener
{
  UiUtils$InstallSettingsDialogFragment$1(UiUtils.InstallSettingsDialogFragment paramInstallSettingsDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this$0.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://google.com/cardboard/cfg")));
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Toast.makeText(this$0.getActivity().getApplicationContext(), Strings.getString("NO_BROWSER_TEXT"), 1).show();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiUtils.InstallSettingsDialogFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */