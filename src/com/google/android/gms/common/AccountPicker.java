package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public final class AccountPicker
{
  public static Intent newChooseAccountIntent(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle)
  {
    return zza(paramAccount, paramArrayList, paramArrayOfString1, paramBoolean, paramString1, paramString2, paramArrayOfString2, paramBundle, false);
  }
  
  public static Intent zza(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean1, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle, boolean paramBoolean2)
  {
    return zza(paramAccount, paramArrayList, paramArrayOfString1, paramBoolean1, paramString1, paramString2, paramArrayOfString2, paramBundle, paramBoolean2, 0, 0);
  }
  
  public static Intent zza(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean1, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    return zza(paramAccount, paramArrayList, paramArrayOfString1, paramBoolean1, paramString1, paramString2, paramArrayOfString2, paramBundle, paramBoolean2, paramInt1, paramInt2, false);
  }
  
  public static Intent zza(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean1, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent();
    if (paramBoolean3) {}
    for (String str = "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE";; str = "com.google.android.gms.common.account.CHOOSE_ACCOUNT")
    {
      localIntent.setAction(str);
      localIntent.setPackage("com.google.android.gms");
      localIntent.putExtra("allowableAccounts", paramArrayList);
      localIntent.putExtra("allowableAccountTypes", paramArrayOfString1);
      localIntent.putExtra("addAccountOptions", paramBundle);
      localIntent.putExtra("selectedAccount", paramAccount);
      localIntent.putExtra("alwaysPromptForAccount", paramBoolean1);
      localIntent.putExtra("descriptionTextOverride", paramString1);
      localIntent.putExtra("authTokenType", paramString2);
      localIntent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
      localIntent.putExtra("setGmsCoreAccount", paramBoolean2);
      localIntent.putExtra("overrideTheme", paramInt1);
      localIntent.putExtra("overrideCustomTheme", paramInt2);
      return localIntent;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.AccountPicker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */