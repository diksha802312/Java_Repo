package LLD.LRUCache;

public class DoubleLinkedList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public DoubleLinkedList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node<K, V> node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        head.next.prev = node;
    }

    public void remove(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev=  node.prev;
    }

    public void moveToFront(Node<K, V> node){  //done in get operation or value update operation
        remove(node);
        addFirst(node);
    }

    public Node<K, V> removeLast(){
        if(tail.prev == head) return null;
        Node<K, V> node = tail.prev;
        remove(node);
        return node;
    }
}
