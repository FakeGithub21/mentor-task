import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

enum EXPRESSION_TYPE {
    ARABIC, ROMAN
}
public abstract class Expression {
    protected int leftOperand, rightOperand;
    protected char op;

    protected static final Map<Character, IntBinaryOperator> operations = new HashMap<>();

    static {
        operations.put('+', Integer::sum);
        operations.put('-', (a, b) -> a - b);
        operations.put('*', (a, b) -> a * b);
        operations.put('/', (a, b) -> a / b);
    }

    public abstract Object calc();

}
