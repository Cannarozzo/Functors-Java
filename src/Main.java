
import java.util.function.Function;

import functor.Functor;
import functor.Const.Const;
import functor.Reader.Reader;
import functor.identity.Identity;
import functor.list.Cont;
import functor.list.Final;
import functor.list.Lista;
import functor.maybe.Just;
import functor.maybe.Maybe;
import functor.maybe.Nothing;
import functor.writer.Writer;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {			
		
		Function<Integer,Integer> f = x -> x + 1;	
		Function<Integer, Maybe> g = x -> x == 0 ? new Just(x) : new Nothing();		
		Function<Maybe, Maybe> h = x ->  x instanceof Just ? new Just(x) : new Nothing();
		Function<String,Integer> tamanhoString = x -> x.length();	
		
		// fmap com just
		Just<Integer> just = new Just<>(3);	
		Nothing nothing = new Nothing();
		System.out.println(just.fmap(f).fmap(f));
		System.out.println(just.fmap(f).fmap(g));// M ( M A), instancia de monada necessaria, para composicao de funtores...		
		System.out.println(new Just(0).fmap(g).fmap(h));// M ( M (..) 
		System.out.println(nothing.fmap(f));
	     
	    // fmap com Const
	    Const<Integer, String> cons = new Const<Integer, String>(3);
	    System.out.println(cons.fmap(f));
	    
	    // fmap com Identity
	    Identity<String> identity = new Identity<>("Fooo");

	    System.out.println(identity.fmap(tamanhoString));
 	    
	    //fmap com lista
	    Cont<Integer> lista = 
	    		new Cont(2, new Cont<Integer>(3, new Cont<Integer>(50, new Final())));	    
	    Lista l2 = (Cont) lista.fmap(f);	    
	    System.out.println(l2);
	    
	    //fmap com Writer
	    Writer<Double,String> w1 = new Writer<>(3.0,"Log");
	    Function<Double, Double> quadrado = x -> Math.pow(x, 2);	    
	    System.out.println(w1.fmap(quadrado).fmap( x -> (double)Math.sqrt((double)x)));
	    
	    //fmap com Reader
	    Function<String, Integer> id = x -> Integer.parseInt(x);	    
	    Reader<String,Integer> r1 = new Reader<String, Integer>(id);
	    System.out.println(r1.fmap( valor -> (int)valor == 0 ? true : false));
	    
	    
	    
	}

}