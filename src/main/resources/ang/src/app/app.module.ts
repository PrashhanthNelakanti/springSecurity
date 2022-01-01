import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {AppComponent} from './app.component';
import {ListUserComponent} from './components/list-user/list-user.component';
import {FormsModule} from '@angular/forms';
import {GetUserComponent} from './components/get-user/get-user.component';
import {EditUserComponent} from './components/edit-user/edit-user.component';
import {UserService} from './service-shared/user-service.service';
import {UserFormComponent} from './components/user-form/user-form.component';
import {MainPageComponent} from './components/main-page/main-page.component';
import {ProfileComponent} from './components/main-page/profile/profile.component';
import {StackComponent} from './components/main-page/stack/stack.component';
import {AboutComponent} from './components/main-page/about/about.component';
import {InterestsComponent} from './components/main-page/interests/interests.component';
import {FooterComponent} from './components/main-page/footer/footer.component';
import {ReachmeComponent} from './components/main-page/reachme/reachme.component';
import {HomeComponent} from './components/primary/home/home.component';
import {ErrorComponent} from './components/error/error.component';
import {GalleryComponent} from './components/primary/gallery/gallery.component';
import {AppRoutingModule} from './app-routing.module';
import {ReachmeService} from './components/main-page/reachme/reachme.service';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';
import {ExcelComponent} from './projects/excel/excel.component';
import {ExcelService} from "./projects/excel/excel.service";


const appRoutes:Routes=[
  {path:'new',component:UserFormComponent},
    {path:'get',component:GetUserComponent},
    {path:'list',component:ListUserComponent},
  {path:'edit',component:EditUserComponent},
 ];
@NgModule({
  declarations: [
    AppComponent,
    ListUserComponent,
    UserFormComponent,
    GetUserComponent,
    EditUserComponent,
    UserFormComponent,

    MainPageComponent,
    HomeComponent,
    ProfileComponent,
    StackComponent,
    AboutComponent,
    InterestsComponent,
    FooterComponent,
    ErrorComponent,
    GalleryComponent,
    ReachmeComponent,
    ExcelComponent,


  ],
  imports: [

    BrowserModule,FormsModule,AppRoutingModule,
    HttpModule,RouterModule.forRoot(appRoutes)
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy},UserService,ReachmeService,ExcelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
