package java8.ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T>{
	default void forEachIf(Consumer<T> action, Predicate<T> filter){
		for(T t : this){//thisがT型のコレクション?適用する個々の要素はこれでいいの...?
			if(filter.test(t)){
				action.accept(t);
			}
		}
	}
}
