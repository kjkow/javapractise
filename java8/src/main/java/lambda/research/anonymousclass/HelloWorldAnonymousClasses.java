package lambda.research.anonymousclass;

/**
 * Created by Kamil.Kowalczyk on 2018-03-20.
 */
public class HelloWorldAnonymousClasses {

    private double aValue = 8933.234;

    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    public void sayHello(){

        class EnglishGreeting implements HelloWorld {

            @Override
            public void greet() {
                greetSomeone("World");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("Hello " + someone);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        HelloWorld frenchGreeting = new HelloWorld() {
            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("Salut " + someone);
            }
        };

        HelloWorldAnonymousClasses newClass = new HelloWorldAnonymousClasses(){
            @Override
            public void sayHello() {
                System.out.println("Overriden method!");
                test();
            }

            public void test(){
                System.out.println(aValue);
            }

        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        newClass.sayHello();

    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
