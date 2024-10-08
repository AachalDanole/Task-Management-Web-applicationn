import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/Employee';
import { TaskServices } from 'taskService';
@Component({
  selector: 'app-createtask',
  templateUrl: './createtask.component.html',
  styleUrls: ['./createtask.component.css']
})
export class CreatetaskComponent implements OnInit  {
  
  
  emp: Employee = new Employee();
  constructor(private employeeService: TaskServices,
    private router: Router,private route: ActivatedRoute,) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.saveEmployee(this.emp).subscribe( (data: any) =>{
      console.log(data);
      this.goToBusList();
    },
      (    error: any) => console.log(error));
  }

  goToBusList(){
    this.router.navigate(['/bus']);
  }
  
  onSubmit(){
    console.log(this.emp);
    this.saveEmployee();
  }
}