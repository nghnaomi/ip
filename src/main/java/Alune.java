import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alune {
    public static void main(String[] args) {
        String logo = "\n   _      _      _      _      _      _   \n"
                + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ \n"
                + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)\n"
                + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) \n"
                + "   _                                  _   \n"
                + " _( )_         _                    _( )_ \n"
                + "(_ o _)   __ _| |_   _ _ __   ___  (_ o _)\n"
                + " (_,_)   / _` | | | | | '_ \\ / _ \\  (_,_) \n"
                + "   _    | (_| | | |_| | | | |  __/    _   \n"
                + " _( )_   \\__,_|_|\\__,_|_| |_|\\___|  _( )_ \n"
                + "(_ o _)                            (_ o _)\n"
                + " (_,_)                              (_,_) \n"
                + "   _      _      _      _      _      _   \n"
                + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ \n"
                + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)\n"
                + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) \n";

        System.out.println(logo + "\n\nhi i'm alune~ what can i do for you? (⸝⸝ᵕᴗᵕ⸝⸝)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");

        
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();
        
        while (true) {
            System.out.println("\n\nenter: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("list")) {
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nyour tasks: ᕙ( •̀ ᗜ •́ )ᕗ");
                int num = 1;
                if (tasks.size() == 0) {
                    System.out.println("no tasks recorded~");
                } else {
                    for (String task : tasks) {
                        System.out.println(num + ". " + task);
                        num++;
                    }
                }
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.equals("bye")) {
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nbye, see you again~ ꉂ(˵˃ ᗜ ˂˵)" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
                break;
            } else {
                tasks.add(input);
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nadded: " + input + " („• ֊ •„)੭" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            }
        }
        
        scanner.close();
    }
}
