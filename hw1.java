import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class hw1 {

    private static void is_palindrome(String line) {
        int len = line.length();
        for (int i = 0; i < len / 2; i++) {
            if (Character.toLowerCase(line.charAt(i)) != Character.toLowerCase(line.charAt(len - i - 1))) {
                System.out.print("N,");
                return;
            }
        }
        System.out.print("Y,");
    }

    private static void include_str_n(String line, String str1, int n) {
        int count = 0;
        for (int i = 0; i < line.length() - str1.length() + 1; i++) {
            count++;
            for (int j = 0; j < str1.length(); j++) {
                if (Character.toLowerCase(str1.charAt(j)) != Character.toLowerCase(line.charAt(i + j))) {
                    count--;
                    break;
                }
            }
        }
        if (count >= n)
            System.out.print("Y,");
        else
            System.out.print("N,");
    }

    private static void AaBb(String line) {
        int a_count = 0;
        int b_count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = Character.toLowerCase(line.charAt(i));
            if (c == 'a')
                a_count++;
            if (a_count >= 1 && c == 'b')
                b_count++;
            else
                b_count = 0;
            if (b_count >= 2) {
                System.out.println("Y");
                return;
            }
        }
        System.out.println("N");
    }

    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        // For your testing of input correctness

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                // You main code should be invoked here
                is_palindrome(line);
                include_str_n(line, str1, 1);
                include_str_n(line, str2, s2Count);
                AaBb(line);
                //
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// java hw1.java C:/Users/black/Desktop/java/lib/tc1.txt abc b 3

// System.out.println("The input file:"+args[0]);
// System.out.println("str1="+str1);
// System.out.println("str2="+str2);
// System.out.println("num of repeated requests of str2 = "+s2Count);