
public class Task implements MyObject{
	private Integer begin;
	private Integer end;
	private String name;

    public Task(Integer begin, Integer end, String name) {
        this.begin = begin;
        this.end = end;
        this.name = name;
    }

	
	public Comparable getKeyData() {
        return this.begin;
    }

	public Comparable getMaxData() {
        return this.end;
    }

//	@Override
	public int compareTo(Object o) {
        if (o instanceof Task) {
            Task o1 = (Task) o;
            return this.getKeyData().compareTo(o1.getKeyData());
        } else {
            throw new ClassCastException(o + " is not of class Task");
        }
    }
	
	
	public boolean overlap(Comparable start, Comparable end) {
        return ((this.getKeyData().compareTo(start) <= 0) &&
                        (this.getMaxData().compareTo(start) >= 0)) || //OR
                ((this.getKeyData().compareTo(start) >= 0) &&
                        (this.getKeyData().compareTo(end) <= 0));
    }

	
	public String toString() {
        return "name=" + this.name + " time=[" + this.begin + "," + this.end + "]";
    }



}
