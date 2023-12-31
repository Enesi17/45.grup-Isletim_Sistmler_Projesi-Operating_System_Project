package IsletimSistemleriProje;

public class DoublyLinkedList {
	Node head;
	public int size;	
	public void addLast(Node newNode) {
		if(head == null) {
			head = newNode;
			size++;
		}else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
			size++;			
		}
	}
	
	public void arayaEkle(Node newNode, int suankiZaman) {
		if(head == null) {
			head = newNode;
			size++;
		}
		
		Node current = head;
		while(current.next != null && current.process.varisZamani <= suankiZaman) {
			current = current.next;
		}
		
		if(current.prev != null) {
			current.prev.next = newNode;
			newNode.prev = current.prev;
			newNode.next = current;
			current.prev = newNode;
		}else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			size++;
			curr.next = newNode;
			newNode.prev = curr;
		}
	}
	
	public void deleteNode(Node node) {
		if(node == head) {
			head = node.next;
		}
		node.delete();
	}
	
	public void olumDegeriArttir(DoublyLinkedList p0, DoublyLinkedList p1, DoublyLinkedList p2, DoublyLinkedList p3, int gercekZaman) {
		Node currentP0 = p0.head;
		Node currentP1 = p1.head;
		Node currentP2 = p2.head;
		Node currentP3 = p3.head;
		int kalanSure = 0;
		
		while(currentP0 != null) {
			currentP0.process.olumAdimi += 1;
			
			if(currentP0.process.olumAdimi == 20) {
				kalanSure = currentP0.process.calisacagiSure - currentP0.process.calistigiSure;
				currentP0.process.zamanAsimi(gercekZaman, kalanSure);
				currentP0.delete();
			}else {
				currentP0 = currentP0.next;
			}
		}
		
		while (currentP1 != null) {
            currentP1.process.olumAdimi += 1;

            if (currentP1.process.olumAdimi == 20) {
                kalanSure = currentP1.process.calisacagiSure - currentP1.process.calistigiSure;
                currentP1.process.zamanAsimi(gercekZaman, kalanSure);
                currentP1.delete();
            } else {
                currentP1 = currentP1.next;
            }
        }
		
        while (currentP2 != null) {
            currentP2.process.olumAdimi += 1;

            if (currentP2.process.olumAdimi == 20) {
                kalanSure = currentP2.process.calisacagiSure - currentP2.process.calistigiSure;
                currentP2.process.zamanAsimi(gercekZaman, kalanSure);
                currentP2.delete();
            } else {
                currentP2 = currentP2.next;
            }
        }
        
        while (currentP3 != null) {
            currentP3.process.olumAdimi += 1;
            if (currentP3.process.olumAdimi == 20) {
                kalanSure = currentP3.process.calisacagiSure - currentP3.process.calistigiSure;
                currentP3.process.zamanAsimi(gercekZaman, kalanSure);
                currentP3.delete();
            } else {
                currentP3 = currentP3.next;
            }
        }
	}

	public boolean IsEmpty() {
		if(head == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void sonraki() {
		if(head==null) {
			return;
		}
		head = head.next;
	}
}
