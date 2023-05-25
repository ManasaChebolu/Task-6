package entity;



public class employee {
	public int empId;
	public String empName;
	public int empSalary;
	public  String empType;
	employee(int empId,String empName,int empSalary,String empType) {
			this.empId =empId;
			this.empName=empName;
			this.empSalary=empSalary;
			this.empType=empType;
		}
		
		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getEmpSalary() {
			return empSalary;
		}

		public void setEmpSalary(int empSalary) {
			this.empSalary = empSalary;
		}

		public String getEmpType() {
			return empType;
		}

		public void setEmpType(String empType) {
			this.empType = empType;
		}
}