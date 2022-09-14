package modelTest;

// import java.util.Map;

public class ModelTest {

	public static void main(String[] args) {
		int length = args.length;
		for (int i=0; i<length; i++){ 
			String arg = args[i];
			System.out.println(arg);
		} 
		// Map<String, String> env = System.getenv();
        // for (Map.Entry<String, String> entry : env.entrySet()) {
        //     String key = entry.getKey();
        //     String value = entry.getValue();
        //     System.out.println(key + " : " + value);
        // }
	}
}
