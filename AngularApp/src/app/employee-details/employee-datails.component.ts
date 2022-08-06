import { Employee } from './../employees.ts';
import { Component, OnInit } from '@angular/core';
import { EmployeeServices } from '../employee.service';
import { EmployeeListComponent } from '../employe-list/employe-list.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-datails',
  templateUrl: './employee-datails.component.html',
  styleUrls: ['./employee-datails.component.css']
})
export class EmployeeDatailsComponent implements OnInit {

  id: number;
  employee: Employee;

  constructor(private route: ActivatedRoute, private router: Router,
    private employeeService: EmployeeServices) { }


  ngOnInit(): void {
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }



}


