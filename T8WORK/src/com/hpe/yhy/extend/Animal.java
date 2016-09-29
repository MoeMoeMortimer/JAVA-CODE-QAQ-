package com.hpe.yhy.extend;

public class Animal {
	private String name;
	private String sex;
	private float age = 10;
	private float weight;

	/**
	 * ���췽�������ã���ʼ������ ����ĳ�ʼ��˳�򣺼��ǹ��췽����ִ��˳�� ���Գ�ʼ��---->���췽����ʼ��
	 */
	public Animal() {
		// ���ഴ��ʱ����ʽ�ĵ��ø���Ĺ��췽����
		// �����ʽ������Ҫд�ڹ��췽���ڵĵ�һ��
		super();
		age = 20;
	}

	public Animal(String myColor, String mySex, int myAge, float myWeight) {
		this.name = myColor;
		this.sex = mySex;
		this.age = myAge;
		this.weight = myWeight;
	}

	/**
	 * get��set����
	 */
	public String getName() {
		return name;
	}

	public void setName(String myName) {
		name = myName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String mySex) {
		sex = mySex;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float myAge) {
		if (myAge > 50) {
			System.out.println("���������Ϣ�������������룡����");
		} else {
			age = myAge;
		}

	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float myWeight) {
		weight = myWeight;
	}

	/**
	 * �෽��
	 */
	public void eat() {
		System.out.println("���ﶼ��ԣ�����");
	}

	public void run() {
		System.out.println("���ﶼ���ܣ�����");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", sex=" + sex + ", age=" + age + ", weight=" + weight + "]";
	}
}
