package functor.maybe;

import java.util.function.Function;

import functor.Functor;

public class Nothing implements Maybe {
	
	public String getNothing(){
		return this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return getNothing();
	}

	@Override
	public Functor fmap(Function f) {		 
		return new Nothing();
	}
	
	

}
