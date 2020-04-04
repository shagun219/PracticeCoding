package StacksNQueues;

public class AnimalShelter<T extends Animal> {

    private static class QueueNode<T> {
        T data;
        QueueNode prev;
        QueueNode next;

        public QueueNode(T data) {
            this.data = data;
            this.prev =null;
            this.next = null;
        }
    }

    QueueNode<T> start = null;
    QueueNode<T> end = null;
    QueueNode<T> dogStart = null;
    QueueNode<T> catStart = null;

    public void enqueue(T animal) {
        QueueNode<T> n = new QueueNode<>(animal);
        if(start == null) {
            start = n;
            end = n;
            if(animal instanceof Dog) {
                dogStart = n;
            }
            else {
                catStart = n;
            }
        }
        else {
            n.prev = end;
            end = n;
        }
    }

    public T dequeueAny() throws NoSuchFieldException {
        if(start == null) {
            throw new NoSuchFieldException("No animal found");
        }
        T animal = start.data;
        if(start == dogStart) {
            findAndResetToNextDog(dogStart);
        }
        else {
            findAndResetToNextCat(catStart);
        }
        start = start.next;
        start.prev = null;
        return animal;
    }

    public Dog dequeueDog() throws NoSuchFieldException {
        if(dogStart == null) {
            throw  new NoSuchFieldException("No Dogs available");
        }
        QueueNode<T> currentDog = dogStart;
        findAndResetToNextDog(dogStart);
        currentDog.prev.next = currentDog.next;
        currentDog.next.prev = currentDog.prev;

        return (Dog)currentDog.data;

    }

    public Cat dequeueCat() throws NoSuchFieldException {
        if(catStart == null) {
            throw  new NoSuchFieldException("No Dogs available");
        }
        QueueNode<T> currentCat = catStart;
        findAndResetToNextDog(catStart);
        currentCat.prev.next = currentCat.next;
        currentCat.next.prev = currentCat.prev;

        return (Cat)currentCat.data;

    }
    private void findAndResetToNextDog(QueueNode<T> dogStart) {
        QueueNode<T> runner = dogStart.next;
        while(runner != null && !(runner.data instanceof Dog)) {
            runner = runner.next;
        }
        dogStart = runner;
    }

    private void findAndResetToNextCat(QueueNode<T> catStart) {
        QueueNode<T> runner = catStart.next;
        while(runner != null && !(runner.data instanceof Cat)) {
            runner = runner.next;
        }
        catStart = runner;
    }
}
