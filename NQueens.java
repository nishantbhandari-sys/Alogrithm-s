import java.util.* ;
class NQueens {
    // static Making ans adds prev ans to next ans 
  
    public static void main(String[] args) {
        int n = 4 ;
        List<List<String>> ans = new ArrayList<>() ;
        ans = solveNQueens( n, ans ) ;
        
        //  Printing answer
        for( List<String> i: ans ){
            for( String str: i ){
                System.out.println( str );
            }
            System.out.println();
        }
        
	}
	
	public static List<List<String>> solveNQueens( int n, List<List<String>> ans ) {
        boolean[][] board = new boolean[ n ][ n ] ;
        
        back( board, 0, ans ) ;
        
        return ans ;
	}
	
	public static void back( boolean[][] board, int row, List<List<String>> ans ){
	    if( row == board.length ){
	        display( board, ans ) ;
	        // System.out.println();
	        return ;
	    }
	    
	    for( int col = 0; col < board.length; col++ ){
	        if( safe( board, row, col ) ){  //  if row , col is a valid place to put the Queen
	         
    	        //  Make a change 
    	        board[ row ][ col ] = true ;
    	        
    	        back( board, row +1, ans ) ;
    	        //  revert the change
    	        board[ row ][ col ] = false ;   
	        }
	    }
	}
	public static boolean safe( boolean[][] board, int row, int col ){
	    //  Check vertically upwards
	    for( int i = row -1; i >= 0; i-- ){
	        if( board[ i ][ col ] )
	            return false ;
	    }
	    	    
	    //  Check in left diagonal     check for min value of row or col times in board
	    int lim = Math.min( row, col ) ;
	    for( int i = 1; i <= lim; i++ ){
	        if( board[ row -i ][ col -i ] ){
	            return false ;
	        }
	    }
	    
	    //  Check in right diagonal     check for min val of row or wall -col in board
	    lim = Math.min( row, board.length -col -1 ) ;
	    for( int i = 1; i <= lim; i++ ){
	        if( board[ row -i ][ col +i ] ){
	            return false ;
	        }
	    }
	    
	    return true ;
	}
	public static void display( boolean[][] board, List<List<String>> ans ){
        List<String> tmp = new ArrayList<>() ;
        
	    for( boolean[] i: board ){
          String str = "" ;
	        for( boolean j: i ){
	            if( j == true )
                    str += "Q" ;
	                // System.out.print( "Q " );
	            else
                    str += "." ;
	                // System.out.print( ". " ) ;
	        }
	        tmp.add( str ) ;
	    }
        ans.add( tmp ) ;
	}
}
