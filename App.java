import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args)
	{
		String[] x = {"1", "2", "3"};
		List<String> list = new ArrayList<String>();
		System.out.println(list);
		App.arrToList(x, list);
		System.out.println(list);
		
		File file = new File("D://test_1.txt");
		try {
			List<String> list_1 = new ArrayList<String>();
			App.arrToList(App.findWords(file), list_1);
			System.out.println(list_1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Testthreads t = new Testthreads();
		

	}

	
	public static<T> void arrToList (T[] arr, List<T> list)
	{
		for(int i = 0; i < arr.length; i++)
		{
			list.add(arr[i]);
		}
	}
	
	public static String[] findWords(File file) throws FileNotFoundException
	{
		FileReader r = new FileReader(file);
		String line = "";
		try (BufferedReader reader = new BufferedReader(r)) 
		{
			String l = "";
			while ((l = reader.readLine()) != null) 
			{
				line = line + l;
			}
			line = line.replaceAll("[^A-Za-z0-9]", " ");
			return line.split(" ");
		} catch (IOException x) 
		{
			System.err.format("IOException: %s%n", x);
		}
		return null;
		
	}
}
