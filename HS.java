import java.util.Arrays;

public class Main{
	public static void main(String[] args) {
	    
	    int[] arr = new int[ 5 ];
	    for ( int i = 0; i < arr.length; i++ ) {
	        arr[ i ] = i +1;
	    }
	    
	    heapSort( arr );
	    
		System.out.println( Arrays.toString( arr ) );
	}
	
	public static void heapSort( int[] arr ){
	    build_max_Heap( arr );
	   // System.out.println( Arrays.toString( arr ) );
	    
	    for( int hsz = arr.length -1; hsz >= 1; hsz-- ){
	        
	        swap( arr, 0, hsz );
	        maxHeapify( arr, 0, hsz );
	        
	       // System.out.println( Arrays.toString( arr ) );
	    }
	}
	
	public static void build_max_Heap( int[] a ){
	    
	    for( int i = a.length /2; i >= 0; i-- )
	        maxHeapify( a, i, a.length );
	}
	
	public static void maxHeapify( int[] arr, int i, int hCap ){
	    
	    int larg = i;
	    int l = 2 *i;
	    int r = l +1;
	    
	    if( l < hCap && arr[ l ] > arr[ larg ] )
	        larg = l;
	    if( r < hCap && arr[ r ] > arr[ larg ] )
	        larg = r;
	        
	    if( larg != i ){
	        swap( arr, i, larg );
	        maxHeapify( arr, larg, hCap );
	    }
	}
	
	public static void swap( int[] a, int i, int j ){
	    int t = a[ i ];
	    a[ i ] = a[ j ];
	    a[ j ] = t;
	}
}





