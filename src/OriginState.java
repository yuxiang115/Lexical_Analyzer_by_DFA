
public class OriginState implements State {

	@Override
	public State next(Token t) {
		if(t.hasNext()){
			switch(t.start()){
			case letterNotInK:
				return States.ID;
			case m:
				return States.m;
			case p:
				return States.p;
			case g:
				return States.g;
			case a:
				return States.a;
			case i:
				return States.i;
			case n:
				return States.n;
			case b:
				return States.b;
			case l:
				return States.l;
			case t:
				return States.t;
			case e:
				return States.e;
			case f:
				return States.f;
			case o:
				return States.o;
			case s:
				return States.s;
			case leftquote:
				return States.Stringing;
			case specialSymbol:
				return FinalState.ss;
			case comment:
				return FinalState.comment;
			case digit:
				return States.Digit1;
			case endof:
			default:
				break;

			}
		}
		return FinalState.NULL;
	}
	
}
