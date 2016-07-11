package com.google.android.gms.internal;

final class zzdj$4
  implements zzdk
{
  /* Error */
  public void zza(zziz paramzziz, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 23 1 0
    //   6: invokevirtual 29	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: astore 5
    //   11: aload_2
    //   12: ldc 31
    //   14: invokeinterface 37 2 0
    //   19: checkcast 39	java/lang/String
    //   22: astore_2
    //   23: new 41	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: ldc 46
    //   35: invokevirtual 50	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   38: astore_2
    //   39: new 41	org/json/JSONObject
    //   42: dup
    //   43: invokespecial 51	org/json/JSONObject:<init>	()V
    //   46: astore 6
    //   48: iconst_0
    //   49: istore_3
    //   50: iload_3
    //   51: aload_2
    //   52: invokevirtual 57	org/json/JSONArray:length	()I
    //   55: if_icmpge +298 -> 353
    //   58: aload_2
    //   59: iload_3
    //   60: invokevirtual 61	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   63: astore 13
    //   65: aload 13
    //   67: ldc 63
    //   69: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 7
    //   74: aload 13
    //   76: ldc 69
    //   78: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 8
    //   83: aload 13
    //   85: ldc 71
    //   87: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 9
    //   92: aload 13
    //   94: ldc 73
    //   96: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 10
    //   101: aload 13
    //   103: ldc 75
    //   105: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 11
    //   110: aload 13
    //   112: ldc 77
    //   114: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 12
    //   119: aload 13
    //   121: ldc 79
    //   123: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: pop
    //   127: aload 13
    //   129: ldc 81
    //   131: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: pop
    //   135: new 83	android/content/Intent
    //   138: dup
    //   139: invokespecial 84	android/content/Intent:<init>	()V
    //   142: astore 13
    //   144: aload 8
    //   146: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +14 -> 163
    //   152: aload 13
    //   154: aload 8
    //   156: invokestatic 96	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   159: invokevirtual 100	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   162: pop
    //   163: aload 9
    //   165: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifne +11 -> 179
    //   171: aload 13
    //   173: aload 9
    //   175: invokevirtual 104	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 10
    //   181: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +11 -> 195
    //   187: aload 13
    //   189: aload 10
    //   191: invokevirtual 107	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   194: pop
    //   195: aload 11
    //   197: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +11 -> 211
    //   203: aload 13
    //   205: aload 11
    //   207: invokevirtual 110	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   210: pop
    //   211: aload 12
    //   213: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +41 -> 257
    //   219: aload 12
    //   221: ldc 112
    //   223: iconst_2
    //   224: invokevirtual 116	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   227: astore 8
    //   229: aload 8
    //   231: arraylength
    //   232: iconst_2
    //   233: if_icmpne +24 -> 257
    //   236: aload 13
    //   238: new 118	android/content/ComponentName
    //   241: dup
    //   242: aload 8
    //   244: iconst_0
    //   245: aaload
    //   246: aload 8
    //   248: iconst_1
    //   249: aaload
    //   250: invokespecial 121	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: invokevirtual 125	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   256: pop
    //   257: aload 5
    //   259: aload 13
    //   261: ldc 126
    //   263: invokevirtual 132	android/content/pm/PackageManager:resolveActivity	(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
    //   266: ifnull +69 -> 335
    //   269: iconst_1
    //   270: istore 4
    //   272: aload 6
    //   274: aload 7
    //   276: iload 4
    //   278: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   281: pop
    //   282: iload_3
    //   283: iconst_1
    //   284: iadd
    //   285: istore_3
    //   286: goto -236 -> 50
    //   289: astore_2
    //   290: aload_1
    //   291: ldc -118
    //   293: new 41	org/json/JSONObject
    //   296: dup
    //   297: invokespecial 51	org/json/JSONObject:<init>	()V
    //   300: invokeinterface 142 3 0
    //   305: return
    //   306: astore_2
    //   307: aload_1
    //   308: ldc -118
    //   310: new 41	org/json/JSONObject
    //   313: dup
    //   314: invokespecial 51	org/json/JSONObject:<init>	()V
    //   317: invokeinterface 142 3 0
    //   322: return
    //   323: astore 7
    //   325: ldc -112
    //   327: aload 7
    //   329: invokestatic 149	com/google/android/gms/ads/internal/util/client/zzb:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: goto -50 -> 282
    //   335: iconst_0
    //   336: istore 4
    //   338: goto -66 -> 272
    //   341: astore 7
    //   343: ldc -105
    //   345: aload 7
    //   347: invokestatic 149	com/google/android/gms/ads/internal/util/client/zzb:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   350: goto -68 -> 282
    //   353: aload_1
    //   354: ldc -118
    //   356: aload 6
    //   358: invokeinterface 142 3 0
    //   363: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	4
    //   0	364	1	paramzziz	zziz
    //   0	364	2	paramMap	java.util.Map<String, String>
    //   49	237	3	i	int
    //   270	67	4	bool	boolean
    //   9	249	5	localPackageManager	android.content.pm.PackageManager
    //   46	311	6	localJSONObject	org.json.JSONObject
    //   72	203	7	str1	String
    //   323	5	7	localJSONException1	org.json.JSONException
    //   341	5	7	localJSONException2	org.json.JSONException
    //   81	166	8	localObject1	Object
    //   90	84	9	str2	String
    //   99	91	10	str3	String
    //   108	98	11	str4	String
    //   117	103	12	str5	String
    //   63	197	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	32	289	org/json/JSONException
    //   32	39	306	org/json/JSONException
    //   58	65	323	org/json/JSONException
    //   272	282	341	org/json/JSONException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */