package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> getTasks() {
        var tasks = taskRepository.findAll();
        return tasks.
                stream().
                map(t -> taskMapper.map(t)).
                toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO getTask(@PathVariable Long id) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@Valid @RequestBody TaskCreateDTO data) {
        var task = taskMapper.map(data);
        this.taskRepository.save(task);
        return taskMapper.map(task);
    }

    @PutMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public TaskDTO updateTask(@Valid @PathVariable Long id, @RequestBody TaskUpdateDTO data) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        this.taskMapper.update(data, task);
        task.setAssignee(userRepository.findById(data.getAssigneeId()).orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found")));
        this.taskRepository.save(task);
        return this.taskMapper.map(task);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        this.taskRepository.deleteById(id);
    }
    // END
}
