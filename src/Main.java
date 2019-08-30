import java.util.List;
import java.util.function.Function;

import functor.Functor;
import functor.maybe.Just;
import functor.maybe.Maybe;
import functor.maybe.Nothing;

public class Main {
	
	public static <A,B> Functor<B> fmapS (Function<A,B> f, Functor<A> funtor){
		if(funtor instanceof Maybe) {
			if(funtor instanceof Just) {
				A v = (A) ((Just) funtor).getJust();				
				return new Just(f.apply(v));
			}else {
				return new Nothing();
			}
		}
		return null;	
		
	}

	
	private static <Integer>Maybe foo (Integer valor){
		switch((int)valor) {
		case 0: 
			return new Nothing();
	    default: 
	    	return new Just(valor);
		
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Just<Integer> j = new Just<>(3);	
		Nothing n1 = new Nothing();
		
		Function<Integer,Integer> f = x -> x + 1;		
		
		Function bar = Function.identity();
		
		
		Function<Integer, Maybe> g = x -> x == 0 ? new Just(x) : new Nothing();
		
		Function<Maybe, Maybe> h = x ->  x instanceof Just ? new Just(x) : new Nothing();
		
	
		
		/*
		
	    System.out.println(j.fmap(f).fmap(f) );
	    
	    System.out.println(g.apply(0));
	    
	    System.out.println(foo(0));
	    */
	    System.out.println(fmapS(f,fmapS( f, j))); // fazer composicao com a funcao map (uso de flatmap/apply etec
	    System.out.println(fmapS(g,fmapS(f,j)));
	    
	    System.out.println(fmapS(h,fmapS(g,fmapS(f,j))));
	    
	}

}