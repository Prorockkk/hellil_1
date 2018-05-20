public class IncrementSynchronize {
		private int value = 0;
		Object x = new Object();
		
		public void getNextValue1()
		{
			synchronized (x)
			{ 
				value++;
			}
		}
		public void getNextValue2()
		{
			synchronized (x)
			{ 
				value++;
			}
		}
		public void getNextValue3()
		{
			synchronized (x)
			{ 
				value++;
			}
		}
		public int getValue()
		{
			return value;
		}
	}