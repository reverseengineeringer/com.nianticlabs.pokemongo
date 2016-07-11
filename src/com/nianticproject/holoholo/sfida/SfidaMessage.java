package com.nianticproject.holoholo.sfida;

import java.util.UUID;

public class SfidaMessage
{
  public static final int ACTIVITY_BYTE_LENGTH = 3;
  public static final String SFIDA_RESPONSE_CERTIFICATION_CHALLENGE_1 = "4010";
  public static final String SFIDA_RESPONSE_CERTIFICATION_CHALLENGE_2 = "5000";
  public static final String SFIDA_RESPONSE_CERTIFICATION_COMPLETE = "4020";
  public static final String SFIDA_RESPONSE_CERTIFICATION_NOTIFY = "3000";
  private static final String TAG = SfidaMessage.class.getSimpleName();
  public static final UUID UUID_BATTERY_LEVEL_CHAR = UUID.fromString("00002A19-0000-1000-8000-00805f9b34fb");
  public static final UUID UUID_BATTERY_SERVICE;
  public static final UUID UUID_BUTTON_NOTIF_CHAR;
  public static final UUID UUID_CENTRAL_TO_SFIDA_CHAR;
  public static final UUID UUID_CERTIFICATE_SERVICE;
  public static final UUID UUID_DEVICE_CONTROL_SERVICE;
  public static final UUID UUID_FW_UPDATE_REQUEST_CHAR;
  public static final UUID UUID_FW_UPDATE_SERVICE = UUID.fromString("0000fef5-0000-1000-8000-00805f9b34fb");
  public static final UUID UUID_FW_VERSION_CHAR;
  public static final UUID UUID_LED_VIBRATE_CTRL_CHAR;
  public static final UUID UUID_SFIDA_COMMANDS_CHAR;
  public static final UUID UUID_SFIDA_TO_CENTRAL_CHAR;
  
  static
  {
    UUID_DEVICE_CONTROL_SERVICE = UUID.fromString("21c50462-67cb-63a3-5c4c-82b5b9939aeb");
    UUID_LED_VIBRATE_CTRL_CHAR = UUID.fromString("21c50462-67cb-63a3-5c4c-82b5b9939aec");
    UUID_BUTTON_NOTIF_CHAR = UUID.fromString("21c50462-67cb-63a3-5c4c-82b5b9939aed");
    UUID_FW_UPDATE_REQUEST_CHAR = UUID.fromString("21c50462-67cb-63a3-5c4c-82b5b9939aef");
    UUID_FW_VERSION_CHAR = UUID.fromString("21c50462-67cb-63a3-5c4c-82b5b9939af0");
    UUID_CERTIFICATE_SERVICE = UUID.fromString("bbe87709-5b89-4433-ab7f-8b8eef0d8e37");
    UUID_CENTRAL_TO_SFIDA_CHAR = UUID.fromString("bbe87709-5b89-4433-ab7f-8b8eef0d8e38");
    UUID_SFIDA_COMMANDS_CHAR = UUID.fromString("bbe87709-5b89-4433-ab7f-8b8eef0d8e39");
    UUID_SFIDA_TO_CENTRAL_CHAR = UUID.fromString("bbe87709-5b89-4433-ab7f-8b8eef0d8e3a");
    UUID_BATTERY_SERVICE = UUID.fromString("0000180F-0000-1000-8000-00805f9b34fb");
  }
  
  public static byte[] getBlinkRed()
  {
    return new byte[] { 0, 0, 0, 13, 1, 15, 112, 1, 0, 0, 1, 15, 112, 1, 0, 0, 1, 15, 112, 1, 0, 0, 1, 15, 112, 1, 0, 0, 1, 15, 112, 1, 0, 0, 1, 15, 112, 1, 0, 0, 1, 15, 112 };
  }
  
  public static byte[] getCancelPattern()
  {
    return new byte[] { 0, 0, 0, 0 };
  }
  
  public static byte[] getCaptureSucceed()
  {
    return new byte[] { 0, 0, 0, 24, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113, 3, 8, -16, 3, -16, -16, 2, 0, -1, 1, 0, -113 };
  }
  
  public static byte[] getDonePattern()
  {
    return new byte[] { 0, 0, 0, 4, 3, 0, 0, 2, 0, 112, 1, 0, 0, 2, 0, 112 };
  }
  
