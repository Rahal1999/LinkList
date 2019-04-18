
public class LinkedList {
	
	private Node head;
	private int size;
	
	public LinkedList() {
		super();
		this.head = null;
		this.size = 0;
	}
	
	public boolean empty(){
		return head == null;
	}
	
	public int size(){
		return size;
	}
	
	public void insertAtHead(int data){
		Node newNode = new Node(data, head);//to create a new node 
		head = newNode;//inserts at head
		size++;
	}
	
	public int deleteAtHead(){
		if (empty()) {
			throw new IllegalOperationException(
					"Cannot delete data from an empty Linked List");
		}
		Node deletedNode = head;
		head = head.getLink();
		size--;
		return deletedNode.getData();
	}
	
	public void traverse(){
		if (empty()) {
			throw new IllegalOperationException(
					"Cannot traverse through data from an empty Linked List");
		}
		
		Node current = head;
		
		while(current != null){
			System.out.println(current.getData());
			current = current.getLink();
		}
	}
	
	public void insertAtEnd(int data){
		if (empty()) {
			insertAtHead(data);
		} else {
			Node current = head;
			
			while(current.getLink() != null){
				current = current.getLink();
			}
			
			Node newNode = new Node(data, null);
			current.setLink(newNode);
			
		}
	}
	
	public int deleteAtEnd(){
		if (empty()) {
			throw new IllegalOperationException(
					"Cannot delete data from an empty Linked List");
		} else if (size() == 1){
			return deleteAtHead();
		} else {
			Node current = head;
			Node previous = null;
			while(current.getLink() != null){
				previous = current;
				current = current.getLink();
			}		
			previous.setLink(null);
			return current.getData();
			
		}
	}
	
	public void insertAfter(int after, int data){
		if (empty()) {
			throw new IllegalOperationException(
					"Cannot insert after a given value since linked list is empty...");
		} else {
			Node current = head;
			Node next = head.getLink();
			
			while(next != null && current.getData() != after){
				current = next;
				next = next.getLink();
			}
			
			if (current.getData() == after){
				Node newNode = new Node(data, next);
				current.setLink(newNode);
			} else {
				throw new IllegalOperationException(
						"Cannot find the given value after which new node needs be inserted...");
			}
		}
	}
	
	public int delete(int dataToDelete){
		if (empty()) {
			throw new IllegalOperationException(
					"Cannot delete since linked list is empty...");
		} else {
			Node current = head;
			Node previous = null;
			
			while(current != null && current.getData() != dataToDelete){
				previous = current;
				current = current.getLink();
			}
			
			if (current.getData() == dataToDelete){
				previous.setLink(current.getLink());
			} else {
				throw new IllegalOperationException(
						"Cannot find the given value to be deleted...");
			}
			return current.getData();
		}
		
	}
	

}
