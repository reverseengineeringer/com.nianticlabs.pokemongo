package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzgr
public final class zzq
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final Context context;
  boolean zzpt = false;
  zzmi<String, zzcz> zzqA;
  NativeAdOptionsParcel zzqB;
  zzck zzqC;
  List<String> zzqD;
  zzk zzqE;
  public zzhx zzqF = null;
  View zzqG = null;
  public int zzqH = 0;
  boolean zzqI = false;
  private HashSet<zzht> zzqJ = null;
  private int zzqK = -1;
  private int zzqL = -1;
  private zzik zzqM;
  private boolean zzqN = true;
  private boolean zzqO = true;
  private boolean zzqP = false;
  final String zzqg;
  public String zzqh;
  final zzan zzqi;
  public final VersionInfoParcel zzqj;
  zza zzqk;
  public zzhz zzql;
  public zzgh zzqm;
  public AdSizeParcel zzqn;
  public zzhs zzqo;
  public zzhs.zza zzqp;
  public zzht zzqq;
  zzn zzqr;
  zzo zzqs;
  zzu zzqt;
  zzv zzqu;
  zzfs zzqv;
  zzfw zzqw;
  zzcw zzqx;
  zzcx zzqy;
  zzmi<String, zzcy> zzqz;
  
  public zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel, null);
  }
  
  zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel, zzan paramzzan)
  {
    zzby.initialize(paramContext);
    if (zzp.zzby().zzgo() != null)
    {
      List localList = zzby.zzdf();
      if (zzJv != 0) {
        localList.add(Integer.toString(zzJv));
      }
      zzp.zzby().zzgo().zzb(localList);
    }
    zzqg = UUID.randomUUID().toString();
    if ((zztf) || (zzth))
    {
      zzqk = null;
      zzqn = paramAdSizeParcel;
      zzqh = paramString;
      context = paramContext;
      zzqj = paramVersionInfoParcel;
      if (paramzzan == null) {
        break label246;
      }
    }
    for (;;)
    {
      zzqi = paramzzan;
      zzqM = new zzik(200L);
      zzqA = new zzmi();
      return;
      zzqk = new zza(paramContext, this, this);
      zzqk.setMinimumWidth(widthPixels);
      zzqk.setMinimumHeight(heightPixels);
      zzqk.setVisibility(4);
      break;
      label246:
      paramzzan = new zzan(new zzh(this));
    }
  }
  
  private void zzbQ()
  {
    View localView = zzqk.getRootView().findViewById(16908290);
    if (localView == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      return;
      localRect1 = new Rect();
      localRect2 = new Rect();
      zzqk.getGlobalVisibleRect(localRect1);
      localView.getGlobalVisibleRect(localRect2);
      if (top != top) {
        zzqN = false;
      }
    } while (bottom == bottom);
    zzqO = false;
  }
  
  private void zze(boolean paramBoolean)
  {
    boolean bool = true;
    if ((zzqk == null) || (zzqo == null) || (zzqo.zzBD == null)) {}
    while ((paramBoolean) && (!zzqM.tryAcquire())) {
      return;
    }
    Object localObject;
    int i;
    int j;
    if (zzqo.zzBD.zzhe().zzbY())
    {
      localObject = new int[2];
      zzqk.getLocationOnScreen((int[])localObject);
      i = zzl.zzcF().zzc(context, localObject[0]);
      j = zzl.zzcF().zzc(context, localObject[1]);
      if ((i != zzqK) || (j != zzqL))
      {
        zzqK = i;
        zzqL = j;
        localObject = zzqo.zzBD.zzhe();
        i = zzqK;
        j = zzqL;
        if (paramBoolean) {
          break label174;
        }
      }
    }
    label174:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((zzja)localObject).zza(i, j, paramBoolean);
      zzbQ();
      return;
    }
  }
  
  public void destroy()
  {
    zzbP();
    zzqs = null;
    zzqt = null;
    zzqw = null;
    zzqv = null;
    zzqC = null;
    zzqu = null;
    zzf(false);
    if (zzqk != null) {
      zzqk.removeAllViews();
    }
    zzbK();
    zzbM();
    zzqo = null;
  }
  
  public void onGlobalLayout()
  {
    zze(false);
  }
  
  public void onScrollChanged()
  {
    zze(true);
    zzqP = true;
  }
  
  public void zza(HashSet<zzht> paramHashSet)
  {
    zzqJ = paramHashSet;
  }
  
  public HashSet<zzht> zzbJ()
  {
    return zzqJ;
  }
  
  public void zzbK()
  {
    if ((zzqo != null) && (zzqo.zzBD != null)) {
      zzqo.zzBD.destroy();
    }
  }
  
  public void zzbL()
  {
    if ((zzqo != null) && (zzqo.zzBD != null)) {
      zzqo.zzBD.stopLoading();
    }
  }
  
  public void zzbM()
  {
    if ((zzqo != null) && (zzqo.zzzv != null)) {}
    try
    {
      zzqo.zzzv.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Could not destroy mediation adapter.");
    }
  }
  
  public boolean zzbN()
  {
    return zzqH == 0;
  }
  
  public boolean zzbO()
  {
    return zzqH == 1;
  }
  
  public void zzbP()
  {
    if (zzqk != null) {
      zzqk.zzbP();
    }
  }
  
  public String zzbR()
  {
    if ((zzqN) && (zzqO)) {
      return "";
    }
    if (zzqN)
    {
      if (zzqP) {
        return "top-scrollable";
      }
      return "top-locked";
    }
    if (zzqO)
    {
      if (zzqP) {
        return "bottom-scrollable";
      }
      return "bottom-locked";
    }
    return "";
  }
  
  public void zzbS()
  {
    zzqq.zzl(zzqo.zzHz);
    zzqq.zzm(zzqo.zzHA);
    zzqq.zzy(zzqn.zztf);
    zzqq.zzz(zzqo.zzEK);
  }
  
  public void zzf(boolean paramBoolean)
  {
    if (zzqH == 0) {
      zzbL();
    }
    if (zzql != null) {
      zzql.cancel();
    }
    if (zzqm != null) {
      zzqm.cancel();
    }
    if (paramBoolean) {
      zzqo = null;
    }
  }
  
  public static class zza
    extends ViewSwitcher
  {
    private final zzif zzqQ;
    private final zzim zzqR;
    
    public zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
    {
      super();
      zzqQ = new zzif(paramContext);
      if ((paramContext instanceof Activity))
      {
        zzqR = new zzim((Activity)paramContext, paramOnGlobalLayoutListener, paramOnScrollChangedListener);
        zzqR.zzgO();
        return;
      }
      zzqR = null;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (zzqR != null) {
        zzqR.onAttachedToWindow();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (zzqR != null) {
        zzqR.onDetachedFromWindow();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      zzqQ.zze(paramMotionEvent);
      return false;
    }
    
    public void removeAllViews()
    {
      Object localObject = new ArrayList();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && ((localView instanceof zziz))) {
          ((List)localObject).add((zziz)localView);
        }
        i += 1;
      }
      super.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zziz)((Iterator)localObject).next()).destroy();
      }
    }
    
    public void zzbP()
    {
      zzb.v("Disable position monitoring on adFrame.");
      if (zzqR != null) {
        zzqR.zzgP();
      }
    }
    
    public zzif zzbT()
    {
      return zzqQ;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */