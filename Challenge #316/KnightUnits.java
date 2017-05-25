public class KnightUnits {

  public int maxAxis(int x, int y){
    return (x > y) ? 0 : 1;
  }

  public int otherIndex(int index){
    return (index > 0) ? 0 : 1;
  }

  public boolean isEven(int num){
    return ((num % 2) > 0) ? false : true;
  }

  public int numberOfMoves(int end_x, int end_y){
    int[] start_coordinates = new int[2];
    int[] end_coordinates = new int[2];

    start_coordinates[0] = 0;
    start_coordinates[1] = 0;
    end_coordinates[0] = end_x;
    end_coordinates[1] = end_y;

    int highIndex = this.maxAxis(end_x, end_y);
    int lowIndex = this.otherIndex(highIndex);
    boolean isAxisEven = this.isEven(end_coordinates[highIndex]);

    int times = 0;
    if(isAxisEven == false){
      start_coordinates[highIndex] += 1;
      start_coordinates[lowIndex] += 2;
      times++;
    }

    System.out.println("(" + Integer.toString(start_coordinates[0]) + "," + Integer.toString(start_coordinates[1]) + ")");

    while(start_coordinates[0] != end_coordinates[0] || start_coordinates[1] != end_coordinates[1]){

      if(start_coordinates[highIndex] <= end_coordinates[highIndex] && start_coordinates[lowIndex] <= end_coordinates[lowIndex]){
        start_coordinates[highIndex] += 2;
        start_coordinates[lowIndex] += 1;
      }
      else if(start_coordinates[highIndex] <= end_coordinates[highIndex] && start_coordinates[lowIndex] >= end_coordinates[lowIndex]){
        start_coordinates[highIndex] += 2;
        start_coordinates[lowIndex] -= 1;
      }
      else if(start_coordinates[highIndex] >= end_coordinates[highIndex] && start_coordinates[lowIndex] <= end_coordinates[lowIndex]){
        start_coordinates[highIndex] -= 1;
        start_coordinates[lowIndex] += 2;
      }
      else{
        start_coordinates[highIndex] -= 1;
        start_coordinates[lowIndex] -= 2;
      }

      System.out.println("(" + Integer.toString(start_coordinates[0]) + "," + Integer.toString(start_coordinates[1]) + ")");
      times++;
    }

    return times;
  }

  public static void main(String[] args){

    KnightUnits testKnight = new KnightUnits();

    int test_x = 240;
    int test_y = 449;

    int moves = testKnight.numberOfMoves(test_x,test_y);
    System.out.println("This is the number of moves for (" + Integer.toString(test_x) +
                       "," + Integer.toString(test_y) + ") : " + Integer.toString(moves));
  }
}
