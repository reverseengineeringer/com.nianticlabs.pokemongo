package com.unity3d.player;

import android.os.Build.VERSION;

public final class q
{
  static final boolean a;
  static final boolean b;
  static final boolean c;
  static final boolean d;
  static final boolean e;
  static final boolean f;
  static final boolean g;
  static final boolean h;
  static final f i;
  static final e j;
  static final h k;
  static final g l;
  static final i m;
  
  static
  {
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      bool1 = true;
      a = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label214;
      }
      bool1 = true;
      label28:
      b = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label219;
      }
      bool1 = true;
      label42:
      c = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label224;
      }
      bool1 = true;
      label56:
      d = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        break label229;
      }
      bool1 = true;
      label70:
      e = bool1;
      if (Build.VERSION.SDK_INT < 19) {
        break label234;
      }
      bool1 = true;
      label84:
      f = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label239;
      }
      bool1 = true;
      label98:
      g = bool1;
      if (Build.VERSION.SDK_INT < 23) {
        break label244;
      }
      bool1 = bool2;
      label112:
      h = bool1;
      if (!a) {
        break label249;
      }
      localObject1 = new d();
      label130:
      i = (f)localObject1;
      if (!b) {
        break label254;
      }
      localObject1 = new c();
      label148:
      j = (e)localObject1;
      if (!d) {
        break label259;
      }
      localObject1 = new l();
      label166:
      k = (h)localObject1;
      if (!e) {
        break label264;
      }
    }
    label214:
    label219:
    label224:
    label229:
    label234:
    label239:
    label244:
    label249:
    label254:
    label259:
    label264:
    for (Object localObject1 = new k();; localObject1 = null)
    {
      l = (g)localObject1;
      localObject1 = localObject2;
      if (h) {
        localObject1 = new n();
      }
      m = (i)localObject1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
      bool1 = false;
      break label42;
      bool1 = false;
      break label56;
      bool1 = false;
      break label70;
      bool1 = false;
      break label84;
      bool1 = false;
      break label98;
      bool1 = false;
      break label112;
      localObject1 = null;
      break label130;
      localObject1 = null;
      break label148;
      localObject1 = null;
      break label166;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */