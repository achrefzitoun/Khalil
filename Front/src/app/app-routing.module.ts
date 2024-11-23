import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './User/login/login.component';
import { BookslistComponent } from './Biblio/bookslist/bookslist.component';
import { CreateAccountComponent } from './User/create-account/create-account.component';

const routes: Routes = [
  { path: 'login' , component: LoginComponent },
  { path: 'booklist', component: BookslistComponent},
  { path: 'signin', component: CreateAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
