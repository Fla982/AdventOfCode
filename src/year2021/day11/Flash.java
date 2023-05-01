package year2021.day11;

public class Flash {

	public Flash() {
		// TODO Auto-generated constructor stub
	}

	
	 public Integer value;
	 public boolean flash;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public boolean isFlash() {
		return flash;
	}
	public void setFlash(boolean flash) {
		this.flash = flash;
	}
	public Flash(Integer value, boolean flash) {
		super();
		this.value = value;
		this.flash = flash;
	}
	@Override
	public String toString() {
		return "Flash [value=" + value + ", flash=" + flash + "]";
	}
	 
	 
}
