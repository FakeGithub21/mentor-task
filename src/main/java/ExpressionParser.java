import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class ExpressionParser {

    private static final Set<Character> operationSet = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    private static int parseArabic(String val) {
        if (val.matches("-?(0|[1-9]\\d*)"))
            return Integer.parseInt(val);
        else
            throw new IllegalArgumentException("Неправильный формат входной строки");
    }

    private static int parseRoman(String val) {
        try {
            return RomanicConverter.convertToInt(val);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static int parserInt(String val, EXPRESSION_TYPE type) {
        try {
            switch (type) {
                case ARABIC: return parseArabic(val);
                case ROMAN:  return parseRoman(val);
                default: throw new Exception("NOT IMPLEMENTED FORMAT");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Неправильный формат входной строки");
        }
    }

    private static EXPRESSION_TYPE getType(char c){
        return Character.isDigit(c)?EXPRESSION_TYPE.ARABIC:EXPRESSION_TYPE.ROMAN;
    }

    private static void checkNum(int val){
        if(val<1 || val>10)
            throw new IllegalArgumentException("Неправильный формат входной строки");
    }

    private static int getEndLeftIndex(String exp){
        for (int i = 0; i < exp.length(); i++) {
            if (operationSet.contains(exp.charAt(i))) {
                return i-1;
            }
        }
        return -1;
    }

    public static Expression parse(String exp) {
        int leftNumIndex = getEndLeftIndex(exp);
        char operation;
        if (leftNumIndex == -1 || leftNumIndex >= (exp.length() - 2) )
            throw new IllegalArgumentException("Неправильный формат входной строки");

        EXPRESSION_TYPE type=getType(exp.charAt(0));

        int leftOperand = parserInt(exp.substring(0, leftNumIndex+1),type);
        checkNum(leftOperand);

        operation=exp.charAt(leftNumIndex+1);

        int rightOperand = parserInt(exp.substring(leftNumIndex+2),type);
        checkNum(rightOperand);

        return type==EXPRESSION_TYPE.ARABIC?new ArabicExpression(leftOperand,operation,rightOperand):new RomanicExpression(leftOperand,operation,rightOperand);
    }

}
