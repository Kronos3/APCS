
public class WorkerTester 
{
	public static void main(String[] args) 
	{
		Worker worker1 = new SalariedWorker ("Joe", 13.5);
		System.out.println(worker1);
		System.out.printf("works 12 hours: $%.2f\n", ((SalariedWorker)worker1).computePay(12));
		System.out.printf("works 45 hours: $%.2f\n", ((SalariedWorker)worker1).computePay(45));
		System.out.println();
		
		Worker worker2 = new HourlyWorker ("Jim", 13.5);
		System.out.println(worker2);
		System.out.printf("works 12 hours: $%.2f\n", ((HourlyWorker)worker2).computePay(12));
		System.out.printf("works 45 hours: $%.2f\n", ((HourlyWorker)worker2).computePay(45));
	}

}
