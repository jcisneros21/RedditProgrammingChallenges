import java.util.*;

class FSM {
  private Wire states[] = { new WhiteWire(), new RedWire(), new BlackWire(),
			     new OrangeWire(), new GreenWire(), new PurpleWire() };
  private String wires[] = { "white", "red", "black", "orange", "green", "purple" };
  public int current;

  public FSM(String wireColor) {
    for (int i = 0; i < wires.length; i++) {
      if (wireColor.contains(this.wires[i])) {
        this.current = i;
      }
    }
  }
  
  public String next(String wireColor) {
    for (int i = 0; i < wires.length; i++) {
      if (wireColor.contains(this.wires[i])) {
        if (states[this.current].getTransition(i)) {
          this.current = i;
          return "Bomb defused";
        }
        else {
          this.current = i;
          return "Boom";
        }
      }
    }
    return "Boom";
  }

}

abstract class Wire {
  private boolean transitions[] = { false, false, false, false, false, false };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class WhiteWire extends Wire {
  private boolean transitions[] = { false, true, false, true, true, true };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); } 
}

class RedWire extends Wire {
  private boolean transitions[] = { false, false, false, false, true, false };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class BlackWire extends Wire {
  private boolean transitions[] = { false, true, true, false, false, true };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class OrangeWire extends Wire {
  private boolean transitions[] = { false, true, true, false, false, false };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class GreenWire extends Wire {
  private boolean transitions[] = { true, false, false, true, false, false };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class PurpleWire extends Wire {
  private boolean transitions[] = { false, true, true, false, false, false };
  public boolean getTransition(int index) { return ((index >= 0 || index <= 5) ? this.transitions[index] : false); }
}

class WireTesting {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String detonated = "Bomb defused";
    String wire;

    wire = input.nextLine();
    FSM wireTest = new FSM(wire);
    while(input.hasNextLine()) {
      wire = input.nextLine();
      if(wire.isEmpty()) {
        break;
      }
      detonated = wireTest.next(wire);
      if(detonated.contains("Boom")) {
        System.out.println();
        break;
      }
    }

    System.out.println(detonated);
    System.exit(0);
  }
}
