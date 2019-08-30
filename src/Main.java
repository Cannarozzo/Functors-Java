import java.util.function.Function;

import functor.maybe.Just;
import functor.maybe.Maybe;
import functor.maybe.Nothing;

public class Main {
	
	public static void main(String[] args) {
		
		
		Just<Integer> j = new Just<>(3);	
		Nothing n1 = new Nothing();
		
		Function<Integer,Integer> f = x -> x + 1;
		
		Function<Integer, Maybe> g = x -> x != 0 ? new Just(x) : new Nothing();
		
		
	    System.out.println(j.fmap(f).fmap(f) );
	    
	    System.out.println(g.apply(0));
	}

}