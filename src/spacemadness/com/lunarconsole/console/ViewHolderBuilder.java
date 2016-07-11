package spacemadness.com.lunarconsole.console;

import android.view.ViewGroup;

public abstract class ViewHolderBuilder<T extends ConsoleEntry>
{
  public abstract ConsoleAdapter.ViewHolder<T> createViewHolder(ViewGroup paramViewGroup);
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ViewHolderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */