package parserJSON;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class WorkerTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		InputStream input = new FileInputStream("workers.json");
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		List<Worker> workersList = mapper.readValue(input,
				typeFactory.constructCollectionType(ArrayList.class, Worker.class));
		
		System.out.println("Sort by LastName + Salary(if LastName=LastName)\n");
		Collections.sort(workersList, Worker.CompareByNameSalary);
		for(Worker worker : workersList){
			System.out.println("Worker"+(workersList.indexOf(worker)+1)+" - "+worker);
		} 
		
	}
}
