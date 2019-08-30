package functor.identity;

import java.util.function.Function;

import functor.Functor;

public class Identity<A> implements Functor {
	
	private A valor;
	
	
	public Identity(A valor) {
		this.valor = valor;
	}

	public A getValor() {
		return valor;
	}

	@Override
	public Functor fmap(Function f) {		
		return new <A>Identity(f.apply(valor));
	}

	@Override
	public String toString() {
		return "Identity (" + valor + ")";
	}

	
}
