public abstract class StringProcessor implements Processor {
	public static String s = "If she weighs same as duck she's made of wood";
	public String name() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

	@Override
	public abstract Object process(Object obj);
	public static void main(String[] args) {
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}

}
