package spacemadness.com.lunarconsole.console;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public abstract class ConsoleAdapter$ViewHolder<T extends ConsoleEntry>
{
  protected final View itemView;
  
  public ConsoleAdapter$ViewHolder(View paramView)
  {
    itemView = paramView;
  }
  
  void bindViewHolder(ConsoleEntry paramConsoleEntry)
  {
    onBindViewHolder(paramConsoleEntry);
  }
  
  protected int getColor(int paramInt)
  {
    return getResources().getColor(paramInt);
  }
  
  protected Context getContext()
  {
    return itemView.getContext();
  }
  
  protected Resources getResources()
  {
    return getContext().getResources();
  }
  
  protected String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public abstract void onBindViewHolder(T paramT);
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleAdapter.ViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */