import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './User/login/login.component';
import { BookslistComponent } from './Biblio/bookslist/bookslist.component';
import { CreateAccountComponent } from './User/create-account/create-account.component';
import { ForgotpasswordComponent } from './User/forgotpassword/forgotpassword.component';
import { BooksmanagmentComponent } from './Admin/booksmanagment/booksmanagment.component';

const routes: Routes = [
  { path: 'login' , component: LoginComponent },
  { path: 'booklist', component: BookslistComponent},
  { path: 'signin', component: CreateAccountComponent},
  { path: 'forgotpassword', component:ForgotpasswordComponent},
  { path: 'books', component:BooksmanagmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
