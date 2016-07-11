package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzgt
  extends zzj.zza
{
  private static zzgt zzFA;
  private static final Object zzpy = new Object();
  private final Context mContext;
  private final zzgs zzFB;
  private final zzbr zzFC;
  private final zzdz zzrf;
  
  zzgt(Context paramContext, zzbr paramzzbr, zzgs paramzzgs)
  {
    mContext = paramContext;
    zzFB = paramzzgs;
    zzFC = paramzzbr;
    if (paramContext.getApplicationContext() != null) {
      paramContext = paramContext.getApplicationContext();
    }
    for (;;)
    {
      zzrf = new zzdz(paramContext, new VersionInfoParcel(8115000, 8115000, true), paramzzbr.zzdc(), new zzdz.zzb()new zzdz.zzc
      {
        public void zza(zzbb paramAnonymouszzbb)
        {
          paramAnonymouszzbb.zza("/log", zzdj.zzxv);
        }
      }, new zzdz.zzc());
      return;
    }
  }
  
  private static AdResponseParcel zza(Context paramContext, zzdz paramzzdz, final zzbr paramzzbr, zzgs paramzzgs, final AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    zzb.zzaF("Starting ad request from service.");
    zzby.initialize(paramContext);
    final zzcg localzzcg = new zzcg(((Boolean)zzby.zzuQ.get()).booleanValue(), "load_ad", zzqn.zzte);
    if ((versionCode > 10) && (zzEF != -1L)) {
      localzzcg.zza(localzzcg.zzb(zzEF), new String[] { "cts" });
    }
    zzce localzzce = localzzcg.zzdn();
    zzFv.init();
    final Object localObject = zzp.zzbB().zzC(paramContext);
    if (zzGE == -1)
    {
      zzb.zzaF("Device is offline.");
      return new AdResponseParcel(2);
    }
    if (versionCode >= 7) {}
    final zzgv localzzgv;
    for (final String str1 = zzEC;; str1 = UUID.randomUUID().toString())
    {
      localzzgv = new zzgv(str1, applicationInfo.packageName);
      if (zzEn.extras == null) {
        break;
      }
      str2 = zzEn.extras.getString("_ad");
      if (str2 == null) {
        break;
      }
      return zzgu.zza(paramContext, paramAdRequestInfoParcel, str2);
    }
    Location localLocation = zzFv.zzd(250L);
    String str2 = zzFw.zzc(paramContext, zzEo.packageName);
    List localList = zzFu.zza(paramAdRequestInfoParcel);
    String str3 = zzFx.zzax(zzEp);
    localObject = zzgu.zza(paramContext, paramAdRequestInfoParcel, (zzgy)localObject, zzFy.zzD(paramContext), localLocation, paramzzbr, str2, str3, localList);
    if (versionCode < 7) {}
    try
    {
      ((JSONObject)localObject).put("request_id", str1);
      if (localObject == null) {
        return new AdResponseParcel(0);
      }
      str1 = ((JSONObject)localObject).toString();
      localzzcg.zza(localzzce, new String[] { "arc" });
      localObject = localzzcg.zzdn();
      if (((Boolean)zzby.zzum.get()).booleanValue()) {
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzdz.zzd localzzd = zzFD.zzdO();
            localzzgv.zzb(localzzd);
            localzzcg.zza(localObject, new String[] { "rwc" });
            localzzd.zza(new zzis.zzc()new zzis.zza
            {
              public void zzb(zzbe paramAnonymous2zzbe)
              {
                zzoD.zza(zzFH, new String[] { "jsf" });
                zzoD.zzdo();
                paramAnonymous2zzbe.zza("/invalidRequest", zzFE.zzFR);
                paramAnonymous2zzbe.zza("/loadAdURL", zzFE.zzFS);
                try
                {
                  paramAnonymous2zzbe.zza("AFMA_buildAdURL", zzFG);
                  return;
                }
                catch (Exception paramAnonymous2zzbe)
                {
                  zzb.zzb("Error requesting an ad url", paramAnonymous2zzbe);
                }
              }
            }, new zzis.zza()
            {
              public void run() {}
            });
          }
        });
      }
      for (;;)
      {
        try
        {
          paramzzbr = (zzgx)localzzgv.zzfS().get(10L, TimeUnit.SECONDS);
          if (paramzzbr != null) {
            continue;
          }
          paramContext = new AdResponseParcel(0);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          paramContext = new AdResponseParcel(0);
          return paramContext;
          if (paramzzbr.getErrorCode() == -2) {
            continue;
          }
          paramContext = new AdResponseParcel(paramzzbr.getErrorCode());
          return paramContext;
          if (localzzcg.zzdq() == null) {
            continue;
          }
          localzzcg.zza(localzzcg.zzdq(), new String[] { "rur" });
          paramzzdz = null;
          if (!paramzzbr.zzfW()) {
            continue;
          }
          paramzzdz = zzFt.zzaw(zzEo.packageName);
          paramzzdz = zza(paramAdRequestInfoParcel, paramContext, zzqj.zzJu, paramzzbr.getUrl(), paramzzdz, str2, paramzzbr, localzzcg, paramzzgs);
          if (zzEW != 1) {
            continue;
          }
          zzFw.clearToken(paramContext, zzEo.packageName);
          localzzcg.zza(localzzce, new String[] { "tts" });
          zzEY = localzzcg.zzdp();
          return paramzzdz;
        }
        finally
        {
          zzid.zzIE.post(new Runnable()
          {
            public void run()
            {
              zzFE.zzfT();
              if (zzFE.zzfR() != null) {
                zzFE.zzfR().release();
              }
            }
          });
        }
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zziz localzziz = zzp.zzbw().zza(zzry, new AdSizeParcel(), false, false, null, paramAdRequestInfoParcelzzqj);
            if (zzp.zzby().zzgu()) {
              localzziz.clearCache(true);
            }
            localzziz.getWebView().setWillNotDraw(true);
            localzzgv.zze(localzziz);
            localzzcg.zza(localObject, new String[] { "rwc" });
            Object localObject = localzzcg.zzdn();
            localObject = zzgt.zzb(str1, localzzcg, (zzce)localObject);
            zzja localzzja = localzziz.zzhe();
            localzzja.zza("/invalidRequest", localzzgvzzFR);
            localzzja.zza("/loadAdURL", localzzgvzzFS);
            localzzja.zza("/log", zzdj.zzxv);
            localzzja.zza((zzja.zza)localObject);
            zzb.zzaF("Loading the JS library.");
            localzziz.loadUrl(paramzzbr.zzdc());
          }
        });
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static AdResponseParcel zza(AdRequestInfoParcel paramAdRequestInfoParcel, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, zzgx paramzzgx, zzcg paramzzcg, zzgs paramzzgs)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnull +346 -> 348
    //   5: aload 7
    //   7: invokevirtual 162	com/google/android/gms/internal/zzcg:zzdn	()Lcom/google/android/gms/internal/zzce;
    //   10: astore 13
    //   12: new 410	com/google/android/gms/internal/zzgw
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 413	com/google/android/gms/internal/zzgw:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)V
    //   20: astore 15
    //   22: new 415	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 418
    //   32: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 96	com/google/android/gms/ads/internal/util/client/zzb:zzaF	(Ljava/lang/String;)V
    //   45: new 425	java/net/URL
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 427	java/net/URL:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: invokestatic 431	com/google/android/gms/ads/internal/zzp:zzbz	()Lcom/google/android/gms/internal/zzmn;
    //   57: invokeinterface 437 1 0
    //   62: lstore 11
    //   64: iconst_0
    //   65: istore 9
    //   67: aload 8
    //   69: ifnull +13 -> 82
    //   72: aload 8
    //   74: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   77: invokeinterface 446 1 0
    //   82: aload_0
    //   83: invokevirtual 450	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   86: checkcast 452	java/net/HttpURLConnection
    //   89: astore 14
    //   91: invokestatic 456	com/google/android/gms/ads/internal/zzp:zzbv	()Lcom/google/android/gms/internal/zzid;
    //   94: aload_1
    //   95: aload_2
    //   96: iconst_0
    //   97: aload 14
    //   99: invokevirtual 459	com/google/android/gms/internal/zzid:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   102: aload 4
    //   104: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +13 -> 120
    //   110: aload 14
    //   112: ldc_w 467
    //   115: aload 4
    //   117: invokevirtual 470	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +32 -> 157
    //   128: aload 14
    //   130: ldc_w 472
    //   133: new 415	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 474
    //   143: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 470	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 6
    //   159: ifnull +61 -> 220
    //   162: aload 6
    //   164: invokevirtual 477	com/google/android/gms/internal/zzgx:zzfV	()Ljava/lang/String;
    //   167: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +50 -> 220
    //   173: aload 14
    //   175: iconst_1
    //   176: invokevirtual 481	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   179: aload 6
    //   181: invokevirtual 477	com/google/android/gms/internal/zzgx:zzfV	()Ljava/lang/String;
    //   184: invokevirtual 485	java/lang/String:getBytes	()[B
    //   187: astore 16
    //   189: aload 14
    //   191: aload 16
    //   193: arraylength
    //   194: invokevirtual 488	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   197: new 490	java/io/BufferedOutputStream
    //   200: dup
    //   201: aload 14
    //   203: invokevirtual 494	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   206: invokespecial 497	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   209: astore_3
    //   210: aload_3
    //   211: aload 16
    //   213: invokevirtual 501	java/io/BufferedOutputStream:write	([B)V
    //   216: aload_3
    //   217: invokestatic 506	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   220: aload 14
    //   222: invokevirtual 509	java/net/HttpURLConnection:getResponseCode	()I
    //   225: istore 10
    //   227: aload 14
    //   229: invokevirtual 513	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   232: astore_3
    //   233: iload 10
    //   235: sipush 200
    //   238: if_icmplt +193 -> 431
    //   241: iload 10
    //   243: sipush 300
    //   246: if_icmpge +185 -> 431
    //   249: aload_0
    //   250: invokevirtual 514	java/net/URL:toString	()Ljava/lang/String;
    //   253: astore_0
    //   254: new 516	java/io/InputStreamReader
    //   257: dup
    //   258: aload 14
    //   260: invokevirtual 520	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   263: invokespecial 523	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   266: astore_1
    //   267: invokestatic 456	com/google/android/gms/ads/internal/zzp:zzbv	()Lcom/google/android/gms/internal/zzid;
    //   270: aload_1
    //   271: invokevirtual 526	com/google/android/gms/internal/zzid:zza	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   274: astore_2
    //   275: aload_1
    //   276: invokestatic 506	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   279: aload_0
    //   280: aload_3
    //   281: aload_2
    //   282: iload 10
    //   284: invokestatic 529	com/google/android/gms/internal/zzgt:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   287: aload 15
    //   289: aload_0
    //   290: aload_3
    //   291: aload_2
    //   292: invokevirtual 532	com/google/android/gms/internal/zzgw:zzb	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
    //   295: aload 7
    //   297: ifnull +21 -> 318
    //   300: aload 7
    //   302: aload 13
    //   304: iconst_1
    //   305: anewarray 153	java/lang/String
    //   308: dup
    //   309: iconst_0
    //   310: ldc_w 534
    //   313: aastore
    //   314: invokevirtual 158	com/google/android/gms/internal/zzcg:zza	(Lcom/google/android/gms/internal/zzce;[Ljava/lang/String;)Z
    //   317: pop
    //   318: aload 15
    //   320: lload 11
    //   322: invokevirtual 538	com/google/android/gms/internal/zzgw:zzj	(J)Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   325: astore_0
    //   326: aload 14
    //   328: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   331: aload 8
    //   333: ifnull +13 -> 346
    //   336: aload 8
    //   338: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   341: invokeinterface 544 1 0
    //   346: aload_0
    //   347: areturn
    //   348: aconst_null
    //   349: astore 13
    //   351: goto -339 -> 12
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_1
    //   357: aload_1
    //   358: invokestatic 506	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   361: aload_0
    //   362: athrow
    //   363: astore_0
    //   364: aload 14
    //   366: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   369: aload 8
    //   371: ifnull +13 -> 384
    //   374: aload 8
    //   376: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   379: invokeinterface 544 1 0
    //   384: aload_0
    //   385: athrow
    //   386: astore_0
    //   387: new 415	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 546
    //   397: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_0
    //   401: invokevirtual 549	java/io/IOException:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   413: new 194	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   416: dup
    //   417: iconst_2
    //   418: invokespecial 197	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   421: areturn
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_1
    //   425: aload_1
    //   426: invokestatic 506	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   429: aload_0
    //   430: athrow
    //   431: aload_0
    //   432: invokevirtual 514	java/net/URL:toString	()Ljava/lang/String;
    //   435: aload_3
    //   436: aconst_null
    //   437: iload 10
    //   439: invokestatic 529	com/google/android/gms/internal/zzgt:zza	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   442: iload 10
    //   444: sipush 300
    //   447: if_icmplt +122 -> 569
    //   450: iload 10
    //   452: sipush 400
    //   455: if_icmpge +114 -> 569
    //   458: aload 14
    //   460: ldc_w 554
    //   463: invokevirtual 557	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   466: astore_0
    //   467: aload_0
    //   468: invokestatic 465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   471: ifeq +40 -> 511
    //   474: ldc_w 559
    //   477: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   480: new 194	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   483: dup
    //   484: iconst_0
    //   485: invokespecial 197	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   488: astore_0
    //   489: aload 14
    //   491: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   494: aload 8
    //   496: ifnull +13 -> 509
    //   499: aload 8
    //   501: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   504: invokeinterface 544 1 0
    //   509: aload_0
    //   510: areturn
    //   511: new 425	java/net/URL
    //   514: dup
    //   515: aload_0
    //   516: invokespecial 427	java/net/URL:<init>	(Ljava/lang/String;)V
    //   519: astore_0
    //   520: iload 9
    //   522: iconst_1
    //   523: iadd
    //   524: istore 9
    //   526: iload 9
    //   528: iconst_5
    //   529: if_icmple +95 -> 624
    //   532: ldc_w 561
    //   535: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   538: new 194	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   541: dup
    //   542: iconst_0
    //   543: invokespecial 197	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   546: astore_0
    //   547: aload 14
    //   549: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   552: aload 8
    //   554: ifnull +13 -> 567
    //   557: aload 8
    //   559: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   562: invokeinterface 544 1 0
    //   567: aload_0
    //   568: areturn
    //   569: new 415	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 563
    //   579: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: iload 10
    //   584: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   593: new 194	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   596: dup
    //   597: iconst_0
    //   598: invokespecial 197	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   601: astore_0
    //   602: aload 14
    //   604: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   607: aload 8
    //   609: ifnull +13 -> 622
    //   612: aload 8
    //   614: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   617: invokeinterface 544 1 0
    //   622: aload_0
    //   623: areturn
    //   624: aload 15
    //   626: aload_3
    //   627: invokevirtual 570	com/google/android/gms/internal/zzgw:zzh	(Ljava/util/Map;)V
    //   630: aload 14
    //   632: invokevirtual 541	java/net/HttpURLConnection:disconnect	()V
    //   635: aload 8
    //   637: ifnull +13 -> 650
    //   640: aload 8
    //   642: getfield 441	com/google/android/gms/internal/zzgs:zzFz	Lcom/google/android/gms/internal/zzha;
    //   645: invokeinterface 544 1 0
    //   650: goto -583 -> 67
    //   653: astore_0
    //   654: goto -229 -> 425
    //   657: astore_0
    //   658: aload_3
    //   659: astore_1
    //   660: goto -303 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	663	1	paramContext	Context
    //   0	663	2	paramString1	String
    //   0	663	3	paramString2	String
    //   0	663	4	paramString3	String
    //   0	663	5	paramString4	String
    //   0	663	6	paramzzgx	zzgx
    //   0	663	7	paramzzcg	zzcg
    //   0	663	8	paramzzgs	zzgs
    //   65	465	9	i	int
    //   225	358	10	j	int
    //   62	259	11	l	long
    //   10	340	13	localzzce	zzce
    //   89	542	14	localHttpURLConnection	java.net.HttpURLConnection
    //   20	605	15	localzzgw	zzgw
    //   187	25	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   197	210	354	finally
    //   91	120	363	finally
    //   120	157	363	finally
    //   162	197	363	finally
    //   216	220	363	finally
    //   220	233	363	finally
    //   249	254	363	finally
    //   275	295	363	finally
    //   300	318	363	finally
    //   318	326	363	finally
    //   357	363	363	finally
    //   425	431	363	finally
    //   431	442	363	finally
    //   458	489	363	finally
    //   511	520	363	finally
    //   532	547	363	finally
    //   569	602	363	finally
    //   624	630	363	finally
    //   12	64	386	java/io/IOException
    //   72	82	386	java/io/IOException
    //   82	91	386	java/io/IOException
    //   326	331	386	java/io/IOException
    //   336	346	386	java/io/IOException
    //   364	369	386	java/io/IOException
    //   374	384	386	java/io/IOException
    //   384	386	386	java/io/IOException
    //   489	494	386	java/io/IOException
    //   499	509	386	java/io/IOException
    //   547	552	386	java/io/IOException
    //   557	567	386	java/io/IOException
    //   602	607	386	java/io/IOException
    //   612	622	386	java/io/IOException
    //   630	635	386	java/io/IOException
    //   640	650	386	java/io/IOException
    //   254	267	422	finally
    //   267	275	653	finally
    //   210	216	657	finally
  }
  
  public static zzgt zza(Context paramContext, zzbr paramzzbr, zzgs paramzzgs)
  {
    synchronized (zzpy)
    {
      if (zzFA == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        zzFA = new zzgt(localContext, paramzzbr, paramzzgs);
      }
      paramContext = zzFA;
      return paramContext;
    }
  }
  
  private static zzja.zza zza(final String paramString, zzcg paramzzcg, final zzce paramzzce)
  {
    new zzja.zza()
    {
      public void zza(zziz paramAnonymouszziz, boolean paramAnonymousBoolean)
      {
        zzoD.zza(paramzzce, new String[] { "jsf" });
        zzoD.zzdo();
        paramAnonymouszziz.zza("AFMA_buildAdURL", paramString);
      }
    };
  }
  
  private static void zza(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    if (zzb.zzN(2))
    {
      zzb.v("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          zzb.v("    " + (String)localObject + ":");
          localObject = ((List)paramMap.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            zzb.v("      " + str);
          }
        }
      }
      zzb.v("  Body:");
      if (paramString2 != null)
      {
        int i = 0;
        while (i < Math.min(paramString2.length(), 100000))
        {
          zzb.v(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
          i += 1000;
        }
      }
      zzb.v("    null");
      zzb.v("  Response Code:\n    " + paramInt + "\n}");
    }
  }
  
  public void zza(final AdRequestInfoParcel paramAdRequestInfoParcel, final zzk paramzzk)
  {
    zzp.zzby().zzb(mContext, zzqj);
    zzid.zzb(new Runnable()
    {
      public void run()
      {
        try
        {
          AdResponseParcel localAdResponseParcel1 = zze(paramAdRequestInfoParcel);
          localAdResponseParcel2 = localAdResponseParcel1;
          if (localAdResponseParcel1 == null) {
            localAdResponseParcel2 = new AdResponseParcel(0);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              AdResponseParcel localAdResponseParcel2;
              paramzzk.zzb(localAdResponseParcel2);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              Object localObject;
              zzb.zzd("Fail to forward ad response.", localRemoteException);
            }
            localException = localException;
            zzp.zzby().zzc(localException, true);
            zzb.zzd("Could not fetch ad response due to an Exception.", localException);
            localObject = null;
          }
        }
      }
    });
  }
  
  public AdResponseParcel zze(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return zza(mContext, zzrf, zzFC, zzFB, paramAdRequestInfoParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */