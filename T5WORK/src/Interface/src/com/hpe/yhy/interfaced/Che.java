package Interface.src.com.hpe.yhy.interfaced;

/*
 * һ�������ʵ�ֶ���ӿ�
 */
public class Che implements Usb, Vehicle {

	@Override
	public void run() {
		System.out.println("�����ܣ���");

	}

	@Override
	public void stop() {
		System.out.println("����ͣ����");

	}

	@Override
	public void speedUp() {
		System.out.println("������٣���");
	}

	@Override
	public void speedDown() {
		System.out.println("������٣���");

	}

	@Override
	public void input() {
		System.out.println("�������USBд�룡��");

	}

	@Override
	public void output() {
		System.out.println("�������USB��ȡ����");

	}

}
