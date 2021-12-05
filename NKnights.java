package com.company;

public class NKnights {
    public static void main(String[] args) {
        int n = 4 ;
        boolean[][] board = new boolean[ n ][ n ] ;

//        ITR_getKnights( board, 0, 0, n ) ;
        REC_getKnights( board, 0, 0, n ) ;
    }

    private static void REC_getKnights(boolean[][] board, int row, int col, int lft) {
        //  All Knights Placed
        if( lft == 0 ){
            display( board ) ;
            return;
        }

        //  Change Rows
        if( row == board.length )
            return;

        //  Change Cols
        if( col == board.length ){
            REC_getKnights( board, row +1, 0, lft );
            return;
        }

        //  If it is SAfe
        if( safe( board, row, col ) ){
            board[ row ][ col ] = true;
            REC_getKnights( board, row, col +1, lft -1 );
            board[ row ][ col ] = false;
        }

        //  If it is not a safe place to put Knight
        REC_getKnights( board, row, col +1, lft );
    }

    private static void ITR_getKnights(boolean[][] board, int i, int j, int lft ) {
        if( lft == 0 ){
            display( board ) ;
            return;
        }

        while ( i < board.length ){
            while ( j < board.length ){

                if( safe( board, i, j ) ){

                    board[ i ][ j ] = true ;
                    ITR_getKnights( board, i, j +1, lft -1 );
                    board[ i ][ j ] = false ;
                }
                j++ ;
            }
            i++ ;
            j = 0;
        }

    }

    private static boolean safe(boolean[][] board, int r, int c ) {
        if( r -2 >= 0 ){
            if( c -1 >= 0 && board[ r -2][ c -1] ){
                return false;
            }

            if( c +1 < board.length && board[ r -2][ c +1] ) {
                return false;
            }
        }
        if( r -1 >= 0 ){
            if( c -2 >= 0 && board[ r -1][ c -2] ){
                return false;
            }

            if( c +2 < board.length && board[ r -1][ c +2] ) {
                return false;
            }
        }
        return true;
    }

    public static void display( boolean[][] board ){
        for (boolean[] booleans : board) {
            for (int j = 0; j < board.length; j++) {

                if ( booleans[j] )
                    System.out.print("K ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
