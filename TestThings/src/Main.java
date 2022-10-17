public class Main {
    public static void main(String[] args) {
        PostFixConverter pfc = new PostFixConverter("2+2*(4-2)+1");
        String s = pfc.convertExpression();
        double i = pfc.evaluatePostfix();
        System.out.println(i);
    }
}