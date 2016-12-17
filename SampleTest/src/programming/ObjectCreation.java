package programming;

public class ObjectCreation {
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException{
		//by new keyword
		ObjectCreation obj1 = new ObjectCreation();
		// by classname
		//ObjectCreation obj2 = (ObjectCreation) Class.forName("scr.programming.ObjectCreation").newInstance();
		
		// by clone 
		ObjectCreation obj = new ObjectCreation();
		ObjectCreation obj3 = (ObjectCreation) obj.clone();
		System.out.println(obj1);
		//System.out.println(obj3);
	}
}
