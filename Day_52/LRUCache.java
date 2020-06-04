package jun_4;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key,value;
	Node next,prev;
	Node(){}
	Node(int key,int value) {
		this.key=key;
		this.value=value;
	}
}
/*
 * Implementation of LRU(Least Recently Used) cache in Java using HashMap and Doubly Linked List
 */
public class LRUCache {
	
	Map<Integer, Node> map;
	int capacity;
	Node head,tail;
	
	LRUCache(int capacity) {
		this.capacity=capacity;
		map=new HashMap<>();
		//initialize dummy head and tail node
		head=new Node();
		tail=new Node();
		//wire them
		head.next=tail;
		tail.prev=head;
		
	}
	
	public int get(int key) {
		if(map.get(key)==null) {
			//key is not present in cache
			return -1;
		}
		//key is present
		Node temp = map.get(key);
		//move to head as this item is recently used
		removeNode(temp);
		offerNode(temp);
		return temp.value;
		
	}
	
	public void put(int key,int value) {
		if(map.containsKey(key)) {
			Node temp=map.get(key);
			temp.value=value;
			//now this item has been recently used
			removeNode(temp);
			offerNode(temp);
		}
		else {
			//check if cache is full
			if(map.size()>=capacity) {
				//we need to remove least recently used item
				map.remove(tail.prev.key);
				removeNode(tail.prev);
			}
			Node newNode = new Node(key,value);
			offerNode(newNode);
			map.put(key,newNode);
		}
	}
	
	public void offerNode(Node newNode) {
		newNode.next=head.next;
		newNode.prev=head;
		head.next.prev=newNode;
		head.next=newNode;
	}
	
	public void removeNode(Node newNode) {
		Node savedPrev = newNode.prev;
		Node savedNext = newNode.next;
		savedPrev.next=savedNext;
		savedNext.prev=savedPrev;
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1, 1);
		cache.put(10, 15);
		cache.put(15, 10);
		cache.put(10, 16);
		cache.put(12, 15);
		cache.put(18, 10);
		cache.put(13, 16);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(10));
		System.out.println(cache.get(15));

	}

}
