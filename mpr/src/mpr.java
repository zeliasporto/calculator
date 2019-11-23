import java.util.Scanner;

public class mpr {
    public static void main(String[] args){

        Scanner t = new Scanner(System.in);

        Pilha<Double> num = new Pilha<Double>();
        Pilha<String> op = new Pilha<String>();

        System.out.println("digite a expressão: ");
        String exp = t.nextLine();
        double v1=0, v2=0;

        for (int i=0; i<exp.length(); i++){
            char sim = exp.charAt(i);

            if(sim==' '){}
            else if(sim=='('){
                op.push(String.valueOf(sim));
            }else if(sim=='^'){
                if(op.isEmpty()){
                    op.push(String.valueOf(sim));
                } else {
                    while (op.top().equals("^")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(Math.pow(v1, v2));
                    }
                    op.push(String.valueOf(sim));
                }
            } else if(sim=='*' || sim=='/'){
                if(op.isEmpty()){
                    op.push(String.valueOf(sim));
                } else {
                    while (op.top().equals("*") || op.top().equals("/") || op.top().equals("^")) {
                        if (op.top().equals("*")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 * v2);
                        }
                        if (op.top().equals("/")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 / v2);
                        }
                        if (op.top().equals("^")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(Math.pow(v1, v2));
                        }
                    }
                    op.push(String.valueOf(sim));
                }
            } else if((sim == '+') || (sim == '-')) {
                if(op.isEmpty()){
                    op.push(String.valueOf(sim));
                } else {
                    while (op.top().equals("*") || op.top().equals("/") || op.top().equals("^") || op.top().equals("+") || op.top().equals("-")) {
                        if (op.top().equals("*")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 * v2);
                        }
                        if (op.top().equals("/")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 / v2);
                        }
                        if (op.top().equals("^")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.pop();
                            num.pop();
                            num.push(Math.pow(v1, v2));
                        }
                        if (op.top().equals("+")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 * v2);
                        }
                        if (op.top().equals("-")) {
                            op.pop();
                            v1 = num.top();
                            num.pop();
                            v2 = num.top();
                            num.pop();
                            num.push(v1 - v2);
                        }
                    }
                    op.push(String.valueOf(sim));
                }
            } else if(sim==')') {
                while (!op.top().equals("(")) {
                    if (op.top().equals("^")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(Math.pow(v1, v2));
                    } else if (op.top().equals("*")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(v1*v2);
                    } else if (op.top().equals("/")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(v1 / v2);
                    } else if (op.top().equals("+")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(v1+v2);
                    } else if (op.top().equals("-")) {
                        op.pop();
                        v1 = num.top();
                        num.pop();
                        v2 = num.top();
                        num.pop();
                        num.push(v1-v2);
                    }
                }
                op.pop();
            } else{
                String vl="";
                for(; i<exp.length(); i++){
                    if(Character.isDigit(exp.charAt(i)) || exp.charAt(i)=='.') {
                        vl += Character.toString(exp.charAt(i));
                    } else{
                        i--;
                        break;
                    }
                }
                num.push(Double.parseDouble(vl));
            }
        }
        while(!op.isEmpty()){
            System.out.println("sdakdlçskdld");
            if (op.top().equals("*")) {
                op.pop();
                v1 = num.top();
                num.pop();
                v2 = num.top();
                num.pop();
                num.push(v1*v2);
            } else if (op.top().equals("/")) {
                op.pop();
                v1 = num.top();
                num.pop();
                v2 = num.top();
                num.pop();
                num.push(v1/v2);
            } else if (op.top().equals("^")) {
                op.pop();
                v1 = num.top();
                num.pop();
                v2 = num.top();
                num.pop();
                num.push(Math.pow(v1, v2));
            } else if (op.top().equals("+")) {
                System.out.println("skdjasdkljadlak");
                op.pop();
                v1 = num.top();
                num.pop();
                v2 = num.top();
                num.pop();
                num.push(v1+v2);
            } else if (op.top().equals("-")) {
                op.pop();
                v1 = num.top();
                num.pop();
                v2 = num.top();
                num.pop();
                num.push(v1-v2);
            }
        }
        System.out.println(num.top());
    }
}
