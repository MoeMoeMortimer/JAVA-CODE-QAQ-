import java.util.Scanner;

public class PhoneBookManger {
	//1.����
	static PhoneBook[] books = new PhoneBook[100];
	//2.�±�
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
				System.out.println("��Ч���������������롣");
			}
		}
	}
	static void Menu(){ 
		System.out.println("----------- �绰������ϵͳ -----------");
		System.out.println("1����  2ɾ��  3�޸�  4����  5��������  6�˳�");
		System.out.println("��ѡ��ҵ��");
	}
	
	private static void findAll() {
		System.out.println("------------ ������ϵ�� -----------");
		for(int i = 0; i <= ptr; i++){
			System.out.println(books[i]);
		}
	}
	
	private static void find() {
		System.out.println("------------ ���ҵ绰�� -----------");
		System.out.println("������Ҫ���ҵ�������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else
			System.out.println(books[index]);
	}
	
	private static void update() {
		System.out.println("------------ �޸ĵ绰�� -----------");
		System.out.println("������Ҫ�޸ĵ�������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else{
			System.out.println(books[index]);
			System.out.println("������������Ϣ��");
			System.out.println("������");
			String newname = sc.next();
			books[index].setName(newname);
			System.out.println("�Ա�");
			String sex = sc.next();
			books[index].setSex(sex);
			System.out.println("���䣺");
			int age = sc.nextInt();
			books[index].setAge(age);
			System.out.println("�绰��");
			String tel = sc.next();
			books[index].setTel(tel);
			System.out.println("QQ��");
			String QQ = sc.next();
			books[index].setQQ(QQ);
			System.out.println("��ַ��");
			String addr = sc.next();
			books[index].setAddr(addr);
		}	
	    System.out.println("�޸ĳɹ���" + books[index]);	
	}
	
	private static void delete() {
		System.out.println("------------ ɾ���绰�� -----------");
		System.out.println("������Ҫɾ����������");
		String name = sc.next();
		int index = findByName(name);
		if(index == -1){
			System.out.println("û���ҵ������Ϣ��");
			return;
		}else{
			System.out.println(books[index]);
			System.out.println("��ȷ��Ҫɾ���� 1��0��");
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
		System.out.println("------------ ���ӵ绰�� -----------");
		System.out.println("������");
		String name = sc.next();
		System.out.println("�Ա�");
		String sex = sc.next();
		System.out.println("���䣺");
		int age = sc.nextInt();
		System.out.println("�绰��");
		String tel = sc.next();
		System.out.println("QQ��");
		String QQ = sc.next();
		System.out.println("��ַ��");
		String addr = sc.next();
		//2��϶���
		PhoneBook book = new PhoneBook(name, sex, addr, tel, QQ, age);
		ptr++;
		books[ptr] = book;
		
		
	}
	//ҵ��������
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
