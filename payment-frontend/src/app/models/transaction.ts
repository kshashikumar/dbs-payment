export class Transaction{

  public transfertype!:string ;
  public messagecode!:string ;
  public customerid!:string ;
  public receiveraccountholdernumber!:string ;
  public receiveraccountholdername!:string ;
  public inramount!:number ;

  public bic!:string;

  constructor(
    transfertype:string,
    messagecode:string,
    customerid:string,
    receiveraccountholdernumber:string,
    receiveraccountholdername:string,
    inramount:number,

    bic:string) {
  this.transfertype = transfertype;
  this.messagecode= messagecode;
  this.customerid = customerid;
  this.receiveraccountholdernumber= receiveraccountholdernumber;
  this.receiveraccountholdername= receiveraccountholdername;
  this.inramount = inramount;

  this.bic= bic;
  }
}
