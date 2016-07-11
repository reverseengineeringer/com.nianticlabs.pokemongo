package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UiUtils
{
  private static final String CARDBOARD_CONFIGURE_ACTION = "com.google.vrtoolkit.cardboard.CONFIGURE";
  private static final String CARDBOARD_WEBSITE = "http://google.com/cardboard/cfg";
  private static final String INTENT_KEY = "intent";
  
  static void launchOrInstallCardboard(Context paramContext)
  {
    launchOrInstallCardboard(paramContext, true);
  }
  
  public static void launchOrInstallCardboard(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = paramContext.getPackageManager();
    Intent localIntent1 = new Intent();
    localIntent1.setAction("com.google.vrtoolkit.cardboard.CONFIGURE");
    Object localObject2 = ((PackageManager)localObject1).queryIntentActivities(localIntent1, 0);
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
      String str = activityInfo.packageName;
      if (str.startsWith("com.google."))
      {
        Intent localIntent2 = new Intent(localIntent1);
        localIntent2.setClassName(str, activityInfo.name);
        ((List)localObject1).add(localIntent2);
      }
    }
    if (((List)localObject1).isEmpty())
    {
      showInstallDialog(paramContext);
      return;
    }
    if (((List)localObject1).size() == 1) {
      localIntent1 = (Intent)((List)localObject1).get(0);
    }
    while (paramBoolean)
    {
      showConfigureDialog(paramContext, localIntent1);
      return;
    }
    paramContext.startActivity(localIntent1);
  }
  
  private static void showConfigureDialog(Context paramContext, Intent paramIntent)
  {
    paramContext = ((Activity)paramContext).getFragmentManager();
    ConfigureSettingsDialogFragment localConfigureSettingsDialogFragment = new ConfigureSettingsDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localConfigureSettingsDialogFragment.setArguments(localBundle);
    localConfigureSettingsDialogFragment.show(paramContext, "ConfigureCardboardDialog");
  }
  
  private static void showInstallDialog(Context paramContext)
  {
    paramContext = ((Activity)paramContext).getFragmentManager();
    new InstallSettingsDialogFragment().show(paramContext, "InstallCardboardDialog");
  }
  
  public static class ConfigureSettingsDialogFragment
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
          UiUtils.showInstallDialog(getActivity());
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
  
  public static class InstallSettingsDialogFragment
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
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */