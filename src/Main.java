import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Digite a quantidade de strings: ");
        int stringsAmount = keyboard.nextInt();
        keyboard.nextLine();

        for (int i = 0; i < stringsAmount; i++) {
            System.out.print("Digite a " + (i + 1) + "º string: ");
            String input = keyboard.nextLine().replace(" ", "");

            if (input.length() > 255) {
                throw new IllegalArgumentException("A String deve conter até 255 caracteres");
            }

            boolean isBalanced = true;
            Stack<Character> characters = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '(' || c == '[') {
                    characters.push(c);
                } else if (c == ')' && !characters.isEmpty() && characters.peek() == '(') {
                    characters.pop();
                } else if (c == ']' && !characters.isEmpty() && characters.peek() == '[') {
                    characters.pop();
                } else {
                    isBalanced = false;
                }
            }
            isBalanced = input.length() == 1 ? false : isBalanced;
            String isBalancedString = isBalanced ? "Yes" : "No";
            System.out.println(isBalancedString);
        }

        keyboard.close();
    }
}