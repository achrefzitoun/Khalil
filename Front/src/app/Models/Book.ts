import { Reservation } from "./Reservation";
import { TypeBook } from "./TypeBook";

export class Book {
    idBook!:number;
    isbn!:number;
    title!:string;
    image!:string;
    language!:string;
    author!:string;
    description!:string;
    numberOfPages!:number;
    nbCopies!:number;
    reservations!:Reservation[];
    typeBook!:TypeBook[];
}