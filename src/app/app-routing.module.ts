import { NgModule } from '@angular/core';
import {Routes, RouterModule, ExtraOptions} from '@angular/router';
import { AppComponent } from './app.component';
import { TableComponent } from './components/table/table-main/table.component';
import {LoginComponent} from './components/login/login.component';
import {LoginGuardService} from './services/security/login-guard.service';
import {TableWarningComponent} from './components/table/table-warning/table-warning.component';
import {TableDownloadComponent} from './components/table/table-download/table-download.component';
import {CompareComponent} from './components/dialogs/compare/compare.component';
import {StepperComponent} from './components/stepper/stepper.component';

const routerOptions: ExtraOptions = {
  scrollPositionRestoration: 'enabled',
  anchorScrolling: 'enabled',
  scrollOffset: [0, 64],
};
const routes: Routes = [
  {path: 'table', component: TableComponent, canActivate: [LoginGuardService]},
  {path: 'login', component: LoginComponent},
  {path: 'table-warning', component: TableWarningComponent, canActivate: [LoginGuardService]},
  {path: 'table-download', component: TableDownloadComponent, canActivate: [LoginGuardService]},
  {path: 'compare', component: CompareComponent, canActivate: [LoginGuardService]},
  {path: 'stepper', component: StepperComponent, canActivate: [LoginGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
