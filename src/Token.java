
public class Token {
	private String value;
	private State s;
	private String tag;
	private int current;
	private int previous;
	private Boolean ifSkip = false;
	
	public Token(String token, State s){
		this.value = token;
		this.s = s;
	}
	
	public Token(String token){
		this.value = token;
		this.current = 0;
		this.previous = 0;
	}
	
	public String getValue(){
		return this.value;
	}
	public String getWord(){
		return value.substring(previous, current);
	}
	
	public State getState(){
		return this.s;
	}
	
	public int getCurrent(){
		return this.current;
	}
	
	public int getPrevious(){
		return this.previous;
	}
	
	public void setPrevious(int i){
		this.previous = i;
	}
	
	public Symbol next(){
		return Scanner.analyze(value.charAt(current++));
	}
	
	public Symbol nextKey(){
		return Scanner.analyzeKey(value.charAt(current++));
	}
	
	public Symbol start(){
		return Scanner.fisrtAnalyze(value.charAt(current++));
	}
	
	
	public Boolean hasNext(){
		return this.current < this.value.length();
	}
	

	
	public void back(){
		this.current--;
	}
	private void setTag(){
		if(s == FinalState.constant)
			tag = "[const]";
		else if(s == FinalState.id)
			tag = "[id]";
		else if (s == FinalState.ss)
			tag = "SS";
		else if(s == FinalState.string)
			tag = "String";
		else if(s == FinalState.key)
			tag = "key";
		else 
			tag = "ERROR";
	}
	public void skip(){
		ifSkip = true;
	}
	
	public String toString(){
		setTag();
		return tag + "\t\t" + value;
	}
	
	public String getTag(){
		return this.tag;
	}
	
	public Boolean ifSkip(){
		return ifSkip;
	}
	
}
