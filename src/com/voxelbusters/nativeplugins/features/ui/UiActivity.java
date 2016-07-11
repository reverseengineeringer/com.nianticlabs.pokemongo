package com.voxelbusters.nativeplugins.features.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.util.HashMap;

public class UiActivity
  extends Activity
{
  AlertDialog alertDialog;
  Bundle bundleInfo;
  boolean paused;
  
  private void showAlertDialog(Bundle paramBundle)
  {
    int i = 3;
    final String str = paramBundle.getString("tag");
    final String[] arrayOfString = paramBundle.getStringArray("button-list");
    alertDialog = getDialogWithDefaultDetails(paramBundle);
    final int j;
    if (arrayOfString.length > 3) {
      j = 0;
    }
    for (;;)
    {
      if (j >= i)
      {
        alertDialog.show();
        return;
        i = arrayOfString.length;
        break;
      }
      paramBundle = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = arrayOfString[j];
          String str = str;
          HashMap localHashMap = new HashMap();
          localHashMap.put("button-pressed", paramAnonymousDialogInterface);
          localHashMap.put("caller", str);
          NativePluginHelper.sendMessage("AlertDialogClosed", localHashMap);
          UiHandler.getInstance().onFinish(str);
          finish();
        }
      };
      alertDialog.setButton(-1 - j, arrayOfString[j], paramBundle);
      j += 1;
    }
  }
  
  private void showLoginPrompt(Bundle paramBundle)
  {
    final String[] arrayOfString = paramBundle.getStringArray("button-list");
    setContentView(new LinearLayout(this));
    alertDialog = getDialogWithDefaultDetails(paramBundle);
    final EditText localEditText1 = new EditText(this);
    final EditText localEditText2 = new EditText(this);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localEditText1);
    ((LinearLayout)localObject).addView(localEditText2);
    alertDialog.setView((View)localObject);
    localObject = paramBundle.getString("place-holder-text-1");
    paramBundle = paramBundle.getString("place-holder-text-2");
    localEditText2.setTransformationMethod(new PasswordTransformationMethod());
    localEditText1.setHint((CharSequence)localObject);
    localEditText2.setHint(paramBundle);
    int i;
    final int j;
    if (arrayOfString.length > 3)
    {
      i = 3;
      j = 0;
    }
    for (;;)
    {
      if (j >= i)
      {
        alertDialog.show();
        return;
        i = arrayOfString.length;
        break;
      }
      paramBundle = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new HashMap();
          paramAnonymousDialogInterface.put("button-pressed", arrayOfString[j]);
          paramAnonymousDialogInterface.put("username", localEditText1.getText().toString());
          paramAnonymousDialogInterface.put("password", localEditText2.getText().toString());
          NativePluginHelper.sendMessage("LoginPromptDialogClosed", paramAnonymousDialogInterface);
          finish();
        }
      };
      alertDialog.setButton(-1 - j, arrayOfString[j], paramBundle);
      j += 1;
    }
  }
  
  private void showSinglePrompt(Bundle paramBundle)
  {
    int i = 3;
    final String[] arrayOfString = paramBundle.getStringArray("button-list");
    alertDialog = getDialogWithDefaultDetails(paramBundle);
    final EditText localEditText = new EditText(this);
    alertDialog.setView(localEditText);
    boolean bool = paramBundle.getBoolean("is-secure");
    paramBundle = paramBundle.getString("place-holder-text-1");
    if (bool) {
      localEditText.setTransformationMethod(new PasswordTransformationMethod());
    }
    if (paramBundle != null) {
      localEditText.setHint(paramBundle);
    }
    final int j;
    if (arrayOfString.length > 3) {
      j = 0;
    }
    for (;;)
    {
      if (j >= i)
      {
        alertDialog.show();
        return;
        i = arrayOfString.length;
        break;
      }
      paramBundle = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = localEditText.getText().toString();
          HashMap localHashMap = new HashMap();
          localHashMap.put("button-pressed", arrayOfString[j]);
          localHashMap.put("input", paramAnonymousDialogInterface);
          NativePluginHelper.sendMessage("SingleFieldPromptDialogClosed", localHashMap);
          finish();
        }
      };
      alertDialog.setButton(-1 - j, arrayOfString[j], paramBundle);
      j += 1;
    }
  }
  
  AlertDialog getDialogWithDefaultDetails(Bundle paramBundle)
  {
    String str = paramBundle.getString("title");
    paramBundle = paramBundle.getString("message");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    if (!StringUtility.isNullOrEmpty(str)) {
      localBuilder.setTitle(str);
    }
    if (!StringUtility.isNullOrEmpty(paramBundle)) {
      localBuilder.setMessage(paramBundle);
    }
    localBuilder.setCancelable(false);
    return localBuilder.create();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (bundleInfo == null) {
      bundleInfo = getIntent().getExtras();
    }
    paramBundle = eUiType.values()[bundleInfo.getInt("type")];
    if (paramBundle == eUiType.ALERT_DIALOG) {
      showAlertDialog(bundleInfo);
    }
    do
    {
      return;
      if (paramBundle == eUiType.SINGLE_FIELD_PROMPT)
      {
        showSinglePrompt(bundleInfo);
        return;
      }
    } while (paramBundle != eUiType.LOGIN_PROMPT);
    showLoginPrompt(bundleInfo);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (alertDialog != null)
    {
      alertDialog.dismiss();
      alertDialog = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    paused = true;
  }
  
  @SuppressLint({"NewApi"})
  protected void onResume()
  {
    super.onResume();
    if (paused)
    {
      finish();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          startActivity(getIntent());
        }
      }, 10L);
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */