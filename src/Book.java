import java.util.Vector;

public class Book {
	private Vector<Token> symtab;
	public Book(){
		this.symtab = new Vector<Token>();
	}
	
	public void add(Token t){
		if(ifAdd(t))
			symtab.addElement(t);
	}
	
	private Boolean ifAdd(Token t){
		if( !(t.getState()==FinalState.constant)
		 && !(t.getState()==FinalState.string)
		 && !(t.getState()==FinalState.id))
			return false;
		
		for(Token a : symtab){
			if(a.getValue().equalsIgnoreCase(t.getValue()))
					return false;
		}
		return true;
	}
	
	public String toString(){
		String s = "";
		for(Token a : symtab){
			s = s + a.toString() + "\n";
		}
		
		return s;
	}
	
	public Vector<Token> getSymtab(){
		return this.symtab;
	}
}
