package IsletimSistemleriProje;

public class Node {
		
		Process process;
		Node next;
		Node prev;
		
		public Node(Process process) {
			this.process = process;
			this.next = null;
			this.prev = null;
		}
		
		public void delete() {
			if(prev != null) {
				prev.next = next;
			}
			
			if(next != null) {
				next.prev = prev;
			}
		}
}

