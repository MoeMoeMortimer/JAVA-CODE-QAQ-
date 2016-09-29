package Interface.src.com.hpe.yhy.interfaced;

import Interface.src.com.hpe.yhy.interfaced1.Usb;

public class UPan implements Usb {
	private String brand;
	private String size;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String myBrand) {
		this.brand = myBrand;
	}

	@Override
	public void input() {
		System.out.println(brand + "开始写入！！！");

	}

	@Override
	public void output() {
		System.out.println(brand + "开始读取！！！");

	}

}
