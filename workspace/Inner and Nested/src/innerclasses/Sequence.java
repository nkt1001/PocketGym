package innerclasses;
interface Selector{
	boolean end();
	Object current();
	void next();
}
public class Sequence {
	private Object[] objects;
	private int next = 0;
	public Sequence(int size){objects = new Object[size];}
	public void add(Object o){
		if(next < objects.length)
			objects[next++] = o;
	}
	private class SequenceSelector implements Selector{
		private int i=0;
		public boolean end() {
			return i==objects.length;
		}
		public Object current() {
			return objects[i];
		}
		public void next() {
			if(i < objects.length)
				i++;
		}
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++){
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current());
			selector.next();
		}
	}
}