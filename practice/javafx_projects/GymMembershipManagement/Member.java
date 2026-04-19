//Fields: Member ID (String), Name (String), Plan (String - e.g., Basic, Premium), Gender (String), and Join Date (LocalDate).
public class Member{
    private String id;
    private String name;
    private String plan;
    private String gender;
    private String date;

    public Member(String id, String name, String plan, String gender, String date){
        this.id=id;
        this.name=name;
        this.plan=plan;
        this.gender=gender;
        this.date=date;
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public String getPlan(){return plan;}
    public String getGender(){return gender;}
    public String getDate(){return date;}
}
