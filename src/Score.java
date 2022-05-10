import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {

	public int getNumScores(List<ScoreInfo> scoreData) {
		
		int x = scoreData.size();
		
		return x;
	}
	public void getNumberAListers(List<ScoreInfo> scoreData){
		
		Stream scoreStream  = scoreData.stream();
		Predicate<ScoreInfo> filterA = (p)->{
			if (p.getScore() >= 90) {
				return true;
			}return false;
		};
	
		long numberALister = scoreStream.filter(filterA).count();
		System.out.println(numberALister);
	}
	
	public double getAverage(List<ScoreInfo> scoreData) {
		
		Stream<ScoreInfo> scoreStream = scoreData.stream();
		Function<ScoreInfo, Integer> mapScoreInfoToScore = (p)->{
			return p.getScore();
		};
		int totalScores = scoreStream.map(mapScoreInfoToScore).mapToInt(Integer::intValue).sum();
		
		scoreStream = scoreData.stream();
		double avgScore = scoreStream.map(mapScoreInfoToScore).mapToInt(Integer::intValue).average().orElse(totalScores);
		return (double) avgScore;
	}
	
	public void getFailingStudentList(List<ScoreInfo> scoreData) {
		
		Comparator<ScoreInfo> sortFirstName = (o1, o2)->{
			if(o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			}else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Stream scoreStream  = scoreData.stream();
		Predicate<ScoreInfo> filterFail = (p)->{
			if (p.getScore() < 70) {
				return true;
			}return false;
		};
		Function<ScoreInfo, String> mapName = (p)->{
			return String.join(" ", p.getFirstName(), p.getLastName());
		};
		List<ScoreInfo> failedStudents = (List<ScoreInfo>) scoreStream.sorted(sortFirstName).filter(filterFail).map(mapName).collect(Collectors.toList());
		System.out.println(failedStudents);
	}
	
	public void printPassingStudents(List<ScoreInfo> scoreData) {
		
		Comparator<ScoreInfo> sortFirstName = (o1, o2)->{
			if(o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			}else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Stream scoreStream  = scoreData.stream();
		Predicate<ScoreInfo> filterFail = (p)->{
			if (p.getScore() >= 70) {
				return true;
			}return false;
		};
		Function<ScoreInfo, String> mapName = (p)->{
			return String.join(" ", p.getFirstName(), p.getLastName());
		};
		List<ScoreInfo> passedStudents = (List<ScoreInfo>) scoreStream.filter(filterFail).sorted(sortFirstName).map(mapName).collect(Collectors.toList());
		System.out.println(passedStudents);
	}
	
	public void displayAllStudents(List<ScoreInfo> scoreData) {
		
		Stream scoreStream  = scoreData.stream();
		Comparator<ScoreInfo> sortLastName = (o1, o2)->{
			if(o1.getLastName().compareTo(o2.getLastName()) > 0) {
				return 2;
			}else if (o1.getLastName().compareTo(o2.getLastName()) < 0) {
				return -2;
			}else {
			return 0;
			}
		};
		
		Function<ScoreInfo, String> mapName = (p)->{
			return String.join(" ", p.getLastName(), p.getFirstName());
		};
		List<ScoreInfo> allStudents = (List<ScoreInfo>) scoreStream.sorted(sortLastName).map(mapName).collect(Collectors.toList());
		System.out.println(allStudents);
	}
	
	public void getStudentRecords(List<ScoreInfo> scoreData){
		
		Stream scoreStream  = scoreData.stream();
		Comparator<ScoreInfo> sortHighestScore = (o1, o2)->{
			if(o1.getScore() > o2.getScore()) {
				return 2;
			}else if (o1.getScore() < o2.getScore()) {
				return -2;
			}else {
			return 0;
			}
		};
		Function<ScoreInfo, String> mapName = (p)->{
			return String.join(" ", p.getLastName(), p.getFirstName());
		};
		List<ScoreInfo> allStudents = (List<ScoreInfo>) scoreStream.sorted(sortHighestScore).map(mapName).collect(Collectors.toList());
		System.out.println(allStudents);
	}
}
