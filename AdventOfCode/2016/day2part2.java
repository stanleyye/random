import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
    	Bathroom b = new Bathroom();
        System.out.println(b.bathroomCode("ULUULLUULUUUUDURUUULLDLDDRDRDULULRULLRLULRUDRRLDDLRULLLDRDRRDDLLLLDURUURDUDUUURDRLRLLURUDRDULURRUDLRDRRLLRDULLDURURLLLULLRLUDDLRRURRLDULRDDULDLRLURDUDRLLRUDDRLRDLLDDUURLRUDDURRLRURLDDDURRDLLDUUDLLLDUDURLUDURLRDLURURRLRLDDRURRLRRDURLURURRRULRRDLDDDDLLRDLDDDRDDRLUUDDLDUURUULDLUULUURRDRLDDDULRRRRULULLRLLDDUDRLRRLLLLLDRULURLLDULULLUULDDRURUDULDRDRRURLDRDDLULRDDRDLRLUDLLLDUDULUUUUDRDRURDDULLRDRLRRURLRDLRRRRUDDLRDDUDLDLUUDLDDRRRDRLLRLUURUDRUUULUDDDLDUULU" + "LLRUDULULLLDRLDDLLUUDRDDDDRUDURDRRUUDDLRRRRURLURLD"
+ "\nLDLUDDLLDDRLLDLDRDDDDDUURUDDDUURLRLRLDULLLDLUDDDULLDUDLRUUDDLUULLDRLDDUDLUDDLURRRLDUURDDRULLURLLRLLUUDRLDDDLDLDRDUDLRDURULDLDRRDRLDLUURRRRLUDDULDULUUUDULDDRLLDDRRUULURRUURRLDUUUDDDDRUURUDRRRDDDDLRLURRRRUUDDDULRRURRDLULRURDDRDRLUDLURDDRDURRUURDUDUDRRDDURRRDURDLUUUURRUDULLDDRLLLURLDUDRRLDDLULUDUDDDDUDLUUULUURUDRURUUDUUURRLDUUDRDRURLLDLLLLLRLLUDURDRRLULRRDDDRLDRDDURLRDULULLDDURURLRRDRULDULUUUURLDURUDUDUDDLUDRRDURULRDULLLDRRDLDLUDURDULULLDDURDDUDRUUUDUDRLDUURDUUUDUURURUDRULRURLDLRDDURDLUU\n" +
"DDLDRLLDRRDRRLLUUURDDULRDUDRDRUDULURLLDDLRRRUDRDLDLURRRULUDRDLULLULLDUUDRLRUDDLRRURRUULRLDLLLDLRLLLURLLLURLLRDDLULLDUURLURDLLDLDUDLDRUUUDDLLDRRRRRUDRURUURRRDRUURDRDDRLDUUULUDUDRUDLLLLDRDRURRRDUUURLDLRLRDDDRLUDULDRLLULRDLDURDLDURUUDDULLULRDDRLRUURLLLURDRUURUUDUUULRDUDDRDURRRDUUDRRRUDRDLRURDLLDDDURLLRRDDDDLDULULDRLDRULDDLRRRLUDLLLLUDURRRUURUUULRRLDUURDLURRLRLLRDLRDDRDDLRDLULRUUUDDDUDRRURDDURURDDUDLURUUURUUUUDURDDLDRDULDRLDRLLRLRRRLDRLLDDRDLDLUDDLUDLULDLLDRDLLRDULDUDDULRRRUUDULDULRRURLRDRUDLDUDLURRRDDULRDDRULDLUUDDLRDUURDRDR\n" +
"URDURRRRUURULDLRUUDURDLLDUULULDURUDULLUDULRUDUUURLDRRULRRLLRDUURDDDLRDDRULUUURRRRDLLDLRLRULDLRRRRUDULDDURDLDUUULDURLLUDLURULLURRRDRLLDRRDULUDDURLDULLDURLUDUULRRLLURURLDLLLURDUDRLDDDRDULLUDDRLDDRRRLDULLLLDUURULUDDDURUULUUUDURUDURDURULLLDRULULDRRLDRLDLRLRUDUDURRLURLRUUDRRDULULDLLDRDRRRDUDUURLDULLLURRDLUDDLDDRDDUDLDDRRRUDRULLURDDULRLDUDDDRULURLLUDLLRLRRDRDRRURUUUURDLUURRDULLRDLDLRDDRDRLLLRRDDLDDDDLUDLRLULRRDDRDLDLUUUDLDURURLULLLDDDULURLRRURLDDRDDLD\n"+
"UDUULLRLUDLLUULRURRUUDDLLLDUURRURURDDRDLRRURLLRURLDDDRRDDUDRLLDRRUDRDRDDRURLULDDLDLRRUDDULLRLDDLRURLUURUURURDLDUDRLUUURRRLUURUDUDUUDDLDULUULRLDLLURLDRUDRLLRULURDLDDLLULLDRRUUDDLRRRUDDLRDRRRULDRDDRRULLLUDRUULURDUDRDLRRLDLRLRLDDULRRLULUUDDULDUDDULRRURLRDRDURUDDDLLRLDRDRULDDLLRLLRDUDDDDDDRLRLLDURUULDUUUDRURRLLRLDDDDRDRDUURRURDRDLLLUDDRDRRRDLUDLUUDRULURDLLLLLRDUDLLRULUULRLULRURULRLRRULUURLUDLDLLUURDLLULLLDDLRUDDRULRDLULRUURLDRULRRLULRLRULRDLURLLRURULRDRDLRRLRRDRUUURURULLLDDUURLDUDLLRRLRLRULLDUUUULDDUUU"));
    }
}

public class Bathroom {
    public String bathroomCode(String s) {
        // split string because each line = 1 number (code)
    	String lines[] = s.split("\\r?\\n");
    	String res = "";
    	String[][] keypad = new String[][]{
            {"0", "0", "1", "0","0"},
            {"0", "2", "3", "4","0"},
            {"5", "6", "7", "8", "9"},
            {"0", "A", "B", "C", "0"},
            {"0", "0", "D", "0", "0"}
        };
        // save previous code
        int[] previousCode = new int[]{2,0};
        for (int x = 0; x < lines.length; x++) {
          	previousCode  = traverseKeypad(lines[x], keypad, previousCode[0], previousCode[1]);
          	res += keypad[previousCode[0]][previousCode[1]];
        }
        return res;
    }

    public int[] traverseKeypad(String movement, String[][] keypad, int startRow, int startCol) {
        int[] lastKey = new int[2];
        for (int m = 0; m < movement.length(); m++) {
            switch (movement.charAt(m)) {
                case 'U':
                	if (startRow > 0 && !keypad[startRow-1][startCol].equals("0")) startRow--;
                	break;
                case 'R':
                	if (startCol < keypad[0].length - 1 && !keypad[startRow][startCol+1].equals("0")) startCol++;
                	break;
                case 'D':
                	if (startRow < keypad.length -1 && !keypad[startRow+1][startCol].equals("0")) startRow++;
                	break;
                case 'L':
                	if (startCol > 0 && !keypad[startRow][startCol-1].equals("0")) startCol--;
                	break;
                default:
                	break;
            }
        }
        lastKey[0] = startRow;
        lastKey[1] = startCol;
        return lastKey;
    }
}