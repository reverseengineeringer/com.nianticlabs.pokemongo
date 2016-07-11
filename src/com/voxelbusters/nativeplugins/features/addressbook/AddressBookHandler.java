package com.voxelbusters.nativeplugins.features.addressbook;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import com.voxelbusters.nativeplugins.utilities.ApplicationUtility;
import com.voxelbusters.nativeplugins.utilities.Debug;
import com.voxelbusters.nativeplugins.utilities.FileUtility;
import com.voxelbusters.nativeplugins.utilities.JSONUtility;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressBookHandler
{
  static final Uri CONTACT_CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
  static final String CONTACT_IN_VISIBLE_GROUP = "in_visible_group";
  static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
  @SuppressLint({"InlinedApi"})
  static final String DISPLAY_NAME;
  static final String EMAIL_CONTACT_ID = "contact_id";
  static final Uri EMAIL_CONTENT_URI;
  static final String EMAIL_DATA = "data1";
  static final String EMAIL_TYPE = "data2";
  static final String FAMILY_NAME = "data3";
  static final String GIVEN_NAME = "data2";
  static final String HAS_PHONE_NUMBER = "has_phone_number";
  private static AddressBookHandler INSTANCE;
  static final String PHONE_CONTACT_ID = "contact_id";
  static final Uri PHONE_CONTENT_URI;
  static final String PHONE_DISPLAY_NAME = "display_name";
  static final String PHONE_NUMBER = "data1";
  static final String PHONE_TYPE = "data2";
  static final String PHOTO_CONTENT_DIRECTORY = "photo";
  static final String PHOTO_URI;
  static final String ROOT_CONTACT_ID = "_id";
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      DISPLAY_NAME = "display_name";
      PHONE_CONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
      if (Build.VERSION.SDK_INT < 11) {
        break label50;
      }
    }
    label50:
    for (String str = "photo_uri";; str = "photo_id")
    {
      PHOTO_URI = str;
      EMAIL_CONTENT_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
      return;
      break;
    }
  }
  
  private void addContactInternal(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("family-name");
    String str2 = paramJSONObject.optString("given-name");
    Object localObject3 = paramJSONObject.optString("image-path", null);
    ContentResolver localContentResolver = null;
    Object localObject1 = localContentResolver;
    if (!StringUtility.isNullOrEmpty((String)localObject3))
    {
      localObject3 = FileUtility.getBitmapStream((String)localObject3);
      localObject1 = localContentResolver;
      if (localObject3 != null) {
        localObject1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
    }
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("email-list");
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("phone-number-list");
    localContentResolver = NativePluginHelper.getCurrentContext().getContentResolver();
    localObject3 = new ArrayList();
    int j = ((ArrayList)localObject3).size();
    Debug.error("Test", "count : " + j);
    paramJSONObject = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    paramJSONObject.withValue("account_type", null);
    paramJSONObject.withValue("account_name", null);
    ((ArrayList)localObject3).add(paramJSONObject.build());
    paramJSONObject = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramJSONObject.withValueBackReference("raw_contact_id", j);
    paramJSONObject.withValue("data3", str1);
    paramJSONObject.withValue("data2", str2);
    paramJSONObject.withValue("mimetype", "vnd.android.cursor.item/name");
    ((ArrayList)localObject3).add(paramJSONObject.build());
    if (localObject1 != null)
    {
      paramJSONObject = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramJSONObject.withValueBackReference("raw_contact_id", j);
      paramJSONObject.withValue("data15", localObject1);
      paramJSONObject.withValue("mimetype", "vnd.android.cursor.item/photo");
      ((ArrayList)localObject3).add(paramJSONObject.build());
    }
    int i;
    if (localJSONArray2 != null)
    {
      i = 0;
      if (i < localJSONArray2.length()) {}
    }
    else if (localJSONArray1 != null)
    {
      i = 0;
    }
    for (;;)
    {
      if (i >= localJSONArray1.length()) {
        paramJSONObject = null;
      }
      try
      {
        localObject1 = localContentResolver.applyBatch("com.android.contacts", (ArrayList)localObject3);
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        for (;;)
        {
          localOperationApplicationException.printStackTrace();
          continue;
          paramJSONObject = "true";
        }
      }
      if (paramJSONObject != null) {
        break label539;
      }
      paramJSONObject = "false";
      NativePluginHelper.sendMessage("ABAddNewContactFinished", paramJSONObject);
      return;
      paramJSONObject = null;
      try
      {
        localObject1 = (String)localJSONArray2.get(i);
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
      if (!StringUtility.isNullOrEmpty(paramJSONObject))
      {
        localObject1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        ((ContentProviderOperation.Builder)localObject1).withValueBackReference("raw_contact_id", j);
        ((ContentProviderOperation.Builder)localObject1).withValue("data1", paramJSONObject);
        ((ContentProviderOperation.Builder)localObject1).withValue("data2", Integer.valueOf(3));
        ((ContentProviderOperation.Builder)localObject1).withValue("mimetype", "vnd.android.cursor.item/email_v2");
        ((ArrayList)localObject3).add(((ContentProviderOperation.Builder)localObject1).build());
      }
      i += 1;
      break;
      paramJSONObject = null;
      try
      {
        localObject2 = (String)localJSONArray1.get(i);
        paramJSONObject = (JSONObject)localObject2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Object localObject2;
          localJSONException2.printStackTrace();
        }
      }
      if (!StringUtility.isNullOrEmpty(paramJSONObject))
      {
        localObject2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        ((ContentProviderOperation.Builder)localObject2).withValueBackReference("raw_contact_id", j);
        ((ContentProviderOperation.Builder)localObject2).withValue("data1", paramJSONObject);
        ((ContentProviderOperation.Builder)localObject2).withValue("data2", Integer.valueOf(7));
        ((ContentProviderOperation.Builder)localObject2).withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        ((ArrayList)localObject3).add(((ContentProviderOperation.Builder)localObject2).build());
      }
      i += 1;
    }
  }
  
  public static AddressBookHandler getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new AddressBookHandler();
    }
    return INSTANCE;
  }
  
  /* Error */
  private void readContactsInBackground()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore 4
    //   8: aload 6
    //   10: astore 5
    //   12: invokestatic 155	com/voxelbusters/nativeplugins/NativePluginHelper:getCurrentContext	()Landroid/content/Context;
    //   15: astore 7
    //   17: aload_3
    //   18: astore 4
    //   20: aload 6
    //   22: astore 5
    //   24: aload 7
    //   26: invokevirtual 161	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: astore 8
    //   31: aload_3
    //   32: astore 4
    //   34: aload 6
    //   36: astore 5
    //   38: aload 8
    //   40: getstatic 63	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:CONTACT_CONTENT_URI	Landroid/net/Uri;
    //   43: aconst_null
    //   44: ldc_w 285
    //   47: aconst_null
    //   48: new 172	java/lang/StringBuilder
    //   51: dup
    //   52: getstatic 71	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:DISPLAY_NAME	Ljava/lang/String;
    //   55: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: ldc_w 290
    //   64: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore_3
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload_3
    //   81: invokeinterface 303 1 0
    //   86: istore_2
    //   87: aload_3
    //   88: astore 4
    //   90: aload_3
    //   91: astore 5
    //   93: new 163	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 164	java/util/ArrayList:<init>	()V
    //   100: astore 6
    //   102: iload_2
    //   103: ifeq +337 -> 440
    //   106: new 305	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails
    //   109: dup
    //   110: invokespecial 306	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:<init>	()V
    //   113: astore 4
    //   115: aload_0
    //   116: aload_3
    //   117: ldc 54
    //   119: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 5
    //   124: aload 8
    //   126: getstatic 221	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   129: aconst_null
    //   130: ldc_w 312
    //   133: iconst_2
    //   134: anewarray 259	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: ldc 17
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload 5
    //   146: aastore
    //   147: ldc 31
    //   149: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   152: astore 10
    //   154: aload 10
    //   156: invokeinterface 303 1 0
    //   161: pop
    //   162: aload_0
    //   163: aload 10
    //   165: getstatic 71	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:DISPLAY_NAME	Ljava/lang/String;
    //   168: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 9
    //   173: aload 4
    //   175: aload 9
    //   177: aload_0
    //   178: aload 10
    //   180: ldc 34
    //   182: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   185: aload_0
    //   186: aload 10
    //   188: ldc 31
    //   190: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   193: invokevirtual 316	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:setNames	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 10
    //   198: invokeinterface 319 1 0
    //   203: aload_0
    //   204: aload_3
    //   205: ldc 38
    //   207: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   210: invokestatic 323	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   213: ifle +285 -> 498
    //   216: iconst_1
    //   217: istore_1
    //   218: iload_1
    //   219: ifeq +51 -> 270
    //   222: aload 8
    //   224: getstatic 76	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:PHONE_CONTENT_URI	Landroid/net/Uri;
    //   227: aconst_null
    //   228: new 172	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 325
    //   235: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 5
    //   240: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: aconst_null
    //   247: aconst_null
    //   248: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   251: astore 10
    //   253: aload 10
    //   255: invokeinterface 328 1 0
    //   260: ifne +243 -> 503
    //   263: aload 10
    //   265: invokeinterface 319 1 0
    //   270: aload_0
    //   271: aload_3
    //   272: getstatic 80	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:PHOTO_URI	Ljava/lang/String;
    //   275: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 10
    //   280: aload 10
    //   282: invokestatic 129	com/voxelbusters/nativeplugins/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   285: ifne +94 -> 379
    //   288: aload 7
    //   290: aload 10
    //   292: invokestatic 334	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   295: ldc_w 336
    //   298: aload 5
    //   300: invokestatic 340	com/voxelbusters/nativeplugins/utilities/FileUtility:getSavedLocalFileFromUri	(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 11
    //   305: aload 11
    //   307: ifnonnull +60 -> 367
    //   310: ldc_w 342
    //   313: ldc_w 344
    //   316: invokestatic 191	com/voxelbusters/nativeplugins/utilities/Debug:error	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: ldc_w 342
    //   322: new 172	java/lang/StringBuilder
    //   325: dup
    //   326: ldc_w 346
    //   329: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 9
    //   334: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 349	com/voxelbusters/nativeplugins/utilities/Debug:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc_w 342
    //   346: new 172	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 351
    //   353: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: aload 10
    //   358: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 349	com/voxelbusters/nativeplugins/utilities/Debug:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 11
    //   369: ifnull +10 -> 379
    //   372: aload 4
    //   374: aload 11
    //   376: invokevirtual 354	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:setPicturePath	(Ljava/lang/String;)V
    //   379: aload 8
    //   381: getstatic 85	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:EMAIL_CONTENT_URI	Landroid/net/Uri;
    //   384: aconst_null
    //   385: ldc_w 356
    //   388: iconst_1
    //   389: anewarray 259	java/lang/String
    //   392: dup
    //   393: iconst_0
    //   394: aload 5
    //   396: aastore
    //   397: aconst_null
    //   398: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   401: astore 5
    //   403: aload 5
    //   405: invokeinterface 328 1 0
    //   410: ifne +178 -> 588
    //   413: aload 5
    //   415: invokeinterface 319 1 0
    //   420: aload 6
    //   422: aload 4
    //   424: invokevirtual 360	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:getHash	()Ljava/util/HashMap;
    //   427: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   430: pop
    //   431: aload_3
    //   432: invokeinterface 328 1 0
    //   437: ifne -331 -> 106
    //   440: invokestatic 365	java/lang/System:gc	()V
    //   443: ldc_w 367
    //   446: astore 5
    //   448: aload_3
    //   449: ifnull +9 -> 458
    //   452: aload_3
    //   453: invokeinterface 319 1 0
    //   458: aload 6
    //   460: astore 4
    //   462: new 369	java/util/HashMap
    //   465: dup
    //   466: invokespecial 370	java/util/HashMap:<init>	()V
    //   469: astore_3
    //   470: aload_3
    //   471: ldc_w 372
    //   474: aload 5
    //   476: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   479: pop
    //   480: aload_3
    //   481: ldc_w 378
    //   484: aload 4
    //   486: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: pop
    //   490: ldc_w 380
    //   493: aload_3
    //   494: invokestatic 383	com/voxelbusters/nativeplugins/NativePluginHelper:sendMessage	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   497: return
    //   498: iconst_0
    //   499: istore_1
    //   500: goto -282 -> 218
    //   503: aload 4
    //   505: aload_0
    //   506: aload 10
    //   508: ldc 28
    //   510: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   513: aload_0
    //   514: aload 10
    //   516: ldc 31
    //   518: invokevirtual 387	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorInt	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   521: invokevirtual 391	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:addPhoneNumber	(Ljava/lang/String;I)V
    //   524: goto -271 -> 253
    //   527: astore 5
    //   529: aload_3
    //   530: astore 4
    //   532: aload 5
    //   534: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   537: aload_3
    //   538: astore 4
    //   540: ldc_w 342
    //   543: aload 5
    //   545: invokevirtual 395	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   548: invokestatic 191	com/voxelbusters/nativeplugins/utilities/Debug:error	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: ldc_w 397
    //   554: astore 6
    //   556: aconst_null
    //   557: astore 7
    //   559: aload 6
    //   561: astore 5
    //   563: aload 7
    //   565: astore 4
    //   567: aload_3
    //   568: ifnull -106 -> 462
    //   571: aload_3
    //   572: invokeinterface 319 1 0
    //   577: aload 6
    //   579: astore 5
    //   581: aload 7
    //   583: astore 4
    //   585: goto -123 -> 462
    //   588: aload_0
    //   589: aload 5
    //   591: ldc 28
    //   593: invokevirtual 310	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorString	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   596: astore 9
    //   598: aload 9
    //   600: ifnull -197 -> 403
    //   603: aload 4
    //   605: aload 9
    //   607: aload_0
    //   608: aload 5
    //   610: ldc 31
    //   612: invokevirtual 387	com/voxelbusters/nativeplugins/features/addressbook/AddressBookHandler:getCursorInt	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   615: invokevirtual 400	com/voxelbusters/nativeplugins/features/addressbook/ContactDetails:addEmail	(Ljava/lang/String;I)V
    //   618: goto -215 -> 403
    //   621: astore 5
    //   623: aload_3
    //   624: astore 4
    //   626: aload 5
    //   628: astore_3
    //   629: aload 4
    //   631: ifnull +10 -> 641
    //   634: aload 4
    //   636: invokeinterface 319 1 0
    //   641: aload_3
    //   642: athrow
    //   643: astore_3
    //   644: goto -15 -> 629
    //   647: astore 4
    //   649: aload 5
    //   651: astore_3
    //   652: aload 4
    //   654: astore 5
    //   656: goto -127 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	AddressBookHandler
    //   217	283	1	i	int
    //   86	17	2	bool	boolean
    //   4	638	3	localObject1	Object
    //   643	1	3	localObject2	Object
    //   651	1	3	localObject3	Object
    //   6	629	4	localObject4	Object
    //   647	6	4	localException1	Exception
    //   10	465	5	localObject5	Object
    //   527	17	5	localException2	Exception
    //   561	48	5	localObject6	Object
    //   621	29	5	localObject7	Object
    //   654	1	5	localException3	Exception
    //   1	577	6	localObject8	Object
    //   15	567	7	localContext	Context
    //   29	351	8	localContentResolver	ContentResolver
    //   171	435	9	str1	String
    //   152	363	10	localObject9	Object
    //   303	72	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   106	216	527	java/lang/Exception
    //   222	253	527	java/lang/Exception
    //   253	270	527	java/lang/Exception
    //   270	305	527	java/lang/Exception
    //   310	367	527	java/lang/Exception
    //   372	379	527	java/lang/Exception
    //   379	403	527	java/lang/Exception
    //   403	440	527	java/lang/Exception
    //   440	443	527	java/lang/Exception
    //   503	524	527	java/lang/Exception
    //   588	598	527	java/lang/Exception
    //   603	618	527	java/lang/Exception
    //   106	216	621	finally
    //   222	253	621	finally
    //   253	270	621	finally
    //   270	305	621	finally
    //   310	367	621	finally
    //   372	379	621	finally
    //   379	403	621	finally
    //   403	440	621	finally
    //   440	443	621	finally
    //   503	524	621	finally
    //   588	598	621	finally
    //   603	618	621	finally
    //   12	17	643	finally
    //   24	31	643	finally
    //   38	74	643	finally
    //   80	87	643	finally
    //   93	102	643	finally
    //   532	537	643	finally
    //   540	551	643	finally
    //   12	17	647	java/lang/Exception
    //   24	31	647	java/lang/Exception
    //   38	74	647	java/lang/Exception
    //   80	87	647	java/lang/Exception
    //   93	102	647	java/lang/Exception
  }
  
  public void addContact(String paramString)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        AddressBookHandler.this.addContactInternal(val$json);
      }
    }).start();
  }
  
  int getCursorInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndex(paramString));
  }
  
  String getCursorString(Cursor paramCursor, String paramString)
  {
    Object localObject = null;
    try
    {
      int i = paramCursor.getColumnIndex(paramString);
      paramString = (String)localObject;
      if (i != -1) {
        paramString = paramCursor.getString(i);
      }
      return paramString;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  public boolean isAuthorized()
  {
    return ApplicationUtility.hasPermission(NativePluginHelper.getCurrentContext(), "android.permission.READ_CONTACTS");
  }
  
  public void readContacts()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        AddressBookHandler.this.readContactsInBackground();
      }
    }).start();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.addressbook.AddressBookHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */