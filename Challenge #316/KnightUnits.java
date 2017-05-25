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

    if(isAxisEven == false){
      start_coordinates[highIndex] += 1;
      start_coordinates[lowIndex] += 2;
    }

    int times = 0;
    while((start_coordinates[0] != end_coordinates[0]) && (start_coordinates[1] != end_coordinates[1])){
      times++;
    }

    return times;
  }

  public static void main(String[] args){

    KnightUnits testKnight = new KnightUnits();

    int test = 0;

    test = 4;
    System.out.println("Passing in 4, is 4 even : " + testKnight.isEven(test));

    test = 3;
    System.out.println("Passing in 3, is 3 even : " + testKnight.isEven(test));


  }
}
