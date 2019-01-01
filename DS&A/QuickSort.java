package sort;

public class QuickSort{
	
	static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
	
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
	
	static void quickSort(int[] arr, int l, int r) {
		int i = l;
		int j = l;
		int k = r;
		
		if(r - l > 1){
			int pivot = arr[r/2 + l/2];//select a pivot value
			
			while(j != k) {
				if(arr[j]<pivot) {
					swap(arr, i, j);
					i++;
					j++;
				}
				else if(arr[j] == pivot) {
					j++;
				}
				else if(arr[j] > pivot) {
					swap(arr, j, k-1);
					k--;
				}
			}
			
			quickSort(arr, l, i);
			quickSort(arr, k, r);
		}	
	}
	

	
	
	public static void main(String args[]){
		int test1[] = {31, 33, 27, 15, 42, 11, 40, 5, 19, 21};
		int[] test2 = {98, 34, 100, 36, 44, 64, 3, 99, 59,
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
		quickSort(test1, 0, test1.length);
		printArray(test1);
		quickSort(test2, 0, test2.length);
		printArray(test2);
		

    }
}




