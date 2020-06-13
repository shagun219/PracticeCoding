package rxJava;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;


public class MapOperators {

    public static void main(String []args) {
        Observable<Integer> observable = Observable.just(83,104,97,103,117,110);
        //Map Operator
        observable.map(MapOperators::getASCIIChar)
                .subscribe(getCharSubscirber());
        //Given a number emit it's digits
        //Does not maintain order - can be seen for async network calls within returned observable
        observable.flatMap(MapOperators::emitDigits)
                .subscribe(getIntSubscirber());
        //Given a number emit it's digits
        //Maintains order - can be seen for async network calls within returned observable
        observable.concatMap(MapOperators::emitDigits)
                .subscribe(getIntSubscirber());
    }

    private static Character getASCIIChar(int i) {
        return (char)i;
    }

    private static Subscriber<Character> getCharSubscirber() {
        Subscriber<Character> s = new Subscriber<Character>() {
            @Override public void onCompleted() {
                System.out.println("\nCompleted");
            }

            @Override public void onError(final Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override public void onNext(final Character character) {
                System.out.print(character);
            }
        };
        return s;
    }

    private static Observable<Integer> emitDigits(Integer num) {
        List<Integer> digits = new ArrayList<>();
        while(num > 0) {
            digits.add(num%10);
            num = num/10;
        }
        Observable<Integer> ob = Observable.from(digits);
        return ob;
    }

    private static Subscriber<Integer> getIntSubscirber() {
        Subscriber<Integer> s = new Subscriber<Integer>() {
            @Override public void onCompleted() {
                System.out.println("\nCompleted");
            }

            @Override public void onError(final Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override public void onNext(final Integer num) {
                System.out.print(num);
            }
        };
        return s;
    }
}
