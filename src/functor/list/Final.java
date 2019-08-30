package functor.list;

import java.util.function.Function;

import functor.Functor;

public class Final implements List {
	
	public String getFinal() {
		return this.getClass().getSimpleName();
	}
	@Override
	public Functor fmap(Function f) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return getFinal();
	}
	
	

}
