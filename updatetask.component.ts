import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/Employee';
import { TaskServices } from 'taskService';

@Component({
  selector: 'app-updatetask',
  templateUrl: './updatetask.component.html',
  styleUrls: ['./updatetask.component.css']
})
export class UpdatetaskComponent implements OnInit {




  empId : number =0;
    emp: Employee = new Employee();
  constructor(private employeeService: TaskServices,
    private router: Router,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.empId = this.route.snapshot.params['empId'];
    this.employeeService. getEmpList(this.empId).subscribe((data: any) => {
      this.emp = data;
    }, error => console.log(error));
  }

  onSubmit(){
    console.log(this.empId);
    console.log(this.emp);
    this.employeeService.updateTask(this.empId, this.emp).subscribe( data =>{
      this.goToEmployeeeList();
    }
    , (error: any) => console.log(error));
  }

  goToEmployeeeList(){
    this.router.navigate(['/emp']);
  }}