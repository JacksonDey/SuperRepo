/*
Team Tyrannosaurus Rexadecimal - Jackson Deysine & Olivia Gallager 
APCS1 pd9
HW44 -- This or That or 14 other things
2015-12-08
*/

//skeleton file for class Hexadecimal


public class Hexadecimal implements Comparable {
    private final static String HEXDIGITS = "0123456789ABCDEF";
    private int _decNum;
    private String _hexNum;

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	    _decNum = 0;
	    _hexNum="0"; 
    }
    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	    _decNum=n;
	    _hexNum=decToHex(n);
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadeCIMAL number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	    _hexNum = s;
	    _decNum = hexToDec(s);	  
    }

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	     String retStr = "";
	     retStr+= "\tHexadecimal format: " + _hexNum + "\n\tDecimal format: " + _decNum;
       return retStr;
    }

    /*=====================================
      String decToBin(int) -- converts base-10 input to hexadeCIMAL
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
      //algo:  --> go through n feed the mod.INDEX into the retStr, return the quotient 
    public static String decToHex( int n ) {
	    String retStr = "";
	    while (n > 0) {
		      retStr = HEXDIGITS.substring(n%16,(n%16)+1) + retStr;//retStr = the corresponding letter
		      n = n/16;
	    }
	    return retStr; 
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to hexadeCIMAL, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) { 
	      if (n < 16) {//basecase
		        return ""+ HEXDIGITS.substring(n,n+1);	
	      } 
	      else { //BE THE BOOJUM heheh
		        return "" + decToHexR(n/16) + HEXDIGITS.substring(n%16,(n%16)+1);	
	     }
    }

    /*=====================================
      String binToDec(String) -- converts base-10 input to hexadeCIMAL
      pre:  s represents non-negative hexadeCIMAL number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	     int retint = 0;
       for (int x= 0 ; x< s.length(); x ++ ) {
          int y = HEXDIGITS.indexOf(s.substring(x,x+1));//we forgot that indexOf() existed
          retint += (y * Math.pow(16 , (s.length()-x-1)) );//i^2 fixes everything
       }
       return retint; 
    }

    /*=====================================
      String binToDecR(String) -- converts base-10 input to hexadeCIMAL, recursively
      pre:  s represents non-negative hexadeCIMAL number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int hexToDecR( String s ) { 
      if (s.length() == 0) {
        return 0;
      }
      else {
        int a = HEXDIGITS.indexOf(s.substring(0,1)) * ((int)Math.pow(16 , s.length()-1 )) ;
        return a + hexToDecR(s.substring(1,s.length())); //chops off first num and sends the rest to the magical boojum
      }  
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class hexadeCIMAL
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexadeCIMAL values
      =============================================*/

  public boolean equals( Object other ) {
 
        //First, check for aliasing.
        boolean retVal = (this == other);
 
        if ( ! retVal )
          retVal = (this._decNum == ((Hexadecimal)other)._decNum);
          //double checkin^
 
        return retVal;
    }



    /*=============================================
      int compareTo(Object) -- tells which of two hexadeCIMAL objects is greater
      pre:  other is instance of class hexadeCIMAL
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	// if (! (other instanceof Hexadecimal))
	//  throw new ClassCastException ("\n My first error message!" + "compareTo() input not a Hexadecimal");
	if(other instanceof Hexadecimal){
	    if (this.equals((Hexadecimal)other) == true) { 
		return 0; 
	    }
	    else {
		if (this._decNum > ((Hexadecimal)other)._decNum) {//has to test decnum b/c hexnum is a string and strings use .equals() method

		    return 1;
		}
		else{ return -1;	}
	    }
	}//End if hex
	if (other instanceof Binary){
	    Binary b = (Binary)other;
	    if(this._decNum == b.get()) {return 0;}
	    if(this._decNum > b.get()) {return 1;}
	    else{return -1;}
	}
	if (other instanceof Rational){
	    Rational b = (Rational)other;
	    if(this._decNum == b.get()) {return 0;}
	    if(this._decNum > b.get()) {return 1;}
	    else{return -1;}
	}
	    
	return 1/0;//just cuz    	
    }
     public int get(){
	 return this._decNum;
    }


    //main method for testing
    public static void main( String[] args ) {

	
	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(26);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(30);
	Hexadecimal b5 = new Hexadecimal(18);
	
		Hexadecimal b6= new Hexadecimal("1A");//26

	System.out.println( b1 );//5
	System.out.println( b2 );//1A
	System.out.println( b3 );//5       
	System.out.println( b4 );//1D  
	System.out.println( b5 );//12  
	System.out.println( b6 );//1A

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true
	System.out.println( b2 == b6 ); //should be false as not aliases
	

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be false
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false
  System.out.println( b2.equals(b6) ); //should be true
  
	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be -1
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	System.out.println( b2.compareTo(b6) ); //should be 0
	 /*=========================================
    =========================================*/
    }//end main()

} //end class
