import { Reservation } from "./Reservation";
import { Role } from "./Role";

export class User{
    idUser!:number;
    firstName!:string;
    secondName!:string;
    email!:string;
    role!:Role;
    pwd!:string;
    identifier!:string;
    phoneNumber!:string;
    birthDate!:Date;
    dateCreation!:Date;
    reservations!:Reservation[];
}