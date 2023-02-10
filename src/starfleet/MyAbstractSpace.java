package starfleet;

import java.util.Objects;

public abstract class MyAbstractSpace{
	
	private String name;
	
	public MyAbstractSpace(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyAbstractSpace other = (MyAbstractSpace) obj;
        return name.equals(other.getName());
    }

}
