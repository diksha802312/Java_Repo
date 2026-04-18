package LLD.LRUCache;

import java.util.HashMap;

public class LRUCache<K, V> {
    private int capacity;
    private HashMap<K, Node<K, V>> cache;
    private DoubleLinkedList<K, V> doubleLinkedList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public V get(K key){
        if(!cache.containsKey(key)) return null;
        Node<K, V> node = cache.get(key);
        doubleLinkedList.moveToFront(node);
        return node.value;
    }

    public void put(K key, V value){
        if(cache.containsKey(key)){
            Node<K, V> node = cache.get(key);
            node.value = value;
            doubleLinkedList.moveToFront(node);
        }else{
            Node<K, V> newNode = new Node<>(key, value);
            if(cache.size() >= capacity){
                Node<K, V> node = doubleLinkedList.removeLast();
                if(node != null) cache.remove(node.key);
            }else{
                cache.put(key, newNode);
                doubleLinkedList.addFirst(newNode);
            }
        }
    }

    public Node<K, V> remove(K key){
        if(!cache.containsKey(key)) return null;
        Node<K, V> node = cache.get(key);
        doubleLinkedList.remove(node);
        cache.remove(key);
        return node;
    }
}
