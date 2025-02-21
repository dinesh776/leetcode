package Github._282ExpressionAddOperators;
//282. Expression Add Operators
//https://leetcode.com/problems/expression-add-operators/description/
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        backtrack(result, num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String num, int target, int index, long eval, long prev, StringBuilder path) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            int length = path.length();

            if (index == 0) {
                // First number, pick it without any operator
                path.append(curr);
                backtrack(result, num, target, i + 1, curr, curr, path);
                path.setLength(length);
            } else {
                // Addition
                path.append('+').append(curr);
                backtrack(result, num, target, i + 1, eval + curr, curr, path);
                path.setLength(length);

                // Subtraction
                path.append('-').append(curr);
                backtrack(result, num, target, i + 1, eval - curr, -curr, path);
                path.setLength(length);

                // Multiplication
                path.append('*').append(curr);
                backtrack(result, num, target, i + 1, eval - prev + prev * curr, prev * curr, path);
                path.setLength(length);
            }
        }
    }
}
