import java.util.* ;
public class Main
{
	public static void main(String[] args) {
	    int[] arr = { 10, 30, 20, 50, 70, 5, 40 } ;
	    ms( arr, 0, arr.length -1 ) ;
		System.out.println( Arrays.toString( arr ) );
	}
	public static int part( int[] arr, int s, int e ){
	    
	    int piv = arr[ ( s + e ) /2 ] ;
	    
	    while( s < e ){
	        while( arr[ s ] < piv )
	            s++ ;
	       
	        while( arr[ e ] > piv )
	            e-- ;
	            
	        if( s < e )
	            swap( arr, s, e ) ;
	    }
	    return s ;
	}
	
	public static void ms( int[] arr, int l, int h ){
	    if( l <= h ){
	        
	        int idx = part( arr, l, h ) ;   //  returns the pivot element's index for making the next ms call
	        
	        ms( arr, l, idx -1) ;
	        ms( arr, idx +1, h ) ;
	    }
	}
	 public static void swap( int[] arr, int i, int j ){
	    int t = arr[ i ] ;
	    arr[ i ] = arr[ j ] ;
	    arr[ j ] = t ;
	}
}
