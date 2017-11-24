public class text {
    public static void main(String[] args) {
        Superbox<Integer> abc = new Superbox<Integer>(3);
        abc.change(3,5);
        abc.add(6);
        abc.print();
        if (abc.findelement(5)) System.out.println("沙迪克");
    }
}
