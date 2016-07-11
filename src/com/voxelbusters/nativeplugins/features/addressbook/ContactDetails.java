package com.voxelbusters.nativeplugins.features.addressbook;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetails
{
  String displayName = "";
  ArrayList<String> emailList = new ArrayList();
  String familyName = "";
  String givenName = "";
  ArrayList<String> phoneList = new ArrayList();
  String profilePicturePath = "";
  
  public void addEmail(String paramString, int paramInt)
  {
    emailList.add(paramString);
  }
  
  public void addPhoneNumber(String paramString, int paramInt)
  {
    phoneList.add(paramString);
  }
  
  HashMap<String, Object> getHash()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("display-name", displayName);
    localHashMap.put("family-name", familyName);
    localHashMap.put("given-name", givenName);
    localHashMap.put("image-path", profilePicturePath);
    localHashMap.put("phone-number-list", phoneList);
    localHashMap.put("email-list", emailList);
    return localHashMap;
  }
  
  public void setNames(String paramString1, String paramString2, String paramString3)
  {
    displayName = paramString1;
    familyName = paramString2;
    givenName = paramString3;
  }
  
  public void setPicturePath(String paramString)
  {
    profilePicturePath = paramString;
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.addressbook.ContactDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */