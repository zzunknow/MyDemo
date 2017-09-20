import java.util.LinkedList;
import java.util.List;

/**
 * 递归级联数组
 * @author zou
 *
 */
public class RecursionArraysDemo {
	
	public static void main(String[] args) {
		//初始数据
		LinkedList<Element> list = new LinkedList<Element>();
		list.add(new Element(1,0,"一级元素1"));
		list.add(new Element(2,0,"一级元素2"));
		list.add(new Element(3,0,"一级元素3"));
		list.add(new Element(4,1,"二级元素1"));
		list.add(new Element(5,1,"二级元素2"));
		list.add(new Element(6,1,"二级元素3"));
		list.add(new Element(7,4,"三级元素1"));
		list.add(new Element(8,4,"三级元素1"));
		push(list,0);
	}
	private static int count = 0; //递归深度
	
	public static void push(List<Element> list,int pid){
		count++;
		for(Element e:list){
			if(e.getPid() == pid){
				for(int i=1;i<count;i++){
					System.out.print("--");
				}
				System.out.println(e);
				if(e.hasSub(list)){
					push(list,e.getId());
				}
			}
		}
		count--;
	}
	
}
class Element{
	private int id;
	private int pid;//父级ID
	private String name;
	
	public Element(int id,int pid,String name){
		this.id = id;
		this.pid = pid;
		this.name = name;
	}
	
	/**
	 * 是否有子元素
	 * @param list
	 * @return
	 */
	public boolean hasSub(List<Element> list){
		for(Element e:list){
			if(e.getPid() == this.id){
				return true;
			}
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public int getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "{id:"+id+",pid:"+pid+",name:\""+name+"\"}";
	}
}