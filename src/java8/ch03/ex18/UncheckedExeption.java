package java8.ch03.ex18;

import java.util.function.Function;

public class UncheckedExeption {

	@FunctionalInterface
	public interface ThrowableFunction<T, U> {
	    U apply(T t) throws Exception;
	}
	
	public static <T, U> Function<T, U> unchecked(ThrowableFunction<T, U> f) {
	    return (t) -> {
	        try {
	            return f.apply(t);
	        } catch (Throwable e) {
	            throw new RuntimeException(e);
	        }
	    };
	}

}
