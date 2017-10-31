
public class WorkerTester 
{
	public static void main(String[] args) 
	{	
		Worker worker1 = new SalariedWorker ("Joe", 13.5);
		System.out.println(worker1);
		System.out.printf("works 12 hours: $%.2f\n", worker1.computePay(12));
		System.out.printf("works 45 hours: $%.2f\n", worker1.computePay(45));
		System.out.println();
		
		Worker worker2 = new HourlyWorker ("Jim", 13.5);
		System.out.println(worker2);
		System.out.printf("works 12 hours: $%.2f\n", worker2.computePay(12));
		System.out.printf("works 45 hours: $%.2f\n", worker2.computePay(45));
		System.out.println();

		Worker worker3 = new Worker ("Billy Bob", 13.5);
		System.out.println(worker3);
		System.out.printf("works 12 hours: $%.2f\n", worker3.computePay(12));
		System.out.printf("works 45 hours: $%.2f\n", worker3.computePay(45));
	}

}
