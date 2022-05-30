package tw.ashlus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name = "afterCompleteTask")
@Component
public class AfterCompleteTask {
	@Id @Column(name = "ID") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "context") 
	private String context;

	public AfterCompleteTask() {
		super();
	}

	public AfterCompleteTask(int id, String context) {
		super();
		this.id = id;
		this.context = context;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}


	
	
}
