#include <stdio.h>
#include <limits.h>

void conq( int arr[], int p, int q, int r ){

	int m = q - p +1 ;
	int n = r - q ;
	
	int L[ m +1], R[ n +1] ;
	L[ m ] = INT_MAX ;
	R[ n ] = INT_MAX ;
	
	int i = 0, j = 0 ;
	
	for( i = 0; i < m; i++ )
		L[ i ] = arr[ p +i ] ;

	for( i = 0; i < n; i++ )
		R[ i ] = arr[ q +1 +i ] ;

	i = 0 ;
	for( int k = p; k <= r; k++ ){
	
		if( L[ i ] < R[ j ] ){
			arr[ k ] = L[ i ] ;
			i++ ;
		}
		else{
			arr[ k ] = R[ j ] ;
			j++ ;
		}
			
	}
}

void div( int arr[], int p, int r ){

	if( p < r ){
		
		int q = ( p + r ) /2 ; 
		div( arr, p, q ) ;
		div( arr, q +1, r ) ;
		
		conq( arr, p, q, r ) ;
		}
}

int main(){

	int arr[] = { 5,2,4,7,1,3,2,6 } ;
	
	div( arr, 0, 7 ) ; 

	for( int i = 0; i < 8; i++ ){
		printf( "%d ", arr[ i ] ) ;
	}

	return 0 ;
}
