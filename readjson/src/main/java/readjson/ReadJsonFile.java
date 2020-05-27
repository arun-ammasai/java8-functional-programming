package readjson;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonFile {

	public static void main(String[] args) {
		ReadJsonFile rj = new ReadJsonFile();
		Map<Integer,Employee> data = rj.readData();
		displayData.accept(data);
	}
	
	Function<String,File> fileReader = fname -> {
		return new File(getClass().getClassLoader().getResource(fname).getFile());
	};
	
	static Consumer<Map<Integer,Employee>> displayData = emp -> {
		emp.forEach((k,v) -> System.out.println(k +" Employee :"+v));
	};
	
	Function<JSONObject, Integer> idData = id -> Integer.parseInt((String)((JSONObject) id).get("id"));
	
	Function<JSONObject, Employee> fetchEmployee = json -> {
		Employee emp = new Employee();
		Integer id = Integer.parseInt((String)json.get("id"));
		emp.setId(id);
		emp.setFirstName((String)json.get("firstName"));
		emp.setLastName((String)json.get("lastName"));
		emp.setWebsite((String)json.get("website"));
		emp.setCity((String)json.get("city"));
		return emp;
	};
	
	Map<Integer,Employee> readData() {
		File file = fileReader.apply("person.json");
		JSONParser parser = new JSONParser();
		Map<Integer,Employee> employee = null ;
		try(Reader reader = new FileReader(file)){
			JSONArray jArray = (JSONArray)parser.parse(reader);
			employee = (Map<Integer, Employee>) jArray.stream().collect(Collectors.toMap(idData, fetchEmployee));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;		
	}

}
