package HospitalPateintManagementSystem;

public class variable {
	protected int patientId;
	protected  String Pname;
	protected int age;
	protected String gender;
	protected String contactNumber;
	protected String bloodGroup;
	protected String doctorInCharge;
	protected String disease;
	protected String emergencyNumber;
	
	
	public variable(
		int patientId,
		String Pname,
		int age,
		String gender,
		String contactNumber,
		String bloodGroup,
		String doctorInCharge,
		String disease,
		String emergencyNumber) {
		this.patientId=patientId;
		this.Pname=Pname;
		this.age=age;
		this.gender=gender;
		this.contactNumber=contactNumber;
		this.bloodGroup=bloodGroup;
		this.doctorInCharge=doctorInCharge;
		this.disease=disease;
		this.emergencyNumber=emergencyNumber;
		
	}
	@Override
    public String toString() {
        return "Patient ID: " + patientId +
                "\nName: " + Pname +
                "\nAge: " + age +
                "\nGender: " + gender +
                "\nContact Number: " + contactNumber +
                "\nBlood Group: " + bloodGroup +
                "\nDoctor In Charge: " + doctorInCharge +
                "\nDisease: " + disease  +
                "\nEmergency Contact: " + emergencyNumber + "\n";
    }
}
