package parserJSON;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker implements Comparable<Worker> {
	public String lastName;
	private String post;
	private Double salary;

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Lastname: " + this.getLastName() + ", Post: " + this.getPost()
				+ ", Salary: " + this.getSalary();
	}
	
	@Override
	public int compareTo(Worker arg0) {
		return 0;
	}
	
	//Sort by Lastname as default. If Lastname=Lastname - for this rows use one more sort by another field - Salary.
	public static Comparator<Worker> CompareByNameSalary = new Comparator<Worker>() {
		@Override
		public int compare(Worker w1, Worker w2) {
			if (w1.getLastName().equals(w2.getLastName()) == false) {
				return new CompareToBuilder()
						.append(w1.getLastName(), w2.getLastName())
						.append(w1.getPost(), w2.getPost())
						.append(w1.getSalary(), w2.getSalary())
						.toComparison();
			} else {
				return new CompareToBuilder()
						.append(w1.getSalary(), w2.getSalary())
						.append(w1.getPost(), w2.getPost())
						.append(w1.getLastName(), w2.getLastName())
						.toComparison();
			}

		}
	};
}
