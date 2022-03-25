package task4.list;

import lombok.Getter;

public class List<T>{

    private final ListNode<T> listHead;
    @Getter
    private int size;

    public List(T value){
        listHead = new ListNode<>(value);
        size = 1;
    }

    public void addElement(T value){
        ListNode<T> lastElement = findLastElement();
        lastElement.setNext(new ListNode<>(value));
        size++;
    }

    public ListNode<T> getListElement(int idx){
        ListNode<T> tmp = listHead;
        int counter = 0;
        while (counter != idx){
             tmp = tmp.getNext();
             counter++;
        }
        return tmp;
    }

    public void printList(){
        ListNode<T> tmp = listHead;
        System.out.println("LIST:");
        while (tmp != null){
            System.out.print(tmp.getValue() + "; ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    private ListNode<T> findLastElement(){
        ListNode<T> tmp = listHead;
        while (tmp.getNext() != null){
            tmp = tmp.getNext();
        }
        return tmp;
    }
}
