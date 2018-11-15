package br.ulbra.operation;

public enum Operator {
    ADDITION {
        @Override
        public Double apply(Double x1, Double x2) {
            return x1 + x2;
        }
    }, 
    SUBTRACTION {
        @Override
        public Double apply(Double x1, Double x2) {
            return x1 - x2;
        }
    },
    MULTIPLICATION {
        @Override
        public Double apply(Double x1, Double x2) {
            return x1 * x2;
        }
    }, 
    DIVISION {
        @Override
        public Double apply(Double x1, Double x2) {
            return x1 / x2;
        }
    };
    
    public static Operator fromString(String operator) {
        Operator op = null;
        
        switch (operator) {
            case "+":
                op = Operator.ADDITION;
                break;
            case "-":
                op = Operator.SUBTRACTION;
                break;
            case "*":
                op = Operator.MULTIPLICATION;
                break;
            case "/":
                op = Operator.DIVISION;
                break;
        }
        
        return op;
    }
    
    public abstract Double apply(Double x1, Double x2);
}
