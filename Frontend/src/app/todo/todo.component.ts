import { Component, OnInit } from '@angular/core';
import { TaskDataService } from '../tasks/task-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DatePipe, NgIf } from '@angular/common';

@Component({
  selector: 'app-todo',
  imports: [FormsModule,DatePipe, NgIf],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent implements OnInit{

  id!:number;
  todo!:Todo;
  constructor(private taskServ:TaskDataService,
    private route:ActivatedRoute,
    private router:Router
  ){}

  ngOnInit(): void {
    
    this.id = this.route.snapshot.params['id'] ;
    
    this.todo = new Todo(this.id,"",false,new Date());
    if(this.id!=-1){
    this.taskServ.getTask(this.id,"sam").subscribe(
      {
        next: data=> this.todo = data,
        error:error=>console.log('some error bruv')
      }
    );
  }
  }

  
  saveTask(){

  if(this.id!=-1){
   this.taskServ.updateTask(this.id, 'Sam', this.todo).subscribe({
    next:data=> {console.log(data);
      this.router.navigate(['todos']);
    },
    error: error=> console.log('Task not updated!')
   });
  }else{
      this.taskServ.saveTask('Sam',this.todo).subscribe({
        next:data=> {console.log(data);
          this.router.navigate(['todos']);
        },
        error: error=> console.log('New task not created!')
       });
  }
}
}
