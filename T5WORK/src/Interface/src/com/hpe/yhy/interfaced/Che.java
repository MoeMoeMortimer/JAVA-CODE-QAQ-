package Interface.src.com.hpe.yhy.interfaced;

/*
 * 一个类可以实现多个接口
 */
public class Che implements Usb, Vehicle {

	@Override
	public void run() {
		System.out.println("车会跑！！");

	}

	@Override
	public void stop() {
		System.out.println("车会停！！");

	}

	@Override
	public void speedUp() {
		System.out.println("车会加速！！");
	}

	@Override
	public void speedDown() {
		System.out.println("车会加速！！");

	}

	@Override
	public void input() {
		System.out.println("车里可以USB写入！！");

	}

	@Override
	public void output() {
		System.out.println("车里可以USB读取！！");

	}

}
