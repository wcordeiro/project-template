import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		Parser parser = new Parser();
		try {
			parser.parseJsonFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
