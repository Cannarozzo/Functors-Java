package functor.list;

import java.util.function.Function;

import functor.Functor;

public class Final implements Lista {
	
	public String getFinal() {
		return this.getClass().getSimpleName();
	}
	@Override
	public Functor fmap(Function f) {		
		return new Final();
	}
	@Override
	public String toString() {
		return getFinal();
	}
	
	

}
