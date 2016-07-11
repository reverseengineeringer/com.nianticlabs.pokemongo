package com.voxelbusters.nativeplugins.features.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import com.voxelbusters.nativeplugins.utilities.Debug;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.util.ArrayList;
import java.util.HashMap;

public class UiHandler
{
  private static UiHandler INSTANCE;
  private String currentDisplayedUiTag;
  private final ArrayList<String> queueList = new ArrayList();
  private final HashMap<String, Bundle> uiElementsMap = new HashMap();
  
  public static UiHandler getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new UiHandler();
    }
    return INSTANCE;
  }
  
  public void onFinish(String paramString)
  {
    currentDisplayedUiTag = null;
    if (queueList.size() > 0)
    {
      paramString = (String)queueList.remove(queueList.size() - 1);
      pushToActivityQueue((Bundle)uiElementsMap.get(paramString), paramString);
    }
  }
  
  public void pushToActivityQueue(Bundle paramBundle, String paramString)
  {
    if (currentDisplayedUiTag != null)
    {
      Debug.log("NativePlugins.Ui", "Queuing this ui element");
      queueList.add(paramString);
      return;
    }
    startActivity(paramBundle);
    currentDisplayedUiTag = paramString;
  }
  
  public void showAlertDialogWithMultipleButtons(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("message", paramString2);
    localBundle.putStringArray("button-list", StringUtility.convertJsonStringToStringArray(paramString3));
    localBundle.putString("tag", paramString4);
    localBundle.putInt("type", eUiType.ALERT_DIALOG.ordinal());
    pushToActivityQueue(localBundle, paramString4);
  }
  
  public void showLoginPromptDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("message", paramString2);
    localBundle.putStringArray("button-list", StringUtility.convertJsonStringToStringArray(paramString5));
    localBundle.putString("place-holder-text-1", paramString3);
    localBundle.putString("place-holder-text-2", paramString4);
    localBundle.putInt("type", eUiType.LOGIN_PROMPT.ordinal());
    startActivity(localBundle);
  }
  
  public void showSingleFieldPromptDialog(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("message", paramString2);
    localBundle.putStringArray("button-list", StringUtility.convertJsonStringToStringArray(paramString4));
    localBundle.putBoolean("is-secure", paramBoolean);
    localBundle.putString("place-holder-text-1", paramString3);
    localBundle.putInt("type", eUiType.SINGLE_FIELD_PROMPT.ordinal());
    startActivity(localBundle);
  }
  
  public void showToast(final String paramString1, String paramString2)
  {
    if (paramString2.equals("SHORT")) {}
    for (final int i = 0;; i = 1)
    {
      NativePluginHelper.executeOnUIThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(NativePluginHelper.getCurrentContext(), paramString1, i).show();
        }
      });
      return;
    }
  }
  
  void startActivity(Bundle paramBundle)
  {
    Intent localIntent = new Intent(NativePluginHelper.getCurrentContext(), UiActivity.class);
    localIntent.putExtras(paramBundle);
    NativePluginHelper.startActivityOnUiThread(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */