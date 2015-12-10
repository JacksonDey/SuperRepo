/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private  Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

    

		
    //~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() {
        _data = new Comparable[10];
        _lastPos = -1;
        _size = 0;
       	int _size = 0;
	int _lastPos = -1;
    }//end constructor
    
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String str = "[";
        for (int i = 0; i < _lastPos + 1; i += 1) {
            str += _data[i] + ",";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        str += "]";
        return str;
    }

    public static String print(Comparable[] a){
	String retStr = "";
	for(int x = 0; x < a.length; x++){
	    retStr += " " + a[x];
	}
	return retStr;
    }

		
    //double capacity of this SuperArray
    private void expand() {
	Comparable[] xxl = new Comparable[_size * 2];
	for(int x = 0; x < _size; x++){
	    xxl[x] = _data[x];	   
	}
	_data = xxl;
   
    }//end expand
		
    //accessor -- return value at specified index
    public int get( int index ) {
	String Str ="" + _data[index];
	int i = Integer.parseInt(Str);
	return i;
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, int newVal ) {
	Comparable saved = _data[index];
	_data[index] = newVal;
	return saved;
	
    }
    public void add( Comparable newVal ) {
	if (_lastPos == _data.length - 1) {
	    expand();
	}
	_data[_lastPos + 1] = newVal;
	_lastPos += 1;
	_size += 1;
    }
    public int linSearch(Comparable co){
	for (int r = 0; r < _data.length; r++){
	    if(_data[r] == co){return r;}

	}
	return -1;
    }
	    


    //main method for testing
    public static void main( String[] args ) {
	SuperArray booty = new SuperArray();
	SuperArray rat = new SuperArray();
	rat.add( new Rational(2,3));
	rat.add( new Rational(1,5));
	rat.add( new Rational(1,8));
	System.out.println(booty);//expect whole array
	System.out.println(booty.get(4));//expect 4
	System.out.println(booty.set(4, 24));//expect 4
	System.out.println(booty.get(4));	//expect 24
	booty.expand();
	System.out.println(booty);
	System.out.println("Hooray");
	System.out.println(booty);
	//*****INSERT ADEQUATE TEST CALLS HERE*****
    }//end main
		
}//end class
