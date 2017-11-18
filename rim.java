import java.util.Scanner;

class threading implements Runnable{
	private int rows;
	private int order;
	
	public threading(int row, int ordr){
		this.rows=row;
		this.order=ordr;
	}
	
	public void run(){
		for(int i=0; i<order; ++i){
			rim.finalmat1[rows][i] = 0;
			for(int j=0; j<order; ++j)
				rim.finalmat1[rows][i] = rim.finalmat1[rows][i] + rim.matrix1[rows][j]*rim.matrix2[j][i];
		}
	}
}


	public class rim{
	public static int[][] matrix1,matrix2,finalmat,finalmat1;
	static int order;
	
	public static void main(String[] args){
	System.out.println("Enter the order of the matrix");
	Scanner input = new Scanner(System.in);
	order= input.nextInt();
	matrix1= new int[order][order];
	matrix2= new int[order][order];
	finalmat= new int[order][order];
	finalmat1= new int[order][order];
	
	//Enter first matrix
	System.out.println("Enter the first matrix");
	for(int i=0; i<order; i++){
		for(int j=0; j<order; j++){
			matrix1[i][j]=input.nextInt();

		}
	}
	
	//Print first matrix
	System.out.println("First matrix is: ");
	for (int i=0; i<order; i++){
		System.out.print(" |");
		for(int j=0; j<order; j++){
			System.out.print(matrix1[i][j] + "  ");
		}
		System.out.print(" |");
		System.out.println(" ");
	}
		
	//Enter second matrix
	System.out.println("Enter the Second matrix: ");
	for(int i=0; i<order; i++){
		for(int j=0; j<order; j++){
			matrix2[i][j]=input.nextInt();

		}
	}

	//Prints second matrix
	System.out.println("second matrix is: ");
	
	for (int i=0; i<order; i++){
		System.out.print(" |");
		for(int j=0; j<order; j++){
			System.out.print(matrix2[i][j] + "  ");
		}
		System.out.print(" |");
		System.out.println(" ");
	}

	//to multiply two matrix using only loops
	for(int i=0; i<order; i++){
		for(int j=0; j<order; j++){
			for(int k=0; k<order; k++){
				finalmat[i][j]= finalmat[i][j] + matrix1[i][k] * matrix2[k][j];
			}
		}
	}
	
	//to print multiplied matrix
	System.out.println("Product of matrix using loops : " );
	for (int i=0; i<order; i++){
		System.out.print(" |");
		for(int j=0; j<order; j++){
			System.out.print(finalmat[i][j] + "  ");
		}
		System.out.print(" |");
		System.out.println(" ");
	}

	long normaltime=System.nanoTime(); //to calculate time of normal multiplication
	System.out.println("Time taken for normal multiplication is : " +normaltime);

	 
	Thread threadcount[] = new Thread[order];
		for(int i=0; i<order; ++i){
			threadcount[i] = new Thread(new threading(i,order));//creating a new thread object 
			threadcount[i].start();//starting the thread by calling start method
	}

	
	//printing the matrix product after multithread multiplication
	System.out.println("Product after multithreaded multiplication is: ");
		
	for (int i=0; i<order; i++){
		 System.out.print("| ");
		for(int j=0; j<order; j++){
			System.out.print(finalmat1[i][j] + "  ");
		}
		System.out.print(" |");
		System.out.println(" ");
	}

	
	long totaltime=System.nanoTime();// total time taken for the prgramme to run
	long finaltime=totaltime-normaltime;//time taken for multithreading
	System.out.println("Time taken for multithreading multiplication is : " +finaltime);
	}
}
