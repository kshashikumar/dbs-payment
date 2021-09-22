export class Customer{
  public customerid!:string ;
  public accountholdername!:string ;
  public overdraftflag!:number ;
  public clearbalance!:number ;
  constructor(customerid:string, accountholdername:string, overdraftflag:number, clearbalance:number){
    this.customerid = customerid;
    this.accountholdername = accountholdername;
    this.clearbalance = clearbalance;
    this.overdraftflag = overdraftflag;
  }
}
