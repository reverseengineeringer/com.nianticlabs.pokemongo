package dagger.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T>
  implements Factory<Set<T>>
{
  private static final String ARGUMENTS_MUST_BE_NON_NULL = "SetFactory.create() requires its arguments to be non-null";
  private final List<Provider<Set<T>>> contributingProviders;
  
  static
  {
    if (!SetFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SetFactory(List<Provider<Set<T>>> paramList)
  {
    contributingProviders = paramList;
  }
  
  public static <T> Factory<Set<T>> create(Factory<Set<T>> paramFactory)
  {
    assert (paramFactory != null) : "SetFactory.create() requires its arguments to be non-null";
    return paramFactory;
  }
  
  public static <T> Factory<Set<T>> create(Provider<Set<T>>... paramVarArgs)
  {
    assert (paramVarArgs != null) : "SetFactory.create() requires its arguments to be non-null";
    paramVarArgs = Arrays.asList(paramVarArgs);
    assert (!paramVarArgs.contains(null)) : "Codegen error?  Null within provider list.";
    assert (!hasDuplicates(paramVarArgs)) : "Codegen error?  Duplicates in the provider list";
    return new SetFactory(paramVarArgs);
  }
  
  private static boolean hasDuplicates(List<? extends Object> paramList)
  {
    HashSet localHashSet = new HashSet(paramList);
    return paramList.size() != localHashSet.size();
  }
  
  public Set<T> get()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList(contributingProviders.size());
    int i = 0;
    int k = contributingProviders.size();
    Object localObject2;
    while (i < k)
    {
      localObject1 = (Provider)contributingProviders.get(i);
      localObject2 = (Set)((Provider)localObject1).get();
      if (localObject2 == null) {
        throw new NullPointerException(localObject1 + " returned null");
      }
      localArrayList.add(localObject2);
      j += ((Set)localObject2).size();
      i += 1;
    }
    Object localObject1 = Collections.newLinkedHashSetWithExpectedSize(j);
    i = 0;
    j = localArrayList.size();
    while (i < j)
    {
      localObject2 = ((Set)localArrayList.get(i)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (localObject3 == null) {
          throw new NullPointerException("a null element was provided");
        }
        ((Set)localObject1).add(localObject3);
      }
      i += 1;
    }
    return java.util.Collections.unmodifiableSet((Set)localObject1);
  }
}

/* Location:
 * Qualified Name:     dagger.internal.SetFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */