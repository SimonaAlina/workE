/*
 * TODO HW:
 * implements a stack collection only for Numbers with same functionalities 
 * and adds a maxElement function that return the higher element from stack
 */
public class EndavaStack<T extends Number> {

	private T head;
	private EndavaStack<T> tail = null;

	public EndavaStack(T... elem) {
		head = elem[0];
		for (int i = 1; i < elem.length; i++) {
			this.push(elem[i]);
		}
	}

	public EndavaStack(T head) {
		this.head = head;
	}

	public T getHead() {
		return head;
	}

	public void push(T elem) {
		if (tail == null) {
			tail = new EndavaStack<T>(head);
		} else {
			tail.push(head);
		}
		head = elem;
	}

	public T pop() {
		T h = head;
		if (tail != null) {
			head = tail.head;
			tail = tail.tail;
		}
		return h;
	}

	public int size() {
		if (tail != null) {
			head = tail.getHead();
			tail = tail.getTail();
			return 1 + size();
		}
		return 1;
	}

	public Number maxElement() {
		T maxElem = head;
		while (tail != null) {
			if (maxElem.intValue() < tail.getHead().intValue())
				maxElem = tail.getHead();
			tail = tail.getTail();
		}
		return maxElem;
	}

	public String toString() {
		if (tail == null)
			return head.toString();
		else
			return head + " " + tail;
	}

	public void setHead(T head) {
		this.head = head;
	}

	public EndavaStack<T> getTail() {
		return tail;
	}

	public void setTail(EndavaStack<T> tail) {
		this.tail = tail;
	}
}
