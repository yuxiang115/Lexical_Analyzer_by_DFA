
public class Scanner {
	private Book book;
	private static char[] k={'m', 'p', 'g', 'a', 'i', 'n', 'b', 'l', 't', 'e', 'f', 'o', 's'};
	private static char[] ss={',', ':', '!', '?', ';', '(', ')'};
	
	public  Scanner(){
		this.book = new Book();
		
	}
	
	public Token scan(Token input){
		Token out = null;
		State s;
		for (s = new OriginState(); !(s instanceof FinalState); s = s.next(input)) {
        } 
		if(s==FinalState.NULL) {
        }
		else if(s == FinalState.comment){
			input.skip();
		}
        else {
        	out = new Token(input.getWord(), s);

        }
        input.setPrevious(input.getCurrent());
		
        if(out != null){
        	book.add(out);
        }
        return out;
	}
	
	public static Symbol fisrtAnalyze(char ch){
		if(Character.isUpperCase(ch))
			ch = Character.toLowerCase(ch);
		if(isLetter_(ch)){
			if(isInK(ch)){
				if(ch == 'm' || ch == 'M')
					return Symbol.m;
				else if(ch == 'p' || ch == 'P')
					return Symbol.p;
				else if(ch == 'g' || ch == 'G')
					return Symbol.g;
				else if(ch == 'a' || ch == 'A')
					return Symbol.a;
				else if(ch == 'i' || ch == 'I')
					return Symbol.i;
				else if(ch == 'n' || ch == 'N')
					return Symbol.n;
				else if(ch == 'b' || ch == 'B')
					return Symbol.b;
				else if(ch == 'l' || ch == 'L')
					return Symbol.l;
				else if(ch == 't' || ch == 'T')
					return Symbol.t;
				else if(ch == 'e' || ch == 'E')
					return Symbol.e;
				else if(ch == 'f' || ch == 'F')
					return Symbol.f;
				else if(ch == 'o' || ch == 'O')
					return Symbol.o;
				else if(ch=='s' || ch == 'S')
					return Symbol.s;
			}
			else
				return Symbol.letterNotInK ;	
		}
		else if(ch == '¡°')
			return Symbol.leftquote;
		else if(ch == '¡±')
			return Symbol.rightquote;
		else if(isDigit(ch))
			return Symbol.digit;
		else if(ch == '#')
			return Symbol.comment;
		else if(isSpecialSymbol(ch))
			return Symbol.specialSymbol;
		return Symbol.endof;
	}
	
	public static Symbol analyze(char ch){
		if(Character.isUpperCase(ch))
			ch = Character.toLowerCase(ch);
		
		if(isLetter_(ch)){
			return Symbol.letter_;
		}
		else if(isDigit(ch))
			return Symbol.digit;
		else if(isSpecialSymbol(ch))
			return Symbol.specialSymbol;
		else if(ch == '¡°')
			return Symbol.leftquote;
		else if(ch == '¡±')
			return Symbol.rightquote;
		return Symbol.endof;
	}
	
	public static Symbol analyzeKey(char ch){
		if(Character.isUpperCase(ch))
			ch = Character.toLowerCase(ch);
		if(isLetter_(ch)){
			if(ch == 'a' || ch == 'A')
				return Symbol.a;
			else if (ch == 'b' || ch == 'B')
				return Symbol.b;
			else if (ch == 'c' || ch == 'C')
				return Symbol.c;
			else if (ch == 'd' || ch == 'D')
				return Symbol.d;
			else if (ch == 'e' || ch == 'E')
				return Symbol.e;
			else if (ch == 'f' || ch == 'F')
				return Symbol.f;
			else if (ch == 'g' || ch == 'G')
				return Symbol.g;
			else if (ch == 'h' || ch == 'H')
				return Symbol.h;
			else if (ch == 'i' || ch == 'I')
				return Symbol.i;
			else if (ch == 'j' || ch == 'J')
				return Symbol.j;
			else if (ch == 'k' || ch == 'K')
				return Symbol.k;
			else if (ch == 'l' || ch == 'L')
				return Symbol.l;
			else if (ch == 'm' || ch == 'M')
				return Symbol.m;
			else if (ch == 'n' || ch == 'N')
				return Symbol.n;
			else if (ch == 'o' || ch == 'O')
				return Symbol.o;
			else if (ch == 'p' || ch == 'P')
				return Symbol.p;
			else if (ch == 'q' || ch == 'Q')
				return Symbol.q;
			else if (ch == 'r' || ch == 'R')
				return Symbol.r;
			else if (ch == 's' || ch == 'S')
				return Symbol.s;
			else if (ch == 't' || ch == 'T')
				return Symbol.t;
			else if (ch == 'u' || ch == 'U')
				return Symbol.u;
			else if (ch == 'v' || ch == 'V')
				return Symbol.v;
			else if (ch == 'w' || ch == 'W')
				return Symbol.w;
			else if (ch == 'x' || ch == 'X')
				return Symbol.x;
			else if (ch == 'y' || ch == 'Y')
				return Symbol.y;
			else if (ch == 'z' || ch == 'Z')
				return Symbol.z;
		}
		else if(isDigit(ch))
			return Symbol.digit;
		else if(isSpecialSymbol(ch))
			return Symbol.specialSymbol;
		return Symbol.endof;
	}
	
	private static Boolean isLetter_(char ch){
		return (Character.isLetter(ch) || ch == '_');
	}
	
	private static Boolean isDigit(char ch){
		return Character.isDigit(ch);
	}
	
	private static Boolean isSpecialSymbol(char ch){
		for(char s: ss){
			if(ch == s)
				return true;
		}
		return false;
	}
	
	private static Boolean isInK(char ch){
		for(char c : k){
			if(ch == c)
				return true;
		}
		return false;
	}
	
	public Book getBookkeeper(){
		return this.book;
	}
	
	
	
}
