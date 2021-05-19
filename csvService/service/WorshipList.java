package service;

public class WorshipList {
    String serviceName;
    String attendanceName;
    String depart;
    String rank;
    int age;

    public WorshipList(String serviceName, String attendanceName,  String depart,  String rank,  int age){
        this.serviceName = serviceName;
        this.attendanceName = attendanceName;
        this.depart = depart;
        this.rank = rank;
        this.age = age;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAttendanceName() {
        return this.attendanceName;
    }

    public void setAttendanceName(String attendanceName) {
        this.attendanceName = attendanceName;
    }

    public String getDepart() {
		return this.depart;
	}

    public void setDepart(String depart) {
		this.depart = depart;
	}

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
