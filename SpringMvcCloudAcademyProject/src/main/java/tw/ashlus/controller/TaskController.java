package tw.ashlus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.ashlus.model.AfterCompleteTask;
import tw.ashlus.model.BeforeCompleteTask;
import tw.ashlus.model.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService tService;
	
	@GetMapping(path = "/index") 
    public String index(Model m) {
//		BeforeCompleteTask bTask = new BeforeCompleteTask();
//		m.addAttribute("bTask", bTask);
		List<BeforeCompleteTask> bTaskes = tService.selectAllFromBTask();
		List<AfterCompleteTask> aTaskes = tService.selectAllFromATask();
		m.addAttribute("bTaskes", bTaskes);
		m.addAttribute("aTaskes", aTaskes);
    	return "task";
    }
	
	@PostMapping(path="/insert")
	public String insert(@RequestParam(name="context")String context, Model m) {
		System.out.println(context);
		BeforeCompleteTask taskBean = new BeforeCompleteTask();
		taskBean.setContext(context);
		tService.insert(taskBean);
		List<BeforeCompleteTask> bTaskes = tService.selectAllFromBTask();
		List<AfterCompleteTask> aTaskes = tService.selectAllFromATask();
		m.addAttribute("bTaskes", bTaskes);
		m.addAttribute("aTaskes", aTaskes);
		return "task";
	}
	@PostMapping(path="/delete")
	public String delete(@RequestParam(name="taskid")Integer id, Model m) {
		tService.deleteById(id);
		List<BeforeCompleteTask> bTaskes = tService.selectAllFromBTask();
		List<AfterCompleteTask> aTaskes = tService.selectAllFromATask();
		m.addAttribute("bTaskes", bTaskes);
		m.addAttribute("aTaskes", aTaskes);
		return "task";
	}
}
