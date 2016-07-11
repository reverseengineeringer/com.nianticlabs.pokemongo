package spacemadness.com.lunarconsole.console;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import spacemadness.com.lunarconsole.R.layout;

public class ConsoleAdapter
  extends BaseAdapter
{
  private DataSource dataSource;
  
  public ConsoleAdapter(DataSource paramDataSource)
  {
    if (paramDataSource == null) {
      throw new NullPointerException("Data source is null");
    }
    dataSource = paramDataSource;
  }
  
  public int getCount()
  {
    return dataSource.getEntryCount();
  }
  
  public Object getItem(int paramInt)
  {
    return dataSource.getEntry(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return dataSource.getEntry(paramInt).type;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localViewHolder;
    }
    for (;;)
    {
      paramView.bindViewHolder(dataSource.getEntry(paramInt));
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.lunar_layout_console_log_entry, paramViewGroup, false);
      paramView = new ConsoleEntry.ViewHolder(paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public static abstract interface DataSource
  {
    public abstract ConsoleEntry getEntry(int paramInt);
    
    public abstract int getEntryCount();
  }
  
  public static abstract class ViewHolder<T extends ConsoleEntry>
  {
    protected final View itemView;
    
    public ViewHolder(View paramView)
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
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */