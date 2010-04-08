
public class Task implements MyObject{
	private Integer begin;
	private Integer end;
	private String name;

	public Task(Integer begin,Integer end,String name){
		this.begin = begin;
		this.end = end;
		this.name = name;
	}

	
	public Comparable getKeyData() {
		//TODO
	}

	public Comparable getMaxData() {
		//TODO
	}

	@Override
	public int compareTo(Object o) {
		//TODO
	}
	
	
	public boolean overlap(Comparable start, Comparable end){
		//TODO
	}

	
	public String toString(){
		return "name="+this.name +" time=["+this.begin+","+this.end+"]";
	}



}
