import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { DatePipe, HashLocationStrategy, LocationStrategy , CommonModule } from "@angular/common";
import { StepsModule } from 'primeng/steps';
import { ToastModule } from 'primeng/toast';
import { TriStateCheckboxModule } from 'primeng/tristatecheckbox';
import { CheckboxModule } from 'primeng/checkbox';
import { SplitterModule } from 'primeng/splitter';
import { FileUploadModule } from 'primeng/fileupload';
import { RadioButtonModule } from 'primeng/radiobutton';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AutoCompleteModule } from "primeng/autocomplete";
import { CalendarModule } from "primeng/calendar";
import { ChipsModule } from "primeng/chips";
import { DropdownModule } from "primeng/dropdown";
import { InputMaskModule } from "primeng/inputmask";
import { InputNumberModule } from "primeng/inputnumber";
import { CascadeSelectModule } from "primeng/cascadeselect";
import { MultiSelectModule } from "primeng/multiselect";
import { InputTextareaModule } from "primeng/inputtextarea";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { ToggleButtonModule } from "primeng/togglebutton";
import { SelectButtonModule } from "primeng/selectbutton";
import { InputTextModule } from 'primeng/inputtext';
import { FieldsetModule } from 'primeng/fieldset';
import { CardModule } from 'primeng/card';
import { AvatarModule } from 'primeng/avatar';
import { KeyFilterModule } from 'primeng/keyfilter';
import { InputSwitchModule } from 'primeng/inputswitch';
import { BlockUIModule } from 'primeng/blockui';
import { PanelModule } from 'primeng/panel';
import { TableModule } from 'primeng/table';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { DividerModule } from 'primeng/divider';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { InplaceModule } from 'primeng/inplace';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { SkeletonModule } from 'primeng/skeleton';
import { DialogModule } from 'primeng/dialog';
import { TimelineModule } from 'primeng/timeline';
import { AccordionModule } from 'primeng/accordion';
import { OverlayPanelModule } from 'primeng/overlaypanel';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { ChartModule } from 'primeng/chart';
import { DataViewModule } from 'primeng/dataview';
import { CarouselModule } from 'primeng/carousel';
import { MenubarModule } from 'primeng/menubar';
import { TagModule } from 'primeng/tag';
import { TieredMenuModule } from 'primeng/tieredmenu';
import { ChipModule } from 'primeng/chip';
import { NgxSpinnerModule } from 'ngx-spinner';
import { TabMenuModule } from 'primeng/tabmenu';
import { PasswordModule } from 'primeng/password';
import { ToolbarModule } from 'primeng/toolbar';
import { MessageService } from 'primeng/api';
import { MatDialogModule } from '@angular/material/dialog';
import { LoginComponent } from './User/login/login.component';
import { BookslistComponent } from './Biblio/bookslist/bookslist.component';
import { HeaderComponent } from './Pages/header/header.component';
import { FooterComponent } from './Pages/footer/footer.component';
import { CreateAccountComponent } from './User/create-account/create-account.component';
import { NewreservationComponent } from './Biblio/newreservation/newreservation.component';
import { BooksmanagmentComponent } from './Admin/booksmanagment/booksmanagment.component';
import { UsermanagmentComponent } from './Admin/usermanagment/usermanagment.component';
import { ReservationsmanagmentComponent } from './Admin/reservationsmanagment/reservationsmanagment.component';
import { ManagereservationsComponent } from './User/managereservations/managereservations.component';
import { ForgotpasswordComponent } from './User/forgotpassword/forgotpassword.component';
import { NewpasswordComponent } from './User/newpassword/newpassword.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BookslistComponent,
    HeaderComponent,
    FooterComponent,
    CreateAccountComponent,
    NewreservationComponent,
    BooksmanagmentComponent,
    UsermanagmentComponent,
    ReservationsmanagmentComponent,
    ManagereservationsComponent,
    ForgotpasswordComponent,
    NewpasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    InputTextModule,
    AccordionModule,
    BlockUIModule,
    DataViewModule,
    DialogModule,
    ConfirmPopupModule,
    ChartModule,
    SkeletonModule,
    PanelModule,
    CheckboxModule,
    RadioButtonModule,
    CommonModule,
    FormsModule,
    AutoCompleteModule,
    CalendarModule,
    ChipsModule,
    InputSwitchModule,
    DropdownModule,
    InputMaskModule,
    InputNumberModule,
    CascadeSelectModule,
    MultiSelectModule,
    OverlayPanelModule,
    InputTextareaModule,
    KeyFilterModule,
    StepsModule,
    ConfirmDialogModule,
    TimelineModule,
    ToastModule,
    TriStateCheckboxModule,
    ToggleButtonModule,
    SplitterModule,
    FileUploadModule,
    SelectButtonModule,
    FieldsetModule,
    CardModule,
    AvatarModule,
    TableModule,
    HttpClientModule,
    ReactiveFormsModule,
    ButtonModule,
    DividerModule,
    InplaceModule,
    CarouselModule,
    MenubarModule,
    TagModule,
    TieredMenuModule,
    ChipModule,
    NgxSpinnerModule,
    TabMenuModule,
    PasswordModule,
    ToolbarModule,
    MatDialogModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
