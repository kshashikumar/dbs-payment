import { Message } from './../../models/message';
import { BankService } from './../../services/bank.service';

import { Component, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';

import { CustomerService } from 'src/app/services/customer.service';
import { MessagecodeService } from 'src/app/services/messagecode.service';
import { Transaction } from 'src/app/models/transaction';
import { TransactionService } from 'src/app/services/transaction.service';

interface Transfer{
   transferdate: Date;
   transfertype:string ;
   messagecode:string ;
   customerid:string ;
   receiveraccountholdernumber:string ;
   receiveraccountholdername:string ;
   inramount:number ;
   status:string ;
   bic:string;

}


@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})



export class TransactionComponent implements OnInit {



  totalbalance!:number;
  totalbalanceflag:boolean=false;
  messages!:Message[];
  customerNotFound:boolean = false;
  bicNotFound:boolean = false;
  sdnMessage!:string;
  fees!:number;
  status: any;
  transferstatus: boolean = false;
  overdraft:boolean = false;
  overdraftcheck:boolean = false;

  constructor(private customerService:CustomerService,
    private bankService:BankService,
    private messageCodeService:MessagecodeService,
    private transactionService:TransactionService) { }

  ngOnInit(): void {

          this.messageCodeService.getAllMessages()
          .subscribe(data => {
              this.messages=data;
          });
  }

  onCustomerFormSubmit($event:any,customerform:NgForm){

     this.customerService.getCustomerById($event.target.value)
     .subscribe(
       data => {
        this.customerNotFound=false;
          customerform.controls['customerid'].setValue(data.customerid);
          customerform.controls['accountholdername'].setValue(data.accountholdername);
          customerform.controls['clearbalance'].setValue(data.clearbalance);
          if(data.overdraftflag==1){
            this.overdraft=true;
          }
          else
          {
            this.overdraft=false;
          }
          this.overdraftcheck=true;
          this.totalbalance=data.clearbalance;

        },
        err => {
          if(err.status==500){
            this.customerNotFound=true;
            customerform.controls['accountholdername'].setValue(null);
            customerform.controls['clearbalance'].setValue(null);
            this.overdraftcheck=false;
          }
        }

       );
      //  console.log(customerform);
      //  console.log(customerform.form.value.accountholdername);
  }

  clearForm(){

  }

  onBicFormSubmit($event:any,bankform:NgForm){
    console.log(bankform);
    this.bankService.getBankById($event.target.value)
    .subscribe(
      data => {
         bankform.controls['bic'].setValue(data.bic);
         bankform.controls['bankname'].setValue(data.bankname);

     },
     err => {
       if(err.status==500){
         this.bicNotFound=true;
       }
     }

      );
  }


  calculateFees($event:any,form:NgForm){

      this.fees=$event.target.value*0.25;
      if(this.overdraft==true){
        this.totalbalanceflag=true;
 }
 else if(this.overdraft==false&&this.totalbalance>$event.target.value){
  this.totalbalanceflag=true;
 }
 else if(this.overdraft==false&&this.totalbalance<$event.target.value){
   this.totalbalanceflag=false;
 }
  }

  onSubmit(transfer:NgForm){

   //console.log(JSON.stringify(transfer));

    this.transactionService.addTransaction(transfer.form.value)
						.subscribe(statusCode => {
							//Expecting success code 201 from server
							this.status = statusCode;
              this.sdnMessage='';

						},
							errorCode => {this.status = errorCode;
                   this.sdnMessage=errorCode.error.message;
              }
						);
            this.transferstatus=true;
    console.log(JSON.stringify(transfer.form.value));
    this.overdraftcheck=false;
    transfer.resetForm();
  }
}
