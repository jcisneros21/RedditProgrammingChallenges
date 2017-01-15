import java.util.Scanner;

class DeleteParenthese {
  
  private String line;

  DeleteParenthese(String line) {
    this.line = line;
  }
  
  // Returns new line with no extra Paratheses
  public String deleteExtra() {
    System.out.println(this.line);
    System.out.println();
    return "hello";
  }
}

class ExtraParenthese {

  public static void main(String[] args) {
    System.out.println("Hello User!\n");
   
    Scanner sc = new Scanner(System.in);
    String input;
    DeleteParenthese modify;

    while(true) {
      input = sc.nextLine();
      
      if(input.isEmpty()) {
        break;
      }
      else {
        modify = new DeleteParenthese(input);
        modify.deleteExtra();
      }
    }
    
    sc.close();
  }
}
