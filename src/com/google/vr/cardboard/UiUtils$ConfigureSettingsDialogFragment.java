package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class UiUtils$ConfigureSettingsDialogFragment
  extends DialogFragment
{
  private Intent intent;
  private final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      try
      {
        getActivity().startActivity(intent);
        return;
      }
      catch (ActivityNotFoundException paramAnonymousDialogInterface)
      {
        UiUtils.access$100(getActivity());
      }
    }
  };
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    intent = ((Intent)getArguments().getParcelable("intent"));
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(Strings.getString("DIALOG_TITLE")).setMessage(Strings.getString("DIALOG_MESSAGE_SETUP")).setPositiveButton(Strings.getString("SETUP_BUTTON"), listener).setNegativeButton(Strings.getString("CANCEL_BUTTON"), null);
    return paramBundle.create();
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiUtils.ConfigureSettingsDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */