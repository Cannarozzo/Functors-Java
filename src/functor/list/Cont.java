package functor.list;

import java.util.function.Function;
import java.util.logging.ConsoleHandler;

import functor.Functor;

public class Cont<A> implements Lista {
	private A valor;
	private Lista<A> prox;
	
	public Cont(A valor, Lista<A> prox) {
		this.valor = valor;
		this.prox = prox;
	}
	
	public A getValor() {
		return valor;
	}

	public Lista<A> getProx() {
		return prox;
	}

	@Override
	public Functor fmap(Function f) {
			return new Cont((A)f.apply(this.valor),(Lista) prox.fmap(f));	
	}
	
	
	
	@Override
	public String toString() {
		return "Cont (" + this.valor + "," + prox + ")";
	}
	
	
}
