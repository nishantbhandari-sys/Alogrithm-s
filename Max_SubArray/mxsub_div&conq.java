package com.company;

import java.util.Arrays;

public class max_subarray {
    public static void main(String[] args) {

                //     0    1   2    3   4   5   6   7    8   9
        int arr[] = { 20, -16, -23, 18, 20, -7, 12, -5, -22, 15 } ;

        int[] ans = mxsb( arr, 0, arr.length -1 );
        System.out.println( Arrays.toString( ans ) );
    }

    static int[] mxsb( int arr[], int low, int high ){

        if( low == high ){
            return new int[] { low, high, arr[ low ] } ;
        }
        else{
            int mid = (low + high) /2 ;

            int[] lft = mxsb( arr, low , mid ) ;
            int[] rht = mxsb( arr, mid +1, high );
            int[] crs = cross( arr, low, mid, high ) ;

            if( lft[ 2 ] >= rht[ 2 ] && lft[ 2 ] >= crs[ 2 ] )
                return new int[] { lft[ 0 ], lft[ 1 ], lft[ 2 ] } ;

            else if( rht[ 2 ] >= lft[ 2 ] && rht[ 2 ] >= crs[ 2 ] )
                return new int[] { rht[ 0 ], rht[ 1 ], rht[ 2 ] } ;

            else
                return new int[] { crs[ 0 ], crs[ 1 ], crs[ 2 ] } ;
        }
    }

    private static int[] cross(int[] arr, int low, int mid, int high) {
        int ml = 0, mr = 0 ;
        int rht_sum, lft_sum ;
        rht_sum = lft_sum = Integer.MIN_VALUE ;

        int sum = 0 ;

        for( int i = mid; i >= low; i-- ){
            sum += arr[ i ] ;
            if( sum > lft_sum ){
                lft_sum = sum ;
                ml = i ;
            }
        }

        sum = 0 ;

        for( int i = mid +1; i <= high; i++ ){
            sum += arr[ i ] ;
            if( sum > rht_sum ){
                rht_sum = sum ;
                mr = i ;
            }
        }

        return new int[] { ml, mr, lft_sum + rht_sum } ;
    }


}
