
/*
    kadane's Algo ->    for finding largest sum contiguous subarray
    
    Eg:     a = [  -2, -3, 4, -1, -2, 1, 5, -3  ]
    
            O/p = [ 4, -1, -2, 1, 5 ]
*/


public class Main
{
	public static void main(String[] args) {
	    
	    int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3  };
	    
	    int[] co = kadaneAlgo( arr );
	    
		System.out.println("left:" + co[ 0 ] + ", right: " + co[ 1 ] );
	}
	
	public static int[] kadaneAlgo( int[] a ){
	    
	    int meh = 0;    //  max. ending here
	    int msf = 0;    //  max. so far
	    
	    int[] co = new int[2];  //  st & en pts. of subarray
	    
	    for( int i = 0; i < a.length; i++ ){
	        
	        meh = meh + a[ i ];
	        
	        if( meh < a[ i ] ){
	            
	            meh = a[ i ];
	            co[ 0 ] = i;
	        }
	        
	        if( msf < meh ){
	            
	            msf = meh;
	            co[ 1 ] = i;
	        }
	    }
	    
	    //  msf contains sum of subarray
	    return co;
	}
}




