package com.google.vr.cardboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class UiLayer
{
  private static final int ALIGNMENT_MARKER_LINE_COLOR = -13487566;
  private static final int ALIGNMENT_MARKER_LINE_WIDTH = 4;
  private static final int ICON_WIDTH_DP = 28;
  private static final String TAG = UiLayer.class.getSimpleName();
  private static final float TOUCH_SLOP_FACTOR = 1.5F;
  private View alignmentMarker;
  private ImageView backButton;
  private volatile Runnable backButtonRunnable = null;
  private final Drawable backIconDrawable;
  private final Context context;
  private volatile boolean isAlignmentMarkerEnabled = false;
  private volatile boolean isSettingsButtonEnabled = true;
  private final DisplayMetrics metrics;
  private final RelativeLayout rootLayout;
  private ImageView settingsButton;
  private final Drawable settingsIconDrawable;
  
  public UiLayer(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      throw new RuntimeException("Context is not an instance of activity: Aborting.");
    }
    context = paramContext;
    settingsIconDrawable = decodeBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAQAAAD/5HvMAAADEklEQVRoBe3BXWjVZQDH8d/0HKW00OZ0kh6XiKUiIl0okhARdBcEjUQSmViYkF14K+TCnTNDEd9ShMGgFGZC9HaZqElo0aZDkhAkt2b5np7j8e3P+XazwWE8/+floA9enM9Hqqure0oxn0HSDPCyYqMDm82KjcPYHFRs9GHzq2KjiM1NxUUzLo2KieW4LFVMrMFllWIij0u7Hi/GcIRr7GexRmE8H/E3LgOsY7xG4VUOcJVDNCgUaxnxG2uZoGGsYABfl3hPw5jIh/zOiNUKw/NcodptvmARzfxIqO+ZymL2c4dql5moEGzDpEwtypgU5I+5PORJu89s+eIHYvhGfniLWN6QGxn+IJZ+xsqFT4hpveyYwi1ius5k2bCPUBV66SJPni76qBBql9LxIgkhinQwU1XIUaBEiEc0KQ1TKePvKDNkQI7j+CsxSelYxhB+DpFRCrL04GeQJbJjGsdwO0pGFmQ5gdtPNMmNDNuwKzJDDuQoYdfJWPniXYqk65AHOkl3m3cUhnmcx6zCTHlgFhXMzjFX4ViJWa88cRazVtWCjZh1yRPdmG1QLfgMs7w8UcBsk2pBO2Z5eaKA2SbVgo2YdckT3ZhtUC1YiVmfPNGPWavCsYA/MauQkwdaqGB2nnkKwwpKpCvIA1tJV6RVvsiyE7sSOTnQQhm77WTkxnR+xu04WVkwjpO4HWOa7FjOP/jpIasUjONr/AyxTOlo4h7+TpCTAS2cxN9dJisN00kIUaKTWapCC1spE+IhU5SOPYSqcJZuChTopp8KoXbIhhe4QUzXmCQ7PiamdXIhwzliOcMYufEmsbwuP3xLDEfkizk84Em7x0vyx+eYlKhFEZMOheA5/qXaLXaygCa+I9RhGlnIbv6j2hATFIY1jPiF1TyjYbRyEV8XeFvDeJY2TjFilULRwEEG2c1CjUKWDxjA5S/ayGgUFrGXy3xJgx4v8ri0KybacHlfMfEaLksUE824NCou7mBzU7HRi81pxUYPNl8pNrZg86li4xUukpCQkJCQkJCQkJDwiAvMUV1d3VPqfz17MXquI1uXAAAAAElFTkSuQmCC");
    backIconDrawable = decodeBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAQAAABIkb+zAAAArklEQVR42u3VyRHCMBBFwQkAcoQ8WJQbEJewby4XRxkzQ3cE/1VpiQAAANhEb73lnj9ruednTVjMz5iwmp8t4cP82Tn3/Ec/mG+++eabb7755ptvvvnmm2+++eYPmv8FyecPCdhz/oCAfecLKHCEClziAs9ogY9MggQJ/5DwlCBBQp2EowQJEmokvCRIkCDhZxJOEZkTLpHLKuEa+SwSMs5fJNwirynhHgAAAJt4A/ZvpX5veSF2AAAAAElFTkSuQmCC");
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    metrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17) {
      localDisplay.getRealMetrics(metrics);
    }
    for (;;)
    {
      rootLayout = new RelativeLayout(paramContext);
      initializeViews();
      return;
      localDisplay.getMetrics(metrics);
    }
  }
  
  private ImageView createButton(Drawable paramDrawable, boolean paramBoolean, int... paramVarArgs)
  {
    int j = (int)(28.0F * metrics.density);
    int i = (int)(j * 1.5F);
    j = (i - j) / 2;
    ImageView localImageView = new ImageView(context);
    localImageView.setPadding(j, j, j, j);
    localImageView.setImageDrawable(paramDrawable);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramDrawable = new RelativeLayout.LayoutParams(i, i);
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      paramDrawable.addRule(paramVarArgs[i]);
      i += 1;
    }
    localImageView.setLayoutParams(paramDrawable);
    if (paramBoolean) {}
    for (i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return localImageView;
    }
  }
  
  private Drawable decodeBitmapFromString(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
    return new BitmapDrawable(context.getResources(), paramString);
  }
  
  private void initializeViews()
  {
    int i = 0;
    int j = (int)((int)(28.0F * metrics.density) * 1.5F);
    settingsButton = createButton(settingsIconDrawable, isSettingsButtonEnabled, new int[] { 12, 13 });
    settingsButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UiUtils.launchOrInstallCardboard(paramAnonymousView.getContext());
      }
    });
    rootLayout.addView(settingsButton);
    backButton = createButton(backIconDrawable, getBackButtonEnabled(), new int[] { 10, 9 });
    backButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = backButtonRunnable;
        if (paramAnonymousView != null) {
          paramAnonymousView.run();
        }
      }
    });
    rootLayout.addView(backButton);
    alignmentMarker = new View(context);
    alignmentMarker.setBackground(new ColorDrawable(-13487566));
    Object localObject = new RelativeLayout.LayoutParams((int)(4.0F * metrics.density), -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, j, 0, j);
    alignmentMarker.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = alignmentMarker;
    if (isAlignmentMarkerEnabled) {}
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      rootLayout.addView(alignmentMarker);
      return;
      i = 8;
    }
  }
  
  public void attachUiLayer(final ViewGroup paramViewGroup)
  {
    ((Activity)context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramViewGroup == null)
        {
          ((Activity)context).addContentView(rootLayout, new RelativeLayout.LayoutParams(-1, -1));
          return;
        }
        paramViewGroup.addView(rootLayout);
      }
    });
  }
  
  public boolean getAlignmentMarkerEnabled()
  {
    return isAlignmentMarkerEnabled;
  }
  
  public boolean getBackButtonEnabled()
  {
    return backButtonRunnable != null;
  }
  
  public boolean getSettingsButtonEnabled()
  {
    return isSettingsButtonEnabled;
  }
  
  public void setAlignmentMarkerEnabled(final boolean paramBoolean)
  {
    isAlignmentMarkerEnabled = paramBoolean;
    ((Activity)context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        View localView = alignmentMarker;
        if (paramBoolean) {}
        for (int i = 0;; i = 4)
        {
          localView.setVisibility(i);
          return;
        }
      }
    });
  }
  
  public void setBackButtonListener(final Runnable paramRunnable)
  {
    backButtonRunnable = paramRunnable;
    ((Activity)context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        ImageView localImageView = backButton;
        if (paramRunnable == null) {}
        for (int i = 4;; i = 0)
        {
          localImageView.setVisibility(i);
          return;
        }
      }
    });
  }
  
  public void setEnabled(final boolean paramBoolean)
  {
    ((Activity)context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        RelativeLayout localRelativeLayout = rootLayout;
        if (paramBoolean) {}
        for (int i = 0;; i = 4)
        {
          localRelativeLayout.setVisibility(i);
          return;
        }
      }
    });
  }
  
  public void setSettingsButtonEnabled(final boolean paramBoolean)
  {
    isSettingsButtonEnabled = paramBoolean;
    ((Activity)context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        ImageView localImageView = settingsButton;
        if (paramBoolean) {}
        for (int i = 0;; i = 4)
        {
          localImageView.setVisibility(i);
          return;
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiLayer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */