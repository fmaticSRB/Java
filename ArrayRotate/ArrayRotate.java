 /***********************************************************
* Author: Filip Matic
* Title: ArrayRotate
* Description: Rotates array by specific amount. 
* Code meant to be generic for any size array and rotation.
 ************************************************************/
import java.util.Arrays;

// Rotate elements in an array
public class ArrayRotate
{
	public static void main(String[] args)
	{
		// Create new array
		int[] Array1 = new int[] {1, 4, 6, 23, 13, 4, 89, 13, 25, 12};

		// print out the array
		System.out.println(Arrays.toString(Array1));

		// Number of rotations
		int R = 4;

		// Create Temp Array
		int[] Temp1 = new int[R];
		for (int j = 0; j<R;j++)
			Temp1[j] = Array1[j];


		// Rotate Int Array
		for (int i = 0; i <= Array1.length-1-R; i++)
			Array1[i] = Array1[i+R];

		// Populate New Array
		for (int k = 0;k<R;k++)
				Array1[Array1.length-R+k] = Temp1[k];

		System.out.println(Arrays.toString(Array1));
	}
}

