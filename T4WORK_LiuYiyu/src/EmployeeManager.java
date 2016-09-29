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
				System.out.println("无效的请求，请重新输入。");
			}
		}
	}
	private static void Menu() {
		System.out.println("----------- 员工管理系统 -----------");
		System.out.println("1增加  2删除  3修改  4查找  5查找所有  6退出");
		System.out.println("请选择业务：");
		
	}
	private static void add() {
		System.out.println("------------ 添加员工信息 -----------");
		System.out.println("编号：");
		String id = sc.next();
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("职务：");
		String position = sc.next();
		System.out.println("请假天数：");
		int holidays = sc.nextInt();
		System.out.println("工资：");
		double salary = sc.nextDouble();
	
		//2组合对象
		Employee person = new Employee(id,name,position,holidays,salary);
		ptr++;
		staff[ptr] = person;
		
	}
	
	private static void delete() {
		System.out.println("------------ 删除员工信息 -----------");
		System.out.println("请输入要删除的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1){
			System.out.println("没有找到相关信息。");
			return;
		}else{
			System.out.println(staff[index]);
			System.out.println("您确认要删除吗？ 1是0否");
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
		System.out.println("------------ 修改员工信息 -----------");
		System.out.println("请输入要修改的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("没有找到相关信息。");
		else{
			System.out.println(staff[index]);
			System.out.println("请重新输入信息：");
			System.out.println("编号：");
			String id = sc.next();
			staff[index].setId(id);
			System.out.println("姓名：");
			String newname = sc.next();
			staff[index].setName(newname);
			System.out.println("职务：");
			String position = sc.next();
			staff[index].setPosition(position);
			System.out.println("请假天数：");
			int holidays = sc.nextInt();
			staff[index].setHolidays(holidays);
			System.out.println("工资：");
			double salary = sc.nextDouble();
			staff[index].setSalary(salary);
			
		}	
	    System.out.println("修改成功，" + staff[index]);	
		
	}
	private static void find() {
		System.out.println("------------ 查找员工信息 -----------");
		System.out.println("请输入要查找的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("没有找到相关信息。");
		else
			System.out.println(staff[index]);
	}
	private static void findAll() {
		System.out.println("------------ 所有员工 -----------");
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
