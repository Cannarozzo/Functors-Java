package functor.Const;

import java.util.function.Function;

import functor.Functor;

public class Const<B,A> implements Functor {
	
	private B valor;	

	public Const(B valor) {
		this.valor = valor;
	}

	@Override
	public Functor fmap(Function f) {
		// descarta B e nao aplica a funcao
		return new Const<B, A>(valor);
	}
	

	public B getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Const (" + valor + ")";
	}	
	
}
