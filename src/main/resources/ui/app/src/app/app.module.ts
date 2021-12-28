import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from '@angular/forms';

import {GenericService} from "./generic.service";
import {PlannerComponent} from './planner/planner.component';
import {MainPageComponent} from "./components/main-page/main-page.component";
import {FooterComponent} from "./components/main-page/footer/footer.component";
import {HomeComponent} from "./components/primary/home/home.component";
import {ProfileComponent} from "./components/main-page/profile/profile.component";
import {StackComponent} from "./components/main-page/stack/stack.component";
import {AboutComponent} from "./components/main-page/about/about.component";
import {InterestsComponent} from "./components/main-page/interests/interests.component";
import {ErrorComponent} from "./components/error/error.component";
import {GalleryComponent} from "./components/primary/gallery/gallery.component";
import {AppRoutingModule} from "./app-routing.module";


@NgModule({
  declarations: [
    AppComponent,
    PlannerComponent,

    MainPageComponent,
    HomeComponent,
    ProfileComponent,
    StackComponent,
    AboutComponent,
    InterestsComponent,
    FooterComponent,
    ErrorComponent,
    GalleryComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,

    HttpClientModule,

    AppRoutingModule

  ],
  providers: [GenericService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
