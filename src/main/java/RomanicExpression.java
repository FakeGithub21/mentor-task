public class RomanicExpression extends Expression {

    RomanicExpression(int left,char op, int right){
        leftOperand=left;
        this.op=op;
        rightOperand=right;
    }

    @Override
    public Object calc() {
        if(op=='/' && rightOperand==0) // Ну вообще 0 оказывается же запрещен
            throw new ArithmeticException("деление на 0");
        int rowVal = operations.get(op).applyAsInt(leftOperand, rightOperand);
        return RomanicConverter.convertToRoman(rowVal);
    }
}
