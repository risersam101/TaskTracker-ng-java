import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from '../list-todos/list-todos.component';
import { API_URL, JPA_API_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {

  constructor(private http:HttpClient) { }

  retrieveAllTodos(userName:string){

    return this.http.get<Todo[]>(`${JPA_API_URL}/users/${userName}/getTasks`

    );
  }

  deleteTask(id:number, name:String){
    return this.http.delete(`${JPA_API_URL}/users/${name}/tasks/${id}`);
  }

  getTask(id:number, name:String){
    return this.http.get<Todo>(`${JPA_API_URL}/users/${name}/tasks/${id}`);
  }

  updateTask(id:number, name:string, task:Todo){
    return this.http.put(`${JPA_API_URL}/users/${name}/tasks/${id}`,
      task);
  }

  saveTask( name:string, task:Todo){
    return this.http.post(`${JPA_API_URL}/users/${name}/tasks`,
      task);
  }

}
