package task4.list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T> {

    private T value;

    private ListNode<T> next;

    public ListNode(T value){
        this.value = value;
        next = null;
    }

    public void print(){
        System.out.println(value);
    }
}
