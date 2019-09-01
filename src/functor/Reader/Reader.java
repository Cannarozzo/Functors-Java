package functor.Reader;

import java.util.function.Function;

import functor.Functor;

public class Reader<R,A> implements Functor{
	Function<R, A> aToR ;
	
	
	public Reader(Function<R, A> aToR) {
		this.aToR = aToR;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Functor fmap(Function f) {		
		return new Reader(f.compose(aToR));
	}

	@Override
	public String toString() {
		return "Reader (" + aToR + ")";
	}

	

}
