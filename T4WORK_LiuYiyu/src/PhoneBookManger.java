import java.util.Scanner;

public class PhoneBookManger {
	//1.集合
	static PhoneBook[] books = new PhoneBook[100];
	//2.下标
	static int ptr = -1;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		while(true){
			Menu();
			choice = sc.nextInt();
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
	static void Menu(){ 
		System.out.println("----------- 电话本管理系统 -----------");
		System.out.println("1增加  2删除  3修改  4查找  5查找所有  6退出");
		System.out.println("请选择业务：");
	}
	
	private static void findAll() {
		System.out.println("------------ 所有联系人 -----------");
		for(int i = 0; i <= ptr; i++){
			System.out.println(books[i]);
		}
	}
	
	private static void find() {
		System.out.println("------------ 查找电话本 -----------");
		System.out.println("请输入要查找的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("没有找到相关信息。");
		else
			System.out.println(books[index]);
	}
	
	private static void update() {
		System.out.println("------------ 修改电话本 -----------");
		System.out.println("请输入要修改的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("没有找到相关信息。");
		else{
			System.out.println(books[index]);
			System.out.println("请重新输入信息：");
			System.out.println("姓名：");
			String newname = sc.next();
			books[index].setName(newname);
			System.out.println("性别：");
			String sex = sc.next();
			books[index].setSex(sex);
			System.out.println("年龄：");
			int age = sc.nextInt();
			books[index].setAge(age);
			System.out.println("电话：");
			String tel = sc.next();
			books[index].setTel(tel);
			System.out.println("QQ：");
			String QQ = sc.next();
			books[index].setQQ(QQ);
			System.out.println("地址：");
			String addr = sc.next();
			books[index].setAddr(addr);
		}	
	    System.out.println("修改成功，" + books[index]);	
	}
	
	private static void delete() {
		System.out.println("------------ 删除电话本 -----------");
		System.out.println("请输入要删除的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1){
			System.out.println("没有找到相关信息。");
			return;
		}else{
			System.out.println(books[index]);
			System.out.println("您确认要删除吗？ 1是0否");
			int result = sc.nextInt();
			if(result == 1){
				for(int i = index; i < ptr; i++){
					books[i] = books[i+1];
				}
				ptr--;
			}
		}
	}
	
	private static void add() {
		System.out.println("------------ 增加电话本 -----------");
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("性别：");
		String sex = sc.next();
		System.out.println("年龄：");
		int age = sc.nextInt();
		System.out.println("电话：");
		String tel = sc.next();
		System.out.println("QQ：");
		String QQ = sc.next();
		System.out.println("地址：");
		String addr = sc.next();
		//2组合对象
		PhoneBook book = new PhoneBook(name, sex, addr, tel, QQ, age);
		ptr++;
		books[ptr] = book;
		
		
	}
	//业务辅助方法
	public static int findByName(String name){
		int index = -1;
		for(int i = 0; i <= ptr; i++){
			if(name.equals(books[i].getName())){
				index = i;
				break;
			}
		}
		return index;
	}
	
}
