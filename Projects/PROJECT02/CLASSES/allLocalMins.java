
// A Java program to find a local minima in an array 
import java.io.*; 

class allLocalMins { 
	
	// A binary search based function that returns 
	// index of a local minima. 
	public static int localMinUtil(int[] arr, int low, int high, int n) { 
		
		System.out.println("oh yes ");
		// Find index of middle element 
		int mid = low + (high - low) / 2; 
		
		// Compare middle element with its neighbours 
		// (if neighbours exist) 
		if(mid == 0 || arr[mid - 1] > arr[mid] && mid == n - 1 || 
		arr[mid] < arr[mid + 1]) 
				return mid; 
		
		// If middle element is not minima and its left 
		// neighbour is smaller than it, then left half 
		// must have a local minima. 
		else if(mid > 0 && arr[mid - 1] < arr[mid]) 
				return localMinUtil(arr, low, mid - 1, n); 
		
		// If middle element is not minima and its right 
		// neighbour is smaller than it, then right half 
		// must have a local minima. 
		return localMinUtil(arr, mid + 1, high, n); 
	} 
	
	// A wrapper over recursive function localMinUtil() 
	public static void localMin(int[] arr, int n){ 
		
		boolean flag = true;
		int x = localMinUtil(arr, 0, n - 1, n);
		System.out.println("index is " +x);
		int y = 0; 
		
		while(flag == true){

			x  = localMinUtil(arr, x+1, n - 1, n);
			y = y+x;
			System.out.println("index is " +y);
			System.out.println("length is "+arr.length);
			if(x < n-1)
				flag = false;

		}
	} 
	
	
	public static void main (String[] args){ 
		
		int arr[] = {4, 1, 5, 2, 16, 40,77,100,99,555,100,1000}; 
		int n = arr.length; 
		localMin(arr, n); 
	} 
} 

//This code is contributed by Dheerendra Singh 
