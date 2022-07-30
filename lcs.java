
/*
Longest Common Subsequence:

    A subsequence is a sequence that appears in the same relative order,
    but not necessarily contiguous. 
    For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc
    are subsequences of “abcdefg”. 

*/
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    
	    String s1 = "aggtaba", s2 = "gxtxayby";
	    
	    int[][] dp = new int[ s1.length() ][ s2.length() ];
	    for( int[] d: dp )
	        Arrays.fill( d, -1 );
	    
		System.out.println( lcs( s1, s2, s1.length() -1, s2.length() -1, dp ) );
	}
	
	public static int lcs( String s1, String s2, int m, int n, int[][] dp ){
	    
	    if( m == -1 || n == -1 )  return 0;
	    
	    if( dp[ m ][ n ] != -1 )    return dp[ m ][ n ];
	    
	    if( s1.charAt( m ) == s2.charAt( n ) )
	    
	        return dp[ m ][ n ] = 1+ lcs( s1, s2, m -1, n -1, dp );
	        
	    return dp[ m ][ n ] = Math.max( lcs( s1, s2, m, n -1, dp ), lcs( s1, s2, m -1, n, dp ) );
	}
}







