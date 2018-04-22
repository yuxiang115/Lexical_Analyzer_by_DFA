
public enum FinalState implements State{
	id,
	key,
	ss,
	string,
	constant,
	NULL,
	error_const,
	error_id,
	error_other,
	comment;
	 @Override
	    public State next(Token token) {
	        return null;
	    }
}
