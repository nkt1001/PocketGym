import java.util.Arrays;

interface Processor{
	public String name();
	//{
		//return getClass().getSimpleName();
	//}
	public Object process(Object obj);
	//{
		//return obj.toString();
	//}
}
class Upcase extends StringProcessor{
	@Override
	public String process(Object obj) {
		return ((String)obj).toUpperCase();
	}
}
class Downcase extends StringProcessor{
	@Override
	public String process(Object obj) {
		return ((String)obj).toLowerCase();
	}
}
class Splitter extends StringProcessor{
	@Override
	public String process(Object obj) {
		// TODO Auto-generated method stub
		return Arrays.toString(((String)obj).split(" "));
	}
}

public class Apply {
	static void process(Processor p, Object o){
		System.out.println("Используем processor " + p.name());
		System.out.println(p.process(o));
	}

}
