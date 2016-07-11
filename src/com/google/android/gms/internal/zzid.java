package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.internal.zzx;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzid
{
  private static final String zzIA = PublisherAdView.class.getName();
  private static final String zzIB = PublisherInterstitialAd.class.getName();
  private static final String zzIC = SearchAdView.class.getName();
  private static final String zzID = AdLoader.class.getName();
  public static final Handler zzIE = new zzia(Looper.getMainLooper());
  private static final String zzIy = AdView.class.getName();
  private static final String zzIz = InterstitialAd.class.getName();
  private boolean zzIF = true;
  private boolean zzIG = false;
  private String zzIa;
  private final Object zzpd = new Object();
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzIE.post(paramRunnable);
  }
  
  private JSONArray zza(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      zza(localJSONArray, paramCollection.next());
    }
    return localJSONArray;
  }
  
  private void zza(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(zze((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(zzz((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(zza((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(zza((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }
  
  private void zza(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, zze((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, zzz((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null) {}
      for (;;)
      {
        paramJSONObject.put(paramString, zza((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, zza(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }
  
  public static void zzb(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    zzic.zza(paramRunnable);
  }
  
  private JSONObject zze(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }
  
  private boolean zzr(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (paramContext == null) {
      return false;
    }
    return paramContext.isScreenOn();
  }
  
  public boolean zzH(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((paramContext == null) || (activityInfo == null))
    {
      zzb.zzaH("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((activityInfo.configChanges & 0x10) == 0) {
      zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    }
    for (boolean bool = false;; bool = true)
    {
      if ((activityInfo.configChanges & 0x20) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x80) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x100) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x200) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x400) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((activityInfo.configChanges & 0x800) == 0)
      {
        zzb.zzaH(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }
  
  public boolean zzI(Context paramContext)
  {
    if (zzIG) {
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new zza(null), localIntentFilter);
    zzIG = true;
    return true;
  }
  
  protected String zzJ(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public AlertDialog.Builder zzK(Context paramContext)
  {
    return new AlertDialog.Builder(paramContext);
  }
  
  public zzbq zzL(Context paramContext)
  {
    return new zzbq(paramContext);
  }
  
  public String zzM(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        paramContext = (ActivityManager.RunningTaskInfo)paramContext.get(0);
        if ((paramContext != null) && (topActivity != null))
        {
          paramContext = topActivity.getClassName();
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public boolean zzN(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      if ((localObject != null) && (localKeyguardManager != null))
      {
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject == null) {
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (Process.myPid() == pid) {
            if ((importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = zzr(paramContext);
              if (bool) {
                return true;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    return false;
  }
  
  public Bitmap zzO(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return null;
    }
    try
    {
      paramContext = ((Activity)paramContext).getWindow().getDecorView();
      Bitmap localBitmap = Bitmap.createBitmap(paramContext.getWidth(), paramContext.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramContext.layout(0, 0, paramContext.getWidth(), paramContext.getHeight());
      paramContext.draw(localCanvas);
      return localBitmap;
    }
    catch (RuntimeException paramContext)
    {
      zzb.zzb("Fail to capture screen shot", paramContext);
    }
    return null;
  }
  
  public DisplayMetrics zza(WindowManager paramWindowManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public PopupWindow zza(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new PopupWindow(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public String zza(Context paramContext, View paramView, AdSizeParcel paramAdSizeParcel)
  {
    if (!((Boolean)zzby.zzvg.get()).booleanValue()) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("width", width);
      localJSONObject2.put("height", height);
      localJSONObject1.put("size", localJSONObject2);
      localJSONObject1.put("activity", zzM(paramContext));
      if (!zztf)
      {
        paramAdSizeParcel = new JSONArray();
        if (paramView != null)
        {
          paramContext = paramView.getParent();
          if (paramContext != null)
          {
            int i = -1;
            if ((paramContext instanceof ViewGroup)) {
              i = ((ViewGroup)paramContext).indexOfChild(paramView);
            }
            paramView = new JSONObject();
            paramView.put("type", paramContext.getClass().getName());
            paramView.put("index_of_child", i);
            paramAdSizeParcel.put(paramView);
          }
          if ((paramContext == null) || (!(paramContext instanceof View))) {
            break label232;
          }
          paramContext = (View)paramContext;
          break label227;
        }
        if (paramAdSizeParcel.length() > 0) {
          localJSONObject1.put("parents", paramAdSizeParcel);
        }
      }
      paramContext = localJSONObject1.toString();
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      zzb.zzd("Fail to get view hierarchy json", paramContext);
      return null;
    }
    for (;;)
    {
      label227:
      paramView = paramContext;
      break;
      label232:
      paramContext = null;
    }
  }
  
  public String zza(Context paramContext, zzan paramzzan, String paramString)
  {
    if (paramzzan == null) {
      return paramString;
    }
    try
    {
      Uri localUri2 = Uri.parse(paramString);
      Uri localUri1 = localUri2;
      if (paramzzan.zzc(localUri2)) {
        localUri1 = paramzzan.zza(localUri2, paramContext);
      }
      paramContext = localUri1.toString();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return paramString;
  }
  
  public String zza(zziz paramzziz, String paramString)
  {
    return zza(paramzziz.getContext(), paramzziz.zzhg(), paramString);
  }
  
  public String zza(InputStreamReader paramInputStreamReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(8192);
    char[] arrayOfChar = new char['ࠀ'];
    for (;;)
    {
      int i = paramInputStreamReader.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  public String zza(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    int i;
    if (((Boolean)zzby.zzvr.get()).booleanValue())
    {
      i = 0;
      if (i + 1 >= paramArrayOfStackTraceElement.length) {
        break label149;
      }
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      String str = localStackTraceElement.getClassName();
      if ((!"loadAd".equalsIgnoreCase(localStackTraceElement.getMethodName())) || ((!zzIy.equalsIgnoreCase(str)) && (!zzIz.equalsIgnoreCase(str)) && (!zzIA.equalsIgnoreCase(str)) && (!zzIB.equalsIgnoreCase(str)) && (!zzIC.equalsIgnoreCase(str)) && (!zzID.equalsIgnoreCase(str)))) {}
    }
    label149:
    for (paramArrayOfStackTraceElement = paramArrayOfStackTraceElement[(i + 1)].getClassName();; paramArrayOfStackTraceElement = null)
    {
      if ((paramArrayOfStackTraceElement != null) && (!paramArrayOfStackTraceElement.contains(paramString)))
      {
        return paramArrayOfStackTraceElement;
        i += 1;
        break;
      }
      return null;
    }
  }
  
  JSONArray zza(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      zza(localJSONArray, paramArrayOfObject[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
  }
  
  public void zza(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().addOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zza(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(zzf(paramContext, paramString));
  }
  
  public void zza(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = paramContext.getApplicationContext();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramContext;
      }
      paramBundle.putString("os", Build.VERSION.RELEASE);
      paramBundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
      paramBundle.putString("device", zzp.zzbv().zzgE());
      paramBundle.putString("js", paramString1);
      paramBundle.putString("appid", ((Context)localObject1).getPackageName());
      paramBundle.putString("eids", TextUtils.join(",", zzby.zzdf()));
    }
    paramString2 = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", paramString2);
    Object localObject1 = paramBundle.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramString2.appendQueryParameter((String)localObject2, paramBundle.getString((String)localObject2));
    }
    zzp.zzbv().zzc(paramContext, paramString1, paramString2.toString());
  }
  
  public void zza(Context paramContext, String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zzij(paramContext, paramString, (String)paramList.next()).zzgz();
    }
  }
  
  public void zza(Context paramContext, String paramString1, List<String> paramList, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      new zzij(paramContext, paramString1, (String)paramList.next(), paramString2).zzgz();
    }
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    zza(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
  }
  
  public void zza(Context paramContext, String paramString1, boolean paramBoolean, HttpURLConnection paramHttpURLConnection, String paramString2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", paramString2);
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public void zza(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", zzf(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(paramBoolean2);
  }
  
  public boolean zza(Context paramContext, Bitmap paramBitmap, String paramString)
  {
    zzx.zzcj("saveImageToFile must not be called on the main UI thread.");
    try
    {
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramContext);
      paramContext.close();
      paramBitmap.recycle();
      return true;
    }
    catch (Exception paramContext)
    {
      zzb.zzb("Fail to save file", paramContext);
    }
    return false;
  }
  
  public boolean zza(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }
  
  public boolean zza(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable paramClassLoader) {}
    return false;
  }
  
  public int zzaA(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      zzb.zzaH("Could not parse value:" + paramString);
    }
    return 0;
  }
  
  public boolean zzaB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }
  
  public String zzaz(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      paramActivity.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(paramOnScrollChangedListener);
    }
  }
  
  public void zzb(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramIntent.addFlags(268435456);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public void zzb(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if (((Boolean)zzby.zzvo.get()).booleanValue()) {
      zza(paramContext, paramString1, paramString2, paramBundle, paramBoolean);
    }
  }
  
  public void zzc(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    zza(paramContext, paramString1, localArrayList);
  }
  
  public Map<String, String> zze(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzp.zzbx().zzf(paramUri).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramUri.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public String zzf(final Context paramContext, String paramString)
  {
    synchronized (zzpd)
    {
      if (zzIa != null)
      {
        paramContext = zzIa;
        return paramContext;
      }
    }
    try
    {
      zzIa = zzp.zzbx().getDefaultUserAgent(paramContext);
      if (TextUtils.isEmpty(zzIa)) {
        if (!zzl.zzcF().zzgT())
        {
          zzIa = null;
          zzIE.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzid.zza(zzid.this))
              {
                zzid.zza(zzid.this, zzJ(paramContext));
                zzid.zza(zzid.this).notifyAll();
                return;
              }
            }
          });
          for (;;)
          {
            paramContext = zzIa;
            if (paramContext != null) {
              break;
            }
            try
            {
              zzpd.wait();
            }
            catch (InterruptedException paramContext)
            {
              zzIa = zzgC();
              zzb.zzaH("Interrupted, use default user agent: " + zzIa);
            }
          }
          paramContext = finally;
          throw paramContext;
        }
      }
      try
      {
        zzIa = zzJ(paramContext);
        zzIa = (zzIa + " (Mobile; " + paramString + ")");
        paramContext = zzIa;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          zzIa = zzgC();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public Bitmap zzg(Context paramContext, String paramString)
  {
    zzx.zzcj("getBackgroundImage must not be called on the main UI thread.");
    try
    {
      paramContext = paramContext.openFileInput(paramString);
      paramString = BitmapFactory.decodeStream(paramContext);
      paramContext.close();
      return paramString;
    }
    catch (Exception paramContext)
    {
      zzb.e("Fail to get background image");
    }
    return null;
  }
  
  public int[] zzg(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getWidth(), paramActivity.getHeight() };
      }
    }
    return zzgF();
  }
  
  public boolean zzgB()
  {
    return zzIF;
  }
  
  String zzgC()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null) {
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    }
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null) {
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
      }
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }
  
  public String zzgD()
  {
    Object localObject1 = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(((UUID)localObject1).getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(((UUID)localObject1).getMostSignificantBits()).toByteArray();
    localObject1 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2)
    {
      try
      {
        Object localObject2 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject2).update(arrayOfByte1);
        ((MessageDigest)localObject2).update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(((MessageDigest)localObject2).digest(), 0, arrayOfByte3, 0, 8);
        localObject2 = new BigInteger(1, arrayOfByte3).toString();
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return (String)localObject1;
  }
  
  public String zzgE()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1)) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  protected int[] zzgF()
  {
    return new int[] { 0, 0 };
  }
  
  public void zzh(Context paramContext, String paramString)
  {
    zzx.zzcj("deleteFile must not be called on the main UI thread.");
    paramContext.deleteFile(paramString);
  }
  
  public int[] zzh(Activity paramActivity)
  {
    int[] arrayOfInt = zzg(paramActivity);
    return new int[] { zzl.zzcF().zzc(paramActivity, arrayOfInt[0]), zzl.zzcF().zzc(paramActivity, arrayOfInt[1]) };
  }
  
  public int[] zzi(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.findViewById(16908290);
      if (paramActivity != null) {
        return new int[] { paramActivity.getTop(), paramActivity.getBottom() };
      }
    }
    return zzgF();
  }
  
  public int[] zzj(Activity paramActivity)
  {
    int[] arrayOfInt = zzi(paramActivity);
    return new int[] { zzl.zzcF().zzc(paramActivity, arrayOfInt[0]), zzl.zzcF().zzc(paramActivity, arrayOfInt[1]) };
  }
  
  public Bitmap zzk(View paramView)
  {
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
    paramView.setDrawingCacheEnabled(false);
    return localBitmap;
  }
  
  public JSONObject zzz(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zza(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException paramMap)
    {
      throw new JSONException("Could not convert map to JSON: " + paramMap.getMessage());
    }
  }
  
  private final class zza
    extends BroadcastReceiver
  {
    private zza() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        zzid.zza(zzid.this, true);
      }
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
        return;
      }
      zzid.zza(zzid.this, false);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */