public class ArabicExpression extends Expression {

    ArabicExpression(int left,char op, int right){
        leftOperand=left;
        this.op=op;
        rightOperand=right;
    }

    @Override
    public Object calc() {
        if(op=='/' && rightOperand==0) // Ну вообще 0 оказывается же запрещен
            throw new ArithmeticException("деление на 0");
        return operations.get(op).applyAsInt(leftOperand, rightOperand);
    }
}
