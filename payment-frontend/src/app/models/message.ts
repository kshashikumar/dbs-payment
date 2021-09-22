export class Message{
  public messagecode!:string ;
  public instruction!:string ;

  constructor(messagecode:string,instruction:string){
    this.messagecode= messagecode;
    this.instruction=instruction;
  }
}
