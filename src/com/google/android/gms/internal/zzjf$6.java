package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzjf$6
  implements DialogInterface.OnClickListener
{
  zzjf$6(JsPromptResult paramJsPromptResult, EditText paramEditText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    zzKE.confirm(zzKF.getText().toString());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjf.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */