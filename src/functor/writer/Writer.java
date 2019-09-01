package functor.writer;

import java.util.function.Function;

import functor.Functor;

public class Writer<A,S> implements Functor{
	
	private A valor;
	private S	 st;
	
	public Writer(A valor, S st) {
		this.valor = valor;
		this.st = st;
	}

	public S getSt() {
		return st;
	}

	public A getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Writer (" + valor + "," + st + ")";
	}

	@Override
	public Functor fmap(Function f) {		
		return new Writer((A)f.apply(this.valor), this.st);
		
	}

}
