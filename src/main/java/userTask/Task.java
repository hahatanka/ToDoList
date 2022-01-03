package userTask;


import java.util.ArrayList;

public class Task {
    private String name;
    private String note;
    private String deadline;
    private String status;
    ArrayList<String> taskNames = new ArrayList<>();


    public Task() {
    }

    public Task(String name , String note, String deadline, String status) {
        this.name = name;
        this.note = note;
        this.deadline = deadline;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline (String deadline){
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public ArrayList taskNames(){
//        ArrayList<String> names = new ArrayList<>();
//        names.add(this.name);
//        return names;
//    }



    @Override
    public String toString() {
        return "Task name: " + name + '\'' +
                "note: " + note + '\'' +
                ", deadline: " + deadline + '\'' +
                ", status: " + status + '\'';
    }
}
