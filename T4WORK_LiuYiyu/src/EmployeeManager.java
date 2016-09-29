import java.util.Scanner;

public class EmployeeManager {
	static Employee[] staff = new Employee[100];
	static Scanner sc = new Scanner(System.in);
	static int ptr = -1;
	public static void main(String[] args) {
		
		while(true){
			Menu();
			int choice = sc.nextInt();
			switch(choice){
			case 1:add();break;
			case 2:delete();break;
			case 3:update();break;
			case 4:find();break;
			case 5:findAll();break;
			case 6:System.exit(0);
			default:
				System.out.println("��Ч���������������롣");
			}
		}
	}
	private static void Menu() {
		System.out.println("----------- Ա������ϵͳ -----------");
		System.out.println("1����  2ɾ��  3�޸�  4����  5��������  6�˳�");
		System.out.println("��ѡ��ҵ��");
		
	}
	private static void add() {
		System.out.println("------------ ���Ա����Ϣ -----------");
		System.out.println("��ţ�");
		String id = sc.next();
		System.out.println("������");
		String name = sc.next();
		System.out.println("ְ��");
		String position = sc.next();
		System.out.println("���������");
		int holidays = sc.nextInt();
		System.out.println("���ʣ�");
		double salary = sc.nextDouble();
	
		//2��϶���
		Employee person = new Employee(id,name,position,holidays,salary);
		ptr++;
		staff[ptr] = person;
		
	}
	
	private static void delete() {
		System.out.println("------------ ɾ��Ա����Ϣ -----------");
		System.out.println("������Ҫɾ����������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1){
			System.out.println("û���ҵ������Ϣ��");
			return;
		}else{
			System.out.println(staff[index]);
			System.out.println("��ȷ��Ҫɾ���� 1��0��");
			int result = sc.nextInt();
			if(result == 1){
				for(int i = index; i < ptr; i++){
					staff[i] = staff[i+1];
				}
				ptr--;
			}
		}
		
	}
	private static void update() {
		System.out.println("------------ �޸�Ա����Ϣ -----------");
		System.out.println("������Ҫ�޸ĵ�������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else{
			System.out.println(staff[index]);
			System.out.println("������������Ϣ��");
			System.out.println("��ţ�");
			String id = sc.next();
			staff[index].setId(id);
			System.out.println("������");
			String newname = sc.next();
			staff[index].setName(newname);
			System.out.println("ְ��");
			String position = sc.next();
			staff[index].setPosition(position);
			System.out.println("���������");
			int holidays = sc.nextInt();
			staff[index].setHolidays(holidays);
			System.out.println("���ʣ�");
			double salary = sc.nextDouble();
			staff[index].setSalary(salary);
			
		}	
	    System.out.println("�޸ĳɹ���" + staff[index]);	
		
	}
	private static void find() {
		System.out.println("------------ ����Ա����Ϣ -----------");
		System.out.println("������Ҫ���ҵ�������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else
			System.out.println(staff[index]);
	}
	private static void findAll() {
		System.out.println("------------ ����Ա�� -----------");
		for(int i = 0; i <= ptr; i++){
			System.out.println(staff[i]);
		}
		
	}
	public static int findByName(String name){
		int index = -1;
		for(int i = 0; i <= ptr; i++){
			if(name.equals(staff[i].getName())){
				index = i;
				break;
			}
		}
		return index;
	}
}
