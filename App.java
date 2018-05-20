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
			list_1  = App.findWords(file);
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
	
	public static ArrayList<String> findWords(File file) throws FileNotFoundException
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
			ArrayList<String> arr = new ArrayList<String>();
			App.arrToList(line.split(" "), arr);
			for (int i = arr.size() - 1; i > 0; i--)
			{
				if (arr.get(i).equals("") || arr.get(i).equals(","))
				{
					arr.remove(i);
					
				}
			}
			return arr;
		} catch (IOException x) 
		{
			System.err.format("IOException: %s%n", x);
		}
		return null;
		
	}
}
