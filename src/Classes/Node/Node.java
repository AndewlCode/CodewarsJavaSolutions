package Classes.Node;

public class Node {
    // данные
    int data;
    // указатель на следующий узел
    Node next;

    public Node(int data) {
        this.data = data;
        // когда мы создаем узел, ссылка на следующий элемент будет null, так как он еще пуст
        this.next = null;
    }
}
