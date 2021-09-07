package my.learning.dsa;

public class QuickSort {

	public static void quickSort(int[] array, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex) {
			int partitionIndex = partition(array, firstIndex, lastIndex);
			quickSort(array, firstIndex, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, lastIndex);
		}
	}

	private static int partition2(int[] a, int beg, int end) {
		int left, right, temp, loc, flag;
		loc = left = beg;
		right = end;
		flag = 0;
		while (flag != 1) {
			while ((a[loc] <= a[right]) && (loc != right))
				right--;
			if (loc == right)
				flag = 1;
			else if (a[loc] > a[right]) {
				temp = a[loc];
				a[loc] = a[right];
				a[right] = temp;
				loc = right;
			}
			if (flag != 1) {
				while ((a[loc] >= a[left]) && (loc != left))
					left++;
				if (loc == left)
					flag = 1;
				else if (a[loc] < a[left]) {
					temp = a[loc];
					a[loc] = a[left];
					a[left] = temp;
					loc = left;
				}
			}
		}
		return loc;
	}

	// values less than pivot should move left and others move right
	// so now pivot is at right sorted position
	private static int partition(int[] array, int firstIndex, int lastIndex) {

		int temp;
		int loc = firstIndex;
		boolean continueOuterLoop = true;
		while (continueOuterLoop) {
			
			// Start from the last index
			while ((array[lastIndex] >= array[loc]) && (loc != lastIndex)) {
				lastIndex--;
			}

			if (loc == lastIndex) {
				continueOuterLoop = false; // we find the partition index
			} else if (array[lastIndex] < array[loc]) {
				// swap
				temp = array[lastIndex];
				array[lastIndex] = array[loc];
				array[loc] = temp;
				loc = lastIndex;
			}
			if (continueOuterLoop) {
				while ((array[firstIndex] <= array[loc]) && (loc != firstIndex)) {
					firstIndex++;
				}

				if (loc == firstIndex)
					continueOuterLoop = false;
				else if (array[firstIndex] > array[loc]) {
					temp = array[firstIndex];
					array[firstIndex] = array[loc];
					array[loc] = temp;
					loc = firstIndex;
				}

			}
		}

		return loc; // it gives partitionIndex
	}

	public static void main(String[] args) {
		int i;
		int[] arr={90,23,101,45,65,23,67,89,34,23};
		//int[] arr = { 90, 23, 100, 65 };
		quickSort(arr, 0, 9);
		System.out.println("\n The sorted array is: \n");
		for (i = 0; i < 10; i++)
			System.out.println(arr[i]);
	}
}
