import java.util.*;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  

public class Predict {
	public static void main(String args[]) {
		String ln = "";   
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor
		HashMap<String,List<String>> diseases=new HashMap<String,List<String>>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\AndroidStudioProjects\\android\\SelfDiagnosisApp\\app\\src\\main\\res\\raw\\dataset.csv"));
		String line=br.readLine();
		String[] symptoms=line.split(",");
		HashMap<String,Integer> indices=new HashMap<String,Integer>();
		for(int i=1;i<symptoms.length;i++) {
			indices.put(symptoms[i], i);
		}
		while ((ln = br.readLine()) != null)   //returns a Boolean value  
		{  
			String[] symps=ln.split(",");
			if(symps.length!=0) {
			List<String> x=new ArrayList<String>();
			for(int i=1;i<symps.length;i++) {
				if((Integer.valueOf(symps[i]).toString()).equals("1")){
					x.add(symptoms[i]);
			}
			}
			diseases.put(symps[0],x);
			}
		}
		// Here you have to added inputs of the spinners.
		Scanner sc=new Scanner(System.in);
		String[] usyms=new String[4];
		String[] inten=new String[4];
		for(int i=0;i<4;i++) {
			usyms[i]=sc.nextLine();
			inten[i]=sc.nextLine();
		}
		//here on starts the work of getting the values for each disease and the sum, create an hashmap to store the sum
		HashMap<String,Double> scores=new HashMap<String,Double>();
		HashMap<String,Integer> present=new HashMap<String,Integer>();
		for (Map.Entry dis : diseases.entrySet()) { 
			List<String> sp=(List<String>) dis.getValue();
			int j=0;
			double score=sp.size();
			int con=0;
			for(int k=0;k<usyms.length;k++) {
				if(sp.contains(usyms[k])) {
					con=con+1;
					if(inten[j].equals("High"))
						score+=1*8.0;
					else if(inten[j].contentEquals("Medium"))
						score=(score+5.0);
					else if(inten[j].equals("Low"))
						score=(score+3.0);
					else if(inten[j].equals("--"))
						score=score+5.3;
				}
			double nbs=0.0;
			if(con>0) {
				nbs=((double)(con/4)*(1/75)/(double)con/sp.size());
			}
			String key=(String)dis.getKey();
			present.put(key,con);
			scores.put(key,(Double)(score+nbs));
			}
		}
		LinkedHashMap<String, Double> reverseSortedMap = new LinkedHashMap<>();
        scores.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		String[] keys=new String[3];
		double[] vals=new double[3];
		int c=0;
		for (Map.Entry rev: reverseSortedMap.entrySet()) { 
			if(c==3) {
				break;
			}
			keys[c]=((String)rev.getKey());
			vals[c]=((double)rev.getValue());
			c+=1;
		}
		for(int i=0;i<keys.length;i++) {
			System.out.println(keys[i]+" "+vals[i]);
		}
		}
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
}
}

/*
asthenia
High
dizziness
High
haemorrhage
Medium
tired
Medium
*/
/*
abdominal tenderness
High
wight gain
Medium
productive cough
Medium
hypoxemia
Low
*/
/*
chest tightness
High
distress respiratory
Medium
cough
High
noisy respiration
Low
*/
/*System.out.println(scores);
int yl=diseases.get("pneumonia").size();
System.out.println(yl);
System.out.println(diseases.get("asthma"));
System.out.println(scores.get("pneumonia"));*/