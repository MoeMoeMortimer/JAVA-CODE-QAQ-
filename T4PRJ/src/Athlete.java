
public class Athlete {
	private String name;
	private String sex;
	private int age;
	private String nationality;
	private String items;
	public Athlete(String name, String sex, int age, String nationality, String items) {
		super();//���ø�����޲ι���--object��������ĸ��࣬�ֽи���
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.nationality = nationality;
		this.items = items;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getNationality(){
		return nationality;
	}
	public void setNationality(String nationality){
		this.nationality = nationality;
	}
	public String getItems(){
		return items;
	}
	public void setItems(String items){
		this.items = items;
	}
	public String toString(){
		return "������"+name+"���Ա�"+sex+"�����䣺"+age+"������:"+nationality+"��Ŀ:"+items;
	}
}
