package proxy;

public class MyService implements Service {

    @Override
    public void viewPage() {
        System.out.println("MyService has been accessed.");
    }
}
