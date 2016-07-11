package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class UiUtils$InstallSettingsDialogFragment
  extends DialogFragment
{
  private final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      try
      {
        getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://google.com/cardboard/cfg")));
        return;
      }
      catch (ActivityNotFoundException paramAnonymousDialogInterface)
      {
        Toast.makeText(getActivity().getApplicationContext(), Strings.getString("NO_BROWSER_TEXT"), 1).show();
      }
    }
  };
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(Strings.getString("DIALOG_TITLE")).setMessage(Strings.getString("DIALOG_MESSAGE_NO_CARDBOARD")).setPositiveButton(Strings.getString("GO_TO_PLAYSTORE_BUTTON"), listener).setNegativeButton(Strings.getString("CANCEL_BUTTON"), null);
    return paramBundle.create();
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiUtils.InstallSettingsDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */