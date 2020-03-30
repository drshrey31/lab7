public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 1
	public void addElement(int index, double value){
//		while (index < 0 || index >= length){
//			System.out.println("Invalid input, please try again with a valid index.");
//			break;
//		}
//		if (head == null){
//			head = new Node(index, value);
//		}
//		else{
//			for (int i = 0; i < length; i++){
//				if (head.getIndex() == index){
//					head = new Node(index,value);
//				}
//				Node nxt = new Node(index, value);
//				head.setNext(nxt);
//			}
//		}

		if (index >= 0 && index < length) {
			Node end, ptr;
			if (head == null){
				head = new Node(index,value);
			}
			else{
				end = head.getNext();
				ptr = head;
				while (end != null){
					System.out.println("Inside loop");
					ptr = end;
					end = end.getNext();
				}
				Node final1 = new Node(index,value);
				ptr.setNext(final1);
			}
		}
	}

	// TODO: Implement me for milestone 2
	public static double dot( SparseVector x, SparseVector y ) {
		Node a,b;
		a = x.head;
		b = y.head;
		double biggie = 0.0;
		int xcounter = 0;
		int ycounter = 0;

		double[] xarr = new double[x.length];
		double[] yarr = new double[y.length];
		// create arrays to store values from sparse vector
		for (int i = 0; i < x.length; i++){
			if (xcounter == 0){
				xarr[i] = a.getValue();
			}
			if (a.getNext().getIndex() > a.getIndex()+1){
				xcounter = a.getNext().getIndex() - a.getIndex()+1;
				while (xcounter > 0){
					xarr[i] = 0;
					xcounter -= 1;
				}
			}
			a.getNext();
		}

		for (int j = 0; j < y.length; j++){
			if (ycounter == 0){
				yarr[j] = b.getValue();
			}
			if (b.getNext().getIndex() > b.getIndex()+1){
				ycounter = b.getNext().getIndex() - b.getIndex()+1;
				while (ycounter > 0){
					yarr[j] = 0;
					ycounter -= 1;
				}
			}
			b.getNext();
		}

		for (int k = 0; k < y.length; k++) {
			biggie += xarr[k] * yarr[k];
		}
		return biggie;

	}
//		Node bptr, bend, cptr, cend;
//		bend = x.head.getNext();
//		bptr = x.head;
//		cend = y.head.getNext();
//		cptr = y.head;
//
//		double[] d = new double[x.length];
//		double[] e = new double[y.length];
//		double biggie = 0;
//
//		for (int j = 0; j < x.length; j++) {
//			if (bptr == null) {
//				d[j] = 0;
//				bptr = new Node(j, 0);
//			} else {
//				d[j] = bptr.getValue();
//			}
//			//System.out.println(d[j]);
//
//			while (bend != null){
//				//System.out.println("Inside loop");
//				bptr = bend;
//				bend = bend.getNext();
//			}
//		}
//
//		for (int i = 0; i < y.length; i++) {
//			if (cptr == null) {
//				e[i] = 0;
//				cptr = new Node(i, 0);
//			} else {
//				e[i] = cptr.getValue();
//			}
//
//			while (cend != null){
//				//System.out.println("Inside loop");
//				cptr = cend;
//				cend = cend.getNext();
//			}
//			for (int l = 0; l < 10; l++) {
//				System.out.println(e[l]);
//			}
//		}
//
//		for (int k = 0; k < y.length; k++) {
//			biggie += d[k] * e[k];
//		}
//		return biggie;
//	}




//	For milestone two, you will need to use some of these debugging tools to go through your program.
//	Take some time to practice using the built-in debugger and familiarize yourself with Step Into, Step
//	Over, and Step Out. The PDF on IntelliJ debugging will likely be a helpful resource.


//	Go through your main method in SparseVector using the IntelliJ debugger and send screenshots to your TA to show your understanding of IntelliJ’s debugging functionality. Also write
//	out the following and send to your TA:
//			• Explain the difference between Step Over and Step Into.
//• Give a situation where using Step Over instead of Step Into would be desirable.
//			• Explain what does Step Out does.
//

	public void removeElement(int index){

	}

	// TODO: Test out your code here!
	public static void main(String[] args) {
//		SparseVector vec = new SparseVector(6);
//		vec.addElement(0, 10.0);
//		vec.addElement(3, -1.1);
//		vec.addElement(5, 32.0);
//		System.out.println(vec);

		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println(result);

// CHANGE THIS SHIT
//		If you were to step into at that point, you will move to the println() line in f(), stepping into the function call.
//
//		If you were to step over at that point, you will move to the f(1) line in g(), stepping over the function call.
//
//		Another useful feature of debuggers is the step out of or step return.
//		In that case, a step return will basically run you through the current function until you go back up one level.
//		In other words, it will step through f(x) and f(1), then back out to the calling function to end up at g(3) in main().

//		(Step Into) A method is about to be invoked, and you want to debug into the code of that method, so the next step is to go into that method and continue debugging step-by-step.
//			Step Into -> Executes every single code line by line until there's an error. Useful to find an error when you don't know what's causing the issue in your code.
//		(Step Over) A method is about to be invoked, but you're not interested in debugging this particular invocation, so you want the debugger to execute that method completely as one entire step.
//			Step Over -> Executes the method all at once, saves time of execution, just runs code. Useful if you know where the error is and are actively fixing it.
//		(Step Return) You're done debugging this method step-by-step, and you just want the debugger to run the entire method until it returns as one entire step.

//			Step Out -> Move out from the current method into other methods being called to debug.

//	(Resume) You want the debugger to resume "normal" execution instead of step-by-step
//
//				(Line Breakpoint) You don't care how it got there, but if execution reaches a particular line of code, you want the debugger to temporarily pause execution there so you can decide what to do.
}
}


