import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileComponent} from './components/main-page/profile/profile.component';
import {AboutComponent} from './components/main-page/about/about.component';
import {InterestsComponent} from './components/main-page/interests/interests.component';
import {StackComponent} from './components/main-page/stack/stack.component';
import {HomeComponent} from './components/primary/home/home.component';
//import { LandingPageComponent } from './primary/landingPage/landing-page.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  { path: 'home', component: HomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'about', component: AboutComponent },
  { path: 'interests', component: InterestsComponent },
  { path: 'stack', component: StackComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