  public static byte[] getDowserCancel()
  {
    return new byte[] { 0, 0, 0, 1, 24, -1, -1 };
  }
  
  public static byte[] getDowserProximity1()
  {
    return new byte[] { 0, 0, 0, 5, 10, -1, -1, 2, 0, -128, 10, -1, -1, 2, 0, -128, 4, 0, -128 };
  }
  
  public static byte[] getDowserProximity2()
  {
    return new byte[] { 0, 0, 0, 10, 2, -1, -113, 1, -1, -1, 3, -1, -113, 1, -1, -1, 3, -1, -113, 1, -1, -1, 3, -1, -113, 1, -1, -1, 3, -1, -113, 4, 0, -128 };
  }
  
  public static byte[] getDowserProximity3()
  {
    return new byte[] { 0, 0, 0, 7, 2, -1, -113, 1, -1, -1, 3, -1, -113, 1, -1, -1, 3, -1, -113, 1, -1, -1, 4, -1, -113 };
  }
  
  public static byte[] getDowserProximity4()
  {
    return new byte[] { 0, 0, 0, 5, 2, -1, -113, 1, -1, -1, 3, 0, -128, 1, -1, -1, 4, 0, -128 };
  }
  
  public static byte[] getDowserProximity5()
  {
    return new byte[] { 0, 0, 0, 2, 1, -1, -1, 17, 0, -128 };
  }
  
  public static byte[] getDowserVisible()
  {
    return new byte[] { 0, 0, 0, 10, 6, -1, -1, 3, 0, -128, 6, -1, -1, 3, 0, -128, 6, -1, -1, 3, 0, -128, 6, -1, -1, 3, 0, -128, 6, -1, -1, 3, 0, -128 };
  }
  
  public static byte[] getError()
  {
    return new byte[] { 0, 0, 0, 1, 24, 15, -16 };
  }
  
  public static byte[] getIncorrectMorseGameEffect()
  {
    return new byte[] { 0, 2, 0, 3, 2, 8, -16, 4, 0, 0, 10, 8, -16 };
  }
  
  public static byte[] getManualPattern(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    byte[] arrayOfByte1 = new byte[3];
    arrayOfByte1[0] = ((byte)paramInt1);
    arrayOfByte1[1] = 0;
    arrayOfByte1[2] = Byte.MIN_VALUE;
    int i = (byte)paramInt7;
    arrayOfByte1[0] = ((byte)(arrayOfByte1[0] | paramInt1));
    arrayOfByte1[1] = ((byte)(arrayOfByte1[1] | paramInt3 << 4));
    arrayOfByte1[1] = ((byte)(arrayOfByte1[1] | paramInt2));
    arrayOfByte1[2] = ((byte)(arrayOfByte1[2] | paramInt4));
    arrayOfByte1[2] = ((byte)(arrayOfByte1[2] | paramInt5 << 4));
    byte[] arrayOfByte2 = new byte[(paramInt6 + 1) * 6 + 4];
    paramInt2 = 0 + 1;
    arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x0));
    paramInt1 = paramInt2 + 1;
    arrayOfByte2[paramInt2] = ((byte)(arrayOfByte2[paramInt2] | 0x0));
    paramInt2 = paramInt1 + 1;
    arrayOfByte2[paramInt1] = ((byte)(arrayOfByte2[paramInt1] | 0x0));
    paramInt1 = paramInt2 + 1;
    arrayOfByte2[paramInt2] = ((byte)(arrayOfByte2[paramInt2] | (byte)(paramInt6 + 1) * 2));
    paramInt2 = 0;
    while (paramInt2 < paramInt6 + 1)
    {
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        arrayOfByte2[paramInt1] = arrayOfByte1[paramInt3];
        paramInt3 += 1;
        paramInt1 += 1;
      }
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        arrayOfByte2[paramInt1] = new byte[] { i, 0, 0 }[paramInt3];
        paramInt3 += 1;
        paramInt1 += 1;
      }
      paramInt2 += 1;
    }
    return arrayOfByte2;
  }
  
  public static byte[] getMorseGame1()
  {
    return new byte[] { -56, -2, -2, 11, 6, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 6, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 2, 15, 112 };
  }
  
  public static byte[] getMorseGame2()
  {
    return new byte[] { -56, -2, -2, 13, 6, 15, 112, 7, 0, 0, 6, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 6, 15, 112, 7, 0, 0, 2, 15, 112, 7, 0, 0, 2, 15, 112 };
  }
  
  public static byte[] getNoPokeball()
  {
    return new byte[] { 0, 0, 0, 6, 2, 15, -16, 10, 0, -128, 2, 15, -16, 10, 0, -128, 2, 15, -16, 10, 0, -128 };
  }
  
  public static byte[] getNotify()
  {
    return new byte[] { -56, -2, -2, 1, 2, 8, -16 };
  }
  
  public static byte[] getPokeballNoShake()
  {
    return new byte[] { 0, 0, 0, 6, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128 };
  }
  
  public static byte[] getPokeballShakeOnce()
  {
    return new byte[] { 0, 0, 0, 8, 3, -1, -1, 25, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128 };
  }
  
  public static byte[] getPokeballShakeThree()
  {
    return new byte[] { 0, 0, 0, 12, 3, -1, -1, 25, 0, -128, 3, -1, -1, 24, 0, -128, 3, -1, -1, 24, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128 };
  }
  
  public static byte[] getPokeballShakeTwice()
  {
    return new byte[] { 0, 0, 0, 10, 3, -1, -1, 25, 0, -128, 3, -1, -1, 24, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128, 1, 15, -16, 2, 0, -128 };
  }
  
  public static byte[] getPokemonCaught()
  {
    return new byte[] { 0, 0, 0, 21, 3, -1, -1, 25, 0, -128, 3, -1, -1, 24, 0, -128, 3, -1, -1, 24, 0, -128, 3, 8, -16, 3, -16, -16, 3, 0, -113, 3, 8, -16, 3, -16, -16, 3, 0, -113, 3, 8, -16, 3, -16, -16, 3, 0, -113, 3, 8, -16, 3, -16, -16, 3, 0, -113, 3, 8, -16, 3, -16, -16, 3, 0, -113 };
  }
  
  public static byte[] getReachedPokestop()
  {
    return new byte[] { 0, 0, 0, 27, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 4, 0, -1, 2, 0, -128, 8, 0, -1, 10, 0, -128, 2, 0, -113, -1, 0, -113, -21, 0, -113 };
  }
  
  public static byte[] getReadyForThrowPokeball()
  {
    return new byte[] { 0, 0, 0, 18, 2, -16, -16, 11, -16, -128, 13, 0, -128, 2, -16, -16, 11, -16, -128, 13, 0, -128, 2, -16, -16, 11, -16, -128, 13, 0, -128, 2, -16, -16, 11, -16, -128, 13, 0, -128, 2, -16, -16, 11, -16, -128, 13, 0, -128, 2, -16, -128, -1, -16, -128, -43, -16, -128 };
  }
  
  private static byte[] getRewardItemActivity(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new byte[9];
      Object tmp11_10 = localObject;
      tmp11_10[0] = 2;
      Object tmp16_11 = tmp11_10;
      tmp16_11[1] = -16;
      Object tmp21_16 = tmp16_11;
      tmp21_16[2] = -128;
      Object tmp26_21 = tmp21_16;
      tmp26_21[3] = 2;
      Object tmp31_26 = tmp26_21;
      tmp31_26[4] = 15;
      Object tmp36_31 = tmp31_26;
      tmp36_31[5] = -16;
      Object tmp41_36 = tmp36_31;
      tmp41_36[6] = 2;
      Object tmp47_41 = tmp41_36;
      tmp47_41[7] = 0;
      Object tmp53_47 = tmp47_41;
      tmp53_47[8] = -113;
      tmp53_47;
    }
    byte[] arrayOfByte;
    int i;
    do
    {
      return (byte[])localObject;
      if (paramInt == 2) {
        return new byte[] { 2, -16, -16, 1, -16, -128, 2, 15, -16, 1, 15, -128, 3, 0, -113 };
      }
      if (paramInt < 3) {
        break;
      }
      arrayOfByte = new byte[paramInt * 6];
      i = 0;
      localObject = arrayOfByte;
    } while (i >= paramInt);
    if (i % 3 == 0)
    {
      localObject = new byte[6];
      Object tmp189_188 = localObject;
      tmp189_188[0] = 2;
      Object tmp194_189 = tmp189_188;
      tmp194_189[1] = 0;
      Object tmp199_194 = tmp194_189;
      tmp199_194[2] = -8;
      Object tmp204_199 = tmp199_194;
      tmp204_199[3] = 2;
      Object tmp209_204 = tmp204_199;
      tmp209_204[4] = 0;
      Object tmp214_209 = tmp209_204;
      tmp214_209[5] = -113;
      tmp214_209;
    }
    for (;;)
    {
      System.arraycopy(localObject, 0, arrayOfByte, 6 * i, 6);
      i += 1;
      break;
      if (i % 3 == 1)
      {
        localObject = new byte[6];
        Object tmp252_251 = localObject;
        tmp252_251[0] = 2;
        Object tmp257_252 = tmp252_251;
        tmp257_252[1] = -128;
        Object tmp262_257 = tmp257_252;
        tmp262_257[2] = -16;
        Object tmp267_262 = tmp262_257;
        tmp267_262[3] = 2;
        Object tmp272_267 = tmp267_262;
        tmp272_267[4] = -16;
        Object tmp277_272 = tmp272_267;
        tmp277_272[5] = -128;
        tmp277_272;
      }
      else
      {
        localObject = new byte[6];
        Object tmp292_291 = localObject;
        tmp292_291[0] = 2;
        Object tmp297_292 = tmp292_291;
        tmp297_292[1] = 8;
        Object tmp302_297 = tmp297_292;
        tmp302_297[2] = -16;
        Object tmp307_302 = tmp302_297;
        tmp307_302[3] = 2;
        Object tmp312_307 = tmp307_302;
        tmp312_307[4] = 15;
        Object tmp317_312 = tmp312_307;
        tmp317_312[5] = -128;
        tmp317_312;
      }
    }
    throw new IllegalArgumentException();
  }
  
  public static byte[] getRewardItems(int paramInt)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] tmp5_4 = arrayOfByte1;
    tmp5_4[0] = 0;
    byte[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 0;
    byte[] tmp15_10 = tmp10_5;
    tmp15_10[2] = 0;
    tmp15_10;
    byte[] arrayOfByte2 = getRewardItemActivity(paramInt);
    byte[] arrayOfByte3 = new byte[1];
    arrayOfByte3[0] = ((byte)(arrayOfByte2.length / 3));
    byte[] arrayOfByte4 = new byte[arrayOfByte1.length + 1 + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte4, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte4, arrayOfByte1.length, arrayOfByte3.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte4, arrayOfByte1.length + arrayOfByte3.length, arrayOfByte2.length);
    return arrayOfByte4;
  }
  
  public static byte[] getSecurityResponseForDebug()
  {
    return SfidaUtils.hexStringToByteArray("0400000000000000000000000000000000000000");
  }
  
  public static byte[] getSecurityResponseForDebug2()
  {
    return SfidaUtils.hexStringToByteArray("050000000000000000000000000000000000000000000000000000000000000000000000");
  }
  
  public static byte[] getSecurityResponseForDebug3()
  {
    return SfidaUtils.hexStringToByteArray("0300000001");
  }
  
  public static byte[] getSpawnedLegendaryPokemon()
  {
    return new byte[] { 0, 0, 0, 30, 16, 15, -1, 8, 0, -128, 16, 15, -1, 8, 0, -128, 16, 15, -1, 6, 0, -128, 16, 15, -1, 3, 0, -128, 16, 15, -1, 2, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128, 16, 15, -1, 1, 0, -128 };
  }
  
  public static byte[] getSpawnedPokemon()
  {
    return new byte[] { 0, 0, 0, 15, 16, -16, -16, 8, 0, 0, 16, -16, -16, 8, 0, 0, 16, -16, -16, 8, 0, 0, 16, -16, -16, 8, 0, 0, 16, -16, -16, 8, 0, 0, 16, -16, -16, 8, 0, 0, 16, -16, -128, -1, -16, -128, -81, -16, -128 };
  }
  
  public static byte[] getSpawnedUncaughtPokemon()
  {
    return new byte[] { 0, 0, 0, 15, 14, -1, -16, 2, 0, 0, 14, -1, -16, 2, 0, 0, 14, -1, -16, 2, 0, 0, 14, -1, -16, 2, 0, 0, 14, -1, -16, 2, 0, 0, 14, -1, -16, 2, 0, 0, 64, -1, -128, -1, -1, -128, -81, -1, -128 };
  }
  
  public static byte[] getThrewPokeball()
  {
    return new byte[] { 0, 0, 0, 2, 20, 0, -16, 4, 0, -128 };
  }
  
  public static byte[] getUpdateRequest()
  {
    return new byte[] { 1 };
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.SfidaMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */