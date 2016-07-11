package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.AndroidAppUri;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzgu
{
  private static final SimpleDateFormat zzFN = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  private static String zzI(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  public static AdResponseParcel zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    JSONObject localJSONObject;
    String str1;
    String str2;
    String str3;
    boolean bool1;
    long l2;
    String str4;
    long l1;
    label107:
    Object localObject1;
    int i;
    label247:
    Object localObject2;
    label285:
    int j;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str1 = localJSONObject.optString("ad_base_url", null);
        str2 = localJSONObject.optString("ad_url", null);
        str3 = localJSONObject.optString("ad_size", null);
        if ((paramAdRequestInfoParcel == null) || (zzEt == 0)) {
          break label858;
        }
        bool1 = true;
        if (bool1)
        {
          paramString = localJSONObject.optString("ad_json", null);
          l2 = -1L;
          str4 = localJSONObject.optString("debug_dialog", null);
          if (!localJSONObject.has("interstitial_timeout")) {
            break label864;
          }
          l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
          localObject1 = localJSONObject.optString("orientation", null);
          i = -1;
          if ("portrait".equals(localObject1))
          {
            i = zzp.zzbx().zzgH();
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            if (!TextUtils.isEmpty(str1)) {
              break label849;
            }
            zzb.zzaH("Could not parse the mediation config: Missing required ad_base_url field");
            return new AdResponseParcel(0);
          }
        }
        else
        {
          paramString = localJSONObject.optString("ad_html", null);
          continue;
        }
        if (!"landscape".equals(localObject1)) {
          continue;
        }
        i = zzp.zzbx().zzgG();
        continue;
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = zzgt.zza(paramAdRequestInfoParcel, paramContext, zzqj.zzJu, str2, null, null, null, null, null);
          str1 = zzBF;
          str2 = body;
          l2 = zzEO;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 != null) {
            break label417;
          }
          paramContext = null;
          if (localObject2 == null) {
            break;
          }
          paramString = paramContext;
          if (paramContext != null) {
            break label872;
          }
          paramString = new LinkedList();
          break label872;
          if (j >= ((JSONArray)localObject2).length()) {
            break label878;
          }
          paramString.add(((JSONArray)localObject2).getString(j));
          j += 1;
          continue;
        }
        paramAdRequestInfoParcel = new StringBuilder().append("Could not parse the mediation config: Missing required ");
        if (bool1)
        {
          paramContext = "ad_json";
          zzb.zzaH(paramContext + " or " + "ad_url" + " field.");
          paramContext = new AdResponseParcel(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        zzb.zzaH("Could not parse the mediation config: " + paramContext.getMessage());
        return new AdResponseParcel(0);
      }
      paramContext = "ad_html";
      continue;
      label417:
      paramContext = zzyY;
    }
    label426:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    label464:
    label506:
    Object localObject4;
    while (localObject3 != null)
    {
      paramString = paramContext;
      if (paramContext != null) {
        break label884;
      }
      paramString = new LinkedList();
      break label884;
      while (j < ((JSONArray)localObject3).length())
      {
        paramString.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = zzyZ;
      continue;
      localObject4 = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localObject4 != null; paramContext = zzEM)
      {
        paramString = paramContext;
        if (paramContext != null) {
          break label896;
        }
        paramString = new LinkedList();
        break label896;
        label544:
        while (j < ((JSONArray)localObject4).length())
        {
          paramString.add(((JSONArray)localObject4).getString(j));
          j += 1;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (localObject1 != null)
      {
        if (orientation != -1) {
          i = orientation;
        }
        j = i;
        if (zzEJ > 0L) {
          l1 = zzEJ;
        }
      }
      for (;;)
      {
        localObject1 = localJSONObject.optString("active_view");
        paramString = null;
        boolean bool2 = localJSONObject.optBoolean("ad_is_javascript", false);
        if (bool2) {
          paramString = localJSONObject.optString("ad_passback_url", null);
        }
        boolean bool3 = localJSONObject.optBoolean("mediation", false);
        boolean bool4 = localJSONObject.optBoolean("custom_render_allowed", false);
        boolean bool5 = localJSONObject.optBoolean("content_url_opted_out", true);
        boolean bool6 = localJSONObject.optBoolean("prefetch", false);
        j = localJSONObject.optInt("oauth2_token_status", 0);
        long l3 = localJSONObject.optLong("refresh_interval_milliseconds", -1L);
        long l4 = localJSONObject.optLong("mediation_config_cache_time_milliseconds", -1L);
        localObject4 = localJSONObject.optString("gws_query_id", "");
        boolean bool7 = "height".equals(localJSONObject.optString("fluid", ""));
        paramContext = new AdResponseParcel(paramAdRequestInfoParcel, str1, str2, (List)localObject2, (List)localObject3, l1, bool3, l4, paramContext, l3, i, str3, l2, str4, bool2, paramString, (String)localObject1, bool4, bool1, zzEv, bool5, bool6, j, (String)localObject4, bool7);
        return paramContext;
        i = j;
      }
      continue;
      localObject3 = paramContext;
      break label506;
      localObject2 = paramContext;
      break label426;
      label849:
      localObject1 = null;
      str2 = paramString;
      break label247;
      label858:
      bool1 = false;
      break;
      label864:
      l1 = -1L;
      break label107;
      label872:
      j = 0;
      break label285;
      label878:
      localObject2 = paramString;
      break label426;
      label884:
      j = 0;
      break label464;
      localObject3 = paramString;
      break label506;
      label896:
      j = 0;
      break label544;
      paramContext = paramString;
    }
  }
  
  /* Error */
  public static JSONObject zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzgy paramzzgy, zzhb.zza paramzza, Location paramLocation, zzbr paramzzbr, String paramString1, String paramString2, List<String> paramList)
  {
    // Byte code:
    //   0: new 273	java/util/HashMap
    //   3: dup
    //   4: invokespecial 274	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload 8
    //   11: invokeinterface 277 1 0
    //   16: ifle +20 -> 36
    //   19: aload 4
    //   21: ldc_w 279
    //   24: ldc_w 281
    //   27: aload 8
    //   29: invokestatic 285	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   32: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_1
    //   37: getfield 293	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEm	Landroid/os/Bundle;
    //   40: ifnull +16 -> 56
    //   43: aload 4
    //   45: ldc_w 295
    //   48: aload_1
    //   49: getfield 293	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEm	Landroid/os/Bundle;
    //   52: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: aload_1
    //   59: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEn	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   62: invokestatic 302	com/google/android/gms/internal/zzgu:zza	(Ljava/util/HashMap;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    //   65: aload 4
    //   67: ldc_w 303
    //   70: aload_1
    //   71: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   74: getfield 312	com/google/android/gms/ads/internal/client/AdSizeParcel:zzte	Ljava/lang/String;
    //   77: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload_1
    //   82: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   85: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   88: iconst_m1
    //   89: if_icmpne +15 -> 104
    //   92: aload 4
    //   94: ldc_w 317
    //   97: ldc_w 319
    //   100: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_1
    //   105: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   108: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   111: bipush -2
    //   113: if_icmpne +15 -> 128
    //   116: aload 4
    //   118: ldc_w 323
    //   121: ldc_w 325
    //   124: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_1
    //   129: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   132: getfield 328	com/google/android/gms/ads/internal/client/AdSizeParcel:zzti	Z
    //   135: ifeq +15 -> 150
    //   138: aload 4
    //   140: ldc_w 263
    //   143: ldc_w 261
    //   146: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: aload_1
    //   151: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   154: getfield 332	com/google/android/gms/ads/internal/client/AdSizeParcel:zztg	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   157: ifnull +172 -> 329
    //   160: new 181	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   167: astore 8
    //   169: aload_1
    //   170: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqn	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   173: getfield 332	com/google/android/gms/ads/internal/client/AdSizeParcel:zztg	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   176: astore 13
    //   178: aload 13
    //   180: arraylength
    //   181: istore 11
    //   183: iconst_0
    //   184: istore 9
    //   186: iload 9
    //   188: iload 11
    //   190: if_icmpge +128 -> 318
    //   193: aload 13
    //   195: iload 9
    //   197: aaload
    //   198: astore 14
    //   200: aload 8
    //   202: invokevirtual 333	java/lang/StringBuilder:length	()I
    //   205: ifeq +12 -> 217
    //   208: aload 8
    //   210: ldc_w 335
    //   213: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 14
    //   219: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   222: iconst_m1
    //   223: if_icmpne +75 -> 298
    //   226: aload 14
    //   228: getfield 338	com/google/android/gms/ads/internal/client/AdSizeParcel:widthPixels	I
    //   231: i2f
    //   232: aload_2
    //   233: getfield 344	com/google/android/gms/internal/zzgy:zzEz	F
    //   236: fdiv
    //   237: f2i
    //   238: istore 10
    //   240: aload 8
    //   242: iload 10
    //   244: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 8
    //   250: ldc_w 349
    //   253: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 14
    //   259: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   262: bipush -2
    //   264: if_icmpne +44 -> 308
    //   267: aload 14
    //   269: getfield 352	com/google/android/gms/ads/internal/client/AdSizeParcel:heightPixels	I
    //   272: i2f
    //   273: aload_2
    //   274: getfield 344	com/google/android/gms/internal/zzgy:zzEz	F
    //   277: fdiv
    //   278: f2i
    //   279: istore 10
    //   281: aload 8
    //   283: iload 10
    //   285: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: iload 9
    //   291: iconst_1
    //   292: iadd
    //   293: istore 9
    //   295: goto -109 -> 186
    //   298: aload 14
    //   300: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   303: istore 10
    //   305: goto -65 -> 240
    //   308: aload 14
    //   310: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   313: istore 10
    //   315: goto -34 -> 281
    //   318: aload 4
    //   320: ldc_w 354
    //   323: aload 8
    //   325: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: aload_1
    //   330: getfield 68	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEt	I
    //   333: ifeq +73 -> 406
    //   336: aload 4
    //   338: ldc_w 356
    //   341: aload_1
    //   342: getfield 68	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEt	I
    //   345: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: aload 4
    //   354: ldc_w 358
    //   357: aload_1
    //   358: getfield 361	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqD	Ljava/util/List;
    //   361: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload 4
    //   367: ldc_w 363
    //   370: aload_1
    //   371: getfield 367	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqB	Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;
    //   374: invokestatic 371	com/google/android/gms/internal/zzgu:zzc	(Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;)Ljava/lang/String;
    //   377: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   380: pop
    //   381: aload_1
    //   382: getfield 374	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEE	Ljava/util/List;
    //   385: invokeinterface 377 1 0
    //   390: ifne +16 -> 406
    //   393: aload 4
    //   395: ldc_w 379
    //   398: aload_1
    //   399: getfield 374	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEE	Ljava/util/List;
    //   402: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: aload 4
    //   408: ldc_w 381
    //   411: aload_1
    //   412: getfield 384	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqh	Ljava/lang/String;
    //   415: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: aload 4
    //   421: ldc_w 386
    //   424: aload_1
    //   425: getfield 390	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   428: getfield 395	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   431: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: aload_1
    //   436: getfield 399	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEo	Landroid/content/pm/PackageInfo;
    //   439: ifnull +22 -> 461
    //   442: aload 4
    //   444: ldc_w 401
    //   447: aload_1
    //   448: getfield 399	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEo	Landroid/content/pm/PackageInfo;
    //   451: getfield 406	android/content/pm/PackageInfo:versionCode	I
    //   454: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload 4
    //   463: ldc_w 408
    //   466: aload 7
    //   468: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 4
    //   474: ldc_w 410
    //   477: aload_1
    //   478: getfield 413	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEq	Ljava/lang/String;
    //   481: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload 4
    //   487: ldc_w 415
    //   490: aload_1
    //   491: getfield 418	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEr	Ljava/lang/String;
    //   494: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload 4
    //   500: ldc_w 420
    //   503: aload_1
    //   504: getfield 135	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqj	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   507: getfield 141	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:zzJu	Ljava/lang/String;
    //   510: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: aload 4
    //   516: aload_2
    //   517: aload_3
    //   518: invokestatic 423	com/google/android/gms/internal/zzgu:zza	(Ljava/util/HashMap;Lcom/google/android/gms/internal/zzgy;Lcom/google/android/gms/internal/zzhb$zza;)V
    //   521: aload 4
    //   523: ldc_w 425
    //   526: aload 5
    //   528: invokevirtual 430	com/google/android/gms/internal/zzbr:zzdd	()I
    //   531: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: aload 4
    //   540: ldc_w 432
    //   543: getstatic 437	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   546: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   549: pop
    //   550: aload 4
    //   552: ldc_w 439
    //   555: getstatic 442	android/os/Build:MODEL	Ljava/lang/String;
    //   558: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   561: pop
    //   562: aload_1
    //   563: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEn	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   566: getfield 445	com/google/android/gms/ads/internal/client/AdRequestParcel:versionCode	I
    //   569: iconst_2
    //   570: if_icmplt +25 -> 595
    //   573: aload_1
    //   574: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEn	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   577: getfield 449	com/google/android/gms/ads/internal/client/AdRequestParcel:zzsJ	Landroid/location/Location;
    //   580: ifnull +15 -> 595
    //   583: aload 4
    //   585: aload_1
    //   586: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEn	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   589: getfield 449	com/google/android/gms/ads/internal/client/AdRequestParcel:zzsJ	Landroid/location/Location;
    //   592: invokestatic 452	com/google/android/gms/internal/zzgu:zza	(Ljava/util/HashMap;Landroid/location/Location;)V
    //   595: aload_1
    //   596: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   599: iconst_2
    //   600: if_icmplt +16 -> 616
    //   603: aload 4
    //   605: ldc_w 455
    //   608: aload_1
    //   609: getfield 458	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEs	Landroid/os/Bundle;
    //   612: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   615: pop
    //   616: aload_1
    //   617: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   620: iconst_4
    //   621: if_icmplt +26 -> 647
    //   624: aload_1
    //   625: getfield 267	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEv	Z
    //   628: ifeq +19 -> 647
    //   631: aload 4
    //   633: ldc_w 460
    //   636: aload_1
    //   637: getfield 267	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEv	Z
    //   640: invokestatic 465	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   643: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   646: pop
    //   647: aload_1
    //   648: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   651: iconst_4
    //   652: if_icmplt +291 -> 943
    //   655: aload_1
    //   656: getfield 468	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEu	Landroid/os/Bundle;
    //   659: ifnull +284 -> 943
    //   662: aload_1
    //   663: getfield 468	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEu	Landroid/os/Bundle;
    //   666: astore_3
    //   667: aload_0
    //   668: aload_1
    //   669: aload_3
    //   670: invokestatic 471	com/google/android/gms/internal/zzgu:zza	(Landroid/content/Context;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Landroid/os/Bundle;)V
    //   673: aload 4
    //   675: ldc_w 473
    //   678: aload_3
    //   679: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   682: pop
    //   683: aload_1
    //   684: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   687: iconst_5
    //   688: if_icmplt +295 -> 983
    //   691: aload 4
    //   693: ldc_w 475
    //   696: aload_1
    //   697: getfield 476	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEz	F
    //   700: invokestatic 481	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   703: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   706: pop
    //   707: aload 4
    //   709: ldc_w 483
    //   712: aload_1
    //   713: getfield 486	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEy	I
    //   716: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   722: pop
    //   723: aload 4
    //   725: ldc_w 488
    //   728: aload_1
    //   729: getfield 491	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEx	I
    //   732: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   735: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   738: pop
    //   739: aload_1
    //   740: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   743: bipush 6
    //   745: if_icmplt +53 -> 798
    //   748: aload_1
    //   749: getfield 494	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEA	Ljava/lang/String;
    //   752: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   755: istore 12
    //   757: iload 12
    //   759: ifne +23 -> 782
    //   762: aload 4
    //   764: ldc_w 496
    //   767: new 49	org/json/JSONObject
    //   770: dup
    //   771: aload_1
    //   772: getfield 494	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEA	Ljava/lang/String;
    //   775: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   778: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   781: pop
    //   782: aload 4
    //   784: ldc_w 498
    //   787: aload_1
    //   788: getfield 501	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEB	J
    //   791: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   794: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   797: pop
    //   798: aload_1
    //   799: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   802: bipush 7
    //   804: if_icmplt +16 -> 820
    //   807: aload 4
    //   809: ldc_w 508
    //   812: aload_1
    //   813: getfield 511	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEC	Ljava/lang/String;
    //   816: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   819: pop
    //   820: aload_1
    //   821: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   824: bipush 11
    //   826: if_icmplt +26 -> 852
    //   829: aload_1
    //   830: getfield 515	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEG	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   833: ifnull +19 -> 852
    //   836: aload 4
    //   838: ldc_w 517
    //   841: aload_1
    //   842: getfield 515	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEG	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   845: invokevirtual 523	com/google/android/gms/ads/internal/request/CapabilityParcel:toBundle	()Landroid/os/Bundle;
    //   848: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: pop
    //   852: aload 4
    //   854: aload 6
    //   856: invokestatic 526	com/google/android/gms/internal/zzgu:zza	(Ljava/util/HashMap;Ljava/lang/String;)V
    //   859: aload_1
    //   860: getfield 453	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   863: bipush 12
    //   865: if_icmplt +26 -> 891
    //   868: aload_1
    //   869: getfield 529	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEH	Ljava/lang/String;
    //   872: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   875: ifne +16 -> 891
    //   878: aload 4
    //   880: ldc_w 531
    //   883: aload_1
    //   884: getfield 529	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzEH	Ljava/lang/String;
    //   887: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   890: pop
    //   891: iconst_2
    //   892: invokestatic 535	com/google/android/gms/ads/internal/util/client/zzb:zzN	(I)Z
    //   895: ifeq +39 -> 934
    //   898: invokestatic 539	com/google/android/gms/ads/internal/zzp:zzbv	()Lcom/google/android/gms/internal/zzid;
    //   901: aload 4
    //   903: invokevirtual 545	com/google/android/gms/internal/zzid:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   906: iconst_2
    //   907: invokevirtual 547	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   910: astore_0
    //   911: new 181	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   918: ldc_w 549
    //   921: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload_0
    //   925: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   934: invokestatic 539	com/google/android/gms/ads/internal/zzp:zzbv	()Lcom/google/android/gms/internal/zzid;
    //   937: aload 4
    //   939: invokevirtual 545	com/google/android/gms/internal/zzid:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   942: areturn
    //   943: new 554	android/os/Bundle
    //   946: dup
    //   947: invokespecial 555	android/os/Bundle:<init>	()V
    //   950: astore_3
    //   951: goto -284 -> 667
    //   954: astore_0
    //   955: new 181	java/lang/StringBuilder
    //   958: dup
    //   959: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   962: ldc_w 557
    //   965: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload_0
    //   969: invokevirtual 201	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   972: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokestatic 119	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   981: aconst_null
    //   982: areturn
    //   983: aload 4
    //   985: ldc_w 475
    //   988: aload_2
    //   989: getfield 344	com/google/android/gms/internal/zzgy:zzEz	F
    //   992: invokestatic 481	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   995: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   998: pop
    //   999: aload 4
    //   1001: ldc_w 483
    //   1004: aload_2
    //   1005: getfield 558	com/google/android/gms/internal/zzgy:zzEy	I
    //   1008: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1011: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1014: pop
    //   1015: aload 4
    //   1017: ldc_w 488
    //   1020: aload_2
    //   1021: getfield 559	com/google/android/gms/internal/zzgy:zzEx	I
    //   1024: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1027: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1030: pop
    //   1031: goto -292 -> 739
    //   1034: astore_0
    //   1035: ldc_w 561
    //   1038: aload_0
    //   1039: invokestatic 565	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1042: goto -260 -> 782
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1045	0	paramContext	Context
    //   0	1045	1	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	1045	2	paramzzgy	zzgy
    //   0	1045	3	paramzza	zzhb.zza
    //   0	1045	4	paramLocation	Location
    //   0	1045	5	paramzzbr	zzbr
    //   0	1045	6	paramString1	String
    //   0	1045	7	paramString2	String
    //   0	1045	8	paramList	List<String>
    //   184	110	9	i	int
    //   238	76	10	j	int
    //   181	10	11	k	int
    //   755	3	12	bool	boolean
    //   176	18	13	arrayOfAdSizeParcel	com.google.android.gms.ads.internal.client.AdSizeParcel[]
    //   198	111	14	localAdSizeParcel	com.google.android.gms.ads.internal.client.AdSizeParcel
    // Exception table:
    //   from	to	target	type
    //   0	36	954	org/json/JSONException
    //   36	56	954	org/json/JSONException
    //   56	104	954	org/json/JSONException
    //   104	128	954	org/json/JSONException
    //   128	150	954	org/json/JSONException
    //   150	183	954	org/json/JSONException
    //   200	217	954	org/json/JSONException
    //   217	240	954	org/json/JSONException
    //   240	281	954	org/json/JSONException
    //   281	289	954	org/json/JSONException
    //   298	305	954	org/json/JSONException
    //   308	315	954	org/json/JSONException
    //   318	329	954	org/json/JSONException
    //   329	406	954	org/json/JSONException
    //   406	461	954	org/json/JSONException
    //   461	595	954	org/json/JSONException
    //   595	616	954	org/json/JSONException
    //   616	647	954	org/json/JSONException
    //   647	667	954	org/json/JSONException
    //   667	739	954	org/json/JSONException
    //   739	757	954	org/json/JSONException
    //   782	798	954	org/json/JSONException
    //   798	820	954	org/json/JSONException
    //   820	852	954	org/json/JSONException
    //   852	891	954	org/json/JSONException
    //   891	934	954	org/json/JSONException
    //   934	943	954	org/json/JSONException
    //   943	951	954	org/json/JSONException
    //   983	1031	954	org/json/JSONException
    //   1035	1042	954	org/json/JSONException
    //   762	782	1034	org/json/JSONException
  }
  
  static void zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, Bundle paramBundle)
  {
    if (!((Boolean)zzby.zzuZ.get()).booleanValue())
    {
      zzb.zzaG("App index is not enabled");
      return;
    }
    if (!zzmm.zzjA())
    {
      zzb.zzaG("Not on service, return");
      return;
    }
    if (zzl.zzcF().zzgT())
    {
      zzb.zzaG("Cannot invoked on UI thread");
      return;
    }
    if ((paramAdRequestInfoParcel == null) || (zzEo == null))
    {
      zzb.zzaH("Invalid ad request info");
      return;
    }
    paramAdRequestInfoParcel = zzEo.packageName;
    if (TextUtils.isEmpty(paramAdRequestInfoParcel))
    {
      zzb.zzaH("Fail to get package name");
      return;
    }
    try
    {
      zza(zzd(paramContext, paramAdRequestInfoParcel), paramAdRequestInfoParcel, paramBundle);
      return;
    }
    catch (RuntimeException paramContext)
    {
      zzb.zzaG("Fail to add app index to content info");
    }
  }
  
  static void zza(UsageInfo paramUsageInfo, String paramString, Bundle paramBundle)
  {
    if ((paramUsageInfo == null) || (paramUsageInfo.zzlu() == null)) {}
    for (;;)
    {
      return;
      paramUsageInfo = paramUsageInfo.zzlu();
      String str = paramUsageInfo.zzln();
      if (!TextUtils.isEmpty(str)) {
        paramBundle.putString("web_url", str);
      }
      try
      {
        paramUsageInfo = paramUsageInfo.zzbw("intent_data");
        if ((paramUsageInfo != null) && (!TextUtils.isEmpty(zzQj)))
        {
          paramBundle.putString("app_uri", AndroidAppUri.newAndroidAppUri(paramString, Uri.parse(zzQj)).toString());
          return;
        }
      }
      catch (IllegalArgumentException paramUsageInfo)
      {
        zzb.zzaH("Failed to parse the third-party Android App URI");
      }
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    float f = paramLocation.getAccuracy();
    long l1 = paramLocation.getTime();
    long l2 = (paramLocation.getLatitude() * 1.0E7D);
    long l3 = (paramLocation.getLongitude() * 1.0E7D);
    localHashMap.put("radius", Float.valueOf(f * 1000.0F));
    localHashMap.put("lat", Long.valueOf(l2));
    localHashMap.put("long", Long.valueOf(l3));
    localHashMap.put("time", Long.valueOf(l1 * 1000L));
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, AdRequestParcel paramAdRequestParcel)
  {
    String str = zzhy.zzgy();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (zzsB != -1L) {
      paramHashMap.put("cust_age", zzFN.format(new Date(zzsB)));
    }
    if (extras != null) {
      paramHashMap.put("extras", extras);
    }
    if (zzsC != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(zzsC));
    }
    if (zzsD != null) {
      paramHashMap.put("kw", zzsD);
    }
    if (zzsF != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzsF));
    }
    if (zzsE) {
      paramHashMap.put("adtest", "on");
    }
    if (versionCode >= 2)
    {
      if (zzsG) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(zzsH)) {
        paramHashMap.put("ppid", zzsH);
      }
      if (zzsI != null) {
        zza(paramHashMap, zzsI);
      }
    }
    if ((versionCode >= 3) && (zzsK != null)) {
      paramHashMap.put("url", zzsK);
    }
    if (versionCode >= 5)
    {
      if (zzsM != null) {
        paramHashMap.put("custom_targeting", zzsM);
      }
      if (zzsN != null) {
        paramHashMap.put("category_exclusions", zzsN);
      }
      if (zzsO != null) {
        paramHashMap.put("request_agent", zzsO);
      }
    }
    if ((versionCode >= 6) && (zzsP != null)) {
      paramHashMap.put("request_pkg", zzsP);
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, SearchAdRequestParcel paramSearchAdRequestParcel)
  {
    Object localObject2 = null;
    if (Color.alpha(zztP) != 0) {
      paramHashMap.put("acolor", zzI(zztP));
    }
    if (Color.alpha(backgroundColor) != 0) {
      paramHashMap.put("bgcolor", zzI(backgroundColor));
    }
    if ((Color.alpha(zztQ) != 0) && (Color.alpha(zztR) != 0))
    {
      paramHashMap.put("gradientto", zzI(zztQ));
      paramHashMap.put("gradientfrom", zzI(zztR));
    }
    if (Color.alpha(zztS) != 0) {
      paramHashMap.put("bcolor", zzI(zztS));
    }
    paramHashMap.put("bthick", Integer.toString(zztT));
    Object localObject1;
    switch (zztU)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (zztV)
      {
      default: 
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramHashMap.put("callbuttoncolor", localObject1);
      }
      if (zztW != null) {
        paramHashMap.put("channel", zztW);
      }
      if (Color.alpha(zztX) != 0) {
        paramHashMap.put("dcolor", zzI(zztX));
      }
      if (zztY != null) {
        paramHashMap.put("font", zztY);
      }
      if (Color.alpha(zztZ) != 0) {
        paramHashMap.put("hcolor", zzI(zztZ));
      }
      paramHashMap.put("headersize", Integer.toString(zzua));
      if (zzub != null) {
        paramHashMap.put("q", zzub);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject1 = "dark";
      continue;
      localObject1 = "light";
      continue;
      localObject1 = "medium";
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zzgy paramzzgy, zzhb.zza paramzza)
  {
    paramHashMap.put("am", Integer.valueOf(zzGs));
    paramHashMap.put("cog", zzx(zzGt));
    paramHashMap.put("coh", zzx(zzGu));
    if (!TextUtils.isEmpty(zzGv)) {
      paramHashMap.put("carrier", zzGv);
    }
    paramHashMap.put("gl", zzGw);
    if (zzGx) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    if (zzGy) {
      paramHashMap.put("is_sidewinder", Integer.valueOf(1));
    }
    paramHashMap.put("ma", zzx(zzGz));
    paramHashMap.put("sp", zzx(zzGA));
    paramHashMap.put("hl", zzGB);
    if (!TextUtils.isEmpty(zzGC)) {
      paramHashMap.put("mv", zzGC);
    }
    paramHashMap.put("muv", Integer.valueOf(zzGD));
    if (zzGE != -2) {
      paramHashMap.put("cnt", Integer.valueOf(zzGE));
    }
    paramHashMap.put("gnt", Integer.valueOf(zzGF));
    paramHashMap.put("pt", Integer.valueOf(zzGG));
    paramHashMap.put("rm", Integer.valueOf(zzGH));
    paramHashMap.put("riv", Integer.valueOf(zzGI));
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("build", zzGN);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", zzGK);
    localBundle2.putDouble("battery_level", zzGJ);
    localBundle1.putBundle("battery", localBundle2);
    localBundle2 = new Bundle();
    localBundle2.putInt("active_network_state", zzGM);
    localBundle2.putBoolean("active_network_metered", zzGL);
    if (paramzza != null)
    {
      paramzzgy = new Bundle();
      paramzzgy.putInt("predicted_latency_micros", zzGS);
      paramzzgy.putLong("predicted_down_throughput_bps", zzGT);
      paramzzgy.putLong("predicted_up_throughput_bps", zzGU);
      localBundle2.putBundle("predictions", paramzzgy);
    }
    localBundle1.putBundle("network", localBundle2);
    paramHashMap.put("device", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, String paramString)
  {
    if (paramString != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", paramString);
      paramHashMap.put("pan", localHashMap);
    }
  }
  
  private static String zzc(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    if (paramNativeAdOptionsParcel != null) {}
    for (int i = zzwS;; i = 0) {
      switch (i)
      {
      default: 
        return "any";
      }
    }
    return "portrait";
    return "landscape";
  }
  
  /* Error */
  private static UsageInfo zzd(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 1067	com/google/android/gms/common/api/GoogleApiClient$Builder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 1070	com/google/android/gms/common/api/GoogleApiClient$Builder:<init>	(Landroid/content/Context;)V
    //   8: getstatic 1076	com/google/android/gms/appdatasearch/zza:zzPV	Lcom/google/android/gms/common/api/Api;
    //   11: invokevirtual 1080	com/google/android/gms/common/api/GoogleApiClient$Builder:addApi	(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    //   14: invokevirtual 1083	com/google/android/gms/common/api/GoogleApiClient$Builder:build	()Lcom/google/android/gms/common/api/GoogleApiClient;
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 1088	com/google/android/gms/common/api/GoogleApiClient:connect	()V
    //   22: new 1090	com/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza
    //   25: dup
    //   26: invokespecial 1091	com/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza:<init>	()V
    //   29: iconst_1
    //   30: invokevirtual 1095	com/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza:zzL	(Z)Lcom/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza;
    //   33: aload_1
    //   34: invokevirtual 1099	com/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza:zzby	(Ljava/lang/String;)Lcom/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza;
    //   37: invokevirtual 1103	com/google/android/gms/appdatasearch/GetRecentContextCall$Request$zza:zzlr	()Lcom/google/android/gms/appdatasearch/GetRecentContextCall$Request;
    //   40: astore_1
    //   41: getstatic 1107	com/google/android/gms/appdatasearch/zza:zzPW	Lcom/google/android/gms/appdatasearch/zzk;
    //   44: aload_0
    //   45: aload_1
    //   46: invokeinterface 1112 3 0
    //   51: lconst_1
    //   52: getstatic 1118	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 1124	com/google/android/gms/common/api/PendingResult:await	(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/api/Result;
    //   58: checkcast 1126	com/google/android/gms/appdatasearch/GetRecentContextCall$Response
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +13 -> 76
    //   66: aload_1
    //   67: invokevirtual 1130	com/google/android/gms/appdatasearch/GetRecentContextCall$Response:getStatus	()Lcom/google/android/gms/common/api/Status;
    //   70: invokevirtual 1135	com/google/android/gms/common/api/Status:isSuccess	()Z
    //   73: ifne +19 -> 92
    //   76: ldc_w 1137
    //   79: invokestatic 589	com/google/android/gms/ads/internal/util/client/zzb:zzaG	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 1140	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_1
    //   93: getfield 1143	com/google/android/gms/appdatasearch/GetRecentContextCall$Response:zzQB	Ljava/util/List;
    //   96: ifnull +15 -> 111
    //   99: aload_1
    //   100: getfield 1143	com/google/android/gms/appdatasearch/GetRecentContextCall$Response:zzQB	Ljava/util/List;
    //   103: invokeinterface 377 1 0
    //   108: ifeq +19 -> 127
    //   111: ldc_w 1145
    //   114: invokestatic 589	com/google/android/gms/ads/internal/util/client/zzb:zzaG	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: ifnull -28 -> 90
    //   121: aload_0
    //   122: invokevirtual 1140	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_1
    //   128: getfield 1143	com/google/android/gms/appdatasearch/GetRecentContextCall$Response:zzQB	Ljava/util/List;
    //   131: iconst_0
    //   132: invokeinterface 1148 2 0
    //   137: checkcast 626	com/google/android/gms/appdatasearch/UsageInfo
    //   140: astore_2
    //   141: aload_2
    //   142: astore_1
    //   143: aload_0
    //   144: ifnull +9 -> 153
    //   147: aload_0
    //   148: invokevirtual 1140	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   151: aload_2
    //   152: astore_1
    //   153: aload_1
    //   154: areturn
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_0
    //   158: ldc_w 1150
    //   161: invokestatic 119	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: ifnull +37 -> 202
    //   168: aload_0
    //   169: invokevirtual 1140	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -21 -> 153
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 1140	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: goto -11 -> 180
    //   194: astore_1
    //   195: goto -15 -> 180
    //   198: astore_1
    //   199: goto -41 -> 158
    //   202: aconst_null
    //   203: astore_1
    //   204: goto -51 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramContext	Context
    //   0	207	1	paramString	String
    //   140	12	2	localUsageInfo	UsageInfo
    // Exception table:
    //   from	to	target	type
    //   0	18	155	java/lang/SecurityException
    //   0	18	177	finally
    //   18	62	190	finally
    //   66	76	190	finally
    //   76	82	190	finally
    //   92	111	190	finally
    //   111	117	190	finally
    //   127	141	190	finally
    //   158	164	194	finally
    //   18	62	198	java/lang/SecurityException
    //   66	76	198	java/lang/SecurityException
    //   76	82	198	java/lang/SecurityException
    //   92	111	198	java/lang/SecurityException
    //   111	117	198	java/lang/SecurityException
    //   127	141	198	java/lang/SecurityException
  }
  
  private static Integer zzx(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */