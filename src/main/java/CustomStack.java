package main.java;

public class CustomStack {


    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }


    static class Stack<T> {
        private Node<T> top;
        int size;

        public void push(T data) {
            Node<T> newElement = new Node<>(data);
            newElement.next = top;
            top = newElement;
            size++;
        }

        public T pop() {
            if (top == null) {
                return null;
            }
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
    }

}
