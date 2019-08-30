package functor.maybe;

import java.util.function.Function;

import functor.Functor;

public class Just<A> implements Maybe {
	private A just;

	public Just(A just) {
		this.just = just;
	}

	public A getJust() {
		return just;
	}

	@Override
	public String toString() {
		return "Just (" + just + ")";
	}

	@Override
	public Functor fmap (Function f){
		// TODO Auto-generated method stub
		return  new Just(f.apply(this.just));
	}	
	

}
