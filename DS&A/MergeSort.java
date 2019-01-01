package sort;

public class MergeSort {
	
	static void printArray(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(i % 10 == 0) {
				System.out.println("");
			}
			System.out.print(arr[i]+" ");
			i = i + 1;
		}
		System.out.println("");
	}
	
	static void merge(int[] arr, int l, int m, int r) {
		
		int[] temp1 = new int[m - l];
		int[] temp2 = new int[r - m];
		
		for(int index = 0; index < m-l; index ++) 
			temp1[index] = arr[l+index];
		
		for(int index = 0; index < r-m; index ++) 
			temp2[index] = arr[m+index];
		
		int i = 0, j = 0, k = 0;
		
		while(k != r-l) {
			if(i == m - l) 
				arr[l + k] = temp2[j ++];
			
			else if(j == r - m) 
				arr[l + k] = temp1[i ++];
			
			else if(temp1[i] <= temp2[j]) 
				arr[l + k] = temp1[i ++];
			
			else if(temp1[i] > temp2[j]) 
				arr[l + k] = temp2[j ++];
			k ++;
			}
	}
	
	static void mergeSort(int[] arr, int l, int r) {
		
		if(l + 1 < r) {
			mergeSort(arr, l, (l+r)/2);
			mergeSort(arr, (l+r)/2, r);
			merge(arr, l, (l+r)/2, r);
		}
	}
	
	public static void main(String[] arg) {
		
		int[] test1 = {31, 33, 27, 15, 42, 11, 40, 5, 19, 21};
		int[] test2 = {
				98, 34, 100, 36, 44, 64, 3, 99, 59,
				20, 88, 55, 91, 14, 58, 25, 29, 44,
				66, 62, 4, 65, 49, 71, 71, 24, 12,
				14, 3, 58, 23, 12, 66, 11, 45, 36,
				55, 64, 35, 24, 85, 73, 33, 85, 46,
				94, 76, 23, 36, 57, 26, 8, 92, 17,
				85, 68, 52, 34, 53, 93, 4, 37, 34,
				70, 9, 15, 42, 31, 16, 72, 61, 62,
				11, 38, 34, 21, 81, 9, 45, 68, 11,
				20, 83, 27, 6, 69, 26, 5, 31, 8,
				74, 97, 11, 60, 1, 68, 14, 27, 46};
		
		mergeSort(test1, 0, test1.length);
		printArray(test1);

		mergeSort(test2, 0, test2.length);
		printArray(test2);
	}
}
