package functor.list;

import java.util.function.Function;

import functor.Functor;

public class Cont<A> implements List {
	private A valor;
	private List<A> prox;
	
	public Cont(A valor, List<A> prox) {
		this.valor = valor;
		this.prox = prox;
	}

	@Override
	public Functor fmap(Function f) {
		if(prox instanceof Final) {
			return new Final();
		}else {
			return new Cont(f.apply(this.valor), prox ) ;
		}
	}

	@Override
	public String toString() {
		return "Cont (" + valor + ", Const =" + prox + ")";
	}
	
	
}
