import org.mariuszgromada.math.mxparser.Expression;

import java.math.BigDecimal;

public class ParserDemo {
    public static void main(String[] args) {
        Expression expression = new Expression("sin(rad(30))");
        BigDecimal ans= new BigDecimal(expression.calculate()).stripTrailingZeros();
        System.out.println(""+ans);
    }
}
