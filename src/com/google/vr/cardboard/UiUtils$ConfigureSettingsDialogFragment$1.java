package com.google.vr.cardboard;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class UiUtils$ConfigureSettingsDialogFragment$1
  implements DialogInterface.OnClickListener
{
  UiUtils$ConfigureSettingsDialogFragment$1(UiUtils.ConfigureSettingsDialogFragment paramConfigureSettingsDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this$0.getActivity().startActivity(UiUtils.ConfigureSettingsDialogFragment.access$000(this$0));
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      UiUtils.access$100(this$0.getActivity());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiUtils.ConfigureSettingsDialogFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */