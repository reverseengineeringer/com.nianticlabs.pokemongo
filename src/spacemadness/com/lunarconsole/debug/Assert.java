package spacemadness.com.lunarconsole.debug;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import spacemadness.com.lunarconsole.utils.ObjectUtils;
import spacemadness.com.lunarconsole.utils.StringUtils;

public class Assert
{
  private static boolean IsEnabled = true;
  
  public static void AreEqual(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Byte.valueOf(paramByte1)), toString(Byte.valueOf(paramByte2)) });
    }
  }
  
  public static void AreEqual(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 != paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Character.valueOf(paramChar1)), toString(Character.valueOf(paramChar2)) });
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 != paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Double.valueOf(paramDouble1)), toString(Double.valueOf(paramDouble2)) });
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 != paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Float.valueOf(paramFloat1)), toString(Float.valueOf(paramFloat2)) });
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 != paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Integer.valueOf(paramInt1)), toString(Integer.valueOf(paramInt2)) });
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 != paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Long.valueOf(paramLong1)), toString(Long.valueOf(paramLong2)) });
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 != paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(paramObject1), toString(paramObject2) });
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2, String paramString)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper(paramString, new Object[] { paramObject3 });
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4 });
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4, paramObject5 });
    }
  }
  
  public static void AreEqual(Object paramObject1, Object paramObject2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))) && ((paramObject1 != null) || (paramObject2 != null))) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { toString(Short.valueOf(paramShort1)), toString(Short.valueOf(paramShort2)) });
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 != paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper("Assertion failed: expected '%s' but was '%s'", new Object[] { Boolean.toString(paramBoolean1), Boolean.toString(paramBoolean2) });
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramBoolean1 != paramBoolean2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Byte.valueOf(paramByte1)) });
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 == paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Character.valueOf(paramChar1)) });
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 == paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Double.valueOf(paramDouble1)) });
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 == paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Float.valueOf(paramFloat1)) });
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 == paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Integer.valueOf(paramInt1)) });
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 == paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Long.valueOf(paramLong1)) });
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 == paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper("Assertion failed: Objects are equal '%s'", new Object[] { toString(paramObject1) });
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2, String paramString)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper(paramString, new Object[] { paramObject3 });
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4 });
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4, paramObject5 });
    }
  }
  
  public static void AreNotEqual(Object paramObject1, Object paramObject2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null)))) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Short.valueOf(paramShort1)) });
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 == paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper("Assertion failed: values are equal '%s'", new Object[] { toString(Boolean.valueOf(paramBoolean1)) });
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void AreNotEqual(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramBoolean1 == paramBoolean2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper("Assertion failed: Object references are the same '%s'", new Object[] { toString(paramObject1) });
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2, String paramString)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3 });
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4 });
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4, paramObject5 });
    }
  }
  
  public static void AreNotSame(Object paramObject1, Object paramObject2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramObject1 == paramObject2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper("Assertion failed: Object references are not the same '%s' but was '%s'", new Object[] { toString(paramObject1), toString(paramObject2) });
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2, String paramString)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3 });
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4 });
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2, String paramString, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper(paramString, new Object[] { paramObject3, paramObject4, paramObject5 });
    }
  }
  
  public static void AreSame(Object paramObject1, Object paramObject2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramObject1 != paramObject2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  private static void AssertHelper(String paramString, Object... paramVarArgs)
  {
    throw new AssertionError(StringUtils.TryFormat(paramString, paramVarArgs));
  }
  
  public static <T> void Contains(T paramT, Collection<T> paramCollection)
  {
    if ((IsEnabled) && ((paramCollection == null) || (!paramCollection.contains(paramT))))
    {
      if (paramCollection == null) {
        AssertHelper("Assertion failed: collection is null", new Object[0]);
      }
    }
    else {
      return;
    }
    AssertHelper("Assertion failed: collection doesn't contain the item %s", new Object[] { paramT });
  }
  
  public static void Fail()
  {
    if (IsEnabled) {
      AssertHelper("Assertion failed", new Object[0]);
    }
  }
  
  public static void Fail(String paramString)
  {
    if (IsEnabled) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Fail(String paramString, Object paramObject)
  {
    if (IsEnabled) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Fail(String paramString, Object paramObject1, Object paramObject2)
  {
    if (IsEnabled) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Fail(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (IsEnabled) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Fail(String paramString, Object... paramVarArgs)
  {
    if (IsEnabled) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Byte.valueOf(paramByte1), Byte.valueOf(paramByte2) });
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 <= paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) });
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 <= paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 <= paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 <= paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 <= paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 <= paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper("Assertion failed: '%s' > '%s'", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) });
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Greater(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 <= paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Byte.valueOf(paramByte1), Byte.valueOf(paramByte2) });
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 < paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) });
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 < paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 < paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 < paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 < paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 < paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper("Assertion failed: '%s' >= '%s'", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) });
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void GreaterOrEqual(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 < paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsEmpty(String paramString)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString))) {
      AssertHelper("Assertion failed: String is not empty '%s'", new Object[] { paramString });
    }
  }
  
  public static void IsEmpty(String paramString1, String paramString2)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[0]);
    }
  }
  
  public static void IsEmpty(String paramString1, String paramString2, Object paramObject)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject });
    }
  }
  
  public static void IsEmpty(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsEmpty(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsEmpty(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((IsEnabled) && (!StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, paramVarArgs);
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper("Assertion failed: collection is null or not empty '%s'", new Object[] { paramCollection });
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection, String paramString)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsEmpty(Collection<?> paramCollection, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() == 0)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsFalse(boolean paramBoolean)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper("Assertion failed: 'false' expected", new Object[0]);
    }
  }
  
  public static void IsFalse(boolean paramBoolean, String paramString)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsFalse(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void IsFalse(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsFalse(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsFalse(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramBoolean)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject)))) {
      if (paramObject == null) {
        break label45;
      }
    }
    label45:
    for (paramObject = paramObject.getClass();; paramObject = null)
    {
      AssertHelper("Assertion failed: expected type of '%s' but was '%s'", new Object[] { paramClass, paramObject });
      return;
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject, String paramString)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject)))) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject1)))) {
      AssertHelper(paramString, new Object[] { paramObject2 });
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject1)))) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3 });
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject1)))) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3, paramObject4 });
    }
  }
  
  public static void IsInstanceOfType(Class<?> paramClass, Object paramObject, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && ((paramClass == null) || (!paramClass.isInstance(paramObject)))) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsNotEmpty(String paramString)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString))) {
      AssertHelper("Assertion failed: String is null or empty '%s'", new Object[] { paramString });
    }
  }
  
  public static void IsNotEmpty(String paramString1, String paramString2)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[0]);
    }
  }
  
  public static void IsNotEmpty(String paramString1, String paramString2, Object paramObject)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject });
    }
  }
  
  public static void IsNotEmpty(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsNotEmpty(String paramString1, String paramString2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsNotEmpty(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((IsEnabled) && (StringUtils.IsNullOrEmpty(paramString1))) {
      AssertHelper(paramString2, paramVarArgs);
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper("Assertion failed: collection is null or empty '%s'", new Object[] { paramCollection });
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection, String paramString)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsNotEmpty(Collection<?> paramCollection, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.size() != 0)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject))) {
      if (paramObject == null) {
        break label45;
      }
    }
    label45:
    for (paramObject = paramObject.getClass();; paramObject = null)
    {
      AssertHelper("Assertion failed: Object '%s' is subtype of '%s'", new Object[] { paramClass, paramObject });
      return;
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject, String paramString)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject))) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject1))) {
      AssertHelper(paramString, new Object[] { paramObject2 });
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject1))) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3 });
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject1))) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3, paramObject4 });
    }
  }
  
  public static void IsNotInstanceOfType(Class<?> paramClass, Object paramObject, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramClass != null) && (paramClass.isInstance(paramObject))) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsNotNull(Object paramObject)
  {
    if ((IsEnabled) && (paramObject == null)) {
      AssertHelper("Assertion failed: Object is 'null'", new Object[0]);
    }
  }
  
  public static void IsNotNull(Object paramObject, String paramString)
  {
    if ((IsEnabled) && (paramObject == null)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsNotNull(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((IsEnabled) && (paramObject1 == null)) {
      AssertHelper(paramString, new Object[] { paramObject2 });
    }
  }
  
  public static void IsNotNull(Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramObject1 == null)) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3 });
    }
  }
  
  public static void IsNotNull(Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (paramObject1 == null)) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3, paramObject4 });
    }
  }
  
  public static void IsNotNull(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramObject == null)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsNotNullElement(List<?> paramList)
  {
    if (IsEnabled)
    {
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IsNotNull(paramList.next(), "Element at %s is null", toString(Integer.valueOf(i)));
        i += 1;
      }
    }
  }
  
  public static void IsNull(Object paramObject)
  {
    if ((IsEnabled) && (paramObject != null)) {
      AssertHelper("Assertion failed: expected 'null' but was '%s'", new Object[] { paramObject });
    }
  }
  
  public static void IsNull(Object paramObject, String paramString)
  {
    if ((IsEnabled) && (paramObject != null)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsNull(Object paramObject1, String paramString, Object paramObject2)
  {
    if ((IsEnabled) && (paramObject1 != null)) {
      AssertHelper(paramString, new Object[] { paramObject2 });
    }
  }
  
  public static void IsNull(Object paramObject1, String paramString, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramObject1 != null)) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3 });
    }
  }
  
  public static void IsNull(Object paramObject1, String paramString, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if ((IsEnabled) && (paramObject1 != null)) {
      AssertHelper(paramString, new Object[] { paramObject2, paramObject3, paramObject4 });
    }
  }
  
  public static void IsNull(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramObject != null)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void IsTrue(boolean paramBoolean)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper("Assertion failed: 'true' expected", new Object[0]);
    }
  }
  
  public static void IsTrue(boolean paramBoolean, String paramString)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void IsTrue(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void IsTrue(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void IsTrue(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void IsTrue(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (!paramBoolean)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Byte.valueOf(paramByte1), Byte.valueOf(paramByte2) });
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 >= paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) });
    }
  }
  
  public static void Less(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 >= paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 >= paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 >= paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public static void Less(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 >= paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public static void Less(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 >= paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void Less(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper("Assertion failed: '%s' < '%s'", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) });
    }
  }
  
  public static void Less(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void Less(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void Less(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void Less(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void Less(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 >= paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Byte.valueOf(paramByte1), Byte.valueOf(paramByte2) });
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2, String paramString)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(byte paramByte1, byte paramByte2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramByte1 > paramByte2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) });
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2, String paramString)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(char paramChar1, char paramChar2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramChar1 > paramChar2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(double paramDouble1, double paramDouble2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramDouble1 > paramDouble2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2, String paramString)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(float paramFloat1, float paramFloat2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramFloat1 > paramFloat2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2, String paramString)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramInt1 > paramInt2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2, String paramString)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(long paramLong1, long paramLong2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramLong1 > paramLong2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper("Assertion failed: '%s' <= '%s'", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) });
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2, String paramString)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper(paramString, new Object[0]);
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject });
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2 });
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper(paramString, new Object[] { paramObject1, paramObject2, paramObject3 });
    }
  }
  
  public static void LessOrEqual(short paramShort1, short paramShort2, String paramString, Object... paramVarArgs)
  {
    if ((IsEnabled) && (paramShort1 > paramShort2)) {
      AssertHelper(paramString, paramVarArgs);
    }
  }
  
  public static <T> void NotContains(T paramT, Collection<T> paramCollection)
  {
    if ((IsEnabled) && (paramCollection != null) && (paramCollection.contains(paramT)))
    {
      if (paramCollection == null) {
        AssertHelper("Assertion failed: collection is null", new Object[0]);
      }
    }
    else {
      return;
    }
    AssertHelper("Assertion failed: collection contains the item %s", new Object[] { paramT });
  }
  
  private static String toString(Object paramObject)
  {
    return ObjectUtils.toString(paramObject);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.debug.Assert
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */