package sort;
public class BucketSort {
	
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
	
	static void bucketSort(int[]arr) {
			int max = 0;
			int output[] = new int[arr.length];
			
			for(int i = 0; i < arr.length; i ++) {
				if(max < arr[i])
					max = arr[i];
			}
			
			int temp[] = new int[max+1];
			
			for(int i = 0; i < max+1; i ++) {
				temp[i] = 0;
			}
			
			for(int i = 0; i < arr.length; i ++) {
				temp[arr[i]] ++;
			}
			
			for(int i = 1; i < max+1; i ++) {
				temp[i] = temp[i] + temp[i-1];
			}
			
			for(int i = arr.length - 1; i >= 0; i --) {
				output[temp[arr[i]] - 1] = arr[i];
				temp[arr[i]] --;
			}
			
			printArray(output);
	}
	
	
	
	public static void main(String[] arg) {
		int[] Test1 = {31, 33, 27, 15, 42, 11, 40, 5, 19, 21};
		int[] Test2 = {
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
		bucketSort(Test1);
		bucketSort(Test2);
	}
}
	

