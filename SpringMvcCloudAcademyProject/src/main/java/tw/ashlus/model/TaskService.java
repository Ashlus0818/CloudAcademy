package tw.ashlus.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskService {
	@Autowired
	private TaskDao tdao;
	
	public List<BeforeCompleteTask> selectAllFromBTask() {
		return tdao.selectAllFromBTask();
	}
	public List<AfterCompleteTask> selectAllFromATask() {
		return tdao.selectAllFromATask();
	}
	public void insert(BeforeCompleteTask taskBean) {
		tdao.insert(taskBean);
	}
	public void deleteById(Integer id) {
		tdao.deleteById(id);
	}
}
