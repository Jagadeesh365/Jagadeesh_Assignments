package in.Assignment.Q8;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hostel implements InitializingBean, DisposableBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(getName() + " he/she eating.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing the Hostel bean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method is called");
	}

	public void myInit() {
		System.out.println("Hostel bean created using init-method");
	}

	public void myDest() {
		System.out.println("Object is destroyed using destroy-method");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("using annontation init called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("destroy called using preDestroy annotation");
	}
}
