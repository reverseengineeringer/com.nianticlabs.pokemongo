package com.nianticlabs.nia.account;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class AccountsActivity
  extends Activity
{
  static final String AUTH_TOKEN_SCOPE_PREFIX = "audience:server:client_id:";
  static String EXTRA_OAUTH_CLIENT_ID = "oauthClientId";
  private static final int REQUEST_CHOOSE_ACCOUNT = 1;
  private static final int REQUEST_GET_AUTH = 2;
  private static String TAG = "AccountsActivity";
  private NianticAccountManager accountManager;
  private boolean authInProgress = false;
  
  private void askUserToRecover(final UserRecoverableAuthException paramUserRecoverableAuthException)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        startActivityForResult(paramUserRecoverableAuthException.getIntent(), 2);
      }
    });
  }
  
  private void failAuth(NianticAccountManager.Status paramStatus, String paramString)
  {
    Log.e(TAG, paramString);
    accountManager.setAuthToken(paramStatus, "");
    finish();
  }
  
  private void getAuth(final String paramString)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        AccountsActivity.getAuthTokenBlocking(AccountsActivity.this, paramString);
        return null;
      }
    }.execute(new Void[0]);
  }
  
  private void getAuthOrAccount()
  {
    String str = accountManager.getAccountName();
    if (str != null)
    {
      getAuth(str);
      return;
    }
    startActivityForResult(AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, false, null, null, null, null), 1);
  }
  
  private static void getAuthTokenBlocking(AccountsActivity paramAccountsActivity, String paramString)
  {
    try
    {
      Log.d(TAG, "Authenticating with account: " + paramString);
      String str = paramAccountsActivity.getIntent().getStringExtra(EXTRA_OAUTH_CLIENT_ID);
      Log.i(TAG, "Authenticating with client id: " + str);
      str = "audience:server:client_id:" + str;
      Log.i(TAG, "Authenticating with scope: " + str);
      paramString = GoogleAuthUtil.getToken(paramAccountsActivity, paramString, str);
      accountManager.setAuthToken(NianticAccountManager.Status.OK, paramString);
      paramAccountsActivity.postFinish();
      return;
    }
    catch (UserRecoverableAuthException paramString)
    {
      paramAccountsActivity.askUserToRecover(paramString);
      return;
    }
    catch (IOException paramString)
    {
      Log.e(TAG, "Unable to get authToken at this time.", paramString);
      accountManager.setAuthToken(NianticAccountManager.Status.NON_RECOVERABLE_ERROR, "");
      paramAccountsActivity.postFinish();
      return;
    }
    catch (GoogleAuthException paramString)
    {
      Log.e(TAG, "User cannot be authenticated.", paramString);
      accountManager.setAuthToken(NianticAccountManager.Status.NON_RECOVERABLE_ERROR, "");
      paramAccountsActivity.postFinish();
    }
  }
  
  private void postFinish()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = "Unexpected requestCode " + paramInt1;
    switch (paramInt1)
    {
    default: 
      Log.e(TAG, str);
      return;
    case 1: 
      if (paramInt2 == 0)
      {
        failAuth(NianticAccountManager.Status.USER_CANCELED_LOGIN, "User decided to cancel account selection.");
        return;
      }
      if (paramIntent == null)
      {
        failAuth(NianticAccountManager.Status.NON_RECOVERABLE_ERROR, "Attempt to choose null account, resultCode: " + paramInt2);
        return;
      }
      paramIntent = paramIntent.getStringExtra("authAccount");
      if ((paramIntent == null) || ("".equals(paramIntent)))
      {
        failAuth(NianticAccountManager.Status.NON_RECOVERABLE_ERROR, "Attempt to choose unnamed account, resultCode: " + paramInt2);
        return;
      }
      accountManager.setAccountName(paramIntent);
      getAuth(paramIntent);
      return;
    }
    getAuthOrAccount();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getResources().getIdentifier("accounts_activity", "layout", getPackageName()));
    accountManager = null;
    paramBundle = NianticAccountManager.getInstance();
    if (paramBundle != null) {
      accountManager = ((NianticAccountManager)paramBundle.get());
    }
    if (accountManager == null) {
      throw new RuntimeException("Unable to locate NianticAccountManager");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    if (i != 0)
    {
      Log.e(TAG, "Google Play Services not available, need to do something. Error code: " + i);
      accountManager.setAuthToken(NianticAccountManager.Status.NON_RECOVERABLE_ERROR, "");
      finish();
    }
    while (authInProgress) {
      return;
    }
    authInProgress = true;
    getAuthOrAccount();
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.account.AccountsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */