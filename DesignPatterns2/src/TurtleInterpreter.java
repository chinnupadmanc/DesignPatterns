import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TurtleInterpreter {

	/*private Context c;

	Parser(Context c) {
		this.c = c;
	}*/

	public StatementsListExpression parseProgram(String fileName) {
		//ArrayList<TurtleExpression> programSteps = new ArrayList<>();

		StatementsListExpression statementsList = new StatementsListExpression();

		ArrayList<TurtleExpression> programSteps = statementsList.getProgramSteps();

		Scanner sc = null; 

		File file = new File(fileName);

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		parser(sc, programSteps);

		return statementsList;
	}


	private void parser(Scanner sc, ArrayList<TurtleExpression> programSteps) {
		int ret = 0;
		while (sc.hasNextLine() && (ret !=-1)) {
			String line = sc.nextLine();
			ret = parseLine(line, sc, programSteps);
		}
	}

	private int parseLine(String line, Scanner sc, ArrayList<TurtleExpression> programSteps) {

		//System.out.println("in parseline :" + line);
		if(line.contains("penUp")) {       
			processPenUp(line, programSteps);
		}

		else if(line.contains("penDown")) {
			processPenDown(line, programSteps);
		}

		else if(line.contains("move")) {
			TurtleExpression te = processArgument(line);
			processMove(line, programSteps, te);
		}

		else if(line.contains("turn")) {
			TurtleExpression te = processArgument(line);
			processTurn(line, programSteps, te);
		}

		else if(line.contains("repeat")) {
			processRepeat(line, sc, programSteps);
		}

		else if(line.contains("end")) {
			return -1;
		}

		else if(line.substring(0,1).equals("$")) {
			processVariable(line, programSteps);
		}
		
		return 0;

	}

	private void processPenUp(String line, ArrayList<TurtleExpression> programSteps) {
		System.out.println("parsed penUp");
		programSteps.add(new PenUpExpression());
	}

	private void processPenDown(String line, ArrayList<TurtleExpression> programSteps) {
		System.out.println("parsed penDown");
		programSteps.add(new PenDownExpression());
	}

	private void processMove(String line, ArrayList<TurtleExpression> programSteps, TurtleExpression te) {

		System.out.println("parsed move");
		programSteps.add(new MoveExpression(te));
	}

	private void processTurn(String line,ArrayList<TurtleExpression> programSteps, TurtleExpression te) {

		System.out.println("parsed turn");
		programSteps.add(new TurnExpression(te));
	}

	private void processRepeat(String line, Scanner sc, ArrayList<TurtleExpression> programSteps) {
		System.out.println("parsing repeat");
		System.out.println("line:" + line);
		TurtleExpression repeatCount = processArgument(line);

		RepeatExpression re = new RepeatExpression(repeatCount);
		ArrayList<TurtleExpression> repeatList= re.getList();
		programSteps.add(re);

		parser(sc, repeatList);
		System.out.println("parsed repeat");
	}

	private void processVariable(String line, ArrayList<TurtleExpression> programSteps) {
		String[] s = line.trim().split(" ");
		programSteps.add(new AssignExpression(s[0], Integer.parseInt(s[2])));
		System.out.println("parsed variable assignment");
	}

	private TurtleExpression processArgument(String line) {
		//System.out.println("parsed variable/constant");
		//System.out.println("line in processarg:" + line);
		TurtleExpression te;
		String[] s = line.trim().split(" ");

		if(s[1].substring(0,1).equals("$")) {
			te  = new VariableExpression(s[1]);
		}
		else {
			te  = new ConstantExpression(Integer.parseInt(s[1]));
		}

		return te;
	}


}
