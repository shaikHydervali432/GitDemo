package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamTutorial {
	
public  void testCase1() {
	//Count the numbers of names that ends with a without using stream class
	ArrayList<String> names = new ArrayList<String>();
	names.add("Hyder");
	names.add("Moula");
	names.add("sam");
	names.add("Naseema");
	names.add("AbdurRahman");
	names.add("AbdulRauf");
	int count =0;
	for(int i=0;i<names.size();i++)
	{
		String actual = names.get(i);
		if(actual.endsWith("a"))
		{
			count++;
		}
	}
	System.out.println(count);
}
public void StreamFilter() {
	//using stream Count the numbers of names that starts with a 
	ArrayList<String> names= new ArrayList<String>();
	names.add("Hyder");
	names.add("Moula");
	names.add("sam");
	names.add("Naseema");
	names.add("AbdurRahman");
	names.add("AbdulRauf");
	Long c = names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
}
public void StreamFilterTC3(){
	// create a lightweight stream compatible collection
	Long a = Stream.of("Alpha","Aama","Beta","Gamma").filter(s->s.endsWith("a")).count();
	System.out.println("The count of the names that ends with a is " +a+ "");
}

public void StreamFilterTC4() {
	//print all the names in array list with length greater than 4
	ArrayList<String> names= new ArrayList<String>();
	names.add("Hyder");
	names.add("Moula");
	names.add("sam");
	names.add("Naseema");
	names.add("AbdurRahman");
	names.add("AbdulRauf");
	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	// if we want to get the only one result
	names.stream().filter(s->s.length()>5).limit(1).forEach(s->System.out.println("The first name with the lenght > 5 is "+s+""));
	
}
public void StreamMapTC5() {
	//names that ends with a and converting them to upper case
	Stream.of("Alpha","Aama","Beta","Gamma").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
	.forEach(s->System.out.println("Names that ends with a are " +s+ ""));
	//names that start with a with upper case and sorted
	List<String>names1 = Arrays.asList("Apple","Ant","Beetle","Angular");
	names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//merging two different into single list and then sort
	ArrayList<String> names = new ArrayList<String>();
	names.add("Hyder");
	names.add("Moula");
	names.add("sam");
	names.add("Naseema");
	names.add("AbdurRahman");
	names.add("AbdulRauf");
	
	Stream<String> newStream= Stream.concat(names1.stream(), names.stream());
	//newStream.sorted().forEach(s->System.out.println(s));
	//Checking whether name in the list present or not 
	boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("sam"));
	System.out.println(flag);
	Assert.assertTrue(flag);
}
public void CollectionsTC6() {
	//CONVERTING them into list and then from list to variable
	List<String>ls=Stream.of("Alpha","Aama","Beta","Gamma").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList()); 
	System.out.println(ls.get(0));
	//prinitng unqiue arrays and sorting
	
	List<Integer> numbers = Arrays.asList(1,1,2,3,3,5,8,9,0,88);
	numbers.stream().distinct().forEach(s->System.out.println("Distinct numbers are "+s+""));
	numbers.stream().sorted().forEach(s->System.out.println("Sorted Order "+s+""));
	List<Integer> li =numbers.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(3));
}
public static void main(String[] args) {
		
		/**StreamTutorial tc1 = new StreamTutorial();
		tc1.testCase1();
		StreamTutorial streamclass = new StreamTutorial();
		streamclass.StreamFilter();
		StreamTutorial TC3= new StreamTutorial();
		TC3.StreamFilterTC3();
		StreamTutorial TC4= new StreamTutorial();
		TC4.StreamFilterTC4();
		StreamTutorial TC5 = new StreamTutorial();
		TC5.StreamMapTC5();
		**/
	StreamTutorial TC6 = new StreamTutorial();
	TC6.CollectionsTC6();
	}

}
