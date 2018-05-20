public class Testthreads {
	
	IncrementSynchronize s = new IncrementSynchronize(); 

	public Testthreads()
	{
		Runnable r1 = () -> {
			for (int i = 0; i < 1000; i++)
			{
				s.getNextValue1();
			}
			System.out.println(s.getValue());
		};
		Runnable r2 = () -> {
			for (int i = 0; i < 1000; i++)
			{
				s.getNextValue2();
			}
			System.out.println(s.getValue());
		};
		Runnable r3 = () -> {
			for (int i = 0; i < 1000; i++)
			{
				s.getNextValue3();
			}
			System.out.println(s.getValue());
		};
		Thread tr1 = new Thread(r1);
		tr1.start();
		Thread tr2 = new Thread(r2);
		tr2.start();
		Thread tr3 = new Thread(r3);
		tr3.start();
		try {
			tr1.join();
			tr2.join();
			tr3.join();
			System.out.println(s.getValue());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
