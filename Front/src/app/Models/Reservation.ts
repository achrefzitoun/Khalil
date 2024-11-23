import { Book } from "./Book";
import { User } from "./User";

export class Reservation {
    idReservation!:number;
    startDate!:Date;
    endDate!:Date;
    remis!:boolean;
    user!:User;
    book!:Book;
}