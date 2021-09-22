export class Bank{
  public bic!:string ;
  public bankname!:string ;

  constructor(bic:string,bankname:string){
    this.bic= bic;
    this.bankname=bankname;
  }
}
