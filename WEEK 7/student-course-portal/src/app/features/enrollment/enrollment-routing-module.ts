import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EnrollmentFormComponent } from './enrollment-form/enrollment-form';
import { ReactiveEnrollmentComponent } from './reactive-enrollment/reactive-enrollment';

import { authGuard } from '../../guards/auth-guard';
import { unsavedChangesGuard } from '../../guards/unsaved-changes-guard';

const routes: Routes = [
  {
    path: '',
    component: EnrollmentFormComponent,
    canActivate: [authGuard]
  },
  {
    path: 'reactive',
    component: ReactiveEnrollmentComponent,
    canActivate: [authGuard],
    canDeactivate: [unsavedChangesGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EnrollmentRoutingModule { }