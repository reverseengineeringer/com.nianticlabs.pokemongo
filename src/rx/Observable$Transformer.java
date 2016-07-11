package rx;

import rx.functions.Func1;

public abstract interface Observable$Transformer<T, R>
  extends Func1<Observable<T>, Observable<R>>
{}

/* Location:
 * Qualified Name:     rx.Observable.Transformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */