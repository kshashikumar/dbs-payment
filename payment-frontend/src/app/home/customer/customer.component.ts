import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/Customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers!: Customer[];
  status!:number;
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {

  }

  onClick(){
       this.customerService.getAllCustomers()
       .subscribe(
         data =>this.customers=data,
         errorCode => this.status = errorCode,
         )
  }

}
