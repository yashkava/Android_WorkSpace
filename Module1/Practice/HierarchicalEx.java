package pra88;



	class Bank
	{
		void bank()
		{
			System.out.println("BANKING");
		}
	}
	class Current extends Bank
	{
		void current()
		{
			System.out.println("CURRENT ACCOUNT");
		}
	}
	class Save extends Bank
	{
		void save()
		{
			System.out.println("SAVING ACCOUNT");
		}
	}

	public class HierarchicalEx 
	{
		
		public static void main(String[] args) 
		{
			Current c =new Current();
			Save s =new Save();
			
			s.bank();
			c.current();
			s.save();
			
		}
}
