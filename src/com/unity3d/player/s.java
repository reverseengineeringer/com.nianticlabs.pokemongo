package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public final class s
  extends Dialog
  implements TextWatcher, View.OnClickListener
{
  private static int c = 1627389952;
  private static int d = -1;
  private Context a = null;
  private UnityPlayer b = null;
  
  public s(Context paramContext, UnityPlayer paramUnityPlayer, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    super(paramContext);
    a = paramContext;
    b = paramUnityPlayer;
    getWindow().setGravity(80);
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    setContentView(createSoftInputView());
    getWindow().setLayout(-1, -2);
    getWindow().clearFlags(2);
    paramContext = (EditText)findViewById(1057292289);
    paramUnityPlayer = (Button)findViewById(1057292290);
    a(paramContext, paramString1, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramString2);
    paramUnityPlayer.setOnClickListener(this);
    paramContext.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          getWindow().setSoftInputMode(5);
        }
      }
    });
  }
  
  private static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    int i;
    if (paramBoolean1)
    {
      i = 32768;
      if (!paramBoolean2) {
        break label57;
      }
    }
    label57:
    for (int j = 131072;; j = 0)
    {
      if (paramBoolean3) {
        k = 128;
      }
      i = k | j | i;
      if ((paramInt >= 0) && (paramInt <= 7)) {
        break label63;
      }
      return i;
      i = 0;
      break;
    }
    label63:
    return i | new int[] { 1, 16385, 12290, 17, 2, 3, 97, 33 }[paramInt];
  }
  
  private String a()
  {
    EditText localEditText = (EditText)findViewById(1057292289);
    if (localEditText == null) {
      return null;
    }
    return localEditText.getText().toString().trim();
  }
  
  private void a(EditText paramEditText, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    paramEditText.setImeOptions(6);
    paramEditText.setText(paramString1);
    paramEditText.setHint(paramString2);
    paramEditText.setHintTextColor(c);
    paramEditText.setInputType(a(paramInt, paramBoolean1, paramBoolean2, paramBoolean3));
    paramEditText.addTextChangedListener(this);
    paramEditText.setClickable(true);
    if (!paramBoolean2) {
      paramEditText.selectAll();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Selection.removeSelection(((EditText)findViewById(1057292289)).getEditableText());
    b.reportSoftInputStr(paramString, 1, paramBoolean);
  }
  
  public final void a(String paramString)
  {
    EditText localEditText = (EditText)findViewById(1057292289);
    if (localEditText != null)
    {
      localEditText.setText(paramString);
      localEditText.setSelection(paramString.length());
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b.reportSoftInputStr(paramEditable.toString(), 0, false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected final View createSoftInputView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(a);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localRelativeLayout.setBackgroundColor(d);
    Object localObject = new EditText(a)
    {
      public final boolean onKeyPreIme(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 4) {
          s.a(s.this, s.a(s.this), true);
        }
        while (paramAnonymousInt == 84) {
          return true;
        }
        return super.onKeyPreIme(paramAnonymousInt, paramAnonymousKeyEvent);
      }
      
      public final void onWindowFocusChanged(boolean paramAnonymousBoolean)
      {
        super.onWindowFocusChanged(paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          ((InputMethodManager)s.b(s.this).getSystemService("input_method")).showSoftInput(this, 0);
        }
      }
    };
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, 1057292290);
    ((EditText)localObject).setLayoutParams(localLayoutParams);
    ((EditText)localObject).setId(1057292289);
    localRelativeLayout.addView((View)localObject);
    localObject = new Button(a);
    ((Button)localObject).setText(a.getResources().getIdentifier("ok", "string", "android"));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(11);
    ((Button)localObject).setLayoutParams(localLayoutParams);
    ((Button)localObject).setId(1057292290);
    ((Button)localObject).setBackgroundColor(0);
    localRelativeLayout.addView((View)localObject);
    ((EditText)localRelativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 6) {
          s.a(s.this, s.a(s.this), false);
        }
        return false;
      }
    });
    localRelativeLayout.setPadding(16, 16, 16, 16);
    return localRelativeLayout;
  }
  
  public final void onBackPressed()
  {
    a(a(), true);
  }
  
  public final void onClick(View paramView)
  {
    a(a(), false);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.unity3d.player.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */