import { DatePipe, NgFor, NgIf, NgOptimizedImage } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TaskDataService } from '../tasks/task-data.service';
import { Router } from '@angular/router';

export class Todo{
  constructor(
    public  id:number,
    public description:string,
    public isDone: boolean,
    public targetDate: Date
  ){

  }
}
@Component({
  selector: 'app-list-todos',
  imports: [NgFor, DatePipe, NgIf],
  standalone:true,
  templateUrl: './list-todos.component.html',
  styleUrl: './list-todos.component.css'
})
export class ListTodosComponent implements OnInit{


  todos !:Todo[];
  errorMessage ='';
  constructor(private taskDataSrv:TaskDataService,
    private router:Router
  ){  }
  ngOnInit(): void {
    this.refreshTasks();
  }

  refreshTasks(){
    this.taskDataSrv.retrieveAllTodos('Sam').subscribe(
      {
        next: response =>{
          console.log(response);
          this.todos = response;
        },
        error: error=>{
          console.log('bruv something aint bussin');
        }
      }
    );
  }

  deleteTask(id:number) {
    this.taskDataSrv.deleteTask(id,'Sam').subscribe(
      {
        next: response=>{console.log(response) 
            this.errorMessage = `Deleted ${id} Successfully`;
            this.refreshTasks();
        },
        error: error=>console.log('Something wrong bruv')
      }
    );
    }

    updateTask(id:number){
      this.router.navigate(['todos',id]);
    }

    createTask() {
     this.router.navigate(['todos',-1]);
      }
    
}
