import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";

import {AccordionModule} from 'primeng/accordion';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule} from "@angular/forms";
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ButtonModule} from "primeng/button";
import {MenubarModule} from 'primeng/menubar';
import {CheckboxModule} from "primeng/checkbox";
import {RadioButtonModule} from "primeng/radiobutton";
import {ToastModule} from "primeng/toast";
import {RippleModule} from "primeng/ripple";
import {FileUploadModule} from 'primeng/fileupload';

import {GenericService} from "./generic.service";
import {MessageService} from "primeng/api";
import {FileuploadComponent} from './fileupload/fileupload.component';
import {PlannerComponent} from './planner/planner.component';

@NgModule({
  declarations: [
    AppComponent,
    FileuploadComponent,
    PlannerComponent
  ],
  imports: [
    BrowserModule,
    AccordionModule,
    BrowserAnimationsModule,
    InputTextModule,
    CheckboxModule,
    ButtonModule,
    RadioButtonModule,
    RippleModule,
    FormsModule,
    MenubarModule,
    HttpClientModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    FileUploadModule
  ],
  providers: [GenericService,MessageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
