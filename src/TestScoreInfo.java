import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestScoreInfo {

	public static void main(String[] args) {
		
		ScoreInfo p1 = new ScoreInfo("Smith","John", 70);
		ScoreInfo p2 = new ScoreInfo("Doe","Mary",85);
		ScoreInfo p3 = new ScoreInfo("Page","Alice",82);
		ScoreInfo p4 = new ScoreInfo("Cooper","Jill",97);
		ScoreInfo p5 = new ScoreInfo("Flintstone","Fred",66);
		ScoreInfo p6 = new ScoreInfo("Rubble","Barney",80);
		ScoreInfo p7 = new ScoreInfo("Smith","Judy",48);
		ScoreInfo p8 = new ScoreInfo("Dean","James",90);
		ScoreInfo p9 = new ScoreInfo("Russ","Joe",55);
		ScoreInfo p10 = new ScoreInfo("Wolfe","Bill",73);
		ScoreInfo p11 = new ScoreInfo("Dart","Mary",54);
		ScoreInfo p12 = new ScoreInfo("Rogers","Chris",78);
		ScoreInfo p13 = new ScoreInfo("Toole","Pat",51);
		ScoreInfo p14 = new ScoreInfo("Khan","Omar",93);
		ScoreInfo p15 = new ScoreInfo("Smith","Ann",95);
		
		List<ScoreInfo> scoreData = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));
		
		Score test = new Score();
		System.out.println(test.getNumScores(scoreData));
		test.getNumberAListers(scoreData);
		System.out.println(test.getAverage(scoreData));
		test.getFailingStudentList(scoreData);
		test.getStudentRecords(scoreData);
		test.printPassingStudents(scoreData);
		test.displayAllStudents(scoreData);
		
	
	}
}
