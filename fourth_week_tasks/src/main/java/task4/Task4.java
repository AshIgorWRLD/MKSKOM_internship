package task4;

import task4.list.List;

public class Task4 {


    public List<String> createFillList(){
        List<String> list = new List<>("AAA");
        list.printList();
        list.addElement("RTY");
        list.addElement("FGH");
        list.addElement("VBN");
        list.printList();
        return list;
    }

    public void doTask(){
        List<String> list = createFillList();
        list.getListElement(0).print();
        list.getListElement(3).print();
    }
}
