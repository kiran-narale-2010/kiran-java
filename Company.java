
import java.util.ArrayList;

abstract class Employee{
	
	private String name;
	
	private int id;
	
	public Employee(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract double CalculateSalary();
	
	@Override
	public String toString() {
		return "Employee[name="+name+",id="+id+",CalculateSalary="+CalculateSalary()+"]";
	}
}
class FullTimeEmployee extends Employee{
	private double monthlysalary;
	
	public FullTimeEmployee(String name,int id,double monthlysalary){
		super(name,id);
		this.monthlysalary=monthlysalary;
	}
	@Override
		public double CalculateSalary() {
			return monthlysalary;
		
		
	}
}
class PartTimeEmployee extends Employee {
	private int hoursWorked;
	
	private double hoursRates;
	
	PartTimeEmployee(String name,int id,int hoursWorked,double hoursRates){
		super(name,id);
		this.hoursWorked=hoursWorked;
		this.hoursRates=hoursRates;
	}
	
	@Override
	public double CalculateSalary() {
		return hoursWorked*hoursRates;
	}
}

class PayrollSystem{
	private ArrayList<Employee> employeelist;
	
	public PayrollSystem() {
		employeelist=new ArrayList<>();
	}
	public void addEmployee(Employee employee) {
		employeelist.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeetoremove=null;
		for(Employee employee:employeelist) {
			if(employee.getId()==id) {
				employeetoremove=employee;
				break;
			}
		}
		if(employeetoremove!=null) {
			employeelist.remove(employeetoremove);
		}
	}
	public void displayEmployee() {
		for (Employee emp:employeelist) {
			System.out.println(emp);
			}
	}
}
	
public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayrollSystem payrollsystem=new PayrollSystem();
		FullTimeEmployee emp3=new FullTimeEmployee("kiran",1,90000.0);
		PartTimeEmployee emp4=new PartTimeEmployee("vikas",2,40,100.0);
		payrollsystem.addEmployee(emp3);
		payrollsystem.addEmployee(emp4);
		System.out.println("Total employees list:");
		payrollsystem.displayEmployee();
		System.out.println("removed employee list:");
		payrollsystem.removeEmployee(1);
		payrollsystem.displayEmployee();
		
	}

}
