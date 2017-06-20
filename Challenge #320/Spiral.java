import java.util.Scanner;

public class Spiral {
	
	// Measures the length of an integer
	public int length_of_num(int num){
		String num_string = Integer.toString(num);
		return num_string.length();
	}
	
	// Prints a number of spaces
	public void printSpaces(int number_of_times){
		int i;
		for(i = 0; i < number_of_times; i++){
			System.out.print(" ");
		}
	}
	
	// Prints the Multi-Dimensional Array
	public void printSquaredMultArray(int[][] array){
		//Solving spacing issue
		int squared_array_length = array.length * array.length;
		int squared_number_length = this.length_of_num(squared_array_length);
		
		int i,j;
		for(i=0; i < array.length; i++){
			for(j=0; j <array.length; j++){
				int value_length = this.length_of_num(array[i][j]);
				this.printSpaces(squared_number_length - value_length); 
				System.out.print(Integer.toString(array[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	public void createSpiral(int num){
		
		// Base Case
		if(num == 1){
		  System.out.println(num);
		  return;
		}
		
		int[][] spiral_array = new int[num][num];
		int square_num = num * num;
		
		// index limits
		int low_limit = 0;
		int high_limit = num-1;
		
		// indexes
		int first_index = 0;
		int second_index = 0;
		
		// Could be 1 or -1
		int added_num = 1;
		
		// Alternates the index to add the number
		int added_index = 1;
		
		int i = 1;
		while(i != (square_num + 1)){
	
			spiral_array[first_index][second_index] = i;
			
			// decrease the limits
			if(first_index == low_limit + 1 && second_index == low_limit){
				low_limit += 1;
				high_limit -= 1;
				
				first_index = low_limit;
				second_index = low_limit;
				added_num = 1;
				added_index = 1;
				i++;
				continue;
			}
			else if(first_index == low_limit && second_index == high_limit){
				added_num = 1;
				added_index = 0;
			}
			else if(first_index == high_limit && second_index == high_limit){
				added_num = -1;
				added_index = 1;
			}
			else if(first_index == high_limit && second_index == low_limit){
				added_num = -1;
				added_index = 0;
			}
			
			
			if(added_index == 0){
				first_index += added_num;
			}
			else{
				second_index += added_num;
			}
			
			i++;
		}
		
		this.printSquaredMultArray(spiral_array);
	}
	 
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("WELCOME TO SPIRAL!");
		System.out.print("Please enter a number: ");
		
		int user_num = scan.nextInt();
		System.out.println();
		
		Spiral spiral = new Spiral();
		spiral.createSpiral(user_num);
	}
}
