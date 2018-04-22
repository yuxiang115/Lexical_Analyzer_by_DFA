
public enum States implements State{

	ID{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol: 
					t.back();
				return FinalState.id;
				default:
					return FinalState.error_id;
				}
			}
			return FinalState.id;
		}
	},
	
	Stringing{
		@Override
		public State next(Token t){
			if(t.hasNext()){
				switch(t.next()){
				case rightquote:
					return States.StringEnd;
				default:
					return States.Stringing;
				}
			}
			return FinalState.error_other; //string lack left quote, incomplete
		}
	},
	
	StringEnd{
		@Override
		public State next(Token t){
			if(t.hasNext()){
				switch(t.next()){
				case endof: t.back();
					return FinalState.string;
				case specialSymbol: 
					t.back();
				return FinalState.string;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.string;
		}
	},
	
	Digit1{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit2;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	Digit2{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit3;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	Digit3{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit4;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	Digit4{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit5;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	Digit5{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit6;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	Digit6{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit7;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.error_const;
		}
	},
	
	Digit7{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case digit:
					return States.Digit7;
				case endof: t.back();
					return FinalState.constant;
				case specialSymbol: t.back();
				return FinalState.constant;
				default:
					return FinalState.error_const;
				}
			}
			return FinalState.constant;
		}
	},
	
	m{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.ma;
				case o:
					return States.mo;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	mo{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.mor;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	mor{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.more;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	more{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				case specialSymbol: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	ma{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case k:
					return States.mak;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	mak{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.make;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	make{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	p{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.pr;
				case l:
					return States.pl;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	pr{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case o:
					return States.pro;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			
			return FinalState.id;
		}
	},
	
	pro{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case g:
					return States.prog;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	prog{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.progr;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	progr{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.progra;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	progra{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case m:
					return States.program;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	program{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case m:
					return States.programm;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	programm{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case i:
					return States.programmi;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	programmi{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case n:
					return States.programmin;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	programmin{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case g:
					return States.programming;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	programming{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	pl{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case u:
					return States.plu;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	plu{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.plus;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	plus{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	g{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.gr;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	gr{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.gre;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	gre{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.grea;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	grea{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case t:
					return States.great;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	great{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	a{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case m:
					return States.am;
				case g:
					return States.ag;
				case n:
					return States.an;
				case s:
					return States.as;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	as{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				case specialSymbol: 
					t.back();
				return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	an{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case d:
					return States.and;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	and{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	ag{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.aga;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	aga{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case i:
					return States.agai;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	agai{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case n:
					return States.again;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
		

	again{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	am{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.ame;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	ame{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.amer;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	amer{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case i:
					return States.ameri;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	ameri{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case c:
					return States.americ;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	americ{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.america;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},

	america{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	i{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.is;
				case f:
					return States.if_;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	is{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	if_{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:
					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	n{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case o:
					return States.no;
				case u:
					return States.nu;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	no{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case t:
					return States.not;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	not{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	nu{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case m:
					return States.num;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	num{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case b:
					return States.numb;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	numb{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.numbe;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	numbe{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.number;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	number{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	o{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case r:
					return States.or;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	or{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	b{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case o:
					return States.bo;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	bo{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case o:
					return States.boo;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	boo{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case l:
					return States.bool;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	bool{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.boole;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	boole{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.boolea;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	boolea{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case n:
					return States.boolean_;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	boolean_{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	

	
	l{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.le;
				case o:
					return States.lo;
				case i:
					return States.li;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	le{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.les;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	les{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.less;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	less{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	lo{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case n:
					return States.lon;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	lon{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case g:
					return States.long_;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	long_{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	
	li{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.lie;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	lie{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
	
	t{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case i:
					return States.ti;
				case e:
					return States.te;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	ti{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case m:
					return States.tim;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	tim{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.time;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	time{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.times;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	times{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},	
	
	te{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case l:
					return States.tel;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	tel{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case l:
					return States.tell;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	tell{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},	
	
	e{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case l:
					return States.el;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	el{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case s:
					return States.els;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	els{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case e:
					return States.else_;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	else_{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},	
	
	s{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.sa;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	sa{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case y:
					return States.say;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},

	
	say{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},	
	
	f{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case a:
					return States.fa;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	fa{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case c:
					return States.fac;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},	
	
	fac{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.nextKey()){
				case t:
					return States.fact;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.id;
				case specialSymbol:
					return FinalState.error_other;
				default:
					t.back();
					if(t.next() == Symbol.letter_)
						return States.ID;
					return FinalState.error_other;
				}
			}
			return FinalState.id;
		}
	},
	
	fact{
		@Override
		public State next(Token t) {
			if(t.hasNext()){
				switch(t.next()){
				case letter_:
					return States.ID;
				case digit:
					return States.ID;
				case endof: t.back();
					return FinalState.key;
				default:

					return FinalState.error_other;
				}
			}
			return FinalState.key;
		}
	},
	
}
