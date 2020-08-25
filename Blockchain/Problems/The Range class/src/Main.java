import java.io.IOException;
import java.io.Serializable;

/**
    Represents inclusive integer range.
*/
class Range implements Serializable {

	private static final long serialVersionUID = 1L;

	/** @serial */
	private final int from;
	/** @serial */
	private final int to;

	/**
	 * Creates Range.
	 * 
	 * @param from start 
	 * @param to end
	 * @throws IllegalArgumentException if start is greater than end. 
	 */
	public Range(int from, int to) {
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
		this.from = from;
		this.to = to;
	}

	private void writeObject (java.io.ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
	}

	private void readObject (java.io.ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		/*int from = (int) ois.readObject();
		int to = (int) ois.readObject();*/
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

}